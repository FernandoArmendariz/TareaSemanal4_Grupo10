package com.utec.tareasemanal4grupo10.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;

import java.util.List;

@Dao
public interface UauarioDAO {

    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    @Query(value = "INSERT INTO usuarios (first_name,last_name,role) VALUES (:nombre, :apellido, :rol)")
    void insert(String nombre, String apellido, String rol);

    @Query("DELETE FROM usuarios")
    void deleteAll();

    @Query("SELECT * FROM usuarios ORDER BY first_name ASC")
    LiveData<List<Usuario>> getUsers();
}
