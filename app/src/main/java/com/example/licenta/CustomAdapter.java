package com.example.licenta;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    private Context c;
    private String[] names;
    int[] images;


    public CustomAdapter(Context ctx, String[] names, int[] images) {
        this.c=ctx;
        this.names=names;
        this.images=images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model, null);
        }


        TextView nameTv=convertView.findViewById(R.id.nameTv);
        ImageView img=convertView.findViewById(R.id.imageView1);

        nameTv.setText(names[position]);
        img.setImageResource(images[position]);
        return convertView;
    }
}
