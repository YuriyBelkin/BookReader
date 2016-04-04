package com.example.ben.bookreader;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class QuizActivity extends Activity {

    ImageView iv;
    TextView tv1;
    Button tv2;
    Button tv3;
    Button tv4;
    Button tv5;
    Button tv6;
    String bookName;
    ArrayList <Quiz> arrQuiz;
    int quizID;

    public void updateQuiz() {
        tv1.setText(arrQuiz.get(quizID).question);
        tv2.setText(arrQuiz.get(quizID).option1);
        tv3.setText(arrQuiz.get(quizID).option2);
        tv4.setText(arrQuiz.get(quizID).option3);
        tv5.setText(arrQuiz.get(quizID).option4);
        iv.setImageBitmap(arrQuiz.get(quizID).getImageQuiz(this));
    }

    public boolean verifyAnswer(int answer) {
        if(answer == arrQuiz.get(quizID).option_correct){
            ArrayList<String> arrQuiztmp = Achievement.getInstance().answeredQuestion;
            boolean answered = false;
            String alias = bookName + "_" + String.valueOf(quizID);
            for(int i = 0; i < arrQuiztmp.size(); i++){
                if(alias.compareTo(arrQuiztmp.get(i)) == 0)
                 answered = true;
            }

            if (answered == false) {
                Achievement.getInstance().answeredQuestion.add(alias);
                Achievement.getInstance().score++;
                Achievement.getInstance().achieveSomething(this);
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        else
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        iv = (ImageView) findViewById(R.id.imageView);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (Button) findViewById(R.id.textView2);
        tv3 = (Button) findViewById(R.id.textView3);
        tv4 = (Button) findViewById(R.id.textView4);
        tv5 = (Button) findViewById(R.id.textView5);
        tv6 = (Button) findViewById(R.id.helpButton);

        bookName = getIntent().getStringExtra("1");

        arrQuiz = new ArrayList<>();
        for (int i = 1; i <= 2; i++){
            arrQuiz.add(new Quiz(this, bookName, i));
        }
        quizID = 0;
        updateQuiz();

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyAnswer(1)) {
                    if (quizID + 1 < 2) {
                        quizID++;
                        updateQuiz();
                    } else
                        finish();
                }
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyAnswer(2)) {
                    if (quizID + 1 < 2) {
                        quizID++;
                        updateQuiz();
                    }
                    else
                        finish();
                }
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyAnswer(3)) {
                    if (quizID + 1 < 2) {
                        quizID++;
                        updateQuiz();
                    }
                    else
                        finish();
                }
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyAnswer(4)) {
                    if (quizID + 1 < 2) {
                        quizID++;
                        updateQuiz();
                    }
                    else
                        finish();
                }
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienchu();
                }
             });
    }

    private void hienchu() {
        ArrayList<String> arrQuiztmp = Achievement.getInstance().answeredQuestion;
        boolean answered = false;
        String alias = bookName + "_" + String.valueOf(quizID);
        for(int i = 0; i < arrQuiztmp.size(); i++){
            if(alias.compareTo(arrQuiztmp.get(i)) == 0)
                answered = true;
        }

        if (answered == false)
            Achievement.getInstance().answeredQuestion.add(alias);
        Toast.makeText(getApplicationContext(), "The answer is option number " + arrQuiz.get(quizID).option_correct, Toast.LENGTH_LONG).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
