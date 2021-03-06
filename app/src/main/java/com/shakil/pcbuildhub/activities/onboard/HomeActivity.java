package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.activities.addnewpost.AddNewPostActivity;
import com.shakil.pcbuildhub.activities.buildyourpc.BuildYourPcListActivity;
import com.shakil.pcbuildhub.drawerextra.DrawerAdapter;
import com.shakil.pcbuildhub.drawerextra.DrawerItem;
import com.shakil.pcbuildhub.drawerextra.SimpleItem;
import com.shakil.pcbuildhub.drawerextra.SpaceItem;
import com.shakil.pcbuildhub.fragments.FragmentPostDashboard;
import com.shakil.pcbuildhub.fragments.FragmentProfile;
import com.shakil.pcbuildhub.utils.UtilsForAll;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "Shakil-HomeActivity";
    private SlidingRootNav slidingRootNav ;
    private Toolbar toolbar;
    private RecyclerView list;
    private DrawerAdapter adapter;
    private static final int POS_POST = 0;
    private static final int POS_PROFILE = 1;
    private static final int POS_ADD_NEW_POST = 2;
    private static final int POS_BUILD_YOUR_PC = 3;
    private static final int POS_ABOUT_US = 4;
    private static final int POS_LOGOUT = 5;
    private String[] screenTitles;
    private Drawable[] screenIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init(savedInstanceState);
        bindUIWithComponents();
    }

    private void init(Bundle savedInstanceState){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home);
        slidingRootNav  = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();
    }

    private void bindUIWithComponents(){

        setAdapter();
        adapter.setListener(new DrawerAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                final int pos = position;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (pos == POS_LOGOUT) {
                            finish();
                            return;
                        }
                        else if (pos == POS_PROFILE){
                            showFragment(FragmentProfile.getInstance());
                            return;
                        }
                        else if (pos == POS_POST){
                            showFragment(FragmentPostDashboard.getInstance());
                            return;
                        }
                        else if (pos == POS_ADD_NEW_POST){
                            startActivity(new Intent(HomeActivity.this, AddNewPostActivity.class));
                            return;
                        }
                        else if (pos == POS_BUILD_YOUR_PC){
                            startActivity(new Intent(HomeActivity.this, BuildYourPcListActivity.class));
                            return;
                        }
                    }
                },5);

                slidingRootNav.closeMenu();

            }
        });
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,new FragmentPostDashboard());
        fragmentTransaction.commit();
    }

    private void setAdapter() {
        list = findViewById(R.id.nav_list_item);
        adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_POST).setChecked(true),
                createItemFor(POS_PROFILE),
                createItemFor(POS_ADD_NEW_POST),
                createItemFor(POS_BUILD_YOUR_PC),
                createItemFor(POS_ABOUT_US),
                new SpaceItem(32),
                createItemFor(POS_LOGOUT)));

        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_POST);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            Log.i(TAG, "Popping back stack fragments");
            getSupportFragmentManager().popBackStack();
        }
        else {
            Log.i(TAG, "Nothing on back stack, exiting app");
            UtilsForAll.exitApp(this);
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fadein,R.anim.fadeout);
        fragmentTransaction.replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withTextTint(getResources().getColor(R.color.md_blue_grey_700))
                .withSelectedTextTint(getResources().getColor(R.color.md_grey_900));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

}
