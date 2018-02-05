package tif.eurekalabs.com.rest;

import android.preference.PreferenceManager;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tif.eurekalabs.com.Tiffin;

/**
 * Created by coderap on 5/4/2017.
 */

public class AddCookiesInterceptor implements Interceptor {
    public static final String PREF_COOKIES = "PREF_COOKIES";
    // We're storing our stuff in a database made just for cookies called PREF_COOKIES.
    // I reccomend you do this, and don't change this default value.

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //Log.e("Cookie", "Add  call");
        Request.Builder builder = chain.request().newBuilder();

        HashSet<String> preferences = (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(Tiffin.getContext()).getStringSet(PREF_COOKIES, new HashSet<String>());

        // Use the following if you need everything in one line.
        // Some APIs die if you do it differently.
        StringBuilder cookiestring = new StringBuilder();
        for (String cookie : preferences) {
            String[] parser = cookie.split(";");
            cookiestring.append(parser[0]);
        }
        Log.e("Cookie", "Add " + chain.request().url() + " cookies " + cookiestring);
        builder.addHeader("cookie", cookiestring.toString());


     /*   for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
            Log.e("Cookie","Add "+chain.request().url()+" cookies"+cookie);
        }*/

        Request r = builder.build();

        //Log.e("Cookie", " after setting cookies " + r.header("Cookie"));
        return chain.proceed(r);
    }
}