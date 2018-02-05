package tif.eurekalabs.com.fragment.restaurantsDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tif.eurekalabs.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PackageFragment extends Fragment implements View.OnClickListener {

    View root;

    CardView cv30;
    CardView cv15;
    CardView cv7;

    public PackageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_restaurants_detail_package, container, false);

        cv30=(CardView) root.findViewById(R.id.cv_30);
        cv15=(CardView) root.findViewById(R.id.cv_15);
        cv7=(CardView) root.findViewById(R.id.cv_7);

        cv30.setOnClickListener(this);
        cv15.setOnClickListener(this);
        cv7.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cv_30:
                break;
            case R.id.cv_15:
                break;
            case R.id.cv_7:
                break;
        }
    }
}
