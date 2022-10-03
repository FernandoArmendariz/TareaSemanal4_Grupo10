package com.utec.tareasemanal4grupo10.persistence.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.utec.tareasemanal4grupo10.persistence.dao.UauarioDAO;
import com.utec.tareasemanal4grupo10.persistence.database.UsuarioRoomBD;
import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;

import java.util.List;

public class UsuarioRepositorio {

    private UauarioDAO daou;
    private LiveData<List<Usuario>> usuarios;

    public UsuarioRepositorio(Application app) {
        UsuarioRoomBD db = UsuarioRoomBD.getDatabase(app);
        daou = db.usuarioDao();
        usuarios = daou.getUsers();

    }

    public LiveData<List<Usuario>> obtenerTodosUsuarios() {
        return usuarios;
    }

    public void ingresarUsuario(Usuario usuario) {
        UsuarioRoomBD.databaseWriteExecutor.execute(() -> {
            daou.insert(usuario);
            //daou.insert(usuario.getNombre(), usuario.getApellido(), usuario.getRol());
        });
    }

    public void borrarTodosUsuarios() {
        UsuarioRoomBD.databaseWriteExecutor.execute(() -> daou.deleteAll());
    }

    public UauarioDAO obtenerUsuarioDAO(){
        return daou;
    }

    public void defineUsuarioDAO(UauarioDAO daou){
        this.daou = daou;
    }
}