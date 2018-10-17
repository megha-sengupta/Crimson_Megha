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
import android.text.TextUtils;
import android.widget.Toast;

public class tracking extends AppCompatActivity {
    private TextView amount, date, time;
    private EditText actualAmount;
    private Button bu1;
    private Spinner spinner;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        actualAmount = (EditText) findViewById(R.id.editText3);
        spinner = (Spinner) findViewById(R.id.spinner1);
        bu1 = (Button) findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }
        public void update(){

            String amount1 = actualAmount.getText().toString();
            String name = spinner.getSelectedItem().toString();
            if (TextUtils.isEmpty(amount1) || TextUtils.isEmpty(name)|| (name =="Choose a category")) {
                new AlertDialog.Builder(this).setMessage("Enter All Details").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actualAmount.setText(null);
                        spinner.setSelection(0);
                    }

                });
            }
                else{
                //firebase has to  be implemented here.
        Toast.makeText(tracking.this, "Updated", Toast.LENGTH_LONG).show();
          actualAmount.setText(null);
        }
    }
}
