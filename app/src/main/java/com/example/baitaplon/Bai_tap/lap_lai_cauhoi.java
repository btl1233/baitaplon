package com.example.baitaplon.Bai_tap;


import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.baitaplon.MainActivity;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class lap_lai_cauhoi {
    public Animation up, down;
    public ImageView img1, img2, img3, img4;
    public TextView tvcauhoi, dapan, causo;
    public  LinearLayout layout_a, layout_b, layout_c, layout_d, layout_main;
    public TextView tena, tenb, tenc, tend;
    public CauHoi cauHoi;
    public Button xacnhan;
    public  TextToSpeech textToSpeech;
    public MediaPlayer mediaParser, thang, thua;
    public  ArrayList<CauHoi> arrCauHoi;
    public  Trangchu mainActivity;
    public  int diem = 0;
    public int checkwin = 0;
    public  int checkthua = 0;
    public int viTriCauHoi = 0;

    public lap_lai_cauhoi(Animation up, Animation down, ImageView img1,
                          ImageView img2, ImageView img3, ImageView img4,
                          TextView tvcauhoi, TextView dapan, TextView causo,
                          LinearLayout layout_a, LinearLayout layout_b,
                          LinearLayout layout_c, LinearLayout layout_d,
                          LinearLayout layout_main, TextView tena, TextView tenb, TextView tenc, TextView tend, CauHoi cauHoi, Button xacnhan, TextToSpeech textToSpeech, MediaPlayer mediaParser, MediaPlayer thang, MediaPlayer thua, ArrayList<CauHoi> arrCauHoi, Trangchu mainActivity, int diem, int checkwin, int checkthua, int viTriCauHoi) {
        this.up = up;
        this.down = down;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.tvcauhoi = tvcauhoi;
        this.dapan = dapan;
        this.causo = causo;
        this.layout_a = layout_a;
        this.layout_b = layout_b;
        this.layout_c = layout_c;
        this.layout_d = layout_d;
        this.layout_main = layout_main;
        this.tena = tena;
        this.tenb = tenb;
        this.tenc = tenc;
        this.tend = tend;
        this.cauHoi = cauHoi;
        this.xacnhan = xacnhan;
        this.textToSpeech = textToSpeech;
        this.mediaParser = mediaParser;
        this.thang = thang;
        this.thua = thua;
        this.arrCauHoi = arrCauHoi;
        this.mainActivity = mainActivity;
        this.diem = diem;
        this.checkwin = checkwin;
        this.checkthua = checkthua;
        this.viTriCauHoi = viTriCauHoi;
    }

    public lap_lai_cauhoi() {

    }


    public void anhXa(View view) {
        tvcauhoi = view.findViewById(R.id.tvcauhoi);
        causo = view.findViewById(R.id.causo);
        img1 = view.findViewById(R.id.imgdapan1);
        img2 = view.findViewById(R.id.imgdapan2);
        img3 = view.findViewById(R.id.imgdapan3);
        img4 = view.findViewById(R.id.imgdapan4);
        tena = view.findViewById(R.id.tena);
        tenb = view.findViewById(R.id.tenb);
        tenc = view.findViewById(R.id.tenc);
        tend = view.findViewById(R.id.tend);
        layout_a = view.findViewById(R.id.layout_a);
        layout_b = view.findViewById(R.id.layout_b);
        layout_c = view.findViewById(R.id.layout_c);
        layout_d = view.findViewById(R.id.layout_d);
        layout_main = view.findViewById(R.id.layout_main);
        thanhcongcu.setVisibility(View.GONE);
        dapan = view.findViewById(R.id.dapan);
        xacnhan = view.findViewById(R.id.xacnhan);
        //Khai báo hàm TextToSpeech tiếng anh
        textToSpeech = new TextToSpeech(mainActivity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        //tốc độ tiếng
        textToSpeech.setSpeechRate(0.5f);
        up = AnimationUtils.loadAnimation(mainActivity, R.anim.up);
        down = AnimationUtils.loadAnimation(mainActivity, R.anim.down);
        mediaParser = MediaPlayer.create(mainActivity, R.raw.at32);
        thang = MediaPlayer.create(mainActivity, R.raw.thang);
        thua = MediaPlayer.create(mainActivity, R.raw.thua);

        //set sự kiện cho buttom
        dapan(textToSpeech, mainActivity, mediaParser, up, down, layout_a, dapan, tena, layout_a, layout_b, layout_c, layout_d, R.drawable.bgr_xanhbien, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30);
        dapan(textToSpeech, mainActivity, mediaParser, up, down, layout_b, dapan, tenb, layout_a, layout_b, layout_c, layout_d, R.drawable.bgr_blue_30, R.drawable.bgr_xanhbien, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30);
        dapan(textToSpeech, mainActivity, mediaParser, up, down, layout_c, dapan, tenc, layout_a, layout_b, layout_c, layout_d, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30, R.drawable.bgr_xanhbien, R.drawable.bgr_blue_30);
        dapan(textToSpeech, mainActivity, mediaParser, up, down, layout_d, dapan, tend, layout_a, layout_b, layout_c, layout_d, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30, R.drawable.bgr_blue_30, R.drawable.bgr_xanhbien);
    }

    public void dapan(TextToSpeech textToSpeech, Context context,
                      MediaPlayer mediaPlayer,
                      Animation up,
                      Animation down,
                      LinearLayout click,
                      TextView dapan,
                      TextView dandung,
                      LinearLayout layout_a,
                      LinearLayout layout_b,
                      LinearLayout layout_c,
                      LinearLayout layout_d,
                      int drawablea, int drawableb,
                      int drawablec, int drawabled) {
        click.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    click.startAnimation(up);
                    mediaPlayer.start();
                    textToSpeech.speak(dandung.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                    layout_a.setBackground(context.getDrawable(drawablea));
                    layout_b.setBackground(context.getDrawable(drawableb));
                    layout_c.setBackground(context.getDrawable(drawablec));
                    layout_d.setBackground(context.getDrawable(drawabled));
                    dapan.setText(dandung.getText().toString());
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        click.startAnimation(down);
                    }
                }
                return true;
            }
        });

    }

    public void setClick() {
        hienCauHoi();
        xacnhan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    xacnhan.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        xacnhan.startAnimation(down);
                        mediaParser.start();
                        boolean check = true;
                        if (dapan.getText().toString().equals(cauHoi.getTendapan())) {
                            thang.start();
                            checkwin++;
                            if (checkwin % 5 == 0) {
                                Dialog dialog = new Dialog(mainActivity);
                               dia(dialog, R.layout.chuoi_win);
                                dialog.show();
                                check = false;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        dialog.dismiss();
                                        nextCauHoi();
                                    }
                                }, 3000);
                            } else {
                                check = true;
                            }
                            checkthua = 0;
                            if (check == true) {
                                chucmung();
                            }
                        } else {
                            thua.start();
                            checkthua++;
                            if (checkthua % 5 == 0) {
                                Dialog dialog = new Dialog(mainActivity);
                                dia(dialog, R.layout.chuoi_thua);
                                dialog.show();
                                check = false;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        dialog.dismiss();
                                    }
                                }, 3000);
                            } else {
                                check = true;
                            }
                            checkwin = 0;
                            if (check == true) {
                                thua();
                            }
                        }
                    }
                }
                return true;
            }
        });

    }

    public void hienCauHoi() {
        cauHoi = arrCauHoi.get(viTriCauHoi);
        causo.setText("Câu " + (viTriCauHoi + 1) + ":");
        tvcauhoi.setText(cauHoi.getCauhoi());
        ArrayList<dapan_ten> arrCauTraLoi = new ArrayList<>();
        arrCauTraLoi.add(new dapan_ten(cauHoi.getDapandung(), cauHoi.getTendapan()));
        arrCauTraLoi.add(new dapan_ten(cauHoi.getDapansai1(), cauHoi.getTen1()));
        arrCauTraLoi.add(new dapan_ten(cauHoi.getDapansai2(), cauHoi.getTen2()));
        arrCauTraLoi.add(new dapan_ten(cauHoi.getDapansai3(), cauHoi.getTen3()));
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            dapan_ten a = arrCauTraLoi.get(vt1);
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);
        }
        Glide.with(mainActivity).load(arrCauTraLoi.get(0).getDapan()).into(img1);
        Glide.with(mainActivity).load(arrCauTraLoi.get(1).getDapan()).into(img2);
        Glide.with(mainActivity).load(arrCauTraLoi.get(2).getDapan()).into(img3);
        Glide.with(mainActivity).load(arrCauTraLoi.get(3).getDapan()).into(img4);

        tena.setText(arrCauTraLoi.get(0).getTen());
        Log.e("", "" + arrCauTraLoi.get(0).getTen());
        tenb.setText(arrCauTraLoi.get(1).getTen());
        tenc.setText(arrCauTraLoi.get(2).getTen());
        tend.setText(arrCauTraLoi.get(3).getTen());

    }

    public void lammoi() {
        layout_a.setBackground(mainActivity.getDrawable(R.drawable.bgr_blue_30));
        layout_b.setBackground(mainActivity.getDrawable(R.drawable.bgr_blue_30));
        layout_c.setBackground(mainActivity.getDrawable(R.drawable.bgr_blue_30));
        layout_d.setBackground(mainActivity.getDrawable(R.drawable.bgr_blue_30));
    }

    private void nextCauHoi() {
        if (viTriCauHoi == 9) {

            ketthuc();

        } else {
            viTriCauHoi++;
            hienCauHoi();
            lammoi();
        }
    }

    public void chucmung() {
        View view = mainActivity.getLayoutInflater().inflate(R.layout.chucmung, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mainActivity);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        bottomSheetDialog.setCancelable(false);
        Button button = view.findViewById(R.id.tieptuc);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    button.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        button.startAnimation(down);
                        nextCauHoi();
                        mediaParser.start();
                        bottomSheetDialog.dismiss();
                    }
                }
                return true;
            }
        });
    }

    public void thua() {
        View view = mainActivity.getLayoutInflater().inflate(R.layout.thua, null);
        BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(mainActivity);
        bottomSheetDialog1.setContentView(view);
        bottomSheetDialog1.show();
        bottomSheetDialog1.setCancelable(false);
        ImageView imageView = view.findViewById(R.id.hinhdapan);
        TextView textView = view.findViewById(R.id.dapandung);
        Glide.with(mainActivity).load(cauHoi.getDapandung()).into(imageView);
        textView.setText(cauHoi.getTendapan());
        Button button = view.findViewById(R.id.dahieu);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.startAnimation(up);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        button.startAnimation(down);
                        hienCauHoi();
                        lammoi();
                        mediaParser.start();
                        bottomSheetDialog1.dismiss();
                    }
                }
                return true;
            }
        });
    }

    public void ketthuc() {
        Dialog dialog = new Dialog(mainActivity);
       dia(dialog, R.layout.khetthuc);
        Button button = dialog.findViewById(R.id.tieptuc);
        dialog.getWindow().setWindowAnimations(R.style.animtordialog);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.startAnimation(up);
                    dialog.dismiss();
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        button.startAnimation(down);
                    }
                }
                return true;
            }
        });
        dialog.show();
    }

    public void dia(Dialog dialog, int layout1) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout1);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams w = window.getAttributes();
        w.gravity = Gravity.CENTER;
        window.setAttributes(w);
        dialog.setCancelable(false);

    }
    public void on_back(View view, MainActivity context, int id){
        context.getOnBackPressedDispatcher().addCallback(context, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(id);

            }
        });
    }
    public void on_back1(View view, Trangchu context, int id){
        context.getOnBackPressedDispatcher().addCallback(context, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(id);

            }
        });
    }
    public void setLoading_data(Dialog dialog) {
     dia(dialog, R.layout.load_ding);
        dialog.getWindow().setWindowAnimations(R.style.animtordialog);
        dialog.show();
    }
    private long time;
    private Toast mtoast;

    public void on_back2(Trangchu context){
        context.getOnBackPressedDispatcher().addCallback(context, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (time + 2000 > System.currentTimeMillis()) {
                    mtoast.cancel();
                    context.finish();
                    return;
                } else {
                    mtoast = Toast.makeText(context, "Nhấn 2 lần để đồng ý thoát", Toast.LENGTH_SHORT);
                    mtoast.show();
                }
                time = System.currentTimeMillis();
            }
        });
    }
}
