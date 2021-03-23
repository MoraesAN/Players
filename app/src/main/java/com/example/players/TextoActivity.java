package com.example.players;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TextoActivity extends AppCompatActivity {

    private EditText edtTexto;
    private Button btnLer, btnApaga;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        btnLer = findViewById(R.id.btnLer);
        edtTexto = findViewById(R.id.edtTexto);

        tts = new TextToSpeech(this,
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.getDefault());
                        } else {
                            Toast.makeText(TextoActivity.this, "O seu dispositivo não possui recursos para executar esta função", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void lerTexto(View v){
        String textoCapturado = edtTexto.getText().toString();
        narrarTexto(textoCapturado);
    }
    public void apagaTexto(View v){
        edtTexto.setText("");
    }

    public void narrarTexto(String texto){
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
    }


}