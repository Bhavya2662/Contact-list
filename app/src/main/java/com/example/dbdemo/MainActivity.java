package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dbdemo.data.MyDBHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHandler db= new MyDBHandler(MainActivity.this);

        Contact aergia = new Contact();
        aergia.setPhoneNumber("70236962764");
        aergia.setName("Aergia");

        db.addContact(aergia);
        aergia.setName("Bhavya");
        aergia.setPhoneNumber("1211212122");
        db.updateContact(aergia);
        //db.deleteContactById(1);
        ArrayList<String> contacts= new ArrayList<>();
//        listView = findViewById(R.id.list_view);


        List<Contact> allContacts = db.getAllContacts();
        for (Contact contact : allContacts){

            contacts.add(contact.getName() + " (" +  contact.getPhoneNumber()+" )");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);
    }
}