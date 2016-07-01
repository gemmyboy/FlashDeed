package gemmyboy.flashdeed;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadScreen extends AppCompatActivity {

    private Handler hand;
    private int wait_time = 2500;       //2.5 seconds

    //----------------------------------------------------------------------------------------------
    //Standard Life Cycle Functions that are called depending on where the flow
    //  of the app is.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        final LoadScreen something = this;

        //Make the App wait X amount of time then call finish
        //  and move onto the next activity
        hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(something, LoginScreen.class);
                startActivity(in);
                finish();
            }
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






