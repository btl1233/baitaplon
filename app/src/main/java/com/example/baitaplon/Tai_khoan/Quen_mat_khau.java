package com.example.baitaplon.Tai_khoan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.MainActivity;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Quen_mat_khau extends Fragment {

    private EditText inputEmail;
    private Button btnReset;
    private ImageView btnBack;
    private FirebaseAuth mAuth;
    private lap_lai_cauhoi laplai;
    private MainActivity mainActivity;
    private Animation up;
    private Animation down;

    public Quen_mat_khau() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quen_mat_khau, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        on_click(view);
    }

    private void on_click(View view) {
        btnReset.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnReset.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {

                        btnReset.startAnimation(down);
                        quan_matkhau();
                    }
                }
                return true;
            }
        });
        btnBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnBack.startAnimation(up);

                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btnBack.setEnabled(false);
                        btnBack.startAnimation(down);
                        Navigation.findNavController(view).navigate(R.id.action_quen_mat_khau_to_login);
                    }
                }
                return true;
            }
        });


    }

    private void anh_xa(View view) {
        mainActivity= (MainActivity) getActivity();
        inputEmail =  view.findViewById(R.id.lgEmail);
        btnReset = view.findViewById(R.id.btnReset);
        btnBack = view.findViewById(R.id.image);
        mAuth = FirebaseAuth.getInstance();
        laplai = new lap_lai_cauhoi();
        laplai.on_back(view, mainActivity, R.id.action_quen_mat_khau_to_login);
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(mainActivity, Trangchu.class));
            mainActivity.finish();
        }
        up = AnimationUtils.loadAnimation(mainActivity, R.anim.up);
        down = AnimationUtils.loadAnimation(mainActivity, R.anim.down);

    }
    private void quan_matkhau(){
        String email = inputEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)|| !email.contains("@gmail.com")) {
            Toast.makeText(getActivity(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}