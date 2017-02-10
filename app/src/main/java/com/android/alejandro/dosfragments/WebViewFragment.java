package com.android.alejandro.dosfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by alejandro on 2/02/17.
 */

public class WebViewFragment extends Fragment {

    private String actualUrl = "";
    private WebView webView;
    private static final String ID_URL_GUARDADA = "id_url_guardada";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.web_layout, container, false);
        webView= (WebView) v.findViewById(R.id.wvWebPage);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getActualUrl(){
        return actualUrl;
    }

    public void mostrarUrl(String url){

        actualUrl = url;

        WebView webView = (WebView) getView().findViewById(R.id.wvWebPage);

        if(webView != null)
            webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ID_URL_GUARDADA,actualUrl);

        webView.saveState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            actualUrl = savedInstanceState.getString(ID_URL_GUARDADA);
            webView.restoreState(savedInstanceState);
        }


    }

}
