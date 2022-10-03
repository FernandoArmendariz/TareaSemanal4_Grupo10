package com.utec.tareasemanal4grupo10.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.utec.tareasemanal4grupo10.MainActivity;
import com.utec.tareasemanal4grupo10.R;
import com.utec.tareasemanal4grupo10.controllers.UsuarioListAdapter;
import com.utec.tareasemanal4grupo10.models.UsuarioViewModel;

public class UsuarioHistorico extends AppCompatActivity {

    private UsuarioViewModel uvm = MainActivity.usuarioViewModel;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_historico);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewUsuarios);

        final UsuarioListAdapter adapter = new UsuarioListAdapter(new UsuarioListAdapter.UsuarioDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        uvm.obtenerUsuarios().observe(this, adapter::submitList);

        fab = findViewById(R.id.btnAgregar);
        //finish elimina la vista
        fab.setOnClickListener(view -> finish());

    }
}