package com.example.administrator.check;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ItemBean> mlist;
    private LayoutInflater inflater;

    public MyAdapter(Context c,List<ItemBean> list)
    {
        mlist=list;
        inflater=LayoutInflater.from(c);
    }
    public int getCount()
    {
        return mlist.size();
    }
    public Object getItem(int position)
    {
        return mlist.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view=inflater.inflate(R.layout.check,null);
        Spinner sp=(Spinner)view.findViewById(R.id.posi);
        TextView id=(TextView) view.findViewById(R.id.id);
        TextView sno=(TextView) view.findViewById(R.id.sno);
        TextView name=(TextView) view.findViewById(R.id.name);
        TextView banji=(TextView) view.findViewById(R.id.banji);

        ItemBean bean=mlist.get(position);
        id.setText(bean.itemId);
        sno.setText(bean.itemSno);
        name.setText(bean.itemName);
        banji.setText(bean.itemBanji);
        final String[] s={"在勤","迟到","早退","旷课","病假"};
        final ArrayAdapter aa=new ArrayAdapter(inflater.getContext(),android.R.layout.simple_spinner_dropdown_item,s);
         sp.setAdapter(aa);
        return view;
    }
}
