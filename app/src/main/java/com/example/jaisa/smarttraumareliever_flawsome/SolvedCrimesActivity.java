package com.example.jaisa.smarttraumareliever_flawsome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SolvedCrimesActivity extends AppCompatActivity {
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_crimes);
        reference = FirebaseDatabase.getInstance().getReference();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.child("users").getChildren()) {
                    String id = postSnapshot.getKey();
                    for(DataSnapshot crimeSnap :postSnapshot.child(id).child("crimes").getChildren())
                    {
                        String crimeID= crimeSnap.getKey();

                        String desc= crimeSnap.child(crimeID).child("description").getValue(String.class);
                        String reportedTo= crimeSnap.child(crimeID).child("reportedTo").getValue(String.class);
                        Boolean solved = crimeSnap.child(crimeID).child("solvedDetails").child("solved").getValue(Boolean.class);
                        String solvedTime = crimeSnap.child(crimeID).child("solvedDetails").child("solvedTimestamp").getValue(String.class);
                        int date = crimeSnap.child(crimeID).child("reportedTimestamp").child("date").getValue(Integer.class);
                        int month = crimeSnap.child(crimeID).child("reportedTimestamp").child("month").getValue(Integer.class);
                        int hour = crimeSnap.child(crimeID).child("reportedTimestamp").child("hours").getValue(Integer.class);
                        int minute = crimeSnap.child(crimeID).child("reportedTimestamp").child("minutes").getValue(Integer.class);
                        int sec = crimeSnap.child(crimeID).child("reportedTimestamp").child("seconds").getValue(Integer.class);
                        String d = hour+":"+minute+":"+sec+" , "+date+"/"+(month+1);



                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }

