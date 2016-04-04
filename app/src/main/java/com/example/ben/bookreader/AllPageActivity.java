package com.example.ben.bookreader;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllPageActivity extends Activity {

    Book book = new Book();

    private void intent_tmp(Page item) {
        if(book.numberOfPage == 10) {
            Intent intent6 = new Intent(this, Book6Activity.class);
            intent6.putExtra("4",item.PageNumber);
            startActivity(intent6);
        }
        else {
        Intent intent = new Intent(this, SinglePageActivity.class);
        intent.putExtra("1", item.PageNumber);
        intent.putExtra("2", book.title);
        intent.putExtra("3", book.numberOfPage);
        startActivity(intent);
        }
    }

    private void intent_quiz() {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("1", book.title);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_page_layout);
        Bundle b = getIntent().getBundleExtra("1");

        book.fromBundle(b);
        ImageView tvImg = (ImageView) findViewById(R.id.coverBook);
        tvImg.setImageBitmap(book.getCover(this));
        TextView tvtmp = (TextView) findViewById(R.id.booktitle);
        tvtmp.setText(book.titleForDisplay);
        // Construct the data source
        ArrayList<Page> arrayOfPages = new ArrayList<Page>();
        fetchingAllPages(arrayOfPages);

           // Create the adapter to convert the array to views
        PageAdapter adapter = new PageAdapter(this, arrayOfPages);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.PageList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Page item = (Page) adapterView.getItemAtPosition(i);
                intent_tmp(item);
            }
        });

        Button quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_quiz();
            }
        });

    }

    private void fetchingAllPages(ArrayList<Page> arrayOfPages) {
        for(int i = 1; i <= book.numberOfPage; i++){
            arrayOfPages.add(new Page(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_this, menu);
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
