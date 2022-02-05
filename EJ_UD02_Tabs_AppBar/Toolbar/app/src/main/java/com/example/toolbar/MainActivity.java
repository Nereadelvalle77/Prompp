package com.example.toolbar;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.toolbar.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private ViewPager viewPager;

    private boolean x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TOOLBAR
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Esto es un fake watshapp no se va a enviar ningun mensaje \uD83D\uDE02 ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TABS
        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter(new PageAdapter());

        TabLayout tabLayout =findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        //ELEMENTOS
        viewPager=findViewById(R.id.viewPager);

        x=true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        int id = item.getItemId();
        switch (id)
        {
            case R.id.btBuscar:
                Log.i("ActionBar","En btBuscar");
                if(x)
                {
                    item.setIcon(getDrawable(R.mipmap.camara2_round));
                    x=false;
                }
                else
                {
                    item.setIcon(getDrawable(R.mipmap.camara0_round));
                    x=true;
                }

                return true;
            case R.id.btOtro:
                Log.i("ActionBar","En btOtro");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public class PageAdapter extends PagerAdapter
    {

        private ConstraintLayout p_llamadas;
        private ConstraintLayout p_chats;
        private ConstraintLayout p_contactos;

        private final int[] ps={R.string.lmds,R.string.chts,R.string.ctcs};

        @Override
        public int getCount()
        {
            return 3;
        }

        public CharSequence getPageTitle(int position)
        {
            String s= getString(ps[position]);
            return s;
        }

        public Object instantiateItem(@NonNull ViewGroup container, int position)
        {
            View page;
            Log.i("pager","aa");
            switch (position)
            {
                case 0:
                    if(p_llamadas ==null)
                    {
                        p_llamadas =(ConstraintLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.p_llamadas,container,false);
                    }
                    page= p_llamadas;
                    break;
                case 1:
                    if(p_chats ==null)
                    {
                        p_chats =(ConstraintLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.p_chats,container,false);
                    }
                    page= p_chats;

                    break;
                default:
                    if(p_contactos ==null)
                    {
                        p_contactos =(ConstraintLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.p_contactos,container,false);
                    }
                    page= p_contactos;
                    break;
            }
            container.addView(page,0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
        {
            //return false;
            return view == object;
        }

        public void destroyItem(@NonNull ViewGroup container,int position, @NonNull Object object)
        {
            container.removeView((View) object);
        }
    }
}