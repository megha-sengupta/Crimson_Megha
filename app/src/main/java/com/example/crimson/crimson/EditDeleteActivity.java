package com.example.crimson.crimson;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDateTime;

public class EditDeleteActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private Spinner spinner2;
    private Button doneEditButton;
    public String name;


    public UpdateInfo info;


    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    private String userID = user.getUid();
    private FirebaseAuth.AuthStateListener mAuthListener;

    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        textView1 = (TextView) findViewById(R.id.textView9);
        textView2 = (TextView) findViewById(R.id.textView10);
        spinner2 = (Spinner) findViewById(R.id.spinner);
        doneEditButton = (Button)findViewById(R.id.button4);

        doneEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = spinner2.getSelectedItem().toString();
                if (name.equals("Choose a category")) {
                    Toast.makeText(EditDeleteActivity.this, "Please choose a category.", Toast.LENGTH_LONG).show();
                    }

                else
                    UpdateDetails();
            }
        });


    }

    public void UpdateDetails(){

        //name = spinner2.getSelectedItem().toString();
        UpdateInfo newInfo = new UpdateInfo(name);
        ref = ref.child(userID);
        ref.setValue(newInfo);
        Toast.makeText(EditDeleteActivity.this,"Details entered succesfully!",Toast.LENGTH_LONG).show();
    }

}
