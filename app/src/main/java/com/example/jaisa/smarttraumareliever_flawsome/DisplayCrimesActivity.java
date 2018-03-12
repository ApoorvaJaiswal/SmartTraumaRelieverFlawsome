package com.example.jaisa.smarttraumareliever_flawsome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jaisa.smarttraumareliever_flawsome.Adapters.SolvedCrimesAdapter;
import com.example.jaisa.smarttraumareliever_flawsome.Beans.Complaint;

import java.util.ArrayList;

public class DisplayCrimesActivity extends AppCompatActivity {

    private RecyclerView mCrimesReportedView;
    private RecyclerView.Adapter mCrimesReportedAdapter;
    private RecyclerView.LayoutManager mCrimesReportedLayoutManager;
    private ArrayList<Complaint> mCrimesReportedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_crimes);

        getSupportActionBar().setTitle("Crimes Reported");

        mCrimesReportedView = (RecyclerView) findViewById(R.id.crimes_reported_view);
        mCrimesReportedView.setHasFixedSize(true);
        mCrimesReportedLayoutManager = new LinearLayoutManager(this);
        mCrimesReportedView.setLayoutManager(mCrimesReportedLayoutManager);

        mCrimesReportedList = new ArrayList<>();
        mCrimesReportedList.add(new Complaint("Acid", "User's desc", "11/03/2018", "23:27", "Karnataka Police"));
        mCrimesReportedList.add(new Complaint("Napthalene", "User's desc", "17/01/2018", "03:27", "Kerala Police"));
        mCrimesReportedList.add(new Complaint("Murder", "User's desc", "02/09/2018", "20:20", "Andhra Police"));

        mCrimesReportedAdapter =  new SolvedCrimesAdapter(mCrimesReportedList);
        mCrimesReportedView.setAdapter(mCrimesReportedAdapter);
    }
}
