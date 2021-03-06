package sadiq.raza.assesszone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView navName,navEmail;
    ImageView imageView ;
    String s_name,s_email;
    ProgressBar progressBar;
    CardView cardView;
    AlertDialog.Builder builder;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view=navigationView.getHeaderView(0);
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        imageView=view.findViewById(R.id.imageView);
        String uri = "az1";
        int imageResource = getResources().getIdentifier(uri, "drawable", this.getPackageName());
        imageView.setImageResource(imageResource);

        s_name=extras.getString("myStr1").toString();
        s_email=extras.getString("myStr2").toString();
        navName = view.findViewById(R.id.navName);
        navEmail=view.findViewById(R.id.navEmail);
        navName.setText("   "+s_name);
        navEmail.setText("   "+s_email);

        //ProgressBar
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(20);

        cardView = findViewById(R.id.testCardView);

        myList = new ArrayList<>();

        myList.add("Test 1");
        myList.add("Test 2");
        myList.add("Test 3");
        myList.add("Test 4");
        myList.add("Test 5");
        myList.add("Test 6");
        myList.add("Test 7");
        myList.add("Test 8");
        myList.add("Test 9");
        myList.add("Test 10");
        myList.add("Test 11");
        myList.add("Test 12");

        builder = new AlertDialog.Builder((HomePage.this));




        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View newView = layoutInflater.inflate(R.layout.testlist,null);

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setView(newView);

                ListView listView = newView.findViewById(R.id.listView);
                final AlertDialog alert = builder.create();
                alert.setTitle("Available Tests");
                ArrayAdapter arrayAdapter = new ArrayAdapter(HomePage.this,android.R.layout.simple_list_item_1,myList);
                listView.setAdapter(arrayAdapter);
                alert.show();

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
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

        if (id == R.id.practice) {
            // Handle the camera action
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.attepmt) {
            Intent intent = new Intent(HomePage.this,Main2Activity.class);
            intent.putExtra("nameValue",s_name);
            startActivity(intent);

        } else if (id == R.id.result) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.profile) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
