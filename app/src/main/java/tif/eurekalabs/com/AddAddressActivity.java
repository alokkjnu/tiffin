package tif.eurekalabs.com;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    TextView tvHome;
    TextView tvOffice;
    TextView tvOthers;

    AppCompatEditText etAddress;
    AppCompatEditText etArea;
    AppCompatEditText etOther;
    AppCompatEditText etInfo;

    AppCompatButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        btnSave = (AppCompatButton) findViewById(R.id.btn_submit);
        tvHome = (TextView) findViewById(R.id.tv_home);
        tvOffice = (TextView) findViewById(R.id.tv_office);
        tvOthers = (TextView) findViewById(R.id.tv_others);

        etArea = (AppCompatEditText) findViewById(R.id.et_area);
        etAddress = (AppCompatEditText) findViewById(R.id.et_address);
        etInfo = (AppCompatEditText) findViewById(R.id.et_information);
        etOther = (AppCompatEditText) findViewById(R.id.et_others);


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


        btnSave.setOnClickListener(this);
        tvHome.setOnClickListener(this);
        tvOffice.setOnClickListener(this);
        tvOthers.setOnClickListener(this);
        etArea.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_home:
                etOther.setVisibility(View.GONE);
                setBg(tvHome, tvOthers, tvOffice);

                break;

            case R.id.tv_office:
                etOther.setVisibility(View.GONE);
                setBg(tvOffice, tvHome, tvOthers);
                break;

            case R.id.tv_others:
                etOther.setVisibility(View.VISIBLE);
                setBg(tvOthers, tvHome, tvOffice);
                break;

            case R.id.btn_submit:
                break;
            case R.id.et_area:
                break;
        }

    }


    private void setBg(TextView tv1, TextView tv2, TextView tv3) {
        int pL = tv1.getPaddingLeft();
        int pT = tv1.getPaddingTop();
        int pR = tv1.getPaddingRight();
        int pB = tv1.getPaddingBottom();

        tv1.setBackground(ContextCompat.getDrawable(this, R.drawable.border_add_name_selected));
        tv2.setBackground(ContextCompat.getDrawable(this, R.drawable.border_add_name_normal));
        tv3.setBackground(ContextCompat.getDrawable(this, R.drawable.border_add_name_normal));

        tv1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        tv2.setTextColor(ContextCompat.getColor(this, R.color.colorSecondaryText));
        tv3.setTextColor(ContextCompat.getColor(this, R.color.colorSecondaryText));

        tv1.setPadding(pL, pT, pR, pB);
        tv2.setPadding(pL, pT, pR, pB);
        tv3.setPadding(pL, pT, pR, pB);
    }
}
