package com.hcxy.selector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectorActivity extends AppCompatActivity implements View.OnClickListener{

    private Button activateBtn;
    private Button selectBtn;
    private ListView listView;
    private ArrayList<String> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        activateBtn = findViewById(R.id.btn_activate);
        activateBtn.setOnClickListener(this);

        selectBtn = findViewById(R.id.btn_selected);
        selectBtn.setOnClickListener(this);

        listView = findViewById(R.id.list);
        getData();
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectorActivity.this,"Item Click on " + position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    private ArrayList<String> getData() {
        mArrayList.add("测试数据0");
        mArrayList.add("测试数据1");
        mArrayList.add("测试数据2");
        mArrayList.add("测试数据3");
        mArrayList.add("测试数据4");
        mArrayList.add("测试数据5");
        return mArrayList;
    }


    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        @Override
        public int getCount() {
            inflater = LayoutInflater.from(SelectorActivity.this);
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null){
                convertView = inflater.inflate(R.layout.item_list,parent,false);
                holder = new ViewHolder();
                holder.titleTxt = convertView.findViewById(R.id.txt_title);
                holder.button = convertView.findViewById(R.id.btn);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.titleTxt.setText(mArrayList.get(position));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SelectorActivity.this,"Button " + position + " click",Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }

    private class ViewHolder {
        TextView titleTxt;
        Button button;
    }
}
