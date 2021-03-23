package com.example.players;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private ImageButton btnPlayVideo, btnPauseVideo;
    private VideoView videoView;
    private Button btnIrParaMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPauseVideo = findViewById(R.id.btnPauseVideo);
        btnIrParaMusica = findViewById(R.id.btnIrParaMusica);
        videoView = findViewById(R.id.video);

        //Para informarmos o caminho (path) de um vídeo, o elemento VideoView
        //só aceita recebê-lo por meio de uma URI em formato prórpio, ou seja,
        //não aceita dado do tipo String. Por isso que precisamos realizar esta
        //conversão abaixo.
        String path = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri pathUri = Uri.parse(path);

        videoView.setVideoURI(pathUri);

    }

    public void playPause(View v){
        if(!videoView.isPlaying()){
            videoView.start();
            btnPlayVideo.setVisibility(View.GONE);
            btnPauseVideo.setVisibility(View.VISIBLE);
        } else {
            videoView.pause();
            btnPauseVideo.setVisibility(View.GONE);
            btnPlayVideo.setVisibility(View.VISIBLE);
        }
    }

    public void activityMusica(View v){
        Intent novaJanela = new Intent(VideoActivity.this, MainActivity.class);
        startActivity(novaJanela);
    }

    @Override
    protected void onPause() {
        if(videoView.isPlaying()) {
            videoView.pause();
        }
        super.onPause();
    }

}