package com.barmej.interactiveapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    private Random mRandom;

    int[] Activities = {
            R.drawable.beach,
            R.drawable.bike,
            R.drawable.football,
            R.drawable.museum,
            R.drawable.park,
            R.drawable.restaurant,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.swimming,
            R.drawable.walking
    };
    int mCurrentIndex = 0;

    Button button;
    ImageButton imageButton;
    ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        mRandom = new Random();

        button = findViewById(R.id.button);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
    }

    public void display(View view) {
        if (mCurrentIndex < Activities.length) {
            Log.d(TAG, "display= " + mCurrentIndex);
            mCurrentIndex= mRandom.nextInt(Activities.length);
            showImage();
        } else {
            Toast.makeText(this, "there are more activities", Toast.LENGTH_SHORT).show();
        }
    }

    public void display1(View view) {
        if (mCurrentIndex < Activities.length) {
            Drawable ActivityDrawable = ContextCompat.getDrawable(this, Activities[mCurrentIndex++]);
            imageView.setImageDrawable(ActivityDrawable);
        } else {
            Toast.makeText(this, "no more activities", Toast.LENGTH_SHORT).show();
        }
    }

    public void display2(View view) {
        if (mCurrentIndex < Activities.length) {
            Drawable ActivityDrawable = ContextCompat.getDrawable(this, Activities[mCurrentIndex--]);
            imageView.setImageDrawable(ActivityDrawable);
        } else {
            Toast.makeText(this, "you came to the beginning", Toast.LENGTH_SHORT).show();
        }
    }

    private void showImage() {
        Drawable ActivityDrawable = ContextCompat.getDrawable(this, Activities[mCurrentIndex++]);
        imageView.setImageDrawable(ActivityDrawable);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX, mCurrentIndex);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
        if (mCurrentIndex != Activities.length) {
            showImage();
        }
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        onRestart();
        super.onRestart();
        Log.i(TAG, "Restarted");
    }
}