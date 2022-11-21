package com.example.autocompleteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView etFirstName, etLastName;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        submit = findViewById(R.id.submit);

        String[] names = {"Lee", "Leon", "Lenny", "Lennox", "Leopold", "Leonard", "Liam", "Levi", "Lucas", "Luke"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_design_autocomplete, names);

        etFirstName.setThreshold(1);//starts the autocomplete after the first character is typed
        etFirstName.setAdapter(adapter);

        etLastName.setThreshold(2);//starts the autocomplete after the second character is typed
        etLastName.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FirstName = etFirstName.getText().toString().trim();
                String LastName = etLastName.getText().toString().trim();

                if (FirstName.isEmpty()) {
                    etFirstName.setError("Enter your first name!");
                    etFirstName.requestFocus();
                }
                else if (LastName.isEmpty()) {
                    etLastName.setError("Enter your last name!");
                    etLastName.requestFocus();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Hurray!! Autocomplete worked successfully", Toast.LENGTH_LONG).show();
                    etFirstName.setText("");
                    etLastName.setText("");
                }
            }
        });
    }
}