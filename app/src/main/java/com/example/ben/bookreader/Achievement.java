package com.example.ben.bookreader;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ben on 6/30/2015.
 */
public class Achievement {
    private static Achievement ourInstance = new Achievement();

    public static Achievement getInstance() {
        return ourInstance;
    }

    private Achievement() {}

    public int score = 0;
    public ArrayList<String> answeredQuestion = new ArrayList<>();

    public void achieveSomething(Context context) {
        if(score == 2)
            Toast.makeText(context, "Congrats, you have reached Level 1!", Toast.LENGTH_SHORT).show();
        if(score == 4)
            Toast.makeText(context, "Congrats, you have reached Level 2!", Toast.LENGTH_SHORT).show();
        if(score == 6)
            Toast.makeText(context, "Congrats, you have reached Level 3!", Toast.LENGTH_SHORT).show();
        if(score == 8)
            Toast.makeText(context, "Congrats, you have reached Level 4!", Toast.LENGTH_SHORT).show();
        if(score == 10)
            Toast.makeText(context, "Congrats, you have reached Level 5!", Toast.LENGTH_SHORT).show();
    }

}
