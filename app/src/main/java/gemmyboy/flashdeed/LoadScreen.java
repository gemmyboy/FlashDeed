package gemmyboy.flashdeed;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadScreen extends AppCompatActivity {

    private Handler hand;
    private boolean skipLogin = false;
    private int wait_time = 2500;       //2.5 seconds
    public static final String PREFS_NAME = "FlashDeed_PREFS";

    //----------------------------------------------------------------------------------------------
    //Standard Life Cycle Functions that are called depending on where the flow
    //  of the app is.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        //Check to see if the user logged into this app before.
        //  if so, then just skip to the homescreen
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String usr = settings.getString("Username", "");
        String pwd = settings.getString("Password", "");

        //Logic will be improved later when networked
        if(usr != "" && pwd != "") {
            skipLogin = true;
        }//end if




        final LoadScreen something = this;

        //Make the App wait X amount of time then call finish
        //  and move onto the next activity
        hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!skipLogin) {
                    Intent in = new Intent(something, LoginScreen.class);
                    startActivity(in);
                    finish();
                } else {
                    Intent in = new Intent(something, HomeScreen.class);
                    startActivity(in);
                    finish();
                }
            }//End run()
        }, wait_time);
    }//End onCreate()

    @Override
    protected void onRestart(){
        super.onRestart();
    }//End onRestart()

    @Override
    protected void onResume(){
        super.onResume();
    }//End onResume()

    @Override
    protected void onPause() {
        super.onPause();
    }//End onPause()

    @Override
    protected void onStop(){
        super.onStop();
    }//End onStop()

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }//End onDestroy()
}//End LoadScreen class






