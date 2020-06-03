package agh.softdev.customers.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.PropertyKey;

@Entity
public class Customer {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Double salary;

    public Customer(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }
}
