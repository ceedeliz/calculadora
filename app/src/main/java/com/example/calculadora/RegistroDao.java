package com.example.calculadora;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RegistroDao {
    @Insert
    void insert(RegistroEntity registro);

    @Update
    void  update(RegistroEntity tarea);

    @Query("DELETE FROM registros")
    void deleteAll();

    @Query("DELETE FROM registros WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM registros ORDER BY id DESC")
    LiveData<List<RegistroEntity>> getAll();
}
