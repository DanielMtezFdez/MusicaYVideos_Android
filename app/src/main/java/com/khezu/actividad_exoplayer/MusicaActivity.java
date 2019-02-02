package com.khezu.actividad_exoplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MusicaActivity extends AppCompatActivity {

    private ListView listaCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_canciones);

        getSupportActionBar().setTitle("Música");

        FragmentCancion fragmentCancion = (FragmentCancion)getSupportFragmentManager().findFragmentById(R.id.fragmentLeads);

        if(fragmentCancion == null){
            fragmentCancion = FragmentCancion.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentLeads, fragmentCancion).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.volverAtras:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void seleccionarCancion(View view){
        Intent intent;
        View parent = (View)view.getParent();
        TextView titulo = (TextView) parent.findViewById(R.id.tituloCancion);

        intent = new Intent(MusicaActivity.this, ExoPlayerMusica.class);
        intent.putExtra("cancion", titulo.getText().toString());
        startActivity(intent);

    }
}
