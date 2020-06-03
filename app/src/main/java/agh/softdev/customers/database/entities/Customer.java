package agh.softdev.customers.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.PropertyKey;

@Entity
public class Customer {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Name;
    private Double Salary;

    public Customer(String name, Double salary) {
        Name = name;
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setId(int id) {
        this.id = id;
    }
}
