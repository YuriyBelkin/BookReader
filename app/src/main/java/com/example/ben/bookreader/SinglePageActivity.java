package com.example.ben.bookreader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;


public class SinglePageActivity extends Activity {

    private String book_title = "";
    private int page_id = 1;
    private int page_total = 0;
    TextView tvhihi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_page);

        Intent intent = getIntent();
        page_id = intent.getIntExtra("1", 0);
        page_total = intent.getIntExtra("3", 0);
        book_title = intent.getStringExtra("2");
        tvhihi = (TextView) findViewById(R.id.currentPage);
        showImageFromResource(page_id);

        Button button = (Button) findViewById(R.id.previous);
        Button button2 = (Button) findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page_id > 1)
                    page_id --;
                showImageFromResource(page_id);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page_id < page_total)
                    page_id ++;
                showImageFromResource(page_id);
                if(page_id == page_total)
                    hienchu();
            }
        });
    }

    private void hienchu() {
        Toast.makeText(getApplicationContext(), "END", Toast.LENGTH_SHORT).show();
    }

    private void showImageFromResource(int pageId) {
        tvhihi.setText("Page " + String.valueOf(pageId) + "/50");
        showImageFromResource(book_title + "_" + String.valueOf(pageId));
    }

    private void showImageFromResource(String fileName) {
        int id = getResources().getIdentifier(fileName, "drawable", getPackageName());
        ImageView imageView = (ImageView) findViewById(R.id.Image);
        imageView.setImageResource(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_page, menu);
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
