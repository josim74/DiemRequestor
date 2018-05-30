package com.biswajitbanik.Diem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.biswajitbanik.Diem.Message.ViewModel.MessageFragment;
import com.biswajitbanik.Diem.MyProject.ViewModel.MyProjectContainerFragment;
import com.biswajitbanik.Diem.Notification.ViewModel.NotificationFragment;
import com.biswajitbanik.Diem.Setting.ViewModel.SettingsFragment;
import com.biswajitbanik.Diem.Util.BottomNavigationViewHelper;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityHomeBinding;

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



        BottomNavigationViewHelper.disableShiftMode(mBinding.bottomNavigation);
        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                Menu menu = mBinding.bottomNavigation.getMenu();
                menu.findItem(R.id.home_menu_item).setIcon(R.drawable.home_unselected);
                menu.findItem(R.id.project_menu_item).setIcon(R.drawable.project_unselected);
                menu.findItem(R.id.message_menu_item).setIcon(R.drawable.message_unselected);
                menu.findItem(R.id.notification_menu_item).setIcon(R.drawable.notification_unselected);
                menu.findItem(R.id.setting_menu_item).setIcon(R.drawable.settings_unselected);



                Fragment fragment = null ;
                switch (item.getItemId()){
                    case R.id.home_menu_item:
                        fragment = new RequestorActivity();
                        item.setIcon(R.drawable.home_selected);
                        break;
                    case R.id.project_menu_item:
                        fragment = new MyProjectContainerFragment();
                        item.setIcon(R.drawable.project_selected);
                        break;
                    case R.id.message_menu_item:
                        fragment = new MessageFragment();
                        item.setIcon(R.drawable.message_selected);
                        break;
                    case R.id.notification_menu_item:
                        fragment = new NotificationFragment();
                        item.setIcon(R.drawable.notification_selected);
                        break;
                    case R.id.setting_menu_item:
                        fragment = new SettingsFragment();
                        item.setIcon(R.drawable.settings_selected);
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
