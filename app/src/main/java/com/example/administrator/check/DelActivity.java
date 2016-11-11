package com.example.administrator.check;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DelActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final DBhelper helper=new DBhelper(this);
        //查询数据，获取游标
        Cursor c=helper.query();
        //列表项数组
        String[] from={"_id","sno","name","class"};
        //列表项ID
        int[] to = new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4};
        //适配器
        ListAdapter adapter=new SimpleCursorAdapter(this,R.layout.del,c,from,to);
        ListView listView=getListView();
        listView.setAdapter(adapter);
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);//提示对话框
        //设置Listview单击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final long temp=arg3;
                builder.setMessage("真的要删除该记录吗？").setPositiveButton("是",new DialogInterface.OnClickListener()
                {public void onClick(DialogInterface dialog,int which)
                {helper.del((int)temp);
                    Cursor c=helper.query();
                    //列表项数组
                    String[] from={"_id","sno","name","class"};
                    //列表项ID
                    int[] to = new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4};
                    //适配器
                    ListAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.del,c,from,to);
                    ListView listView=getListView();
                    listView.setAdapter(adapter);
                }
                }).setNegativeButton("否",new DialogInterface.OnClickListener()
                {public void onClick(DialogInterface dialog,int which)
                    {

                    }
                });
                AlertDialog AD=builder.create();
                AD.show();
            }
        });
        helper.close();
    }
}