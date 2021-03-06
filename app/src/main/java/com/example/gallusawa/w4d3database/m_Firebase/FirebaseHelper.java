package com.example.gallusawa.w4d3database.m_Firebase;

import com.example.gallusawa.w4d3database.m_Model.Spacecraft;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by gallusawa on 8/23/17.
 */

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<Spacecraft> spacecrafts = new ArrayList<>();


    //Pass Database Reference
    public FirebaseHelper(DatabaseReference db){
        this.db=db;
    }

    //Write if not null
    public boolean save(Spacecraft spacecraft){

        if(spacecraft == null){
            saved =false;
        }else{
            try{
                db.child("spacecraft").push().setValue(spacecraft);
                saved=true;

            }catch (DatabaseException e){
                e.printStackTrace();
                saved = false;
            }
        }
        return  saved;
    }

    //Implement FetchData to fill the ArrayList
    private  void fetchData(DataSnapshot dataSnapshot){
        spacecrafts.clear();

        for(DataSnapshot ds: dataSnapshot.getChildren()){
            Spacecraft spacecraft = ds.getValue(Spacecraft.class);
            spacecrafts.add(spacecraft);
        }


    }
   //Retrieve data
    public ArrayList<Spacecraft> retrieve(){

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);
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
        });

        return spacecrafts;
    }


}
