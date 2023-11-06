package com.example.contactsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {Contacts.class},version = 1)
public abstract class ContactDataBase extends RoomDatabase {
    public abstract  ContactDAO getContactDAO();

    //Singleton Pattern
    private  static ContactDataBase dbInstances;

    public static synchronized ContactDataBase getInstance(Context context){
        if(dbInstances == null){
            dbInstances = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDataBase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbInstances;
    }
}
