package com.example.ben.bookreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView tvScore;

    private void intent_tmp(Book item) {
            Intent intent = new Intent(this, AllPageActivity.class);
            intent.putExtra("1", item.toBundle());
            startActivity(intent);

    }

    @Override
    protected void onResume() {
        tvScore.setText("Score: " + String.valueOf(Achievement.getInstance().score));
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        ArrayList<Book> arrayOfBooks = new ArrayList<Book>();
        fetchingAllBooks(arrayOfBooks);

        // Create the adapter to convert the array to views
        BookAdapter adapter = new BookAdapter(this, arrayOfBooks);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.BookList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book item = (Book) adapterView.getItemAtPosition(i);
                intent_tmp(item);
            }
        });
        tvScore = (TextView) findViewById(R.id.textView6);
    }

    private void fetchingAllBooks(ArrayList<Book> arrayOfBooks) {
        arrayOfBooks.add(new Book("conan_1", 50, "Conan Episode 1"));
        arrayOfBooks.add(new Book("conan_12", 50, "Conan Episode 12"));
        arrayOfBooks.add(new Book("conan_13", 50, "Conan Episode 13"));
        arrayOfBooks.add(new Book("conan_14", 50, "Conan Episode 14"));
        arrayOfBooks.add(new Book("conan_15", 50, "Conan Episode 15"));
        arrayOfBooks.add(new Book("book6", 10, "5 Little Ducks"));
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


