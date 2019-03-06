package com.example.audiovideostreamingmubs;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class DetailVideo extends AppCompatActivity {
    VideoView vvStreaming;
    String[] arrayUrl = {"https://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4","http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_video );

        vvStreaming = findViewById( R.id.vv_streaming );
        final int position = this.getIntent().getIntExtra( "position", 1 );

try {
    MediaController controller = new MediaController( this );
    controller.setAnchorView( vvStreaming );

    Uri bahan = Uri.parse( arrayUrl[position] );
    vvStreaming.setVideoURI( bahan );
    vvStreaming.setMediaController( controller );
    vvStreaming.requestFocus();

    vvStreaming.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.start();
        }
    } );
}catch (Exception e) {
    e.printStackTrace();
}

    }
}
