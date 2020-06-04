package agh.softdev.customers

import agh.softdev.customers.adapters.CustomerAdapter
import agh.softdev.customers.models.Customer
import agh.softdev.customers.viewModels.CustomerViewModel
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_customers.*
import kotlinx.android.synthetic.main.activity_main.*

class customers : AppCompatActivity() {

    private var CustomersList: List<Customer> = ArrayList();
    lateinit var customerViewModel:CustomerViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)
        CustomersList = createDummyCustomers();

        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java);

        val customersObserver = Observer<List<agh.softdev.customers.database.entities.Customer>> { customers ->
            customerslist.adapter = CustomerAdapter(customers);
        }
        customerViewModel.customers.observe(this,customersObserver);


        customerslist.layoutManager = LinearLayoutManager(this);
        customerslist.setHasFixedSize(true);


    }

    private fun createDummyCustomers() : List<Customer>{
        var customers:List<Customer> = ArrayList();
        for (i in 1..100){
            customers += Customer("Customer${i}",i*10.2)
        }
        return customers;
    }





}
