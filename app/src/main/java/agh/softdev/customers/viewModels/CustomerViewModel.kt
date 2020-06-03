package agh.softdev.customers.viewModels

import agh.softdev.customers.database.entities.Customer
import agh.softdev.customers.repositories.CustomerRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class CustomerViewModel(application: Application) : AndroidViewModel(application) {
    var repository: CustomerRepository;
    var customers:LiveData<List<Customer>>;

    init {
        repository = CustomerRepository(application);
        customers = repository.allCustomers;
    }

    public fun insert(customer: Customer){
        repository.insert(customer);
    }

    public fun delete(customer: Customer){
        repository.delete(customer);
    }

    public fun update(customer: Customer){
        repository.update(customer);
    }

    public fun deleteAll(){
        repository.deleteAll();
    }

    public fun getAllCustomers():LiveData<List<Customer>>{
        return repository.allCustomers;
    }

}