package com.example.shinelon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//图片暂时存储于数组中
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private SwipeRefreshLayout swipeRefresh;
    private Picture[] pictures = {
            new Picture("随机点点看", R.drawable.aqweq),
            new Picture("可能有惊喜", R.drawable.dsfsd),
            new Picture("感谢有你们", R.drawable.ffsd),
            new Picture("目前还在完善中", R.drawable.ewrwerw),
            new Picture("随机循环了图片", R.drawable.hjkl),
            new Picture("先将就着看看", R.drawable.fgs),
    };
    private List<Picture> pictureList = new ArrayList<>();
    private PictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        NavigationView naviView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_1);
        }
        /**
         * 滑动界面的点击事件跳转网页
         */
        naviView.setCheckedItem(R.id.nav_mydata);//默认选项为我的资料
        naviView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                        public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.nav_mydata:
                                Intent intent = new Intent(MainActivity.this, MyDataActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_updata:
                                Intent intent1 = new Intent(MainActivity.this, updata.class);
                                startActivity(intent1);
                                break;
                            case R.id.nav_day:
                                Intent intent2 = new Intent(MainActivity.this, DayActivity.class);
                                startActivity(intent2);
                                break;
                            case R.id.nav_about:
                                Intent intent3 = new Intent(MainActivity.this, AboutActivity.class);
                                startActivity(intent3);
                                break;
                            default:
                        }
                        return true;
                    }
                });

        /**下拉刷新
         */
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                refreshPicture();
            }
        });
        /**
         * 图片遍历
         *
         */
        initPicture();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);
    }
    private void initPicture() {
        pictureList.clear();
        for (int i = 0; i < 200; i++) {
            Random random = new Random();
            int index = random.nextInt(pictures.length);
            pictureList.add(pictures[index]);
        }
    }
    //下拉刷新方法
    private void refreshPicture(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initPicture();
                            adapter.notifyDataSetChanged();
                            swipeRefresh.setRefreshing(false);
                        }
                    });
                }
            }).start();
        }

    //导航按钮的触发方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}