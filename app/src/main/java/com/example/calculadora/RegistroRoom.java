package com.example.calculadora;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RegistroEntity.class}, version = 1)
public abstract class RegistroRoom extends RoomDatabase {
    public abstract RegistroDao registroDao();
    private static volatile RegistroRoom INSTANCE;

    public static RegistroRoom getDatabase(final Context context){
        if(INSTANCE ==null){
            synchronized (RegistroRoom.class){
                if(INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RegistroRoom.class, "tarea_base").build();
                }
            }
        }
        return  INSTANCE;
    }

}
