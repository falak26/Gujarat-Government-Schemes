package in.ac.charusat.cspit.it.schemes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 0)//activity1
                    {
                        Intent intent = new Intent(MainActivity.this, activityedu.class);

                        startActivity(intent);
                    }
                    else if(finalI == 1)//activity2
                    {
                        Intent intent = new Intent(MainActivity.this, activityagriculture.class);

                        startActivity(intent);
                    }
                    else if(finalI == 2)//activity3
                    {
                        Intent intent = new Intent(MainActivity.this, activityclimate.class);

                        startActivity(intent);
                    }
                    else if(finalI == 3)//activity4
                    {
                        Intent intent = new Intent(MainActivity.this, activityhealth.class);

                        startActivity(intent);
                    }else if(finalI == 4)//activity5
                    {
                        Intent intent = new Intent(MainActivity.this, activityfinance.class);

                        startActivity(intent);
                    }else if(finalI == 5)//activity6
                    {
                        Intent intent = new Intent(MainActivity.this, activityhouse.class);

                        startActivity(intent);
                    }else if(finalI == 6)//activity7
                    {
                        Intent intent = new Intent(MainActivity.this, activityfood.class);

                        startActivity(intent);
                    }else if(finalI == 7)//activity8
                    {
                        Intent intent = new Intent(MainActivity.this, activityforest.class);

                        startActivity(intent);
                    }else if(finalI == 8)//activity9
                    {
                        Intent intent = new Intent(MainActivity.this, activityinformation.class);

                        startActivity(intent);
                    }else if(finalI == 9)//activity10
                    {
                        Intent intent = new Intent(MainActivity.this, activityadmin.class);

                        startActivity(intent);
                    }else if(finalI == 10)//activity11
                    {
                        Intent intent = new Intent(MainActivity.this, activityindustry.class);

                        startActivity(intent);
                    }else if(finalI == 11)//activity12
                    {
                        Intent intent = new Intent(MainActivity.this, activityenergy.class);

                        startActivity(intent);
                    }
                    else {
                        }
            }
        });
        }
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        super.onBackPressed();
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
  int id = item.getItemId();

//        if (id == R.id.profile) {
//            Intent intent = new Intent(MainActivity.this, activity_profile.class);
//
//            startActivity(intent);
//
//        } else if (id == R.id.tellafriend) {
//
//        } else if (id == R.id.rateus) {
//
//        } else if (id == R.id.help) {
//
//        } else if (id == R.id.about) {
//
//        } else if (id == R.id.developers) {
//
//        }

        switch (id){
            case R.id.mainActivity1:
//                Intent h = new Intent(MainActivity.this,activity_profile.class);
                startActivity(new Intent(MainActivity.this,mainActivity1.class));
                break;
            case R.id.tellafriend:
//                Intent i = new Intent(MainActivity.this,activity_tellafriend.class);
//                startActivity(i);
//                break;
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT,"www.techquike.com");
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent,"Share via"));
                break;

            case R.id.rateus:
                Intent j = new Intent(MainActivity.this,activity_rateus.class);
                startActivity(j);
                break;
            case R.id.help:
                Intent k = new Intent(MainActivity.this,activity_help.class);
                startActivity(k);
                break;
            case R.id.about:
                Intent l = new Intent(MainActivity.this,activity_about.class);
                startActivity(l);
                break;
            case R.id.developers:
                Intent m = new Intent(MainActivity.this,activity_developers.class);
                startActivity(m);
                break;

        }
         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
