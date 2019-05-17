package com.example.listviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class OneTestActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//绑定Layout里面的ListView
        ListView list = (ListView) findViewById(R.id.list_view_2);
//生成动态数组，加入数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.timg);//图像资源的ID
            map.put("name", "联系人" + i);
            map.put("size", "@E-mail");
            map.put("button", "呼叫");
            listItem.add(map);
        }
//生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,//数据源
                R.layout.testitem,//ListItem的XML实现
//动态数组与ImageItem对应的子项
                new String[]{"image", "name", "size", "button"},
//ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.image, R.id.name, R.id.size, R.id.button}
        );
//添加并且显示
        list.setAdapter(listItemAdapter);
//添加点击
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast tot = Toast.makeText(
                        OneTestActivity.this,
                        "点击了第" + arg2 + "个联系人",
                        Toast.LENGTH_SHORT);
                tot.show();
            }
        });
    }
}








