package com.example.googlemapdemo.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.googlemapdemo.R;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, ChildEventListener {

    EditText edName, edEmail;
    Button btnSave;
    List<UserModel> userList = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        btnSave = findViewById(R.id.btnSave);
        lv = findViewById(R.id.lv);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, userList);
        lv.setAdapter(arrayAdapter);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        UserModel userModel = new UserModel();
        userModel.setName(edName.getText().toString());
        userModel.setEmail(edEmail.getText().toString());


        UserDAO userDAO=new UserDAO(this);
        userDAO.userAdd(UserModel.userId++,userModel);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference myRef = firebaseDatabase.getReference("user");

        myRef.addChildEventListener(this);

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        userList.add(dataSnapshot.getValue(UserModel.class));
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
