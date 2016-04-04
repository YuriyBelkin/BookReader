package com.example.ben.bookreader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;


/**
 * Created by Ben on 6/28/2015.
 */
public class Book {
    public String title;
    public int numberOfPage;
    public String titleForDisplay;

    public Book() {};
    public Book(String title, int numberOfPage, String titleForDisplay) {
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.titleForDisplay = titleForDisplay;
    }

    public void fromBundle(Bundle bundle) {
        title = bundle.getString("1");
        numberOfPage = bundle.getInt("2");
        titleForDisplay = bundle.getString("3");
    }

    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putString("1", title);
        b.putInt("2", numberOfPage);
        b.putString("3", titleForDisplay);
        return b;
    }

    public Bitmap getCover(Context context){
        int id = context.getResources().getIdentifier(title + "_1", "drawable", context.getPackageName());
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

}


