package agh.softdev.customers.repositories

import agh.softdev.customers.database.Database
import agh.softdev.customers.database.daos.CustomerDao
import agh.softdev.customers.database.entities.Customer
import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerRepository(application: Application) {

    var customerDao : CustomerDao;
    var allCustomers : LiveData<List<Customer>>;

    init {
        var database:Database = Database.getInstance(application);
        customerDao = database.customerDao();
        allCustomers = customerDao.all;
    }

    public fun insert(customer: Customer){
        // start new coroutine to add a customer
        CoroutineScope(Dispatchers.IO).launch {
            customerDao.insert(customer);
        }
    }

    public fun update(customer: Customer){
        CoroutineScope(Dispatchers.IO).launch {
            customerDao.update(customer);
        }
    }

    public fun delete(customer: Customer){
        CoroutineScope(Dispatchers.IO).launch {
            customerDao.delete(customer);
        }
    }

    public fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            customerDao.deleteAll();
        }
    }
}