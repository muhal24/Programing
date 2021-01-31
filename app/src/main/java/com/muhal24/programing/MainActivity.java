package com.muhal24.programing;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;



public class   MainActivity extends AppCompatActivity {

    TextView mi1;
    TextView mi2;
    TextView mi3;
    TextView mi4;
    TextView mi5;
    TextView mi6;
    TextView mi7;
    TextView mi8;
    TextView mi9;
    TextView mi10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mi1= findViewById(R.id.java);
        mi2= findViewById(R.id.golang);
        mi3= findViewById(R.id.javascript);
        mi4= findViewById(R.id.css);
        mi5= findViewById(R.id.html);
        mi6= findViewById(R.id.react);
        mi7= findViewById(R.id.python);
        mi8= findViewById(R.id.kotlin);
        mi9= findViewById(R.id.cpp);
        mi10= findViewById(R.id.swift);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Programing");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Programing");
        toolbar.setTitleTextColor(getResources().getColor(R.color.bottomNavigationBackground));
        setSupportActionBar(toolbar);
    }


    public void JumpJava(View view) {

        Intent intent = new Intent(getApplicationContext(), Java.class);
        startActivity(intent);

    }

    public void JumpGolang(View view) {

        Intent intent = new Intent(getApplicationContext(), Golang.class);
        startActivity(intent);

    }

    public void JumpJavascript(View view) {

        Intent intent = new Intent(getApplicationContext(), Javascript.class);
        startActivity(intent);

    }

    public void JumpCss(View view) {

        Intent intent = new Intent(getApplicationContext(), Css.class);
        startActivity(intent);

    }

    public void JumpHtml(View view) {

        Intent intent = new Intent(getApplicationContext(), Html.class);
        startActivity(intent);

    }

    public void JumpReact(View view) {

        Intent intent = new Intent(getApplicationContext(), React.class);
        startActivity(intent);

    }

    public void JumpPython(View view) {

        Intent intent = new Intent(getApplicationContext(), Python.class);
        startActivity(intent);

    }

    public void JumpKotlin(View view) {

        Intent intent = new Intent(getApplicationContext(), Kotlin.class);
        startActivity(intent);

    }

    public void JumpCpp(View view) {

        Intent intent = new Intent(getApplicationContext(), Cpp.class);
        startActivity(intent);

    }

    public void JumpSwift(View view) {

        Intent intent = new Intent(getApplicationContext(), Swift.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void changeStatusBar(int mode, Window window){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.contentBodyColor));
            //white mode
            if(mode==1){
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }
}