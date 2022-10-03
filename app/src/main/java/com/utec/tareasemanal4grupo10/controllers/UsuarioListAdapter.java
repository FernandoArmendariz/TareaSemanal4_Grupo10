package com.utec.tareasemanal4grupo10.controllers;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.utec.tareasemanal4grupo10.persistence.entities.Usuario;

public class UsuarioListAdapter extends ListAdapter<Usuario, UsuarioViewHolder> {

    private OnItemClickListener listener;

    public UsuarioListAdapter(@NonNull DiffUtil.ItemCallback<Usuario> diffCallbak){
        super(diffCallbak);
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UsuarioViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuarioActual = getItem(position);
        holder.bind(usuarioActual.getNombre(), usuarioActual.getApellido(), usuarioActual.getRol(), usuarioActual.getFecha());

    }

    public static class UsuarioDiff extends DiffUtil.ItemCallback<Usuario>{
        @Override
        public boolean areItemsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
            return oldItem.getUid() == newItem.getUid();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
            return oldItem.getNombre().equals(newItem.getNombre()) && oldItem.getRol().equals(newItem.getRol());
        }
    }

    public interface OnItemClickListener {
        void onItemDelete(Usuario usuario);
        void OnItemClick(Usuario usuario);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
