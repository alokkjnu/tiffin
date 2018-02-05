package tif.eurekalabs.com.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.List;

import tif.eurekalabs.com.R;
import tif.eurekalabs.com.adapter.BannerListItemAdapter;
import tif.eurekalabs.com.adapter.NearbyRestuarantsListItemAdapter;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.google.android.gms.location.places.AutocompleteFilter.TYPE_FILTER_REGIONS;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView tvLocation;
    private TextView tvSubLocation;
    private TextView tvCredits;

    ImageView ivLocation;

    RecyclerView rvBanner;
    RecyclerView rvRestaurants;

    View root;

    BannerListItemAdapter adapterBannerList;
    NearbyRestuarantsListItemAdapter adapterRestaurantsList;

    List<Drawable> bannerList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_home, container, false);

        tvLocation = (TextView) root.findViewById(R.id.tv_location);
        tvSubLocation = (TextView) root.findViewById(R.id.tv_sub_location);

        rvBanner=(RecyclerView) root.findViewById(R.id.rv_banner);
        rvRestaurants=(RecyclerView) root.findViewById(R.id.rv_resturants);

        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_1));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_2));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_3));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_1));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_2));
        bannerList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_ad_3));

        adapterBannerList = new BannerListItemAdapter(bannerList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        rvBanner.setLayoutManager(mLayoutManager);
        rvBanner.setAdapter(adapterBannerList);

        adapterRestaurantsList=new NearbyRestuarantsListItemAdapter(bannerList,getContext());
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        rvRestaurants.setLayoutManager(mLayoutManager2);
        rvRestaurants.setAdapter(adapterRestaurantsList);

        tvLocation.setOnClickListener(this);
        tvSubLocation.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        try {

             final LatLngBounds BOUNDS_INDIA = new LatLngBounds(new LatLng(23.63936, 68.14712), new LatLng(28.20453, 97.34466));



            AutocompleteFilter.Builder builder = new AutocompleteFilter.Builder();
            builder.setTypeFilter(TYPE_FILTER_REGIONS);
            AutocompleteFilter filter = builder.build();

            Intent intent =
                    new PlaceAutocomplete
                            .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(filter)
                            .setBoundsBias(BOUNDS_INDIA)
                            .build(getActivity());
            startActivityForResult(intent, 1);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // retrive the data by using getPlace() method.
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                Log.e("Tag", "Place: " + place.getAddress() + place.getPhoneNumber());

                tvLocation.setText(place.getName());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getContext(), data);
                // TODO: Handle the error.
                Log.e("Tag", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }
}
