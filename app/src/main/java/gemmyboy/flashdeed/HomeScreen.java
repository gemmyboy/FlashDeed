package gemmyboy.flashdeed;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    private DrawerLayout mNav;
    private ListView mLV;
    private String[] mOptions;
    private ActionBarDrawerToggle mDT;
    public static final String PREFS_NAME = "FlashDeed_PREFS";


    //----------------------------------------------------------------------------------------------
    //Standard Life Cycle Functions that are called depending on where the flow
    //  of the app is.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Setting-up the Toolbar -- Using Toolbar because it's cross-API compatible on devices
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        //Setting-up and launching the Nav-Drawer menu
        mNav = (DrawerLayout) findViewById(R.id.drawer_layout);
        mLV = (ListView) findViewById(R.id.left_drawer);
        mOptions = getResources().getStringArray(R.array.left_nav_menu);

        mLV.setAdapter(new ArrayAdapter<String>(this, R.layout.nav_item, mOptions));
        mLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Derp
            }
        });



        mDT = new ActionBarDrawerToggle(this, mNav, myToolbar, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mNav.setDrawerListener(mDT);
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

    //Called when initially creating the Toolbar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_home, m);
        return true;
    }//End onCreateOptionsMenu

    //When an item is selected from the top-left menu on the Activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(HomeScreen.this, "Settings Dialog: Not Implemented", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                SharedPreferences.Editor e = this.getSharedPreferences(PREFS_NAME, 0).edit();
                e.remove("Username");
                e.remove("Password");
                e.commit();

                Intent in = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(in);
                finish();
                return true;
            default:
                Toast.makeText(HomeScreen.this, item.getTitle() + ": Not Implemented", Toast.LENGTH_SHORT);
                return true;
        }//End Switch
    }//End onOptionsItemSelected

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }//End onPrepareOptionsMenu()

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDT.syncState();
    }//End onPostCreate()

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDT.onConfigurationChanged(newConfig);
    }//End onConfigurationChanged()

    //OnClick for menu item
    public void OnClick_NavMenu(View v){
        Toast.makeText(HomeScreen.this, ((Button)v).getText() + ": Not Implemented", Toast.LENGTH_SHORT).show();
    }//End OnClick_NavMenu()


}//End HomeScreen class