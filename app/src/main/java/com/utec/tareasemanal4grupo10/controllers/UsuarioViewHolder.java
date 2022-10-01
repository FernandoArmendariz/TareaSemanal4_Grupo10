package com.utec.tareasemanal4grupo10.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.utec.tareasemanal4grupo10.R;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {
    private final TextView nombreItemView;
    private final TextView rolItemView;
    private final TextView idItenmView;

    private UsuarioViewHolder(View itemView){
        super(itemView);
        nombreItemView = itemView.findViewById(R.id.textViewNombre);
        rolItemView = itemView.findViewById(R.id.textViewDescripcion);
        idItenmView = itemView.findViewById(R.id.textViewID);
    }

    public void bind(String nombre, String descripcion){
        nombreItemView.setText(nombre);
        rolItemView.setText(descripcion);
        idItenmView.setText((!nombre.isEmpty())?nombre.valueOf(nombre.charAt(0)).toUpperCase():"");
    }

    static UsuarioViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_usuario_item, parent, false);
        return new UsuarioViewHolder(view);
    }

}
