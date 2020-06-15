package com.example.calculadora;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RegistroViewModel extends AndroidViewModel {
    public LiveData<List<RegistroEntity>> allRegistros;
    public RegistroRepository registroRepository;

    public RegistroViewModel(Application application) {
        super(application);
        registroRepository = new RegistroRepository(application);
        allRegistros = registroRepository.getAll();
    }

    public LiveData<List<RegistroEntity>> getAllRegistros() {
        return allRegistros;
    }
    public void insertarRegistro(RegistroEntity nuevoregistroEntity){
        registroRepository.insert(nuevoregistroEntity);
    }
}
