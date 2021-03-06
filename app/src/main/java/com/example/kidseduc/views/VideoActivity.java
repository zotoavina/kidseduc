package com.example.kidseduc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kidseduc.R;
import com.example.kidseduc.models.Lesson;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView video;
    String apiKey = "AIzaSyC3HuCKe17Qr7oMIfA58Bm16OsDWSG3UeI";
    private Lesson lesson ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lesson = (Lesson) getIntent().getSerializableExtra("LESSON");
        setContentView(R.layout.activity_video);
        video = (YouTubePlayerView) findViewById(R.id.video);
        video.initialize(apiKey, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            youTubePlayer.cueVideo(lesson.getContent(),1);
            youTubePlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.d("Video error", "onInitializationFailure: ");
    }
}