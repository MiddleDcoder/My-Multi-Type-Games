package com.games.lorenz.jhun.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityAnagramLogic extends AppCompatActivity implements View.OnClickListener{

    private TextView wordTv;
    private EditText wordEnteredTv;
    private Button validate, newGame;
    private String wordToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anagram_logic);
        wordTv = findViewById(R.id.wordTv);
        wordEnteredTv = findViewById(R.id.wordEnteredEt);
        validate = findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(this);

        newGame();


    }

    @Override
    public void onClick(View view) {
        if(view == validate){
            validate();
        }else if (view == newGame){
            newGame();
        }

    }


    private void validate(){
        String w = wordEnteredTv.getText().toString();

        if (wordToFind.equals(w)){
            Toast.makeText(this,"Congratulations ! You found the word " + wordToFind, Toast.LENGTH_LONG).show();
            newGame();
        }else{
            Toast.makeText(this,"Retry !" + wordToFind, Toast.LENGTH_LONG).show();
        }
    }

    private void newGame(){
        wordToFind = Anagram.randomWord();
        String wordShuffle = Anagram.shuffleWord(wordToFind);
        wordTv.setText(wordShuffle);
        wordEnteredTv.setText("");
    }


}
