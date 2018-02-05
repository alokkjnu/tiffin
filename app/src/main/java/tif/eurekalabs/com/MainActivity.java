package tif.eurekalabs.com;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tif.eurekalabs.com.adapter.FragmentAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llHome;
    private LinearLayout llProfile;
    private LinearLayout llCart;
   // private LinearLayout llSearch;

    public static RelativeLayout parent;

    private ViewPager viewPager;

    private FragmentAdapter adapter;

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llHome= (LinearLayout) findViewById(R.id.ll_home);
       // llSearch = (LinearLayout) findViewById(R.id.ll_explore);
        llCart = (LinearLayout) findViewById(R.id.ll_cart);
        llProfile = (LinearLayout) findViewById(R.id.ll_profile);

        parent = (RelativeLayout) findViewById(R.id.parent);

        viewPager = (ViewPager) findViewById(R.id.fragment_holder);

        viewPager.setOffscreenPageLimit(5);

        llCart.setOnClickListener(this);
        //llSearch.setOnClickListener(this);
        llHome.setOnClickListener(this);
        llProfile.setOnClickListener(this);

        adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                } else if (position == 1) {

                } else if (position == 2) {

                } else if (position == 3) {

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                viewPager.setCurrentItem(0);
                break;
         /*   case R.id.ll_explore:
                viewPager.setCurrentItem(1);
                break;*/
            case R.id.ll_cart:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_profile:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
