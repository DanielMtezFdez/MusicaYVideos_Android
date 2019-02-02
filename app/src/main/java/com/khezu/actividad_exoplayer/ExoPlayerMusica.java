package com.khezu.actividad_exoplayer;

import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;

import java.io.IOException;

public class ExoPlayerMusica extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private String cancion;
    private String url;
    private ImageView imagen;
    private TextView titulo;
    private TextView cantantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player_musica);
        getSupportActionBar().hide();

        playerView = (PlayerView) findViewById(R.id.playerView);
        cancion = getIntent().getExtras().getString("cancion");
        imagen = (ImageView)findViewById(R.id.imagenExoPlayer);
        titulo = (TextView)findViewById(R.id.nombreCancionExo);
        cantantes = (TextView) findViewById(R.id.nombreAutoresExo);

        switch(cancion) {
            case "Bad Bunny - Caro":
                imagen.setImageResource(R.drawable.caro);
                titulo.setText("Caro");
                cantantes.setText("Bad Bunny");
                url="asset:///caro.mp3";
                break;
            case "Anuel AA and Karol G - Secreto":
                imagen.setImageResource(R.drawable.secreto_anuel_aa_ft_karol_g);
                titulo.setText("Secreto");
                cantantes.setText("Anuel AA and Karol G");
                url="asset:///anuel_aa_karol_g__secreto.mp3";
                break;
            case "Lola Indigo - Fuerte":
                imagen.setImageResource(R.drawable.fuerte);
                titulo.setText("Fuerte");
                cantantes.setText("Lola Indigo");
                url="asset:///fuerte.mp3";
                break;
            case "Zara Larsson - Lush Life":
                imagen.setImageResource(R.drawable.lush_life);
                titulo.setText("Lush Life");
                cantantes.setText("Zara Larsson");
                url="asset:///lush_life.mp3";
                break;
            case "Bebe Rexha ft Florida George Line - Meant to be":
                imagen.setImageResource(R.drawable.meant_to_be);
                titulo.setText("Meant to be");
                cantantes.setText("Bebe Rexha ft Florida George Line");
                url="asset:///meant_to_be.mp3";
                break;
            case "C. Tangana, Alizz - Pa llamar tu atencion":
                imagen.setImageResource(R.drawable.pa_llamar_tu_atencion);
                titulo.setText("Pa llamar tu atención");
                cantantes.setText("C. Tangana, Alizz ft Mc Bin Laden");
                url="asset:///pa_llamar_tu_atencion.mp3";
                break;
            case "Jonas Blue ft Jack & Jack - Rise":
                imagen.setImageResource(R.drawable.rise);
                titulo.setText("Rise");
                cantantes.setText("Jonas Blue ft Jack & Jack");
                url="asset:///rise.mp3";
                break;
            case "David Guetta, Bebe Rexha & J Balvin - Say my name":
                imagen.setImageResource(R.drawable.say_my_name);
                titulo.setText("Say my name");
                cantantes.setText("David Guetta, Bebe Rexha & J Balvin");
                url="asset:///say_my_name.mp3";
                break;
            case "Bebe Rexha ft Lil Wayne - The way I are (Dance with somebody)":
                imagen.setImageResource(R.drawable.the_way_i_are);
                titulo.setText("The way I are (Dance with somebody)");
                cantantes.setText("Bebe Rexha ft Lil Wayne");
                url="asset:///the_way_i_are.mp3";
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());

        playerView.setPlayer(player);

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayer"));
        ExtractorMediaSource archivoMultimedia = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(String.valueOf(url)));

        player.prepare(archivoMultimedia);
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onStop() {
        super.onStop();

        playerView.setPlayer(null);
        player.release();
        player = null;
    }
}
