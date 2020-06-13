package com.example.jaisa.smarttraumareliever_flawsome;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout reportingStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setSubtitle(R.string.app_bytext);

        reportingStatus = (LinearLayout)findViewById(R.id.reporting_status);
        reportingStatus.setVisibility(View.GONE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_user_profile){
            startActivity(new Intent(MainActivity.this,ProfileActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.report_crime:
                intent = new Intent(MainActivity.this,ReportCrimeActivity.class);
                startActivity(intent);
                break;
            case R.id.crimes_reported:
                intent = new Intent(MainActivity.this,DisplayCrimesActivity.class);
                startActivity(intent);
                break;
            case R.id.solved_crime:
                intent = new Intent(MainActivity.this,SolvedCrimesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
