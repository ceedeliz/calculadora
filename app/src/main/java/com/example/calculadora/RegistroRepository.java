package com.example.calculadora;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RegistroRepository {
    private RegistroDao registroDao;
    private LiveData<List<RegistroEntity>> allRegistros;
    public RegistroRepository(Application application){
        RegistroRoom db = RegistroRoom.getDatabase(application);
        registroDao = db.registroDao();
        allRegistros =registroDao.getAll();
    }
    public LiveData<List<RegistroEntity>> getAll() { return allRegistros;};

    public void insert (RegistroEntity registro){ new insertAsyncTask(registroDao).execute(registro);}

    private static class insertAsyncTask extends AsyncTask<RegistroEntity, Void, Void>{
        private RegistroDao registroDao;
        insertAsyncTask(RegistroDao dao){ registroDao = dao;}
        @Override
        protected Void doInBackground(RegistroEntity... registroEntities) {
            registroDao.insert(registroEntities[0]);
            return null;
        }
    }
}
