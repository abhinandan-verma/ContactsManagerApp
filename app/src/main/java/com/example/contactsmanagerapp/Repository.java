package com.example.contactsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.logging.LogRecord;

public class Repository {
    //The Available Data sources
    // -ROOM Database

    private  final  ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;
    public Repository(Application application) {

        ContactDataBase contactDataBase = ContactDataBase.getInstance(application);
        this.contactDAO = contactDataBase.getContactDAO();

        //Used for Background Database Operations
        executor = Executors.newSingleThreadExecutor();

        //Used for Updating the UI
         handler = new Handler(Looper.getMainLooper());
    }

    //Methods in DAO being executed from Repository
    public  void addContact(Contacts contact){


        executor.execute(new Runnable() {
            @Override
            public void run() {
                //executes the code asynchronously on separate threads
                contactDAO.insert(contact);
            }
        });

    }
    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });

    }
    public LiveData<List<Contacts>> getAllContacts(){

       return contactDAO.getAllContacts();
    }
}
