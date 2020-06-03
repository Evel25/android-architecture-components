package agh.softdev.customers.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

import agh.softdev.customers.database.daos.CustomerDao;
import agh.softdev.customers.database.entities.Customer;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@androidx.room.Database(entities = {Customer.class},version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instanse;

    public abstract CustomerDao customerDao();

    public static synchronized Database getInstance(Context context){
        if(instanse == null){
            instanse  = Room.databaseBuilder(context.getApplicationContext(),Database.class,"customers_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instanse;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InsertDummyCutomers(instanse).execute();
        }
    };

    private static class InsertDummyCutomers extends AsyncTask<Void,Void,Void>{
        private CustomerDao customerDao;
        private InsertDummyCutomers(Database db){
            customerDao = db.customerDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            customerDao.insert(new Customer("hafid id-baha",12546.2));
            customerDao.insert(new Customer("ahmed ali",125.462));
            customerDao.insert(new Customer("ousama said",12.5462));
            customerDao.insert(new Customer("ahmed jamaa",125.2));
            return null;
        }
    }
}
