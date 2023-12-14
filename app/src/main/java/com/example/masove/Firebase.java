package com.example.masove;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

    private static FirebaseAuth mAuth;
    private Context context;
    private static FirebaseDatabase DATABASE;
    private static DatabaseReference REFERENCE;
    public static FirebaseDatabase getDatabase() {
        if (DATABASE == null)
            DATABASE = FirebaseDatabase.getInstance();
        return DATABASE;
    }

    public static DatabaseReference getReference() {
        REFERENCE = getDatabase().getReference("Users");
        return REFERENCE;
    }

    public void FirebasecController(Context context) {
        this.context = context;
    }
    public static FirebaseAuth getAuth()
    {
        if(mAuth == null)
            mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public boolean CurrentUser()
    {
        FirebaseUser isFbUser= getAuth().getCurrentUser();
        if(isFbUser!=null)
            return true;
        return false;
    }
    public void LogOut()
    {
        getAuth().signOut();
    }
    public void creatUser(String email, String password, String userName) {
        getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserS user = new UserS(userName, task.getResult().getUser().getUid(), email);

                            Intent intent=new Intent(context,MainActivity.class);
                            context.startActivity(intent);
                        } else {;
                            Toast.makeText(context, "" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void signInUser (String email, String password) {
        getAuth().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);

                        } else {
                            ;
                            Toast.makeText(context, "" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

