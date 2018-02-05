package tif.eurekalabs.com.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import tif.eurekalabs.com.R;


/**
 * Created by coderap on 4/4/2017.
 */

public class BannerListItemAdapter extends RecyclerView.Adapter<BannerListItemAdapter.MyViewHolder> {

    public List<Drawable> list;

    RelativeLayout parent;

    static String TAG = "BannerListItemAdapter";

    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;

        public MyViewHolder(View view) {
            super(view);

            ivIcon = (ImageView) view.findViewById(R.id.iv_img);

        }
    }


    public BannerListItemAdapter(List<Drawable> feedsList, Context c) {
        this.list = feedsList;
        context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_banner, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.ivIcon.setImageDrawable(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}

