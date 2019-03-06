package com.example.audiovideostreamingmubs;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private Context context;

    String[] arrayNamaVideo = {"First Video","Second Video","Third Video","Fourth Video","Fifth Video","Sixth Video","Seventh Video","Eighth Video","Ninth Video","Tenth Video","Eleventh Video","Twelveth Video"};

    public VideoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( context ).inflate( R.layout.rv_layout,viewGroup,false );
        return new VideoViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, final int i) {
videoViewHolder.tvVideo.setText( arrayNamaVideo[i] );
videoViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        context.startActivity( new Intent( context,DetailVideo.class ) );
    }
} );
    }

    @Override
    public int getItemCount() {
        return arrayNamaVideo.length;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView tvVideo;

        public VideoViewHolder(@NonNull View itemView) {
            super( itemView );

            tvVideo = itemView.findViewById( R.id.tv_nama );
        }
    }
}
