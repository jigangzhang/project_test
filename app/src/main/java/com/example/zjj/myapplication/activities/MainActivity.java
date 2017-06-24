package com.example.zjj.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zjj.myapplication.R;
import com.example.zjj.myapplication.adapter.ListViewTestAdapter;
import com.example.zjj.myapplication.adapter.RecyclerTestAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.edit_test)
    EditText editTest;
    @BindView(R.id.text_test)
    TextView textTest;
    @BindView(R.id.listView_test)
    ListView listView;
    @BindView(R.id.recycler_test)
    RecyclerView recyclerTest;
    @BindView(R.id.listView_menu)
    ListView listViewMenu;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ListViewTestAdapter listAdapter;
    private RecyclerTestAdapter recyclerTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏actionbar
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String packageName = getPackageName();
        listAdapter = new ListViewTestAdapter(this);
        recyclerTestAdapter = new RecyclerTestAdapter();
        if (listView == null) {
            System.out.println("listView is null");
        } else
            listView.setAdapter(listAdapter);
        listViewMenu.setAdapter(listAdapter);
        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click:" + position + "  " + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click:" + position + "  " + id, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerTest.setLayoutManager(new LinearLayoutManager(this));
        recyclerTest.setAdapter(recyclerTestAdapter);
        recyclerTestAdapter.setOnItemClickListener(new RecyclerTestAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "recycler click:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        //    editTest.setText(packageName + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
