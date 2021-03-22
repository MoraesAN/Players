package com.example.players;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPlay, btnPause;
    int controle = 0;
    private MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.musica);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer.start();
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);

    }

    public void playPause(View v){
        if(mediaPlayer.isPlaying()){
            btnPause.setVisibility(View.VISIBLE); // metodo para "Sumir" o botão
            btnPlay.setVisibility(View.GONE);
            mediaPlayer.pause();
            controle = 1;
        } else {
            mediaPlayer.start();
            btnPlay.setVisibility(View.GONE); // metodo para "Sumir" o botão
            btnPause.setVisibility(View.VISIBLE);
            controle = 0;
        }

    }
}