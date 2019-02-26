package com.games.lorenz.jhun.mygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSelection extends AppCompatActivity {

    Button monsterDash, catchHustle, exitButton, anagramLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);


        monsterDash = (Button) findViewById(R.id.monsterDash);
        catchHustle = (Button) findViewById(R.id.catchHustle);
        anagramLogic = findViewById(R.id.anagramLogic);
        exitButton = (Button) findViewById(R.id.exitButton);





        monsterDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(MainSelection.this, StartActivity.class);
                startActivity(intent);*/ // this if for combination of two intent technique

               /* Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent); */ //this is for getApplicationContext

                /* startActivity(new Intent(MainSelection.this, StartActivity.class));
                * finish();  // This is for startActivity with getApplicationContext()*/

                startActivity(new Intent(MainSelection.this, StartActivity.class));
                finish();
                // this is for .this technique just intent activity no data

            }
        });



        catchHustle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSelection.this, CatchHustleMainActivity.class));
                finish();

            }
        });

        anagramLogic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainSelection.this, MainActivityAnagramLogic.class
                ));
            }
        });


        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    finishAndRemoveTask();
                }else{
                    finish();
                    System.exit(0);
                }


               // moveTaskToBack(true);

            /*    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        MainSelection.super.finishAndRemoveTask();
                    }else{
                        MainSelection.super.finish();
                    }
                }else {
                   MainSelection.super.finish();
                } */ // sample code test


            }
        });


    }


}
