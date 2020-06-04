package agh.softdev.customers

import agh.softdev.customers.adapters.CustomerAdapter
import agh.softdev.customers.database.entities.Customer
import agh.softdev.customers.viewModels.CustomerViewModel
import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_customers.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var customerViewModel:CustomerViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var customerViewModel: CustomerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java);
        //val customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java);
        val customersObserver = Observer<List<agh.softdev.customers.database.entities.Customer>> { customers ->
            txtCustomerCount.text = "${customers.size} Customer";
        }
        customerViewModel.customers.observe(this,customersObserver);

        btnAddCust.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, add_customer::class.java);
            startActivityForResult(intent,100);
        })

        btnCustomers.setOnClickListener(View.OnClickListener {
            val customersIntent = Intent(this,customers::class.java);
            startActivity(customersIntent);
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Toast.makeText(this,"i am here and request code is ${requestCode}",Toast.LENGTH_LONG).show()
        if(requestCode == 100 && resultCode == RESULT_OK){
            val name : String? = data?.extras?.getString("name")
            val salary : Double? = data?.extras?.getDouble("salary")

            // add the customer to the database
            val customer = Customer(name,salary);
            customerViewModel.insert(customer);

            Toast.makeText(this,"Your Customer Is Inserted",Toast.LENGTH_LONG).show()
        }
    }
}
