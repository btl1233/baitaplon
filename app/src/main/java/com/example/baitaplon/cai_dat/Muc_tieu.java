package com.example.baitaplon.cai_dat;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class Muc_tieu extends Fragment {

    CheckBox check_de, check_vua, check_kho, check_ratkho;
    private String name, hinhanh, muctieu;
    private DatabaseReference tai_khoan;
    private FirebaseUser getuser;
    private lap_lai_cauhoi lap_lai;
    private Dialog dialog;
    private Animation up, down;
    private Trangchu trangchu;
    private NavController navController;
    private Button luu, luu1;
    private ImageView img;
    private Bundle bundle;

    public Muc_tieu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.muc_tieu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        on_click();
        get_tt();
    }

    private void get_tt() {
        tai_khoan.child(getuser.getUid()).child("muctieu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    img.setVisibility(View.VISIBLE);
                    luu.setVisibility(View.VISIBLE);
                    luu1.setVisibility(View.GONE);
                    String a = snapshot.getValue().toString();
                    switch (a) {
                        case "Dễ":
                            check_de.setChecked(true);
                            break;
                        case "Vừa":
                            check_vua.setChecked(true);
                            break;
                        case "Khó":
                            check_kho.setChecked(true);
                            break;
                        case "Rất khó":
                            check_ratkho.setChecked(true);
                            break;
                        default:
                            break;
                    }
                } else {
                    img.setVisibility(View.GONE);
                    luu.setVisibility(View.GONE);
                    luu1.setVisibility(View.VISIBLE);
                    luu1.setEnabled(false);
                    luu1.setAlpha(0.5f);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void on_click() {

        check_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on_check(check_vua, check_kho, check_ratkho);
                muctieu = "Dễ";
                luu1.setEnabled(true);
                luu1.setAlpha(1);
            }
        });
        check_vua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on_check(check_de, check_kho, check_ratkho);
                muctieu = "Vừa";
                luu1.setEnabled(true);
                luu1.setAlpha(1);
            }
        });
        check_kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on_check(check_vua, check_de, check_ratkho);
                muctieu = "Khó";
                luu1.setEnabled(true);
                luu1.setAlpha(1);
            }
        });
        check_ratkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on_check(check_vua, check_kho, check_de);
                muctieu = "Rất khó";
                luu1.setEnabled(true);
                luu1.setAlpha(1);
            }
        });
        luu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    luu.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        luu.startAnimation(down);
                        tai_khoan.addValueEventListener(new ValueEventListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("muctieu", muctieu);
                                    tai_khoan.child(getuser.getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
                                        @Override
                                        public void onComplete(@NonNull Task task) {
                                            navController.navigate(R.id.cai_dat2);
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
                return true;
            }
        });
        luu1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    luu1.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        luu1.startAnimation(down);
                        tai_khoan.child(getuser.getUid()).addValueEventListener(new ValueEventListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (!snapshot.exists()) {
                                    lap_lai.setLoading_data(dialog);
                                    name = bundle.getString("name");
                                    hinhanh = bundle.getString("hinhanh");
                                    add_tk(name, hinhanh);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
                return true;
            }
        });
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        img.startAnimation(down);
                        navController.navigate(R.id.action_muc_tieu_to_cai_dat22);
                    }
                }
                return true;
            }
        });
    }

    private void on_check(CheckBox check_vua, CheckBox check_kho, CheckBox check_ratkho) {
        check_vua.setChecked(false);
        check_kho.setChecked(false);
        check_ratkho.setChecked(false);
    }

    private void anh_xa(View view) {
        trangchu = (Trangchu) getActivity();
        check_de = view.findViewById(R.id.check_de);
        check_vua = view.findViewById(R.id.check_vua);
        check_kho = view.findViewById(R.id.check_kho);
        img = view.findViewById(R.id.img);
        check_ratkho = view.findViewById(R.id.check_ratkho);
        tai_khoan = FirebaseDatabase.getInstance().getReference().child("tai_khoan");
        getuser = FirebaseAuth.getInstance().getCurrentUser();
        lap_lai = new lap_lai_cauhoi();
        dialog = new Dialog(trangchu);
        up = AnimationUtils.loadAnimation(trangchu, R.anim.up);
        down = AnimationUtils.loadAnimation(trangchu, R.anim.down);
        navController = Navigation.findNavController(view);
        bundle = this.getArguments();
        luu = view.findViewById(R.id.luu);
        lap_lai.on_back1(view,trangchu,R.id.action_muc_tieu_to_cai_dat22);
        luu1 = view.findViewById(R.id.luu1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void add_tk(String name, String hinhanh) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("id", getuser.getUid());
        hashMap.put("email", getuser.getEmail());
        hashMap.put("hinhanh", hinhanh);
        hashMap.put("muctieu", muctieu);
        hashMap.put("ngay_dang_ky", java.time.LocalDate.now() + "");
        HashMap hashMap1 = new HashMap();
        hashMap1.put("so_lan_diem_10", "0");
        hashMap1.put("so_lan_kiem_tra", "0");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cao_nhan", "0");
        hashMap2.put("bac_thay", "0");
        hashMap2.put("hoc_gia", "0");
        tai_khoan.child(getuser.getUid()).child("thong_ke").updateChildren(hashMap1);
        tai_khoan.child(getuser.getUid()).child("thanh_tich").updateChildren(hashMap2);
        tai_khoan.child(getuser.getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                dialog.dismiss();
                navController.navigate(R.id.action_muc_tieu_to_baitap1234);

            }
        });

    }
}