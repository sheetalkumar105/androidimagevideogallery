package com.impulsiveweb.galleryimageview;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.impulsiveweb.galleryview.ActionCallback;
import com.impulsiveweb.galleryview.GalleryView;
import com.impulsiveweb.galleryview.GalleryViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int PICK_IMAGE = 100;
    public static int PICK_VIDEO = 101;
    public ArrayList<String> paths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAddVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_VIDEO);
            }
        });

        findViewById(R.id.btnAddImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE);
            }
        });

        findViewById(R.id.btnShowGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGallery();
            }
        });
    }


    public void updateList(){
        ViewGroup vg = (ViewGroup) findViewById(R.id.container);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_VIDEO) {
            if (data != null) {
                Uri contentURI = data.getData();
                String selectedVideoPath = getVideoPath(contentURI);
                Log.d("path",selectedVideoPath);
                paths.add(selectedVideoPath);
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            if (data != null) {
                Uri contentURI = data.getData();
                String selectedImagePath = getImagePath(contentURI);
                Log.d("path",selectedImagePath);
                paths.add(selectedImagePath);
            }
        }
    }

    public String getVideoPath(Uri uri) {
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public String getImagePath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public void showGallery(){
        GalleryView.show(this,paths);

//        GalleryView.show(this,paths, 0, new ActionCallback(){
//
//            @Override
//            public void onAction(String path, int position) {
//                Log.e("Action","Done");
//            }
//        });
    }

}
