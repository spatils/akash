package com.example.admin.akash.DisplayImageList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.akash.R;
import com.example.admin.akash.common.Product;

import java.util.List;

public class DisplayImageAdaptor  extends ArrayAdapter<Product> {
    private Context mContext;
    List<Product> mylist;
    public DisplayImageAdaptor(Context _context, List<Product> _mylist) {
        super(_context, R.layout.images_gridview, _mylist);
        mContext = _context;
        this.mylist = _mylist;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        if (convertView == null) {
            convertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.images_gridview, parent, false);


            ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
            TextView textView = (TextView) convertView.findViewById(R.id.title);
            int id = mContext.getResources().getIdentifier("drawable/" + product.getProductImageURL(), null, mContext.getPackageName());
            System.out.println("id "+id+" drawable/" + product.getProductImageURL());
            imageView.setImageResource(id);
            textView.setText(product.getProductName());
            return convertView;
        }else return convertView;

    }


}
