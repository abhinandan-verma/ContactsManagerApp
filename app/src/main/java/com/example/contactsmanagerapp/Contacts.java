package com.example.contactsmanagerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
//each entity class corresponds to table &
//fields,properties & variables represent Columns

public class Contacts {
    @ColumnInfo(name = "column_id")
    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name = "column_name")
    private  String name;
    @ColumnInfo(name = "column_email")
    private  String email;

    public Contacts( String name, String email) {

        this.name = name;
        this.email = email;
    }

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
