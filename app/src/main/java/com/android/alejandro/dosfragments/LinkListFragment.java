package com.android.alejandro.dosfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by alejandro on 2/02/17.
 */

public class LinkListFragment extends ListFragment{

    private OnListFragmentSelectionListener mListener;
    private int posSeleccionada;
    private static final String ID_POSICION_LISTA_ELEGIDA ="pos";
    private int NINGUNA_POS_ELEGIDA = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public LinkListFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_activated_1,MainActivity.titulos));

        if(savedInstanceState != null)
            posSeleccionada = savedInstanceState.getInt(ID_POSICION_LISTA_ELEGIDA);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        getListView().setSelector(R.color.colorAccentTransparent);

        if(posSeleccionada != NINGUNA_POS_ELEGIDA)
            getListView().setItemChecked(posSeleccionada,true);
    }

    public interface  OnListFragmentSelectionListener{

        void onListFragmentSelection(int pos);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if ( context instanceof OnListFragmentSelectionListener){
            mListener = (OnListFragmentSelectionListener) context;
        }else{
            throw new RuntimeException(context.toString()
            +" debe implementar OnListFragmentSelectionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        posSeleccionada = position;

        getListView().setSelector(R.color.colorAccentTransparent);

        mListener.onListFragmentSelection(position);
    }
    //

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ID_POSICION_LISTA_ELEGIDA,posSeleccionada);
    }


}
