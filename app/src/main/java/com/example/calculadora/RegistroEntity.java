package com.example.calculadora;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "registros")
public class RegistroEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String resultado;

    public RegistroEntity(String resultado) {
        this.resultado = resultado;
    }

    public String getRegistro() {
        return resultado;
    }

    public void setRegistro(String resultado) {
        this.resultado = resultado;
    }
}
