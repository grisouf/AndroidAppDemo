package com.gridev.androidappdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class HomeFragment extends Fragment {

    private OnResultClickListener resultClickListener;
    private OnCalculateClickListener calculateClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // TODO :
        view.findViewById(R.id.homeCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculateClickListener == null) return;
                calculateClickListener.onClick();
            }
        });

        view.findViewById(R.id.homeResults).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultClickListener == null) return;
                resultClickListener.onClick();
            }
        });

        return view;
    }

    public interface OnCalculateClickListener {
        void onClick();
    }

    public interface OnResultClickListener {
        void onClick();
    }

    public void setOnCalculateClickListener(OnCalculateClickListener listener){
        calculateClickListener = listener;
    }

    public void setOnResultClickListener(OnResultClickListener listener) {
        resultClickListener = listener;
    }

}
