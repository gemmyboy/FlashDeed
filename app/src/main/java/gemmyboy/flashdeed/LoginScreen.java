package gemmyboy.flashdeed;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    public static final String PREFS_NAME = "FlashDeed_PREFS";

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

    //----------------------------------------------------------------------------------------------

    //Onclick function for Login button
    public void OnClick_Login(View v) {
        String username = ((EditText)findViewById(R.id.text_field_username)).getText().toString();
        String password = ((EditText)findViewById(R.id.text_field_password)).getText().toString();

        //Null error check
        if (username == null || password == null) {
            Toast.makeText(getApplicationContext(), "Please enter your Username && Password", Toast.LENGTH_SHORT).show();
            return;
        }//End if

        Log.d("Derp", "Username: " + username.toLowerCase() + " | Password: " + password.toLowerCase());

        String admin = "admin";

        //Basic login cred until backend system and DB are setup.
        if (username.equalsIgnoreCase(admin) && password.equalsIgnoreCase(admin)) {
            SharedPreferences.Editor e = this.getSharedPreferences(PREFS_NAME, 0).edit();
            e.putString("Username", username);
            e.putString("Password", password);
            e.commit();

            Intent in = new Intent(this, HomeScreen.class);
            startActivity(in);
        } else {
            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
        }//End else
    }//End OnClick_Login()

    //Onclick function for Register button
    public void OnClick_Register(View v) {
        Toast.makeText(getApplicationContext(), "Register Feature: Not Implemented", Toast.LENGTH_SHORT).show();
    }//End OnClick_Login()
}//End LoginScreen class
