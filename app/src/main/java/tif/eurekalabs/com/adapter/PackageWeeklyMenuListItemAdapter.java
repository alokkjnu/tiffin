package tif.eurekalabs.com.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import tif.eurekalabs.com.R;


/**
 * Created by coderap on 4/4/2017.
 */

public class PackageWeeklyMenuListItemAdapter extends RecyclerView.Adapter<PackageWeeklyMenuListItemAdapter.MyViewHolder> {

    public List<Drawable> list;

    RelativeLayout parent;

    static String TAG = "PackageWeeklyMenuListItemAdapter";

    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvDay;
        TextView tvDescription;

//        ExpandableLinearLayout expandableLinearLayout;

        public MyViewHolder(View view) {
            super(view);

            tvDay = (TextView) view.findViewById(R.id.tv_day);
            tvDescription = (TextView) view.findViewById(R.id.tv_description);

            //          expandableLinearLayout=(ExpandableLinearLayout) view.findViewById(R.id.expandableLayout);


        }
    }


    public PackageWeeklyMenuListItemAdapter(List<Drawable> feedsList, Context c) {
        this.list = feedsList;
        context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_package_weekly_menu, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        /*holder.expandableLinearLayout.setInRecyclerView(true);
        holder.expandableLinearLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
               *//* createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                expandState.put(position, true);*//*
               holder.tvDay.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_up_black,0);
            }

            @Override
            public void onPreClose() {
              *//*  createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                expandState.put(position, false);*//*
                holder.tvDay.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_down_black,0);
            }
        });

        holder.tvDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
               holder.expandableLinearLayout.toggle();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}