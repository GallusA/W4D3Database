package com.example.gallusawa.w4d3database.view.MainActivity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallusawa.w4d3database.R;
import com.example.gallusawa.w4d3database.m_Firebase.FirebaseHelper;
import com.example.gallusawa.w4d3database.m_Model.Spacecraft;
import com.example.gallusawa.w4d3database.m_UI.MyAdaptor;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference db;
    FirebaseHelper helper;
    MyAdaptor adaptor;
    RecyclerView rv;

    EditText nameEditTxt, propTxt, descTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));



        //INITIALIZING  FIREBASE  Database
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);

        //ADAPTER
        adaptor = new MyAdaptor(this, helper.retrieve());
        rv.setAdapter(adaptor);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });

    }
//Display input Dialog
    private  void  displayInputDialog(){
        Dialog d = new Dialog(this);
        d.setTitle("Save Firebase");
        d.setContentView(R.layout.input_dialog);


        nameEditTxt = (EditText) d.findViewById(R.id.nameEditText);
         propTxt = (EditText) d.findViewById(R.id.propellantEditText);
        descTxt = (EditText) d.findViewById(R.id.descTxt);

        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);

        //save
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Data
                String name = nameEditTxt.getText().toString();
                String propellant = propTxt.getText().toString();
                String desc = descTxt.getText().toString();

                //Set Data

                Spacecraft s = new Spacecraft();
                s.setName(name);
                s.setPropellant(propellant);
                s.setDescription(desc);


                //validation

                if (name != null && name.length() > 0) {
                    //then save
                    if (helper.save(s)) {
                        //if saved, clair editTxt
                        nameEditTxt.setText("");
                        propTxt.setText("");
                        descTxt.setText("");


                        adaptor = new MyAdaptor(MainActivity.this, helper.retrieve());
                        rv.setAdapter(adaptor);

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Name must not be empty", Toast.LENGTH_SHORT).show();

                }
            }
        });
         d.show();
    }
    }



