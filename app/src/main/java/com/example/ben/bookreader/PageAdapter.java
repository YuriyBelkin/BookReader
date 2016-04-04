package com.example.ben.bookreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ben on 6/29/2015.
 */
public class PageAdapter extends ArrayAdapter<Page> {
    public PageAdapter(Context context, ArrayList<Page> pages) {
        super(context, 0, pages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Page Page = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.page_number_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvPageNum = (TextView) convertView.findViewById(R.id.PageNumber);
        // Populate the data into the template view using the data object
        tvPageNum.setText("Page " + String.valueOf(Page.PageNumber));
        // Return the completed view to render on screen
        return convertView;
    }
}

