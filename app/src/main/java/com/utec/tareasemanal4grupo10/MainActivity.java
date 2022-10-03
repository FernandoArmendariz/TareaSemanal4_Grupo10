package com.utec.tareasemanal4grupo10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.utec.tareasemanal4grupo10.models.UsuarioViewModel;
import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;
import com.utec.tareasemanal4grupo10.views.UsuarioHistorico;

public class MainActivity extends AppCompatActivity {

    //declaracion de variables para spinner
    AutoCompleteTextView autocompleteRol;
    ArrayAdapter<String> adapterItems;
    //room
    public static UsuarioViewModel usuarioViewModel;
    //declaramos las variables del formulario
    EditText nombre,apellido,rol;
    Button btnEnviar, bntHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        //ArrayAdapter para asignar los valores de strings.xml a la Vista
        adapterItems = new ArrayAdapter<>(
                this,

                //Layout de la vista del menu
                R.layout.textview_rol_item,

                /* Se obtienen los recursos, donde se pueden pedir
                un listado de los arrays declarados en Strings.xml */
                getResources().getStringArray(R.array.lst_rol)
        );
        autocompleteRol = findViewById(R.id.cmbRol);    //se obtiene el objeto
        autocompleteRol.setAdapter(adapterItems);       //se asigna layout con los valores

        //inicializamos la BD
        //usuarioRepositorio = new UsuarioRepositorio(getApplication());

        //agregamos boton
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(view -> {
            //generamos proximo mensaje
            insertarNuevoUsuario();
        });

        bntHistorico = findViewById(R.id.btnHistorico);
        bntHistorico.setOnClickListener(view -> {
            //Se llama a crear a UsuarioHistorico
            Intent intent = new Intent(MainActivity.this, UsuarioHistorico.class);
            startActivity(intent);
        });

    }

    private void insertarNuevoUsuario(){
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        rol=findViewById(R.id.cmbRol);

        //Creamos entidad Usuario
        Usuario usuario = new Usuario(
                nombre.getText().toString(),
                apellido.getText().toString(),
                rol.getText().toString()
        );
        //Agregamos a BD
        usuarioViewModel.agregarUsuario(usuario);

        nombre.setText("");
        apellido.setText("");
        rol.setText("");

    }

}