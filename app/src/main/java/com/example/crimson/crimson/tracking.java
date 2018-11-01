package com.example.crimson.crimson;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;

import java.text.*;
import java.util.*;
import java.time.*;

import android.text.TextUtils;
import android.widget.Toast;


public class tracking extends AppCompatActivity {

    private EditText actualAmount;
    private Button bu1;
    private Spinner spinner;
    private DatabaseReference ref= FirebaseDatabase.getInstance().getReference();

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener mAuthListener;
    public String amount1,name;
    public LocalDateTime dateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        actualAmount = (EditText) findViewById(R.id.editText3);
        spinner = (Spinner) findViewById(R.id.spinner1);
        bu1 = (Button) findViewById(R.id.button);

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }
        public void update() {

            amount1 = actualAmount.getText().toString();
            //TextView textView = (TextView)spinner.getSelectedView();
            //name = textView.getText().toString();
            name = spinner.getSelectedItem().toString();
            if (TextUtils.isEmpty(amount1) || name.equals("Choose a category")) {
                new AlertDialog.Builder(this).setMessage("Enter All Details").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actualAmount.setText(null);
                        spinner.setSelection(0);
                    }

                }).create().show();
            } else {

                setUserInfo();
                actualAmount.setText(null);
                spinner.setSelection(0);
            }
        }
        public void setUserInfo()
            {
                UpdateInfo info = new UpdateInfo(amount1,name,dateTime);
                FirebaseUser user = mAuth.getCurrentUser();
                ref.child(user.getUid()).setValue(info);
                Toast.makeText(tracking.this,"Details entered succesfully!",Toast.LENGTH_LONG).show();
            }
    }
