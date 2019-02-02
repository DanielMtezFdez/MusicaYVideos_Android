package com.khezu.actividad_exoplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SeleccionActivity extends AppCompatActivity {

    private Button botonMusica, botonVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        botonMusica = (Button)findViewById(R.id.botonMusica);
        botonVideo =(Button)findViewById(R.id.botonVideos);

        //Establecemos tipo de fuente
        Typeface miFuente = Typeface.createFromAsset(getAssets(), "MUSICNET.ttf");
        botonMusica.setTypeface(miFuente);
        botonVideo.setTypeface(miFuente);

    }

    public void seleccionarTipo(View view){
        final Intent intent;
        switch(view.getId()){
            case R.id.botonMusica:
                intent = new Intent(SeleccionActivity.this, MusicaActivity.class);
                startActivity(intent);
                break;
            case R.id.botonVideos:
                final EditText cajaTextoURL = new EditText(this);
                intent = new Intent(SeleccionActivity.this, VideosActivity.class);
                AlertDialog dialog;
                dialog = new AlertDialog.Builder(SeleccionActivity.this)
                        .setTitle("URL vídeo")
                        .setMessage("Escribe la URL del vídeo (extensión .mp4")
                        .setView(cajaTextoURL)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String url = cajaTextoURL.getText().toString();
                                intent.putExtra("url", url);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .create();
                dialog.show();
                break;
        }
    }

}
