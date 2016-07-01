package com.sina.testforpushmaster.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sina.testforpushmaster.R;

import java.util.List;

/**
 * Created by Wuzp on 2016/7/1.
 */
public class MyListViewAdapter extends BaseAdapter {
    private static final String TAG = MyListViewAdapter.class.getSimpleName();

    private List<String> mData;
    private Context mContext;

    public MyListViewAdapter(Context context, List<String> data){
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        String name = mData.get(position);
        if(null == convertView){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(name);
        return convertView;
    }

    private static class ViewHolder {
        private TextView name;

        public ViewHolder(View view){
            name = (TextView)view.findViewById(R.id.text_name);
        }

    }
}
