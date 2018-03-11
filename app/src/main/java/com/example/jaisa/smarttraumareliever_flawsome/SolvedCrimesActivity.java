package com.example.jaisa.smarttraumareliever_flawsome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jaisa.smarttraumareliever_flawsome.Adapters.LawsAdapter;
import com.example.jaisa.smarttraumareliever_flawsome.Adapters.SolvedCrimesAdapter;
import com.example.jaisa.smarttraumareliever_flawsome.Beans.Complaint;

import java.util.ArrayList;

public class SolvedCrimesActivity extends AppCompatActivity {

    private RecyclerView mSolvedView;
    private RecyclerView.Adapter mSolvedAdapter;
    private RecyclerView.LayoutManager mSolvedLayoutManager;
    private ArrayList<Complaint> mSolvedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_crimes);

        getSupportActionBar().setTitle("Solved Crimes");

        mSolvedView = (RecyclerView) findViewById(R.id.solved_view);
        mSolvedView.setHasFixedSize(true);
        mSolvedLayoutManager = new LinearLayoutManager(this);
        mSolvedView.setLayoutManager(mSolvedLayoutManager);

        mSolvedList = new ArrayList<>();
        mSolvedList.add(new Complaint("Acid", "User's desc", "11/03/2018", "23:27", "Karnataka Police"));
        mSolvedList.add(new Complaint("Napthalene", "User's desc", "17/01/2018", "03:27", "Kerala Police"));
        mSolvedList.add(new Complaint("Murder", "User's desc", "02/09/2018", "20:20", "Andhra Police"));

        mSolvedAdapter =  new SolvedCrimesAdapter(mSolvedList);
        mSolvedView.setAdapter(mSolvedAdapter);
    }
}
