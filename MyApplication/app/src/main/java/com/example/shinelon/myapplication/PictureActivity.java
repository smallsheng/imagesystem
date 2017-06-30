package com.example.shinelon.myapplication;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PictureActivity extends AppCompatActivity {
   public static final String  PICTURE_NAME = "picture_name";
    public static final String  PICTURE_IMAGE_ID = "picture_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        Intent intent = getIntent();
        String  pictureName = intent.getStringExtra(PICTURE_NAME);
        int pictureImageId = intent.getIntExtra(PICTURE_IMAGE_ID,0);
        Toolbar toolbal =(Toolbar)findViewById(R.id.toobal);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView pictureImageView = (ImageView)findViewById(R.id.image_view);
        TextView pictureContentText = (TextView)findViewById(R.id.content_text);
        setSupportActionBar(toolbal);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }collapsingToolbarLayout.setTitle(pictureName);
        Glide.with(this).load(pictureImageId).into(pictureImageView);
        String pictureContent = generatePictureContent(pictureName);
        pictureContentText.setText(pictureContent);
    }
    private String generatePictureContent(String pictureName){
        StringBuilder pictureContent = new StringBuilder();
        for (int i=0;i<500;i++){
            pictureContent.append(pictureName);
        }
        return pictureContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
