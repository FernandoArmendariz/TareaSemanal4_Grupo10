package com.utec.tareasemanal4grupo10.models;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConvertirFechaTexto {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @TypeConverter
    public static Date toDate(String timestamp) throws ParseException {
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return timestamp == null ? null : sdf.parse(timestamp);

    }

    @TypeConverter
    public static String toTimestamp(Date date) {
        return date == null ? null : sdf.format(date);
    }
}
