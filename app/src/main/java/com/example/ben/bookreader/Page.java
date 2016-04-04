package com.example.ben.bookreader;

import android.os.Bundle;

/**
 * Created by Ben on 6/29/2015.
 */
public class Page {
    public int PageNumber;

    public Page(int PageNumber) {
        this.PageNumber = PageNumber;
    }

    public void fromBundle(Bundle bundle) {
        PageNumber = bundle.getInt("1");
    }

    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putInt("1", PageNumber);
        return b;
    }

}
