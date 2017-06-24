package com.example.zjj.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zjj.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zjj on 2017/6/18.
 */

public class ListViewTestAdapter extends BaseAdapter {
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private Context context;

    public ListViewTestAdapter(Context context) {
        this.context = context;
    }

    public ListViewTestAdapter(Context context, List<Map<String, Object>> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
        String date = sd.format(new Date());
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.listview_items, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();
        if(holder.imgList != null) {
            holder.imgList.setImageDrawable(context.getResources().getDrawable(R.drawable.katon));
        }
        holder.text1List.setText("my test");
        holder.text2List.setText("testing.....");
        System.out.println("testing...");
        holder.text3List.setText( date);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_list)
        ImageView imgList;
        @BindView(R.id.text1_list)
        TextView text1List;
        @BindView(R.id.text2_list)
        TextView text2List;
        @BindView(R.id.text3_list)
        TextView text3List;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    /**
     public final class ViewHolder{
     private ImageView image;
     private TextView text1;
     private TextView text2;
     private TextView text3;
     }
     */
}
