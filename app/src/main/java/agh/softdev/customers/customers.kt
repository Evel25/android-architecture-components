package agh.softdev.customers

import agh.softdev.customers.adapters.CustomerAdapter
import agh.softdev.customers.models.Customer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_customers.*

class customers : AppCompatActivity() {

    private var CustomersList: List<Customer> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)
        CustomersList = createDummyCustomers();

        customerslist.adapter = CustomerAdapter(CustomersList);
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
