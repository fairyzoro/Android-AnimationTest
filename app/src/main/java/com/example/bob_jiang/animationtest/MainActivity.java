package com.example.bob_jiang.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Bob_JIANG on 10/10/2015.
 */
public class MainActivity extends AppCompatActivity {
    private ListView mlistview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mlistview = new ListView(this);
        mlistview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                switch (arg2) {
                    case 0:
                        Intent it0 = new Intent(MainActivity.this, PropertyAnimation.class);
                        startActivity(it0);
                        break;
                    case 1:
                        Intent it1 = new Intent(MainActivity.this, ViewAnimation.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2 = new Intent(MainActivity.this, DrawableAnimation.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3 = new Intent(MainActivity.this, DrawableCanvasAnimation.class);
                        startActivity(it3);
                        break;
                    case 4:
                        Intent it4 = new Intent(MainActivity.this, SurfaceViewAnimation.class);
                        startActivity(it4);
                }
            }
        });
        setContentView(mlistview);
    }

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<String> getData() {
        ArrayList<String> ALS = new ArrayList<>();
        ALS.add("Property Animation");
        ALS.add("View Animation");
        ALS.add("DrawableAnimation");
        ALS.add("DrawableCanavsAnimation");
        ALS.add("SurfaceViewAnimation");
        return ALS;
    }

}
