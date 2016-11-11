package com.example.administrator.check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button butadd;
    private Button butdel;
    private Button butquery;
    private Button butcheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("课堂助手");
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
        butadd=(Button)findViewById(R.id.add);
        butdel=(Button)findViewById(R.id.del);
        butquery=(Button)findViewById(R.id.query);
        butcheck=(Button)findViewById(R.id.check);
        butadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                 startActivity(intent);
            }
        });
        butdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,DelActivity.class);
                startActivity(i1);
            }
        });
        butquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,QueryActivity.class);
                startActivity(i2);
            }
        });
        butcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(MainActivity.this,WorkActivity.class);
                startActivity(i3);
            }
        });
    }
}
