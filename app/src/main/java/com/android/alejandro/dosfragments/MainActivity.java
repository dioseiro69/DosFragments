package com.android.alejandro.dosfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener{

    public static ArrayList<TutorialAndroid> listaDatos = new ArrayList<>();
    public static String [] titulos;
    private WebViewFragment wvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();
    }

    public void cargarDatos()
    {
        titulos = getResources().getStringArray(R.array.lista_enlaces_tutoriales_Android);
        String [] enlaces = getResources().getStringArray(R.array.urls_enlaces_tutoriales_Android);

        for(int i=0;i<titulos.length;i++) {
            listaDatos.add(new TutorialAndroid(titulos[i],enlaces[i]));
        }
    }

    @Override
    public void onListFragmentSelection(int posElemento) {

        String url = listaDatos.get(posElemento).getEnlaceContenido();

        wvFragment = (WebViewFragment)getSupportFragmentManager().findFragmentById(R.id.webFragment);

        if(wvFragment==null){

            Intent i = new Intent (this, SegundaActivity.class);
            i.putExtra("enlace",url);
            startActivity(i);
        }
        else {

            if (!wvFragment.getActualUrl().equals(url))
                wvFragment.mostrarUrl(url);
        }
    }
}
