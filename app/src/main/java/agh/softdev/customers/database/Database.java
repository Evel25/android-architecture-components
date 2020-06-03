package agh.softdev.customers.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import agh.softdev.customers.database.daos.CustomerDao;
import agh.softdev.customers.database.entities.Customer;

@androidx.room.Database(entities = {Customer.class},version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instanse;

    public abstract CustomerDao customerDao();

    public static synchronized Database getInstance(Context context){
        if(instanse == null){
            instanse  = Room.databaseBuilder(context.getApplicationContext(),Database.class,"customers_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instanse;
    }
}
