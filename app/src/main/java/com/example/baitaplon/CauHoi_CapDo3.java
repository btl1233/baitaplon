package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.baitaplon.Bai_tap.CauHoi;
import com.example.baitaplon.Bai_tap.dapan_ten;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CauHoi_CapDo3 extends AppCompatActivity {

    TextView tv_cauhoi;
    EditText edt_cautraloi;
    ImageView img_cauhoi;
    Button btn_kiemtra;

    Animation up, down;
    CauHoi cauHoi;
    List<CauHoi> list_cauHoi;
    int viTriCauHoi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_hoi_cap_do3);
        anhxa();
        init();
        hienCauHoi();
        checkCauTraLoi();
    }

    private void anhxa(){
        tv_cauhoi = findViewById(R.id.tv_causo);
        edt_cautraloi = findViewById(R.id.edt_cautraloi);
        img_cauhoi = findViewById(R.id.img_cauhoi);
        btn_kiemtra = findViewById(R.id.btn_kiemtra);
    }

    private void init(){
        cauHoi = new CauHoi();
        list_cauHoi = new ArrayList<>();

        list_cauHoi.add(new CauHoi("Quả táo",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"));
        list_cauHoi.add(new CauHoi("Quả cam",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        list_cauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
    }

    private void hienCauHoi(){
        cauHoi = list_cauHoi.get(viTriCauHoi);
        tv_cauhoi.setText("Câu hỏi " + viTriCauHoi);
        Glide.with(CauHoi_CapDo3.this).load(cauHoi.getDapandung()).into(img_cauhoi);
    }

    private void checkCauTraLoi(){
        btn_kiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_cautraloi.getText().toString().equals(cauHoi.getTendapan())) {
                    nextCauHoi();
                    edt_cautraloi.setText("");
                    Toast.makeText(CauHoi_CapDo3.this,"Nices",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CauHoi_CapDo3.this,":v",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void nextCauHoi(){
        if (viTriCauHoi == 9) {

        } else {
            viTriCauHoi++;
            hienCauHoi();
        }
    }
}