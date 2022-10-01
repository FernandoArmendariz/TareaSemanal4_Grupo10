package com.utec.tareasemanal4grupo10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.utec.tareasemanal4grupo10.models.UsuarioViewModel;
import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;
import com.utec.tareasemanal4grupo10.views.UsuarioHistorico;

import java.util.Date;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    public static final String LISTA_USUARIOS_EXTRA = "com.example.tareasemanal4_grupo10.listaUsuarios";

    //declaracion de variables para material spinner
    AutoCompleteTextView autocompleteRol;
    ArrayAdapter<String> adapterItems;
    //room
    private Timer miTimer;
    public static UsuarioViewModel usuarioViewModel;
    //declaramos las variables del formulario
    String nombre;
    String apellido;
    String rol;
    Button btnEnviar, bntHistorico;
    private static Integer index =0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        //ArrayAdapter para asignar los valores de strings.xml a la Vista
        adapterItems = new ArrayAdapter<>(
                this,

                //Layout de la vista del menu
                R.layout.dropdown_rol_item,

                        /* Se obtienen los recursos, donde se pueden pedir
                        un listado de los arrays declarados en Strings.xml */
                getResources().getStringArray(R.array.lst_rol)
        );
        autocompleteRol = findViewById(R.id.cmbRol);    //se obtiene el objeto
        autocompleteRol.setAdapter(adapterItems);       //se asigna layout con los valores

        //inicializamos la BD
        //usuarioRepositorio = new UsuarioRepositorio(getApplication());

        //agregamos boton
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //generamos proximo mensaje
                insertarNuevoUsuario();
            }
        });

        bntHistorico = (Button) findViewById(R.id.btnHistorico);
        bntHistorico.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, UsuarioHistorico.class);
                startActivity(intent);
            }
        });

        //inicio hilo
        miTimer = new Timer();
//        miTimer.schedule(new TimerTask(){
//
////            @Override
////            public void run() {
////                temporizador();
////            }
////        }, 1000, 15000);
//
    }

    private void insertarNuevoUsuario(){
        nombre=((EditText) findViewById(R.id.txtNombre)).getText().toString();
        apellido=((EditText) findViewById(R.id.txtApellido)).getText().toString();
        rol=((EditText) findViewById(R.id.cmbRol)).getText().toString();

        index++;
        String msg="Mensaje: "+index.toString()+" "+ new Date().toString();
        //Creamos entidad Usuario

        Usuario usuario = new Usuario(nombre,apellido,rol);
        //Agregamos a BD
        usuarioViewModel.agregarUsuario(usuario);

    }
    //este metodo se ejecuta cada 15s
//    @SuppressLint("LongLogTag")
//    private void temporizador(){
//        LiveData<List<Usuario>> usuarios = usuarioRepositorio.obtenerTodosUsuarios();
//        for (Usuario u : usuarios.getValue()) {
//            Log.i(TAG,String.valueOf(u.getUid()));
//            Log.i(TAG,u.getNombre());
//            Log.i(TAG,u.getApellido());
//            Log.i(TAG,u.getRol());
//           // Log.i(TAG,u.getFecha());
//            //usuarioRepositorio.borrarTodosUsuarios();
//        }
//    }


}