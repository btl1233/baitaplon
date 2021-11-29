package com.example.baitaplon.Bai_tap;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class baitap extends Fragment {

    private TextView txt_diem_10, txt_baikt;
    private Trangchu trangchu;
    private Animation up, down;
    private FirebaseUser user;
    private DatabaseReference data_tk;
    Bundle bundle;
    lap_lai_cauhoi lap_lai_cauhoi;
    public baitap() {
        // Required empty public constructor
    }

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.baitap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        on_click(view);
        get_tt();
    }

    private void get_tt() {
        data_tk.child(user.getUid()).child("thong_ke").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String diem10 = snapshot.child("so_lan_diem_10").getValue().toString();
                    Log.e(diem10,diem10);
                    txt_diem_10.setText(diem10);
                    String solankt = snapshot.child("so_lan_kiem_tra").getValue().toString();
                    Log.e(solankt,solankt);
                    txt_baikt.setText(solankt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void on_click(View view) {

        view.findViewById(R.id.tracnghiemtraicay).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view.findViewById(R.id.tracnghiemtraicay).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        view.findViewById(R.id.tracnghiemtraicay).startAnimation(down);
                        bundle.putString("luyentap","traicay");
                        popmenu(v,R.id.action_baitap1234_to_luyen_tap2,bundle);

                    }
                }
                return true;
            }
        });

        view.findViewById(R.id.tracnghiemdogiadung).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view.findViewById(R.id.tracnghiemdogiadung).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        view.findViewById(R.id.tracnghiemdogiadung).startAnimation(down);
                        bundle.putString("luyentap","dogiadung");
                        popmenu(v,R.id.action_baitap1234_to_luyen_tap2,bundle);

                    }
                }
                return true;
            }
        });
        view.findViewById(R.id.tracnghiemdongvat).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view.findViewById(R.id.tracnghiemdongvat).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        view.findViewById(R.id.tracnghiemdongvat).startAnimation(down);

                        bundle.putString("luyentap","dongvat");
                        popmenu(v,R.id.action_baitap1234_to_luyen_tap2,bundle);

                    }
                }
                return true;
            }
        });
        view.findViewById(R.id.tracnghiemxeco).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view.findViewById(R.id.tracnghiemxeco).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        view.findViewById(R.id.tracnghiemxeco).startAnimation(down);
                        bundle.putString("luyentap","xeco");
                        popmenu(v,R.id.action_baitap1234_to_luyen_tap2,bundle);

                    }
                }
                return true;
            }
        });


    }
    private void popmenu(View view,int id1,Bundle bundle){
        PopupMenu popupMenu=new PopupMenu(trangchu,view, Gravity.CENTER);
        popupMenu.getMenuInflater().inflate(R.menu.item,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.luyen_tap:
                        navController.navigate(id1,bundle);
                        return true;
                    case R.id.kiem_tra:
                        navController.navigate(id1,bundle);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
    private void anh_xa(View view) {
        trangchu = (Trangchu) getActivity();
        txt_diem_10 = view.findViewById(R.id.txt_diem_10);
        txt_baikt = view.findViewById(R.id.txt_baikt);
        navController = Navigation.findNavController(view);
        up = AnimationUtils.loadAnimation(trangchu, R.anim.up);
        down = AnimationUtils.loadAnimation(trangchu, R.anim.down);
        user = FirebaseAuth.getInstance().getCurrentUser();
        data_tk = FirebaseDatabase.getInstance().getReference().child("tai_khoan");
        bundle=new Bundle();
        thanhcongcu.setVisibility(View.VISIBLE);
        lap_lai_cauhoi=new lap_lai_cauhoi();
        lap_lai_cauhoi.on_back2(trangchu);
    }
}