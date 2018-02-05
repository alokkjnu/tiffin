package tif.eurekalabs.com;

import android.app.Application;
import android.content.Context;


/**
 * Created by coderap on 5/4/2017.
 */

public class Tiffin extends Application {

    private static Tiffin instance;



    public static  Tiffin getInstance()
    {
        return instance;
    }

    public static Context getContext()
    {
        return instance;
    }

    @Override
    public void onCreate()
    {
        instance=this;
        super.onCreate();
    }

}
