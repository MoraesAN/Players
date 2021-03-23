package com.example.players;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPlay, btnPause;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);

        mediaPlayer = MediaPlayer.create(this, R.raw.musica);
    }

    //Outros métodos
    public void playPause(View v){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            btnPlay.setVisibility(View.GONE);
            btnPause.setVisibility(View.VISIBLE);
        } else {
            mediaPlayer.pause();
            btnPause.setVisibility(View.GONE);
            btnPlay.setVisibility(View.VISIBLE);
        }

    }
    public void activityVideo(View v){
        Intent novaJanela = new Intent(MainActivity.this, VideoActivity.class);
        startActivity(novaJanela);
    }

    @Override
    protected void onPause() {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        super.onPause();
    }

}