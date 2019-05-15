package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.Model.QuestionOS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2ActivitySec1 extends AppCompatActivity {
    List<QuestionOS> quesList;
    public int score=0;
    int ctr1=1;
    QuestionOS currentQ1;
    TextView txtQuestion;
    RadioGroup grp;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime;
    public ArrayList<String> wrongQuestList = new ArrayList<String>();
    public ArrayList<String> selectedAnswer = new ArrayList<String>();
    public ArrayList<String> actualAnswer = new ArrayList<String>();
    int number;
    ProgressBar progressBar;
    int progress = 1;
    String catName="",levelName="";
    TextView qstnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_sec1);
        qstnNo = (TextView)findViewById(R.id.qstnNo);
        
        Intent iin=getIntent();
        Bundle b=iin.getExtras();

        if(b!=null){
            catName=(String)b.get("category_name");
            levelName=(String)b.get("level_name");
            Log.d("Category Name",catName);
            Log.d("Level Name",levelName);
        }
        number=0;
        DbHelper db= new DbHelper(this);
        textViewTime = (TextView)findViewById(R.id.textViewTime);
        final CounterClass timer = new CounterClass(1800000, 1000);
        timer.start();
        quesList =db.getAllQuestions(catName,levelName);
        for(int i=0;i<5;i++){
            while(true){
                int next = random.nextInt(5);
                if(!list.contains(next))
                {
                    list.add(next);
                    break;
                }
            }
        }
        currentQ1= quesList.get(list.get(0));
        txtQuestion =(TextView)findViewById(R.id.textView1);
        rda =(RadioButton)findViewById(R.id.radio0);
        rdb =(RadioButton)findViewById(R.id.radio1);
        rdc =(RadioButton)findViewById(R.id.radio2);
        rdd =(RadioButton)findViewById(R.id.radio3);
        butNext =(Button)findViewById(R.id.button1);
        setQuestionView();
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        butNext.setEnabled(false);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.radio0 || i == R.id.radio1 || i==R.id.radio2 || i == R.id.radio3)
                    butNext.setEnabled(true);
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setProgress(1);
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress+1;
                progressBar.setProgress(progress);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                //Log.d("yourans", currentQ1.getANSWER1() + " " + answer.getText());
                if (currentQ1.getANSWER().equals(answer.getText())) {
                    score++;
                    //Log.d("score", "Your score" + score1);
                }
                else
                {
                    wrongQuestList.add(number, currentQ1.getQUESTION());
                    selectedAnswer.add(number, answer.getText().toString());
                    actualAnswer.add(number, currentQ1.getANSWER());
                    number++;
                }
                grp.clearCheck();
                butNext.setEnabled(false);
                if (ctr1 < 5) {
                    if (ctr1 == 4) {
                        butNext.setText("End Test");
                    }
                    currentQ1 = quesList.get(list.get(ctr1));
                    setQuestionView();
                } else {
                    timer.onFinish();
                    timer.cancel();
                }
            }
        });

    }

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
           showResult();
        }
    }

    public void showResult(){
        Intent intent = new Intent(Main2ActivitySec1.this, ResultActivity.class);
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
        rda.setText(currentQ1.getOPTA());
        rdb.setText(currentQ1.getOPTB());
        rdc.setText(currentQ1.getOPTC());
        rdd.setText(currentQ1.getOPTD());
        if(ctr1<10)
            qstnNo.setText("0" + ctr1 + "/30");
        else
            qstnNo.setText("" + ctr1+ "/30");
        ctr1++;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage("If you close all your progress would not be saved... Do you wish to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        // alert.setTitle("CompQuiz");
        alert.show();
    }
}
