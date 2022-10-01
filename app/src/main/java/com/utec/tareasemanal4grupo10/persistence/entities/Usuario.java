package com.utec.tareasemanal4grupo10.persistence.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.utec.tareasemanal4grupo10.models.ConvertirFechaLong;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "usuarios")
public class Usuario implements Serializable {

        @PrimaryKey(autoGenerate = true)
        private Long uid;

        @NotNull
        @ColumnInfo(name = "first_name")
        private String nombre;

        @NotNull
        @ColumnInfo(name = "last_name")
        private String apellido;

        @ColumnInfo(name = "role")
        private String rol;
        //@Column(name="FEC_HORA", nullable=false, insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_TIMESTAMP")
        @ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
        @TypeConverters(ConvertirFechaLong.class)
        private Date fecha;

        public Usuario(@NotNull String nombre, @NotNull String apellido, @NotNull String rol) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.rol = rol;
        }

        public Long getUid() {
                return uid;
        }

        public void setUid(Long uid) {
                this.uid = uid;
        }

        @NotNull
        public String getNombre() {
                return nombre;
        }

        @NotNull
        public String getApellido() {
                return apellido;
        }

        @NotNull
        public String getRol() {
                return rol;
        }

        public Date getFecha() {
                return fecha;
        }

        public void setFecha(Date fecha) {
                this.fecha = fecha;
        }
}
