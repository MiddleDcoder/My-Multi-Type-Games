package com.games.lorenz.jhun.mygame;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class StartActivity extends AppCompatActivity {

    ImageButton play, more, shop, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

            //full screen,

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        play = (ImageButton)findViewById(R.id.play);
        more = (ImageButton)findViewById(R.id.more);
        shop = (ImageButton)findViewById(R.id.shop);
        back = (ImageButton)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainSelection.class));
                finish();
            }
        });

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GameMainActivity.class));
                finish();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, ShopActivity.class));
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(StartActivity.this, more);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        Intent intent, chooser;
                        int id = menuItem.getItemId();
                            if (id == R.id.feedback){
                                intent = new Intent(Intent.ACTION_SEND);
                                intent.setData(Uri.parse("mailto:"));
                                String[] to = {"barentoy55@gmail.com"}; // my email
                                intent.putExtra(Intent.EXTRA_EMAIL, to);
                                intent.setType("message/rfc822");
                                chooser = Intent.createChooser(intent, "Send Feedback");
                                startActivity(chooser);

                            }

                            if (id == R.id.share){
                                intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Doodle Dash");
                                  //This is for recommend your game website link
                                String sAux = "\n Let me recommend you this game \n\n";
                                // for the link of your app download either playstore, dropbox, and mediafire
                                sAux = sAux+ "https://play.google.com/store/apps/details?id=com.angrymonkey.angrymonkey \n\n";
                                intent.putExtra(Intent.EXTRA_TEXT, sAux);
                                startActivity(Intent.createChooser(intent, "Share"));
                            }

                        return true;
                    }
                });
                popupMenu.show();
            }

        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){

                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);

    }
}
