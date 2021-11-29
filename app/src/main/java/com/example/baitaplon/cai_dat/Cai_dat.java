package com.example.baitaplon.cai_dat;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.bumptech.glide.Glide;
import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.MainActivity;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class Cai_dat extends Fragment implements com.example.baitaplon.cai_dat.chon_anh.click {

    private DatabaseReference data_tk;
    private FirebaseUser user_tk;
    private ImageView anh,img;
    private EditText text_name,txt_email;
    private Button btn_dang_xuat,btn_loi_cam_on,btn_dieukhoan,btn_phan_hoi,btn_chung_tamhotro,btn_muc_thn;
    private TextView txt_anh_dai_dien,txt_hoantat;
    private BottomSheetDialog bottomSheetDialog;
    private chon_anh chon_anh;
    private ArrayList<String> arrayList;
    private Trangchu trangchu;
    private String links_anh = "";
    private Dialog dialog;
    private NavController navController;
    private lap_lai_cauhoi laplai;
    private Animation up, down;
    private SharedPreferences Luu_tru_data;
    public Cai_dat() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.cai_dat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anh_xa(view);
        get_data(view);
        on_click();
    }

    private void on_click() {
        anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mo_anh();
            }
        });
        txt_anh_dai_dien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mo_anh();
            }
        });
        txt_hoantat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_tt();
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
                        navController.navigate(R.id.action_cai_dat2_to_hoso1234);
                    }
                }
                return true;
            }
        });
        btn_dang_xuat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_dang_xuat.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_dang_xuat.startAnimation(down);
                        SharedPreferences.Editor editor = Luu_tru_data.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.commit();
                        Intent intent = new Intent(trangchu, MainActivity.class);
                        startActivity(intent);
                        trangchu.finish();
                    }
                }
                return true;
            }
        });
        btn_chung_tamhotro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_chung_tamhotro.startAnimation(up);

                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_chung_tamhotro.startAnimation(down);
                        String[] TO = {"nhom5@gmail.com"};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("*/*");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Yêu cầu hỗ trợ");
                        try {
                            startActivity(Intent.createChooser(emailIntent, "Hỗ trợ"));
                        } catch (android.content.ActivityNotFoundException ex) {
                        }
                    }
                }
                return true;
            }
        });
        btn_phan_hoi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_phan_hoi.startAnimation(up);

                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_phan_hoi.startAnimation(down);
                        String[] TO = {"nhom5@gmail.com"};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("*/*");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Góp ý hỗ trợ");
                        try {
                            startActivity(Intent.createChooser(emailIntent, "Phản hồi"));
                        } catch (android.content.ActivityNotFoundException ex) {
                        }
                    }
                }
                return true;
            }
        });
        btn_muc_thn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_muc_thn.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_muc_thn.startAnimation(down);
                        navController.navigate(R.id.action_cai_dat2_to_muc_tieu);
                    }
                }
                return true;
            }
        });
        btn_dieukhoan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_dieukhoan.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_dieukhoan.startAnimation(down);
                        Bundle bundle=new Bundle();
                        bundle.putString("quyen","dieukhoan");
                        navController.navigate(R.id.action_cai_dat2_to_quyen_rieng_tu,bundle);
                    }
                }
                return true;
            }
        });
        btn_loi_cam_on.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_loi_cam_on.startAnimation(up);

                } else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        btn_loi_cam_on.startAnimation(down);
                        Bundle bundle=new Bundle();
                        bundle.putString("quyen","loicamon");
                        navController.navigate(R.id.action_cai_dat2_to_quyen_rieng_tu,bundle);
                    }
                }
                return true;
            }
        });
    }

    private void get_data(View view) {
        data_tk.child(user_tk.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    txt_email.setText(snapshot.child("email").getValue().toString());
                    text_name.setText(snapshot.child("name").getValue().toString());
                    Glide.with(view).load(snapshot.child("hinhanh").getValue().toString()).error(R.drawable.male).into(anh);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void mo_anh() {
        View view1 = getLayoutInflater().inflate(R.layout.chon_hinh_anh, null);
        bottomSheetDialog.setContentView(view1);
        bottomSheetDialog.setCancelable(false);
        RecyclerView recyclerView = view1.findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new GridLayoutManager(trangchu, 3));
        recyclerView.setAdapter(chon_anh);
        bottomSheetDialog.show();
    }
    private void anh_xa(View view) {
        trangchu= (Trangchu) getActivity();
        text_name=view.findViewById(R.id.txt_name);
        anh=view.findViewById(R.id.anh);
        img=view.findViewById(R.id.img);
        txt_email=view.findViewById(R.id.txt_email);
        txt_hoantat=view.findViewById(R.id.txt_hoantat);
        btn_loi_cam_on=view.findViewById(R.id.btn_loi_cam_on);
        btn_dang_xuat=view.findViewById(R.id.btn_dang_xuat);
        btn_dieukhoan=view.findViewById(R.id.btn_dieukhoan);
        txt_anh_dai_dien=view.findViewById(R.id.txt_anh_dai_dien);
        btn_phan_hoi=view.findViewById(R.id.btn_phan_hoi);
        btn_chung_tamhotro=view.findViewById(R.id.btn_chung_tamhotro);
        btn_muc_thn=view.findViewById(R.id.btn_muc_thn);
        data_tk= FirebaseDatabase.getInstance().getReference().child("tai_khoan");
        user_tk= FirebaseAuth.getInstance().getCurrentUser();
        arrayList = new ArrayList<>();
        add_links_anh();
        thanhcongcu.setVisibility(View.GONE);
        chon_anh = new chon_anh(arrayList, trangchu, this);
        bottomSheetDialog = new BottomSheetDialog(trangchu);
        navController= Navigation.findNavController(view);
        dialog=new Dialog(trangchu);
        laplai=new lap_lai_cauhoi();
        up = AnimationUtils.loadAnimation(trangchu, R.anim.up);
        down = AnimationUtils.loadAnimation(trangchu, R.anim.down);
        Luu_tru_data = trangchu.getSharedPreferences("data", trangchu.MODE_PRIVATE);
        laplai.on_back1(view,trangchu,R.id.action_cai_dat2_to_hoso1234);
    }

    private void add_links_anh() {
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3233/3233483.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3233/3233515.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/1587/1587565.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/128/3667/3667290.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3667/3667249.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3667/3667226.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3667/3667193.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/3667/3667256.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/2945/2945408.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/4509/4509624.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/4509/4509618.png");
        arrayList.add("https://cdn-icons-png.flaticon.com/512/4509/4509600.png");
    }

    @Override
    public void onVideoclick(int postition) {
        links_anh = arrayList.get(postition);
        Glide.with(trangchu).load(links_anh).into(anh);
        bottomSheetDialog.dismiss();
    }
    private void update_tt() {
        laplai.setLoading_data(dialog);
        data_tk.child(user_tk.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(links_anh.isEmpty()){
                        add_tk(snapshot.child("hinhanh").getValue().toString());
                    }else {
                        add_tk(links_anh);
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void add_tk(String uri) {
        data_tk.child(user_tk.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", text_name.getText().toString());
                    hashMap.put("hinhanh", uri);
                    data_tk.child(user_tk.getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            dialog.dismiss();
                            navController.navigate(R.id.hoso1234);

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