package com.example.baitaplon.cai_dat;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class chon_nhan_vat extends Fragment {

    private EditText editText_name;
    private ImageView img_name;
    private ImageView img_nu;
    private LinearLayout layout_nam;
    private LinearLayout layout_nu;
    private Button btn_xac_nhan;
    private String hinhanh = "";
    private lap_lai_cauhoi lap_lai;
    private Dialog dialog;
    private Animation up, down;
    private Trangchu trangchu;
    private NavController navController;
    public chon_nhan_vat() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chon_nhan_vat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhxa(view);
        on_click();
    }

    private void on_click() {
        img_nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_nu.setBackground(trangchu.getDrawable(R.drawable.vong2));
                layout_nam.setBackground(trangchu.getDrawable(R.drawable.vong1));
                hinhanh = "https://cdn-icons-png.flaticon.com/512/3233/3233515.png";
                btn_xac_nhan.setEnabled(true);
                btn_xac_nhan.setAlpha(1f);
            }
        });
        img_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_nu.setBackground(trangchu.getDrawable(R.drawable.vong1));
                layout_nam.setBackground(trangchu.getDrawable(R.drawable.vong2));
                hinhanh = "https://cdn-icons-png.flaticon.com/512/3233/3233483.png";
                btn_xac_nhan.setEnabled(true);
                btn_xac_nhan.setAlpha(1f);
            }
        });

        btn_xac_nhan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_xac_nhan.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_xac_nhan.startAnimation(down);
                        if (editText_name.getText().toString().isEmpty() || editText_name.getText().toString().length() < 5) {
                            showError(editText_name, "Your usename is not valid");
                        } else {
                            Bundle bundle=new Bundle();
                            bundle.putString("name",editText_name.getText().toString());
                            bundle.putString("hinhanh",hinhanh);
                            navController.navigate(R.id.action_chon_nhan_vat_to_muc_tieu,bundle);
                        }


                    }
                }
                return true;
            }
        });

    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    private void anhxa(View dialog1) {
        trangchu= (Trangchu) getActivity();
        btn_xac_nhan = dialog1.findViewById(R.id.btn_xac_nhan);
        img_name = dialog1.findViewById(R.id.img_name);
        img_nu = dialog1.findViewById(R.id.img_nu);
        layout_nam = dialog1.findViewById(R.id.layout_nam);
        layout_nu = dialog1.findViewById(R.id.layout_nu);
        editText_name = dialog1.findViewById(R.id.txt_name);
        up = AnimationUtils.loadAnimation(trangchu, R.anim.up);
        down = AnimationUtils.loadAnimation(trangchu, R.anim.down);
        navController= Navigation.findNavController(dialog1);
        thanhcongcu.setVisibility(View.GONE);
    }
}
