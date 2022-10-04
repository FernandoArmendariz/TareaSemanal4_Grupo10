package com.utec.tareasemanal4grupo10.models;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertirFechaString {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss X", Locale.getDefault());

    @TypeConverter
    public static Date toDate(String timestamp){
        Date date;
        try {
            date = sdf.parse(timestamp);

        }catch (ParseException p){
            date = null;
        }
        return date;
    }

    @TypeConverter
    public static String toTimestamp(Date date) {
        return date == null ? null : sdf.format(date);
    }
}
