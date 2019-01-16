package com.games.lorenz.jhun.mygame;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;


public class CatchHustleMainActivity extends AppCompatActivity {

    ImageButton back, more2, playCatchHustle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_hustle_main);


        more2 = (ImageButton) findViewById(R.id.more2);
        back = (ImageButton) findViewById(R.id.backToMain);
        playCatchHustle = (ImageButton) findViewById(R.id.play_catchHustle);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainSelection.class));
                finish();
            }
        });

        playCatchHustle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), catchHustlePlayGameActivity.class));
                finish();
            }
        });

        more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu2 = new PopupMenu(CatchHustleMainActivity.this, more2);
                popupMenu2.getMenuInflater().inflate(R.menu.pop_menu2, popupMenu2.getMenu());

                popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Intent intent, chooser;
                        int id = item.getItemId();
                        if (id == R.id.feedback2){
                            intent = new Intent(Intent.ACTION_SEND);
                            intent.setData(Uri.parse("mailto:"));
                            String[] to = {"barentoy55@gmail.com"}; // my email
                            intent.putExtra(Intent.EXTRA_EMAIL, to);
                            intent.setType("message/rfc822");
                            chooser = Intent.createChooser(intent, "Send Feedback");
                            startActivity(chooser);
                        }

                        if (id == R.id.share2){
                            intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Catch Hustle");
                            // this is for recommend your game website link
                            String sAux = "\n Let me recommend you this game \n\n";
                            // for the link of your app download either playstore or other sites
                            sAux = sAux+ "https://play.google.com \n\n";
                            intent.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(intent, "Share"));
                        }

                        return true;
                    }
                });
                popupMenu2.show();
            }
        });

    }
}
