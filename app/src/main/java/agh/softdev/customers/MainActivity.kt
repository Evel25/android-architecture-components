package agh.softdev.customers

import agh.softdev.customers.database.entities.Customer
import agh.softdev.customers.viewModels.CustomerViewModel
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var customerViewModel: CustomerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java);
        //val customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        val customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)


        btnAddCust.setOnClickListener(View.OnClickListener {
            //var cust:Customer = Customer("mostafa",1254.00);
            //customerViewModel.insert(cust);
            //Toast.makeText(applicationContext,"i think the customer is created",Toast.LENGTH_LONG).show();

            val intent = Intent(this, add_customer::class.java);
            startActivity(intent);
        })
    }
}
