package com.android.alejandro.dosfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alejandro on 9/02/17.
 */

public class SegundaActivity extends AppCompatActivity{

    public static final String EXTRA_URL="com.android.alejandro.dosfragments";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String url = getIntent().getStringExtra(EXTRA_URL);

        WebViewFragment wvFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.webFragment);

        if (!wvFragment.getActualUrl().equals(url)){
            wvFragment.mostrarUrl(url);
        }
    }
}
