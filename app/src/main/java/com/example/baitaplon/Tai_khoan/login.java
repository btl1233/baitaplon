package com.example.baitaplon.Tai_khoan;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.MainActivity;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login extends Fragment {
    private TextView btnSignup;
    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private TextView tvForgotPassword;
    private MainActivity mainActivity;
    private NavController navController;
    private ImageView imageView;
    private lap_lai_cauhoi laplai;
    private Animation up, down;
    private Dialog dialog;
    private   SharedPreferences Luu_tru_data;
   private String tk,mk;
    public login() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        on_click();
        get_tt();
    }

    private void get_tt() {
        if(!tk.isEmpty()){
            if (!mk.isEmpty()){
                laplai.setLoading_data(dialog);
                mAuth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            dialog.dismiss();
                        } else {
                            dialog.dismiss();
                            Intent intent = new Intent(mainActivity, Trangchu.class);
                            startActivity(intent);
                            mainActivity.finish();
                        }

                    }
                });
            }
        }
    }

    private void on_click() {
        tvForgotPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvForgotPassword.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        tvForgotPassword.setEnabled(false);
                        tvForgotPassword.startAnimation(down);
                        navController.navigate(R.id.action_login_to_quen_mat_khau);
                    }
                }
                return true;
            }
        });
        btnLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnLogin.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btnLogin.startAnimation(down);
                        checkCredentials();
                    }
                }
                return true;
            }
        });
        btnSignup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnSignup.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btnSignup.setEnabled(false);
                        btnSignup.startAnimation(down);
                        navController.navigate(R.id.action_login_to_dang_ky);
                    }
                }
                return true;
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView.startAnimation(up);

                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageView.setEnabled(false);
                        imageView.startAnimation(down);
                        navController.navigate(R.id.action_login_to_bat_dau);
                    }
                }
                return true;
            }
        });
    }

    private void checkCredentials() {

        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || !email.contains("@gmail.com")) {
            showError(inputEmail, "Email is not vaild");
        } else if (TextUtils.isEmpty(password) || password.length() < 7) {
            showError(inputPassword, "Password must be 7 character");
        } else {
            laplai.setLoading_data(dialog);
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        dialog.dismiss();
                        // there was an error
                        if (password.length() < 6) {
                            inputPassword.setError("Password too short, enter minimum 6 characters!");
                        } else {
                            Toast.makeText(mainActivity, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        dialog.dismiss();
                        SharedPreferences.Editor editor = Luu_tru_data.edit();
                        editor.putString("taikhoan", email);
                        editor.putString("matkhau", password);
                        editor.commit();
                        Intent intent = new Intent(mainActivity, Trangchu.class);
                        startActivity(intent);
                        mainActivity.finish();
                    }

                }
            });
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    private void anh_xa(View view) {
        btnSignup = view.findViewById(R.id.tvSignUp);
        inputEmail = view.findViewById(R.id.lgEmail);
        inputPassword = view.findViewById(R.id.lgPassWord);
        btnLogin = view.findViewById(R.id.btnlogin);
        mAuth = FirebaseAuth.getInstance();
        tvForgotPassword = view.findViewById(R.id.forgotPassword);
        mainActivity = (MainActivity) getActivity();
        navController = Navigation.findNavController(view);
        imageView = view.findViewById(R.id.image);
        laplai = new lap_lai_cauhoi();
        laplai.on_back(view, mainActivity, R.id.action_login_to_bat_dau);
        dialog=new Dialog(mainActivity);
        up = AnimationUtils.loadAnimation(mainActivity, R.anim.up);
        down = AnimationUtils.loadAnimation(mainActivity, R.anim.down);
        Luu_tru_data = mainActivity.getSharedPreferences("data", mainActivity.MODE_PRIVATE);
        tk=Luu_tru_data.getString("taikhoan", "");
        mk=Luu_tru_data.getString("matkhau", "");
    }
}