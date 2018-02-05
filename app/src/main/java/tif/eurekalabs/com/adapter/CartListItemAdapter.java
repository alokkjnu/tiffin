package tif.eurekalabs.com.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import tif.eurekalabs.com.R;


/**
 * Created by coderap on 4/4/2017.
 */

public class CartListItemAdapter extends RecyclerView.Adapter<CartListItemAdapter.MyViewHolder> {

    public List<Drawable> list;

    RelativeLayout parent;

    static String TAG = "CartListItemAdapter";

    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View view) {
            super(view);
        }
    }


    public CartListItemAdapter(List<Drawable> feedsList, Context c) {
        this.list = feedsList;
        context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_order_cart, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
    /*    LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View child1 =  li.inflate(R.layout.list_item_order_cart,null);
        ((TextView) child1.findViewById(R.id.tv_name)).setText("Loreum Ipsum 1");
        holder.llOrder.addView(child1);
        View child2 =  li.inflate(R.layout.list_item_order_cart,null);
        ((TextView) child2.findViewById(R.id.tv_name)).setText("Loreum Ipsum 2");
        holder.llOrder.addView(child2);
        View child3 =  li.inflate(R.layout.list_item_order_cart,null);
        ((TextView) child3.findViewById(R.id.tv_name)).setText("Loreum Ipsum 3");
        holder.llOrder.addView(child3);*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}