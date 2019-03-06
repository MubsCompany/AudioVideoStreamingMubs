package com.example.audiovideostreamingmubs;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {
    MediaPlayer player;
    String url = "http://live2.radiorodja.com/;stream.mp3";
    @BindView(R.id.btn_play)
    ImageButton btnPlay;
    @BindView(R.id.btn_pause)
    ImageButton btnPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        ButterKnife.bind( this );

        setPlaying();
    }

    private void setPlaying() {
        player = new MediaPlayer();

        try {
            player.setDataSource( url );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        player.start();

    }

    @OnClick({R.id.btn_play, R.id.btn_pause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                setPlaying();
                try {
                    player.prepareAsync();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }

                player.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                    }
                } );
                break;
            case R.id.btn_pause:
                player.stop();
                break;
        }
    }
}
