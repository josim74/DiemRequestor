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

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.Util.TextureVideoView;


public class IntroActivity extends AppCompatActivity {

    TextureVideoView mVideoView;

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

        mVideoView = (TextureVideoView) findViewById(R.id.mgvideoView);
        mVideoView.setScaleType(TextureVideoView.ScaleType.CENTER_CROP);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shortversion);
        mVideoView.setDataSource(this,uri);
        //mVideoView.setVideoURI(uri);

        mVideoView.setLooping(true);
        mVideoView.play();

//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setLooping(true);
//            }
//        });
    }
}
