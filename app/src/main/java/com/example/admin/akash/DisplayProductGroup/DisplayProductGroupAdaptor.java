package com.example.admin.akash.DisplayProductGroup;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.akash.R;
import com.example.admin.akash.common.Product;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DisplayProductGroupAdaptor  extends ArrayAdapter<Product> {
    private Context mContext;
    List<Product> mylist;
    String TAG = "DisplayProductGroupAdaptor";

    public DisplayProductGroupAdaptor(Context _context, List<Product> _mylist) {
        super(_context, R.layout.table_productgroup_gridview, _mylist);
        mContext = _context;
        this.mylist = _mylist;
        Log.v(TAG,"____size of productGroup"+_mylist.size());
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

            convertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.table_productgroup_gridview, parent, false);
            Uri uri = Uri.parse(product.getProductImageURL());
            SimpleDraweeView imageView = (SimpleDraweeView) convertView.findViewById(R.id.image);
            imageView.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
            imageView.setImageURI(uri);
            imageView.setOnClickListener(  new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String TAG = "DisplayProductGroup";
                    View parentRow = (View) v.getParent();
                    GridView listView = (GridView) parentRow.getParent();
                    //final int position = listView.getPositionForView(parentRow);
                    listView.performItemClick(v,position,0);
                    Log.v(TAG,"Position"+position);
                }
            });
            TextView textView = (TextView) convertView.findViewById(R.id.title);
            textView.setText(product.getProductName());
            Log.v(TAG,"____Product Name"+product.getProductName());
            return convertView;


    }


}
