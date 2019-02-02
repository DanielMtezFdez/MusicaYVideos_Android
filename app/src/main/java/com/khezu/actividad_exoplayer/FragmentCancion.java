package com.khezu.actividad_exoplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentCancion extends Fragment {

    private ListView mCancionList;
    ArrayAdapter<Cancion> mCancionAdapter;

    public FragmentCancion() {
        // Required empty public constructor
    }

    public static FragmentCancion newInstance() {
        FragmentCancion fragment = new FragmentCancion();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.lista_canciones, container, false);

        //Instancia del ListView
        mCancionList = (ListView) root.findViewById(R.id.leads_list);

        //Inicializar el adaptador con la fuente de datos
        mCancionAdapter = new CancionAdapter(getActivity(), RepositorioCanciones.getInstance().getLeads());

        //Relaciono la lista con el adaptador
        mCancionList.setAdapter(mCancionAdapter);

        return root;
    }

}
