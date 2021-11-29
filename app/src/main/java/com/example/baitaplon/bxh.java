package com.example.baitaplon;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;

public class bxh extends Fragment {

    Trangchu trangchu;
    public bxh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bxh, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trangchu= (Trangchu) getActivity();
        thanhcongcu.setVisibility(View.VISIBLE);
        lap_lai_cauhoi lap_lai_cauhoi=new lap_lai_cauhoi();
        lap_lai_cauhoi.on_back2(trangchu);
    }
}