package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.Model.QuestionOS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.example.pro.doyk.Adapter.Category.getCategoryTitle;

public class QuestActivity extends AppCompatActivity {
    List<QuestionOS> quesList;
    public int score = 0;
    int ctr1 = 0;
    QuestionOS currentQ1;
    TextView txtQuestion;

    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnAnswer;

    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime;
    public ArrayList<String> wrongQuestList = new ArrayList<String>();
    public ArrayList<String> selectedAnswer = new ArrayList<String>();
    public ArrayList<String> actualAnswer = new ArrayList<String>();
    int number;
    String catName = "", levelName = "";
    TextView qstnNo;
    boolean timerFlag;
    String answer;


    ///
///
    final CounterClass timer = new CounterClass(21000, 1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        qstnNo = (TextView) findViewById(R.id.qstnNo);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.ab_align);
        TextView tvTitle = findViewById(R.id.tvTitle);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);

        btnA.setOnClickListener(listener);
        btnB.setOnClickListener(listener);
        btnC.setOnClickListener(listener);
        btnD.setOnClickListener(listener);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            catName = (String) b.get("category_name");
            levelName = (String) b.get("level_name");
            Log.d("CategoryName", catName);
            Log.d("LevelName", levelName);
        }
        tvTitle.setText(getCategoryTitle(catName));
        number = 0;

        DbHelper db = new DbHelper(this);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        timer.start();
        quesList = db.getAllQuestions(catName, levelName);
        Log.d("ListSize", "quesList" + quesList.size());
        for (int i = 0; i < quesList.size(); i++) {
            while (true) {
                int next = random.nextInt(quesList.size());
                if (!list.contains(next)) {
                    list.add(next);
                    Log.d("ListSize", "list" + list.get(i));
                    break;
                }
            }
        }
        currentQ1 = quesList.get(list.get(0));
        txtQuestion = (TextView) findViewById(R.id.textView1);
        setQuestionView();

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnA:
                    answer = btnA.getText().toString();
                    btnAnswer = btnA;
                    break;
                case R.id.btnB:
                    answer = btnB.getText().toString();
                    btnAnswer = btnB;
                    break;
                case R.id.btnC:
                    answer = btnC.getText().toString();
                    btnAnswer = btnC;
                    break;
                case R.id.btnD:
                    answer = btnD.getText().toString();
                    btnAnswer = btnD;
                    break;
            }
            timerFlag = true;
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            btnD.setEnabled(false);
            if (currentQ1.getANSWER().equals(answer)) {
                btnAnswer.setBackgroundDrawable(getResources().getDrawable(R.drawable.shapeofrectanglebtn_green));

            } else {
                btnAnswer.setBackgroundDrawable(getResources().getDrawable(R.drawable.shapeofrectanglebtn_red));
            }
            Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextQuest();
                    }
                }, 1000);
        }
    };


    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            timerFlag = false;
            nextQuest();
        }
    }

    public void nextQuest() {

        if(btnAnswer != null){
            btnAnswer.setBackgroundDrawable(getResources().getDrawable(R.drawable.shapeofrectanglebtn));
        }
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        timer.start();
        if (timerFlag) {
            if (currentQ1.getANSWER().equals(answer)) {
                score++;
            } else {
                wrongQuestList.add(number, currentQ1.getQUESTION());
                selectedAnswer.add(number, answer);
                actualAnswer.add(number, currentQ1.getANSWER());
                number++;
            }
        } else {
            wrongQuestList.add(number, currentQ1.getQUESTION());
            selectedAnswer.add(number, "Час питання вийшов.");
            actualAnswer.add(number, currentQ1.getANSWER());
            number++;
        }

        if (ctr1 < increment(quesList.size())) {
            Log.d("ListSize", "increment" + increment(quesList.size()));
            currentQ1 = quesList.get(list.get(ctr1));
            setQuestionView();
        } else {
            timer.cancel();
            showResult();
        }

    }



    public int increment(int size){
        int i;
        if(size <= 10){i = size;}
        else{i = 10;}
        return i;
    }

    public void showResult(){
        Intent intent = new Intent(QuestActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score);//Your score
        b.putString("category_name",catName);//Your table name
        b.putString("level_name",levelName);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestList);
        intent.putStringArrayListExtra("selectedAnswer", selectedAnswer);
        intent.putStringArrayListExtra("actualAnswer", actualAnswer);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    private void setQuestionView(){
        txtQuestion.setText(currentQ1.getQUESTION());
        btnA.setText(currentQ1.getOPTA());
        btnB.setText(currentQ1.getOPTB());
        btnC.setText(currentQ1.getOPTC());
        btnD.setText(currentQ1.getOPTD());
        if(ctr1 < 9)
            qstnNo.setText("0" + (ctr1 + 1) + "/10");
        else
            qstnNo.setText("" + (ctr1 + 1)+ "/10");
        ctr1++;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.exit_fr_quest)
                .setCancelable(false)
                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        timer.cancel();
                        finish();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}

