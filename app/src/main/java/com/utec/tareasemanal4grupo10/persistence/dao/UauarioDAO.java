package com.utec.tareasemanal4grupo10.persistence.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;

import java.util.List;

@Dao
public interface UauarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //@Query(value = "INSERT INTO usuarios (first_name,last_name,role) VALUES (:nombre, :apellido, :rol)")
    void insert(Usuario usuario);

    @Query("DELETE FROM usuarios")
    void deleteAll();

    @Query("SELECT * FROM usuarios ORDER BY first_name ASC")
    LiveData<List<Usuario>> getUsers();
}
