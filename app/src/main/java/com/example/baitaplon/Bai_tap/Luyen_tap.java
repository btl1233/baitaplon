package com.example.baitaplon.Bai_tap;

import static com.example.baitaplon.Trangchu.thanhcongcu;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baitaplon.Bai_tap.CauHoi;
import com.example.baitaplon.Bai_tap.lap_lai_cauhoi;
import com.example.baitaplon.R;
import com.example.baitaplon.Trangchu;

import java.util.ArrayList;


public class Luyen_tap extends Fragment {

    private Animation up, down;
    private ImageView img1, img2, img3, img4;
    private TextView tvcauhoi, dapan, causo;
    private LinearLayout layout_a, layout_b, layout_c, layout_d, layout_main;
    private TextView tena, tenb, tenc, tend;
    private CauHoi cauHoi;
    private Button xacnhan;
    private TextToSpeech textToSpeech;
    private MediaPlayer mediaParser, thang, thua;
    private ArrayList<CauHoi> arrCauHoi;

    private  int diem = 0;
    private int checkwin = 0;
    private int checkthua = 0;
    private int viTriCauHoi = 0;
    private Trangchu mainActivity;
    private com.example.baitaplon.Bai_tap.lap_lai_cauhoi lap_lai_cauhoi;

    public Luyen_tap() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.luyen_tap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cauHoi = new CauHoi();
        arrCauHoi = new ArrayList<>();
        Bundle  bundle = this.getArguments();
        mainActivity= (Trangchu) getActivity();
        thanhcongcu.setVisibility(View.GONE);
        String luyentap=bundle.getString("luyentap");
        switch (luyentap){
            case "traicay":
                init();
                Log.e("traicay","traicay");
                break;
            case "dogiadung":
                init1();
                Log.e("dogiadung","dogiadung");
                break;
            case "xeco":
                init2();
                Log.e("xeco","xeco");
                break;
            case "dongvat":
                init3();
                Log.e("dongvat","dongvat");
                break;
            default:
                break;
        }

        lap_lai_cauhoi=new lap_lai_cauhoi(up,down,img1,img2,img3,img4,tvcauhoi,dapan,causo,layout_a,layout_b,layout_c,layout_d,layout_main,
                tena,tenb,tenc,tend,cauHoi,xacnhan,textToSpeech,mediaParser,thang,thua,arrCauHoi,mainActivity,diem,checkwin,checkthua,viTriCauHoi);
        lap_lai_cauhoi.anhXa(view);
        lap_lai_cauhoi.setClick();
        lap_lai_cauhoi.on_back1(view,mainActivity,R.id.action_luyen_tap2_to_baitap1234);
    }
    private void init() {

        arrCauHoi.add(new CauHoi("Quả táo",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"));
        arrCauHoi.add(new CauHoi("Quả cam",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));

    }
    private void init1() {

        arrCauHoi.add(new CauHoi("Quả táo",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"));
        arrCauHoi.add(new CauHoi("Quả cam",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));

    }
    private void init2() {
        arrCauHoi.add(new CauHoi("Quả táo",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"));
        arrCauHoi.add(new CauHoi("Quả cam",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));

    }
    private void init3() {
        arrCauHoi.add(new CauHoi("Quả táo",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"));
        arrCauHoi.add(new CauHoi("Quả cam",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));
        arrCauHoi.add(new CauHoi("Quả ổi",
                "https://cdn-icons-png.flaticon.com/512/2548/2548605.png", "Guava",
                "https://cdn-icons-png.flaticon.com/512/415/415682.png", "Apple",
                "https://cdn-icons-png.flaticon.com/512/1041/1041383.png", "Orange",
                "https://cdn-icons-png.flaticon.com/512/2909/2909761.png", "Banana"
        ));

    }

}