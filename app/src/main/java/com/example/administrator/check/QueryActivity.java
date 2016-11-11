package com.example.administrator.check;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SimpleAdapter sim_adapter;
    DBhelper helper;
    ListView namelv;
    List<Map<String,Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query);
        this.setTitle("学生信息");

        helper=new DBhelper(this);
        db=helper.getWritableDatabase();
        dataList=new ArrayList<Map<String,Object>>();
        namelv=(ListView)findViewById(R.id.list);


        try {
            sim_adapter = new SimpleAdapter(this, getData(), R.layout.del, new String[]{"text1", "text2", "text3", "text4"}, new int[]{R.id.text1, R.id.text2, R.id.text3, R.id.text4});
            namelv.setAdapter(sim_adapter);
        }catch (Exception e){
                Toast.makeText(QueryActivity.this,"查询失败！！！",Toast.LENGTH_LONG).show();
            Log.i("info","！！！！！！！！！！！！！...");
        }
    }

    public List<Map<String,Object>> getData(){
        try {
            Cursor c = db.query("atten", null, null, null, null, null, "_id");
            if (c != null) {
                while (c.moveToNext()) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("text1", c.getString(0));
                    map.put("text2", c.getString(1));
                    map.put("text3", c.getString(2));
                    map.put("text4", c.getString(3));
                    dataList.add(map);
                }
                c.close();
            }
            db.close();

        }catch (Exception e){
            Toast.makeText(QueryActivity.this,"查询信息",Toast.LENGTH_LONG).show();
            Log.i("info","！！！！！！！！！！！！！查询信息");
            return null;
        }
        return dataList;
    }
}
