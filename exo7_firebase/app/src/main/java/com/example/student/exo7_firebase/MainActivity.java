package com.example.student.exo7_firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText mLogin;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("IMERIR", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("IMERIR", "onAuthStateChanged:signed_out");
                }

            }
        };



    }


    // redirect to the activity for registration
    public void clickButtonSignUp(View view){
        Intent intent = new Intent(MainActivity.this, RegistrationEmailPasswordActivity.class);
        startActivity(intent);


    }

    // login
    public void clickButtonSignIn(View view){
        mLogin = (EditText) findViewById(R.id.text_email_login);
        mPassword = (EditText) findViewById(R.id.text_password_login);

        String email = mLogin.getText().toString();
        String password = mPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("IMERIR", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("IMERIR", "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, "auth failed",
                                    Toast.LENGTH_SHORT).show();
                        }

                        Toast.makeText(MainActivity.this, "auth succes",
                                Toast.LENGTH_SHORT).show();
                    }
                });





    }

}
