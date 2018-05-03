package com.example.googlemapdemo.firebasedemo;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Dell on 03-05-2018.
 */

public class UserDAO {
    Context context;

    public UserDAO(Context context) {
        this.context = context;
    }

    void userAdd(int id, UserModel u) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        DatabaseReference ref = myRef.child("users" + id);
        ref.child("name").setValue(u.getName());
        ref.child("email").setValue(u.getEmail());
    }
}
