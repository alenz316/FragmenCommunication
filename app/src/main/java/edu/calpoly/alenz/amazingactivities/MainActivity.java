package edu.calpoly.alenz.amazingactivities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AnyColorBoxFragment.SayHello {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called " + this);

        FragmentManager fragmentManager = getSupportFragmentManager();

        AnyColorBoxFragment fragment = (AnyColorBoxFragment) fragmentManager.findFragmentById(R.id.container_area);

        if (fragment == null) {
            // Only add the fragment once
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            AnyColorBoxFragment boxFragment = AnyColorBoxFragment.newInstance(Color.CYAN);
            transaction.add(R.id.container_area, boxFragment);

            transaction.commit();
        } else {
            Log.e("Fragments 4 Life", "fragment already there");
        }


        findViewById(R.id.blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Talking to the fragment is as simple as getting it from the FragmentManager
                AnyColorBoxFragment fragment = (AnyColorBoxFragment) getSupportFragmentManager().findFragmentById(R.id.container_area);
                fragment.setColor(Color.BLUE);
            }
        });

        findViewById(R.id.green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnyColorBoxFragment fragment = (AnyColorBoxFragment) getSupportFragmentManager().findFragmentById(R.id.container_area);
                fragment.setColor(Color.GREEN);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called " + this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called " + this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called " + this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called " + this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called " + this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called " + this);
    }

    @Override
    public void sayHello() {
        Toast.makeText(this, "HELLO WORLD", Toast.LENGTH_SHORT).show();
    }
}
