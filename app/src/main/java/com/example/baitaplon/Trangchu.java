package com.example.baitaplon;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
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

public class Trangchu extends AppCompatActivity {
    private DatabaseReference tai_khoan;
    public static LinearLayout thanhcongcu;
    private FirebaseUser getuser;
    private EditText editText_name;
    private ImageView img_name;
    private ImageView img_nu;
    private LinearLayout layout_nam;
    private LinearLayout layout_nu;
    private Button btn_xac_nhan;
    boolean check1, check2, check3;
    private String hinhanh = "";
    private lap_lai_cauhoi lap_lai;
    private Dialog dialog;
    private Animation up, down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        tai_khoan = FirebaseDatabase.getInstance().getReference().child("tai_khoan");
        thanhcongcu = findViewById(R.id.thanhcongcu);
        getuser = FirebaseAuth.getInstance().getCurrentUser();
        lap_lai = new lap_lai_cauhoi();
        up = AnimationUtils.loadAnimation(this, R.anim.up);
        down = AnimationUtils.loadAnimation(this, R.anim.down);
        dialog = new Dialog(this);
        lap_lai.setLoading_data(dialog);
        tai_khoan.child(getuser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    dialog.dismiss();
                    Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_baitap1234_to_chon_nhan_vat);

                } else {
                    dialog.dismiss();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        check1 = true;
        check2 = false;
        check3 = false;


        findViewById(R.id.bt).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    findViewById(R.id.bt).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        findViewById(R.id.bt).startAnimation(down);
                        check1 = true;
                        if (check2) {
                            check2 = false;
                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_hoso1234_to_baitap1234);

                        }
                        if (check3) {
                            check3 = false;

                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_bxh1234_to_baitap1234);
                        }
                    }
                }
                return true;
            }


        });
        findViewById(R.id.hs).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    findViewById(R.id.hs).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        findViewById(R.id.hs).startAnimation(down);
                        check2 = true;
                        if (check1) {
                            check1 = false;
                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_baitap1234_to_hoso1234);
                        }
                        if (check3) {
                            check3 = false;
                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_bxh1234_to_hoso1234);

                        }
                    }
                }
                return true;
            }


        });
        findViewById(R.id.bxh).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    findViewById(R.id.bxh).startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        findViewById(R.id.bxh).startAnimation(down);
                        check3 = true;
                        if (check1) {
                            check1 = false;
                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_baitap1234_to_bxh1234);
                        }
                        if (check2) {
                            check2 = false;
                            Navigation.findNavController(Trangchu.this, R.id.trangchu).navigate(R.id.action_hoso1234_to_bxh1234);

                        }
                    }
                }
                return true;
            }


        });


    }

}