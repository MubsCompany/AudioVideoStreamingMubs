package com.example.audiovideostreamingmubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioFragment extends Fragment {
    @BindView(R.id.rv_audio)
    RecyclerView rvAudio;
    Unbinder unbinder;
    AudioAdapter audioAdapter;

    public AudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View audioInflate = inflater.inflate( R.layout.fragment_audio, container, false );
        unbinder = ButterKnife.bind( this, audioInflate );

        audioAdapter = new AudioAdapter( getActivity() );
        rvAudio.setAdapter( audioAdapter );
        rvAudio.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );

        return audioInflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
