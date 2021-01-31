package com.muhal24.programing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.RelativeLayout;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

public class React extends AppCompatActivity {

    MediaController mediaController;
    // VideoView videoview;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;
    SimpleExoPlayer player;
    PlayerView playerView;
    ImageView fullscreenButton;
    MediaSource videoSource ;
    DataSource.Factory dataSourceFactory ;
    boolean fullscreen = false;

    Boolean is1Clicked = false ;
    Boolean is2Clicked = false ;
    Boolean is3Clicked = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_react);
        listView = (ListView) findViewById(R.id.lreactvideo);
        videoList= new ArrayList<>();

            videoList.add("1");
            videoList.add("2");
            videoList.add("3");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.textEffect,videoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setVideoURI("https://www.youtube.com/watch?v=n1a3VZY0xgM") ;
                        //chooseVideoFromGallary();
                        is1Clicked = true ;
                        is2Clicked = false ;
                        is3Clicked = false ;
                        break ;
                    case 1 :
                        setVideoURI("https://www.youtube.com/watch?v=n1a3VZY0xgM") ;
                        is1Clicked = false ;
                        is2Clicked = true ;
                        is3Clicked = false ;
                        break ;
                    case 2 :
                        setVideoURI("https://www.youtube.com/watch?v=n1a3VZY0xgM") ;
                        is1Clicked = false ;
                        is2Clicked = false ;
                        is3Clicked = true ;
                        break ;
                }


            }
        });

        player = ExoPlayerFactory.newSimpleInstance(getApplicationContext());

        playerView = findViewById(R.id.Videoreact);

        fullscreenButton = playerView.findViewById(R.id.exo_fullscreen_icon);

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullscreen) {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(React.this, R.drawable.ic_fullscreen_open));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().show();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) ( 200 * getApplicationContext().getResources().getDisplayMetrics().density);
                    playerView.setLayoutParams(params);

                    fullscreen = false;
                }else{
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(React.this, R.drawable.ic_fullscreen_close));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().hide();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = params.MATCH_PARENT;
                    playerView.setLayoutParams(params);

                    fullscreen = true;
                }
            }
        });

        playerView.setPlayer(player);
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);

        dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(), Util.getUserAgent(getApplicationContext(),getApplicationContext().getString(R.string.app_name)));
        setVideoURI("https://www.youtube.com/watch?v=n1a3VZY0xgM") ;

    }

    @Override
    public void onPause() {
        super.onPause();
        player.setPlayWhenReady(false);
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }

    public void setVideoURI(String vidUri){
        Log.e("filepath", vidUri);
        Uri uri = Uri.parse(vidUri) ;
        videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        player.prepare(videoSource);
        player.setPlayWhenReady(true);
    }

}
