package com.example.baitaplon.Tai_khoan;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.MainActivity;
import com.example.baitaplon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Dang_ky extends Fragment {

    private Button btnRegister;
    private TextView AccExirst;
    private EditText inputEmail, inputPassword, inputConformPassword;
    private FirebaseAuth mAuth;
    private NavController navigation;
    private ImageView imageView;
    private lap_lai_cauhoi laplai;
    private Animation up, down;
    private Dialog dialog;

    public Dang_ky() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dang_ky, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        on_click();
    }

    private void on_click() {
        btnRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnRegister.startAnimation(up);

                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btnRegister.startAnimation(down);
                        checkCredentials();
                    }
                }
                return true;
            }
        });

        AccExirst.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    AccExirst.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        AccExirst.setEnabled(false);
                        AccExirst.startAnimation(down);
                        navigation.navigate(R.id.action_dang_ky_to_login);
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
                        navigation.navigate(R.id.action_dang_ky_to_login);
                    }
                }
                return true;
            }
        });
    }

    private void anh_xa(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        AccExirst = view.findViewById(R.id.alreadyHaveAccount);
        inputEmail = view.findViewById(R.id.inputEmail);
        inputConformPassword = view.findViewById(R.id.inputConformPassword);
        inputPassword = view.findViewById(R.id.inputPassword);
        mAuth = FirebaseAuth.getInstance();
        btnRegister = view.findViewById(R.id.btnRegister);
        navigation = Navigation.findNavController(view);
        imageView = view.findViewById(R.id.image);
        laplai = new lap_lai_cauhoi();
        laplai.on_back(view, mainActivity, R.id.action_dang_ky_to_login);
        dialog = new Dialog(mainActivity);
        up = AnimationUtils.loadAnimation(mainActivity, R.anim.up);
        down = AnimationUtils.loadAnimation(mainActivity, R.anim.down);
    }

    private void checkCredentials() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String conformpassword = inputConformPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || !email.contains("@gmail.com")) {
            showError(inputEmail, "Email is not vaild");
        } else if (TextUtils.isEmpty(password) || password.length() < 7) {
            showError(inputPassword, "Password must be 7 character");
        } else if (TextUtils.isEmpty(conformpassword) || !conformpassword.equals(password)) {
            showError(inputConformPassword, "Password not match");
        } else {
            laplai.setLoading_data(dialog);
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //  progressBar.setVisibility(View.GONE);
                    if (!task.isSuccessful()) {
                        dialog.dismiss();
                        Log.e("Authentication failed.", task.getException().toString());
                        Toast.makeText(getActivity(), "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();
                    } else {
                        dialog.dismiss();
                        navigation.navigate(R.id.action_dang_ky_to_login);

                    }
                }
            });
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}