package com.example.audiovideostreamingmubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    VideoAdapter videoAdapter;
    RecyclerView rvVideo;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View videoInflate = inflater.inflate( R.layout.fragment_video, container, false );

        rvVideo = videoInflate.findViewById( R.id.rv_video );
        videoAdapter = new VideoAdapter( getActivity() );
        rvVideo.setAdapter( videoAdapter );
        rvVideo.setLayoutManager( new LinearLayoutManager( getContext(), LinearLayoutManager.VERTICAL, false ) );

        return videoInflate;
    }

}
