package tw.org.iii.myfragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private Page0 page0;
    private Page1 page1;
    private Page2 page2;
    private Page3 page3;
    private Page4 page4;
    private FragmentManager fmgr;
    //private FragmentTransaction tran;
    private Fragment[] fragments;

    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.container);
        page0 = new Page0();
        page1 = new Page1();
        page2 = new Page2();
        page3 = new Page3();
        page4 = new Page4();
        fragments = new Fragment[]{page0,page1,page2,page3,page4};

        fmgr = getSupportFragmentManager();

        pager.setAdapter(new MyAdapter(fmgr));
        pager.setCurrentItem(1);
        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0){
                    pager.setCurrentItem(1);
                }else if (position == 4){
                    pager.setCurrentItem(3);
                }
            }
        });

        initActionBar();
    }


    private void initActionBar(){
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener =
                new ActionBar.TabListener() {
                    @Override
                    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

                    }

                    @Override
                    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

                    }

                    @Override
                    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

                    }
                };


        actionBar.addTab(actionBar.newTab()
                .setText("Page 1")
                .setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Page 2")
                .setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Page 3")
                .setTabListener(tabListener));

    }


    public void gotoPage1(View view) {
        pager.setCurrentItem(1);
    }
    public void gotoPage2(View view) {
        pager.setCurrentItem(2);
    }
    public void gotoPage3(View view) {
        pager.setCurrentItem(3);
    }

    private class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0 || position == 4){
                return  "";
            }else {
                return "Page: " + position;
            }
        }
    }

}
