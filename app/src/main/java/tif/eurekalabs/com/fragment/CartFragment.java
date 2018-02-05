package tif.eurekalabs.com.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tif.eurekalabs.com.R;
import tif.eurekalabs.com.adapter.CartListItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment implements View.OnClickListener {


    RecyclerView rvOrder;

    List<Drawable> bannerList = new ArrayList<>();

    CartListItemAdapter adapter;

    View root;

    AppCompatButton btnPay;

    TextView tvApplyCoupon;
    TextView tvCouponCode;
    TextView tvCouponAmount;
    TextView tvCouponHeading;
    TextView tvDiscount;
    TextView tvGST;
    TextView tvDeliveryCharges;
    TextView tvTotal;
    TextView tvPayable;
    TextView tvName;
    TextView tvNumber;
    TextView tvLocation;
    TextView tvRestaurantName;
    TextView tvMinOrder;
    TextView tvRating;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =inflater.inflate(R.layout.fragment_cart, container, false);

        btnPay=(AppCompatButton) root.findViewById(R.id.btn_pay);

        tvName=(TextView) root.findViewById(R.id.tv_name);
        tvNumber=(TextView) root.findViewById(R.id.tv_number);
        tvLocation=(TextView) root.findViewById(R.id.tv_location);
        tvRestaurantName=(TextView) root.findViewById(R.id.tv_restaurant_name);
        tvRating=(TextView) root.findViewById(R.id.tv_rating);
        tvMinOrder=(TextView) root.findViewById(R.id.tv_min_order);
        tvTotal=(TextView) root.findViewById(R.id.tv_total);
        tvPayable=(TextView) root.findViewById(R.id.tv_pay);
        tvGST=(TextView) root.findViewById(R.id.tv_gst);
        tvDiscount=(TextView) root.findViewById(R.id.tv_discount);
        tvCouponHeading=(TextView) root.findViewById(R.id.tv_coupon_heading);
        tvCouponAmount=(TextView) root.findViewById(R.id.tv_coupon_amount);
        tvCouponCode=(TextView) root.findViewById(R.id.tv_coupon_code);
        tvApplyCoupon=(TextView) root.findViewById(R.id.tv_apply_coupon);
        tvDeliveryCharges=(TextView) root.findViewById(R.id.tv_delivery);

        rvOrder =(RecyclerView) root.findViewById(R.id.rv_order);
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_1));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_2));

        adapter = new CartListItemAdapter(bannerList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvOrder.setLayoutManager(mLayoutManager);
        rvOrder.setAdapter(adapter);

        btnPay.setOnClickListener(this);

        tvApplyCoupon.setOnClickListener(this);
        tvCouponCode.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_pay:
                break;
            case R.id.tv_apply_coupon:
                tvApplyCoupon.setVisibility(View.GONE);
                tvCouponCode.setVisibility(View.VISIBLE);
                tvCouponHeading.setVisibility(View.VISIBLE);
                tvCouponAmount.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_coupon_code:
                break;
        }
    }
}
