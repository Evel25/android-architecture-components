package agh.softdev.customers

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_customer.*

class add_customer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)

        btnAddCust.setOnClickListener(View.OnClickListener {
            if(!edtName.text.trim().isEmpty() && !edtSalary.text.trim().isEmpty()){
                val name = edtName.text.toString();
                val salary = edtSalary.text.toString().toDouble();

                //Toast.makeText(this,"name ${name} and salary ${salary}",Toast.LENGTH_LONG).show()
                val intentResult = Intent();
                intentResult.putExtra("name",name);
                intentResult.putExtra("salary",salary);
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });
    }
}
