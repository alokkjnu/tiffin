package tif.eurekalabs.com;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import tif.eurekalabs.com.adapter.CartListItemAdapter;
import tif.eurekalabs.com.adapter.OrderSummaryListItemAdapter;

public class OrderSummaryActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    RecyclerView rvOrder;

    List<Drawable> bannerList = new ArrayList<>();

    OrderSummaryListItemAdapter adapter;

    TextView tvCouponCode;
    TextView tvCouponAmount;
    TextView tvCouponHeading;
    TextView tvDiscount;
    TextView tvGST;
    TextView tvDeliveryCharges;
    TextView tvTotal;
    TextView tvPayable;
    TextView tvPaidVia;
    TextView tvRepeat;
    TextView tvAddress;
    TextView tvStatus;
    TextView tvRestaurantName;
    TextView tvMinOrder;
    TextView tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        toolbar = (Toolbar) findViewById(R.id.toolbar);


        StepView stepView = findViewById(R.id.step_view);
        stepView.go(2,true);
        stepView.done(true);

        tvAddress=(TextView) findViewById(R.id.tv_address);
        tvStatus=(TextView) findViewById(R.id.tv_order_status);
        tvPaidVia=(TextView) findViewById(R.id.tv_paid_via);
        tvRestaurantName=(TextView) findViewById(R.id.tv_restaurant_name);
        tvRating=(TextView) findViewById(R.id.tv_rating);
        tvMinOrder=(TextView) findViewById(R.id.tv_min_order);
        tvTotal=(TextView) findViewById(R.id.tv_total);
        tvPayable=(TextView) findViewById(R.id.tv_pay);
        tvGST=(TextView) findViewById(R.id.tv_gst);
        tvDiscount=(TextView) findViewById(R.id.tv_discount);
        tvCouponHeading=(TextView) findViewById(R.id.tv_coupon_heading);
        tvCouponAmount=(TextView) findViewById(R.id.tv_coupon_amount);
        tvCouponCode=(TextView) findViewById(R.id.tv_coupon_code);
        tvRepeat=(TextView) findViewById(R.id.tv_repeat_order);
        tvDeliveryCharges=(TextView) findViewById(R.id.tv_delivery);

        rvOrder =(RecyclerView) findViewById(R.id.rv_order);
        bannerList.add(ContextCompat.getDrawable(this,R.drawable.img_ad_1));
        bannerList.add(ContextCompat.getDrawable(this,R.drawable.img_ad_2));

        adapter = new OrderSummaryListItemAdapter(bannerList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvOrder.setLayoutManager(mLayoutManager);
        rvOrder.setAdapter(adapter);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_back_white));

        tvRepeat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
