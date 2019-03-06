package com.example.audiovideostreamingmubs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );

        fm = getSupportFragmentManager();
        fm.beginTransaction().add( R.id.container, new AudioFragment() ).addToBackStack( "any" ).commit();

        bottomNavigation.setOnNavigationItemSelectedListener( this );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       Fragment destinationFragment = null;
        switch (menuItem.getItemId()) {
            case R.id.mn_audio :
                destinationFragment = new AudioFragment();
                break;
            case R.id.mn_video :
                destinationFragment = new VideoFragment();
                break;
        }
        assert destinationFragment != null;
        fm.beginTransaction().replace( R.id.container,destinationFragment ).addToBackStack( "any" ).commit();
        return super.onOptionsItemSelected( menuItem );
    }
}
