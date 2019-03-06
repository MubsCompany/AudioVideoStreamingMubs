package com.example.audiovideostreamingmubs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioViewHolder> {
    Context context;

    String[] arrayAudioUrl = {"http://mic.duytan.edu.vn:86/ncs.mp3"};
    String[] arrayNamaAudio = {"First Audio","Second Audio","Third Audio","Fourth Audio","Fifth Audio","Sixth Audio","Seventh Audio","Eighth Audio","Ninth Audio","Tenth Audio","Eleventh Audio","Twelveth Audio"};

    public AudioAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from( context ).inflate( R.layout.rv_layout,viewGroup,false );
        return new AudioViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder audioViewHolder, int i) {
audioViewHolder.tvLayoutAudio.setText( arrayNamaAudio[i] );
audioViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       context.startActivity( new Intent( context,DetailActivity.class ) );
    }
} );
    }

    @Override
    public int getItemCount() {
        return arrayNamaAudio.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder {
        TextView tvLayoutAudio;

        public AudioViewHolder(@NonNull View itemView) {
            super( itemView );

tvLayoutAudio = itemView.findViewById( R.id.tv_nama );
        }
    }
}
