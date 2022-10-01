package com.utec.tareasemanal4grupo10.persistence.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.utec.tareasemanal4grupo10.persistence.dao.UauarioDAO;
import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class UsuarioRoomBD extends RoomDatabase {

    public abstract UauarioDAO usuarioDao();
    private static volatile UsuarioRoomBD INSTANCE;
    private static final int NUMBER_OF_THREADS = 1;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static UsuarioRoomBD getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UsuarioRoomBD.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                            UsuarioRoomBD.class, "usuarios_database")
                            .build();
                    }
                }
            }
            return INSTANCE;
        }

}
