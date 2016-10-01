package thedorkknightrises.techraceapp.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;
import thedorkknightrises.techraceapp.clues.ClueFragment;
import thedorkknightrises.techraceapp.locations.LocationFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static int currentPage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //  Initialize SharedPreferences
        SharedPreferences pref = getSharedPreferences(AppConstants.PREFS, MODE_PRIVATE);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, ScannerFragment.newInstance()).commit();
            currentPage = AppConstants.PAGE_SCANNER;
            boolean locked = !pref.getBoolean(AppConstants.PREFS_UNLOCKED, false);
            if (locked) {
                //  Launch app intro
                Intent i = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(i);
            }
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (currentPage == AppConstants.PAGE_SCANNER)
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_scanner && currentPage != AppConstants.PAGE_SCANNER) {
            toolbar.setTitle(getString(R.string.app_name));
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, ScannerFragment.newInstance()).commit();
            currentPage = AppConstants.PAGE_SCANNER;
        } else if (id == R.id.nav_clues && currentPage != AppConstants.PAGE_CLUES) {
            toolbar.setTitle(getString(R.string.clues));
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, ClueFragment.newInstance(1)).commit();
            currentPage = AppConstants.PAGE_CLUES;
        } else if (id == R.id.nav_locations && currentPage != AppConstants.PAGE_LOCATIONS) {
            toolbar.setTitle(getString(R.string.locations));
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, LocationFragment.newInstance(1)).commit();
            currentPage = AppConstants.PAGE_LOCATIONS;
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(MainActivity.this, AboutActivity.class),
                    ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        } else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this, ContactActivity.class),
                    ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
