package com.example.zjj.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zjj.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zjj on 2017/6/18.
 */

public class RecyclerTestAdapter extends RecyclerView.Adapter<RecyclerTestAdapter.ViewHolder> implements View.OnClickListener {

    private View view;
    private OnItemClickListener myOnItemClickListener = null;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(parent.getContext(), R.layout.listview_items, null);
       // view.setTag(i);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
        String date = sd.format(new Date());
        holder.imgList.setImageResource(R.drawable.katon);
        holder.imgList.setTag(position);
        holder.text1List.setText("recyclerview test");
        holder.text2List.setText("recyclerview testing....");
        holder.text3List.setText(date);
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View v) {
        if(myOnItemClickListener != null){
            myOnItemClickListener.onItemClick(v, (Integer)v.findViewById(R.id.img_list).getTag());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {   //自定义静态类 viewholder
        @BindView(R.id.img_list)
        ImageView imgList;
        @BindView(R.id.text1_list)
        TextView text1List;
        @BindView(R.id.text2_list)
        TextView text2List;
        @BindView(R.id.text3_list)
        TextView text3List;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public static interface OnItemClickListener{    //自定义item点击监听接口
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){   //为当前adapter set 监听接口
        this.myOnItemClickListener = listener;
    }
}
