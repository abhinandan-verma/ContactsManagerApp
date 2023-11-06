package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    //AndroidViewModel class is a subClass of ViewModel
    //and similar to them, they are designed to store and
    //manage UI related data, are responsible to prepare and
    //provide data for UI and automatically allow data
    // to survive configuration change

    private  Repository myRepository;

    //liveData
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public  LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public  void addNewContact(Contacts contact){
        myRepository.addContact(contact);
    }
    public  void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }
}
