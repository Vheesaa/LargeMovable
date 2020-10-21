package com.example.largemovable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
    Integer x = 1;
    TextView sound1;
    TextView sound2;
    TextView sound3;
    String clicked;
    Button playagain;

    Random r = new Random();
    int Low = 0;
    int High = 5;
    int rndm = r.nextInt(High-Low) + Low;

    int[] sounds= {R.raw.bat, R.raw.bin, R.raw.cat,R.raw.cot,R.raw.dog};
    String[] words = new String[] {"bat", "bin", "cat", "cot", "dog"};

    String word = null;

    public void alphabet(View view) {
        String clicked = (String) view.getTag();

        if (x==1) {
            TextView sound1 = findViewById(R.id.Sound1);
            sound1.setText(clicked);
            word = clicked;
        }
        else if (x == 2) {
            TextView sound2 = findViewById(R.id.Sound2);
            sound2.setText(clicked);
            word = word + clicked;
        }
        else if (x == 3) {
            TextView sound3 = findViewById(R.id.Sound3);
            sound3.setText(clicked);
            playagain = (Button) findViewById(R.id.PlayAgain);
            word = word + clicked;
            if (word.equals(words[rndm])) {
                Toast.makeText(this, "You're right!", Toast.LENGTH_SHORT).show();
                playagain.setVisibility(View.VISIBLE);
            } else
                Toast.makeText(this, "You're wrong!", Toast.LENGTH_SHORT).show();
            x = 0;
            sound1 = findViewById(R.id.Sound1);
            sound2 = findViewById(R.id.Sound2);
            sound3 = findViewById(R.id.Sound3);

            sound1.setText("?");
            sound2.setText("?");
            sound3.setText("?");
            word = null;

        }
        x++;

    }

    public void PlayAgain(View view) {
        playagain.setVisibility(View.INVISIBLE);
        x = 1;
        sound1 = findViewById(R.id.Sound1);
        sound2 = findViewById(R.id.Sound2);
        sound3 = findViewById(R.id.Sound3);

        sound1.setText("?");
        sound2.setText("?");
        sound3.setText("?");

        rndm = r.nextInt(High-Low) + Low;

    }

    public void WordSound(View view) {

        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);

        MediaPlayer mediaplayer = MediaPlayer.create(this, sounds[rndm]);
        mediaplayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.getSupportActionBar().hide();
    }
}