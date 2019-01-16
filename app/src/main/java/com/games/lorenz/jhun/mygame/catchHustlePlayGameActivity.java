package com.games.lorenz.jhun.mygame;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;

public class catchHustlePlayGameActivity extends AppCompatActivity {

    //Frame
    private FrameLayout gameFrame;
    private int frameHeight, frameWidth, initialFrameWidth;
    private LinearLayout startLayout;

    //Image
    private ImageView box, black, orange, pink;
    private Drawable imageBoxRight, imageBoxLeft;

    //Size
    private int boxSize;

    //Position
    private float boxX, boxY;
    private  float blackX, blackY;
    private  float orangeX, orangeY;
    private  float pinkX, pinkY;

    //Score
    private TextView scoreLabel, highScoreLabel;
    private int score, highScore, timeCount;

    //Class
    private Timer timer;
    private Handler handler = new Handler();

    //Status
    private  boolean start_flg = false;
    private  boolean action_flg = false;
    private boolean pink_flg = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_hustle_play_game);

        gameFrame = findViewById(R.id.gameFrame);
        startLayout = findViewById(R.id.startLayout);
        box = findViewById(R.id.box);
        black = findViewById(R.id.black);
        orange = findViewById(R.id.orange);
        pink = findViewById(R.id.pink);
        scoreLabel = findViewById(R.id.scoreLabel);
        highScoreLabel = findViewById(R.id.highScoreLabel);

        imageBoxLeft = getResources().getDrawable(R.drawable.box_left);
        imageBoxRight = getResources().getDrawable(R.drawable.box_right);



    }

    public void startGame(View view){
        start_flg = true;
        startLayout.setVisibility(View.INVISIBLE);


    }

    public void quitGame(View view){

    }
}
