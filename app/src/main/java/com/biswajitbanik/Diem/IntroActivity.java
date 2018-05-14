package com.biswajitbanik.Diem;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.codility.introsilder.R;


public class IntroActivity extends AppCompatActivity {

    VideoView mVideoView;

    Button exploreBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Intent intent = new Intent(IntroActivity.this, PagerActivity.class);

        exploreBtn = (Button) findViewById(R.id.explorebtn);
        exploreBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        mVideoView = (VideoView) findViewById(R.id.mgvideoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shortversion);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }
}
