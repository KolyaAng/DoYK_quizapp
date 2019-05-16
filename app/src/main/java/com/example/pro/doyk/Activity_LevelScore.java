package com.example.pro.doyk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.LeaderBoard.Fundamentals.LeaderBoardAcSec1B;
import com.example.pro.doyk.LocalScoreBoard.ScoreLevel1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_LevelScore extends AppCompatActivity {

    Button catScore;
    Button leaderBoard;
    TextView yourScore;
    FirebaseAuth mAuth;
    DatabaseReference mUserRefDatabase;
    ChildEventListener mChildEventListener;
    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_score);
        setTitle("Рейтинг");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setAuthInstance();
        setDatabaseInstance();

        int totalScore = dbHelper.getTotalScore();

        String userId = mAuth.getCurrentUser().getUid();
        mUserRefDatabase.child("users").child(userId).child("totalScoreMarks").setValue(totalScore);

        catScore = findViewById(R.id.btnCatScore);
        leaderBoard = findViewById(R.id.btnLeaderb);
        yourScore = findViewById(R.id.tvYourS);

        yourScore.setText("Твій результат: " + String.valueOf(totalScore));

        catScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ScoreLevel1.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int totalScore = dbHelper.getTotalScore();
//                String ts = String.valueOf(totalScore);
//
//                Toast toast = Toast.makeText(getApplicationContext(), ts, Toast.LENGTH_LONG);
//                toast.show();

                Intent i= new Intent(getApplicationContext(), LeaderBoardAcSec1B.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
