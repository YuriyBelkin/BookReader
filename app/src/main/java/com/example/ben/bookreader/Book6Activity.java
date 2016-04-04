package com.example.ben.bookreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Book6Activity extends Activity {

    ArrayList<String> content = new ArrayList<String>();
    String imgPath;
    int pageID;

    Button b1;
    Button b2;
    TextView tv;
    TextView tvhihi;

    public void updatePage(){
        tv.setText(content.get(pageID));
        showImageFromResource(pageID + 1);
    }

    private void showImageFromResource(int pageId) {
        tvhihi.setText("Page " + String.valueOf(pageId) + "/10");
        showImageFromResource("book6" + "_" + String.valueOf(pageId));
    }

    private void showImageFromResource(String fileName) {
        int id = getResources().getIdentifier(fileName, "drawable", getPackageName());
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(id);
    }

    private void hienchu() {
        Toast.makeText(getApplicationContext(), "END", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book6);
        pageID = getIntent().getIntExtra("4", 1) - 1;
        b1 = (Button) findViewById(R.id.next_button);
        b2 = (Button) findViewById(R.id.prev_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pageID + 1 < 10) {
                    ++pageID;
                    updatePage();
                     }
                else {
                    hienchu();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pageID >= 1) {
                    --pageID;
                    updatePage();
                }
            }
        });

        content.add("Nine little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only eight little ducks came back.");

        content.add("Eight little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only seven little ducks came back.");

        content.add("Seven little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only six little ducks came back.");

        content.add("Six little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only five little ducks came back.");

        content.add("Five little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only four little ducks came back.");

        content.add("Five little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only three little ducks came back.");

        content.add("Five little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only two little ducks came back.");

        content.add("Five little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But only one little ducks came back.");

        content.add("Five little ducks \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But But none of the five little ducks came back.");

        content.add("Sad mother duck \n" +
                "Went out one day \n" +
                "Over the hill and far away \n" +
                "Mother duck said \n" +
                "\"Quack, quack, quack, quack.\" \n" +
                "But all of the five little ducks are dead.");
        tv = (TextView) findViewById(R.id.textView7);
        tvhihi = (TextView) findViewById(R.id.textView8);

        updatePage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book6, menu);
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
