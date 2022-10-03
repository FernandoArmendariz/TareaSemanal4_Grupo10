package com.utec.tareasemanal4grupo10.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.utec.tareasemanal4grupo10.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {
    private final TextView nombreItemView;
    private final TextView rolItemView;
    private final TextView fechaItemView;
    private final TextView idItenmView;

    private UsuarioViewHolder(View itemView){
        super(itemView);
        nombreItemView = itemView.findViewById(R.id.textViewNombre);
        rolItemView = itemView.findViewById(R.id.textViewDescripcion);
        fechaItemView = itemView.findViewById(R.id.textViewFecha);
        idItenmView = itemView.findViewById(R.id.textViewID);
    }

    public void bind(String nombre, String apellido, String descripcion, Date fecha){
        nombreItemView.setText(nombre);
        rolItemView.setText(descripcion);
        idItenmView.setText((!nombre.isEmpty()) ? String.valueOf(nombre.charAt(0)).toUpperCase():"");
        fechaItemView.setText(
                //se da formato a la fecha para mostrar
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fecha)
        );
    }

    static UsuarioViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_usuario_item, parent, false);
        return new UsuarioViewHolder(view);
    }

}
