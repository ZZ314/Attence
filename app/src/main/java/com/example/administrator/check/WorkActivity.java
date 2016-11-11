package com.example.administrator.check;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WorkActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkon);
        this.setTitle("课堂点名");

        List<ItemBean> itemlist=new ArrayList<>();

        final DBhelper helper=new DBhelper(this);
        try {
            Cursor c = helper.query();
            if (c != null) {
                while (c.moveToNext()) {
                    itemlist.add(new ItemBean(c.getString(0).toString(), c.getString(1).toString(),
                            c.getString(2).toString(), c.getString(3).toString(),R.id.posi));
                }
            }
            ListView lv = (ListView) findViewById(R.id.listview);
            lv.setAdapter(new MyAdapter(this,itemlist));
        }
        catch (Exception e)
        {}
    }
}
