package tif.eurekalabs.com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import tif.eurekalabs.com.fragment.CartFragment;
import tif.eurekalabs.com.fragment.HomeFragment;
import tif.eurekalabs.com.fragment.ProfileFragment;
import tif.eurekalabs.com.fragment.SearchFragment;

/**
 * Created by coderap on 5/14/2016.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private static int ITEMS = 3;
    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show image
                return new HomeFragment();
           /* case 1: // Fragment # 1 - This will show image
                return new SearchFragment();*/
            case 1: // Fragment # 1 - This will show image
                return new CartFragment();
            case 2: // Fragment # 1 - This will show image
                return new ProfileFragment();
        }
        return null;
    }
}
