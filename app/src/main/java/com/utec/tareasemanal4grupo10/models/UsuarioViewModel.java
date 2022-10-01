package com.utec.tareasemanal4grupo10.models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;
import com.utec.tareasemanal4grupo10.persistence.repositories.UsuarioRepositorio;

import java.util.List;

public class UsuarioViewModel extends AndroidViewModel {

    private UsuarioRepositorio usuarioRepositorio;
    private final LiveData<List<Usuario>> usuarios;

    public UsuarioViewModel(Application application){
        super(application);
        usuarioRepositorio = new UsuarioRepositorio(application);
        usuarios = usuarioRepositorio.obtenerTodosUsuarios();
    }

    public LiveData<List<Usuario>> obtenerUsuarios(){
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        usuarioRepositorio.ingresarUsuario(usuario);
    }

    public void borrarUsuario(Usuario usuario){
        usuarioRepositorio.borrarTodosUsuarios();
    }
}
