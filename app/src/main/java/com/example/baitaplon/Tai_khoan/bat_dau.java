package com.example.baitaplon.Tai_khoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.baitaplon.R;


public class bat_dau extends Fragment {


    public bat_dau() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bat_dau, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       Animation up = AnimationUtils.loadAnimation(getActivity(), R.anim.up);
        Animation down = AnimationUtils.loadAnimation(getActivity(), R.anim.down);
        view.findViewById(R.id.bat_dau).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view.findViewById(R.id.bat_dau).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        view.findViewById(R.id.bat_dau).startAnimation(down);
                        Navigation.findNavController(view).navigate(R.id.action_bat_dau_to_login);
                    }
                }
                return true;
            }
        });

    }
}