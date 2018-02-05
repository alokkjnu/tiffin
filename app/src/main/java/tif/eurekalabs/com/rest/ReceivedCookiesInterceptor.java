package tif.eurekalabs.com.rest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;
import tif.eurekalabs.com.Tiffin;

/**
 * Created by coderap on 5/4/2017.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //Log.e("Cookie","Recieved  call");
        Response originalResponse = chain.proceed(chain.request());
        if(chain.request().url().toString().contains("login")||chain.request().url().toString().contains("googleLogin")) {
            Log.e("Cookie", "Recieved  call " + originalResponse.headers("Set-Cookie"));
            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                HashSet<String> cookies = new HashSet<>();
                for (String header : originalResponse.headers("Set-Cookie")) {
                    cookies.add(header);
                    //Log.e("Cookie", "Recieved  " + chain.request().url() + " cookies" + header);
                }

                SharedPreferences.Editor memes = PreferenceManager.getDefaultSharedPreferences(Tiffin.getContext()).edit();
                memes.putStringSet("PREF_COOKIES", cookies).apply();
                memes.commit();
            }
        }

        return originalResponse;
    }
}