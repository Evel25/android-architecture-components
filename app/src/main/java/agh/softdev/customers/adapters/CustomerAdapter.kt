package agh.softdev.customers.adapters

import agh.softdev.customers.R
import agh.softdev.customers.customers
import agh.softdev.customers.models.Customer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.customer_card_item.view.*

class CustomerAdapter(private val Customers:List<agh.softdev.customers.database.entities.Customer>) : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCustomerName:TextView = itemView.txtCustomerName
        val txtCustomerSalary:TextView = itemView.txtCustomerSalary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.customer_card_item,parent,false);

        return CustomerViewHolder(itemView);
    }

    public fun getItemAt(position: Int):agh.softdev.customers.database.entities.Customer{
        return Customers[position];
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val currentCustomer:agh.softdev.customers.database.entities.Customer = Customers.get(position);

        holder.txtCustomerName.text = currentCustomer.name;
        holder.txtCustomerSalary.text = currentCustomer.salary.toString();
    }

    override fun getItemCount() = Customers.size;
}