package gemmyboy.flashdeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginScreen extends AppCompatActivity {


    //----------------------------------------------------------------------------------------------
    //Standard Life Cycle Functions that are called depending on where the flow
    //  of the app is.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
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
}//End LoginScreen class
