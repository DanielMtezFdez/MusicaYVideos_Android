package com.khezu.actividad_exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CancionAdapter extends ArrayAdapter<Cancion> {

    public CancionAdapter(Context context, List<Cancion> objects){
        super(context, 0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtener inflater
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //¿Existe el view actual?
        if(null == convertView){
            convertView = inflater.inflate(R.layout.item_cancion, parent, false);
        }

        //Referencias UI
        ImageView imagenCancion = (ImageView)convertView.findViewById(R.id.imagenCancion);
        TextView tituloCancion = (TextView) convertView.findViewById(R.id.tituloCancion);

        //Cancion actual
        Cancion cancion = getItem(position);

        //Setup
        Glide.with(getContext()).load(cancion.getmImagen()).into(imagenCancion);
        tituloCancion.setText(cancion.getmTitulo());

        return convertView;
    }
}
