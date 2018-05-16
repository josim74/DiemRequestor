package com.biswajitbanik.Diem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.codility.introsilder.R;
import com.codility.introsilder.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    public static final String PREF_USER_FIRST_TIME = "user_first_time";
 private ActivityHomeBinding mBinding;
    boolean isUserFirstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);


        //If the app is fresh, this will be true and will start an intent to PagerActivity

        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(HomeActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent intent = new Intent(HomeActivity.this, IntroActivity.class);
        intent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime) {
            startActivity(intent);
        }

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = new RequestorActivity();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }

        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                Fragment fragment = null ;
                switch (item.getItemId()){
                    case R.id.home_menu_item:
                        fragment = new RequestorActivity();
                        break;


                }
                if (fragment!=null)
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();



                return true;
            }
        });






    }
}
