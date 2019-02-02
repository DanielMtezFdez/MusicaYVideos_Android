package com.khezu.actividad_exoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class VideosActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        playerView = (PlayerView)findViewById(R.id.playerView);
        url = getIntent().getExtras().getString("url");
    }

    @Override
    protected void onStart() {
        super.onStart();

        player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());

        playerView.setPlayer(player);

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this, "ExoPlayer");
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
