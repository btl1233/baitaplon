package com.example.baitaplon.cai_dat;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class hoso extends Fragment {
    private Animation up, down;
    private AppBarLayout appBarLayout;
    private ImageView anh,anh1,cai_dat;
    private Trangchu trangchu;
    private NavController navController;
    private TextView txt_name,txt_email,txt_ngay_tg,txt_so_lan_diem10,txt_so_lan_kt;
    private DatabaseReference data_tk;
    private FirebaseUser user_tk;
    private ProgressBar pro_cao_nhan,pro_bac_thay,pro_hoc_gia;
    private TextView txt_cao_nhan,txt_bac_thay,txt_hoc_gia;
    public hoso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.hoso, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        inittoolbarabumation();
        on_click();
        get_data();
    }

    private void get_data() {
        data_tk.child(user_tk.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    txt_name.setText(snapshot.child("name").getValue().toString());
                    txt_email.setText(snapshot.child("email").getValue().toString());
                    txt_ngay_tg.setText("Tham gia vào "+snapshot.child("ngay_dang_ky").getValue().toString());
                    String hinhanh=snapshot.child("hinhanh").getValue().toString();
                    Glide.with(trangchu).load(hinhanh).error(R.drawable.male).into(anh);
                    Glide.with(trangchu).load(hinhanh).error(R.drawable.male).into(anh1);
                    String diem10=snapshot.child("thong_ke").child("so_lan_diem_10").getValue().toString();
                    if (!diem10.isEmpty()){
                        txt_so_lan_diem10.setText(diem10);
                    }
                    String solankt=snapshot.child("thong_ke").child("so_lan_kiem_tra").getValue().toString();
                    if (!solankt.isEmpty()){
                        txt_so_lan_kt.setText(solankt);
                    }
                    get_tt(snapshot);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void get_tt(DataSnapshot snapshot){
        String cao_nhan=snapshot.child("thanh_tich").child("cao_nhan").getValue().toString();
        String bac_thay=snapshot.child("thanh_tich").child("bac_thay").getValue().toString();
        String hoc_gia=snapshot.child("thanh_tich").child("hoc_gia").getValue().toString();
        if (!cao_nhan.isEmpty()) {
            if (Integer.parseInt(cao_nhan)<101){
                txt_cao_nhan.setText(cao_nhan+"/100");
                pro_cao_nhan.setProgress(Integer.parseInt(cao_nhan));
            }else {
                txt_cao_nhan.setText("100/100");
                pro_cao_nhan.setProgress(100);
            }

        }
        if (!bac_thay.isEmpty()){
            if (Integer.parseInt(bac_thay)<1001){
            txt_bac_thay.setText(bac_thay+"/1k");
            pro_bac_thay.setProgress(Integer.parseInt(bac_thay)/10);
            }else {
                txt_bac_thay.setText("1k/1k");
                pro_bac_thay.setProgress(100);
            }
        }
        if (!hoc_gia.isEmpty()) {
            if (Integer.parseInt(hoc_gia)<101){
            txt_hoc_gia.setText(hoc_gia+"/100");
            pro_hoc_gia.setProgress(Integer.parseInt(hoc_gia));
            }else {
                txt_hoc_gia.setText("100/100");
                pro_hoc_gia.setProgress(100);
            }
        }
    }
    private void on_click() {
        cai_dat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    cai_dat.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        cai_dat.setEnabled(false);
                        cai_dat.startAnimation(down);
                        navController.navigate(R.id.action_hoso1234_to_cai_dat2);
                    }
                }
                return true;
            }
        });
    }

    private void anh_xa(View view) {
        trangchu= (Trangchu) getActivity();
        appBarLayout=view.findViewById(R.id.appBarLayout);
        anh1 = view.findViewById(R.id.anh1);
        anh = view.findViewById(R.id.anh);
        txt_name = view.findViewById(R.id.txt_name);
        txt_email = view.findViewById(R.id.txt_email);
        txt_ngay_tg = view.findViewById(R.id.txt_ngay_tg);
        txt_so_lan_diem10 = view.findViewById(R.id.so_diem_10);
        txt_so_lan_kt = view.findViewById(R.id.so_lan_kiem_tra);
        pro_cao_nhan = view.findViewById(R.id.pro_cao_nhan);
        pro_bac_thay = view.findViewById(R.id.pro_bac_thay);
        pro_hoc_gia = view.findViewById(R.id.pro_hoc_gia);
        txt_cao_nhan = view.findViewById(R.id.txt_cao_nhan);
        txt_bac_thay = view.findViewById(R.id.txt_bac_thay);
        txt_hoc_gia = view.findViewById(R.id.txt_hoc_gia);
        thanhcongcu.setVisibility(View.VISIBLE);
        cai_dat = view.findViewById(R.id.cai_dat);
        up = AnimationUtils.loadAnimation(trangchu, R.anim.up);
        down = AnimationUtils.loadAnimation(trangchu, R.anim.down);
        navController= Navigation.findNavController(view);
        data_tk= FirebaseDatabase.getInstance().getReference().child("tai_khoan");
        user_tk= FirebaseAuth.getInstance().getCurrentUser();
        lap_lai_cauhoi lap_lai_cauhoi=new lap_lai_cauhoi();
        lap_lai_cauhoi.on_back2(trangchu);
    }
    private void inittoolbarabumation(){
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset)>50){
                    Log.e("11",""+2000);
                    anh1.setVisibility(View.VISIBLE);
                }else {
                    Log.e("113",""+2000);
                    anh1.setVisibility(View.GONE);
                }
            }
        });
    }
}