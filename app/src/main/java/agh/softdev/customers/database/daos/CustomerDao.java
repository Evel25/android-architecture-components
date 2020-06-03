package agh.softdev.customers.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import agh.softdev.customers.database.entities.Customer;

@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);
    @Update
    void update(Customer customer);
    @Delete
    void delete(Customer customer);
    @Query("Delete From customer")
    void deleteAll();
    @Query("SELECT * FROM customer")
    LiveData<List<Customer>> getAll();
}
