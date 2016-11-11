package com.example.administrator.check;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private EditText ed1,ed2;
     private Button but1,but2,but3;
    private Spinner position;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        this.setTitle("添加信息");

        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        but1=(Button)findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        but3=(Button)findViewById(R.id.but3);
        position=(Spinner)findViewById(R.id.position);//获取下拉列表组件
        //创建一个下拉列表选项数组
        final String[] str={"计科1401班","计科1402班","计科1403班","计科1404班","其他"};
        //创建一个数组适配器
        final ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,str);
        position.setAdapter(aa);//设置下拉列表的适配器

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sno=ed1.getText().toString();
                String name=ed2.getText().toString();
                String banji=position.getSelectedItem().toString();
                if(sno.equals("")||name.equals(""))
                {
                    Toast.makeText(AddActivity.this,"学号或者姓名不能为空",Toast.LENGTH_LONG).show();
                }
                else{
                    DBhelper helper = new DBhelper(getApplicationContext());
                    ContentValues values = new ContentValues();
                    values.put("sno", sno);
                    values.put("name", name);
                    values.put("class", banji);
                    helper.insert(values);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                    builder.setMessage("需要查看学生记录吗？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent in1 = new Intent(AddActivity.this, QueryActivity.class);
                            startActivity(in1);
                        }
                    }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ed1.setText("");
                    ed2.setText("");
                    AlertDialog AD = builder.create();
                    AD.show();
                }
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(AddActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}
