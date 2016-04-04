package com.example.ben.bookreader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by Ben on 6/29/2015.
 */
public class Quiz {
    public String quizImagePath;
    public String bookName;
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public int option_correct;

    public Quiz (Activity context, String bookName, int questionNumber) {
        int questionArrayID = context.getResources().getIdentifier(bookName + "_" + questionNumber, "array", context.getPackageName());
        String[] questionArray = context.getResources().getStringArray(questionArrayID);
        quizImagePath = questionArray[0];
        bookName = questionArray[1];
        question = questionArray[2];
        option1 = questionArray[3];
        option2 = questionArray[4];
        option3 = questionArray[5];
        option4 = questionArray[6];
        option_correct = Integer.parseInt(questionArray[7]);
    }

    public Bitmap getImageQuiz(Context context) {
        if(quizImagePath.compareTo("") == 0) return null;

        int id = context.getResources().getIdentifier(quizImagePath, "drawable", context.getPackageName());
        return BitmapFactory.decodeResource(context.getResources(), id);
    }
}
