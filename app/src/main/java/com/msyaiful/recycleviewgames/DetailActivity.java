package com.msyaiful.recycleviewgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView det_tit, det_des;
    ImageView det_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        det_img = findViewById(R.id.detail_image);
        det_tit = findViewById(R.id.detail_title);
        det_des = findViewById(R.id.detail_description);

        Glide.with(this).load(getIntent().getStringExtra("img")).into(det_img);
        det_tit.setText(getIntent().getStringExtra("title"));
        det_des.setText(getIntent().getStringExtra("description"));
    }
}
