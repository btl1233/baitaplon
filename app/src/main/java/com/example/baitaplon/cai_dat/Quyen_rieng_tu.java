package com.example.baitaplon.cai_dat;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;

import pl.droidsonroids.gif.GifImageView;


public class Quyen_rieng_tu extends Fragment {

    NestedScrollView scrollView;
    GifImageView gif;
    ImageView img;
    public Quyen_rieng_tu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quyen_rieng_tu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thanhcongcu.setVisibility(View.GONE);
        scrollView=view.findViewById(R.id.scrollView);
        lap_lai_cauhoi lap_lai_cauhoi=new lap_lai_cauhoi();
        Trangchu trangchu = (Trangchu) getActivity();
        gif=view.findViewById(R.id.gif);
        img=view.findViewById(R.id.img);
        Bundle bundle = this.getArguments();
        String quyen = bundle.getString("quyen");
        if (quyen.equals("dieukhoan")){
            scrollView.setVisibility(View.VISIBLE);
            gif.setVisibility(View.GONE);
        }else {
            scrollView.setVisibility(View.GONE);
            gif.setVisibility(View.VISIBLE);
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_quyen_rieng_tu_to_cai_dat2);
            }
        });
        lap_lai_cauhoi.on_back1(view,trangchu,R.id.action_quyen_rieng_tu_to_cai_dat2);

    }
}