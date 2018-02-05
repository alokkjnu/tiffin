package tif.eurekalabs.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import tif.eurekalabs.com.R;
import tif.eurekalabs.com.model.DrawerItem;

/**
 * Created by pc on 2/5/2018.
 */

public class DrawerListItemAdapter extends ArrayAdapter<DrawerItem> {

    Context mContext;
    int layoutResourceId;
    DrawerItem data[] = null;

    public DrawerListItemAdapter(Context mContext, int layoutResourceId, DrawerItem[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.iv_icon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.tv_title);

        DrawerItem folder = data[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
