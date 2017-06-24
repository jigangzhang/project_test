package com.example.zjj.myapplication.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zjj.myapplication.R;
import com.example.zjj.myapplication.adapter.RecyclerTestAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zjj on 2017/6/22.
 */

public class ListFragment extends Fragment implements RecyclerTestAdapter.OnItemClickListener {
    @BindView(R.id.recycler_fragment)
    RecyclerView recyclerFragment;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {//对View进行操作
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {//对view绑定适配器等操作
        super.onViewCreated(view, savedInstanceState);
        recyclerFragment.setLayoutManager(new LinearLayoutManager(recyclerFragment.getContext()));
        RecyclerTestAdapter adapter = new RecyclerTestAdapter();
        recyclerFragment.setAdapter(adapter);
        recyclerFragment.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));//为RecyclerView添加分割线（采用的是google提供的一个实现类）
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "click:" + position, Toast.LENGTH_SHORT).show();
    }
}
