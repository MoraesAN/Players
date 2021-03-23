package com.example.players;

import androidx.appcompat.app.AppCompatActivity;

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
        mediaPlayer = MediaPlayer.create(this, R.raw.musica);
        mediaPlayer.start();
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);

    }

    public void playPause(View v){
        if(mediaPlayer.isPlaying()){
            btnPlay.setVisibility(View.GONE);
            btnPause.setVisibility(View.VISIBLE); // método para "Aparecer" o botão
            mediaPlayer.pause();

        } else {
            btnPlay.setVisibility(View.GONE); // método para "Sumir" o botão
            btnPause.setVisibility(View.VISIBLE);
            mediaPlayer.start();

        }

    }
    @Override
    protected void onPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        super.onPause();
    }

}