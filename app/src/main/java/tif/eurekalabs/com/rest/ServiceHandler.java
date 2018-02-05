package tif.eurekalabs.com.rest;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class ServiceHandler
{

	static InputStream is = null;
    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
 
    public ServiceHandler() {
 
    }
 
    /**
     * Making service call
     * @url - url to make request
     * @method - http request method
     * */
    public String makeServiceCall(String url,List<NameValuePair> params) {
        HttpEntity httpEntity = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
        } catch (UnsupportedEncodingException e) {
           Log.e("Exception ", "" + e.getMessage());
        }
        try {
            HttpResponse response = httpClient.execute(httpPost);
            httpEntity = response.getEntity();
            is = httpEntity.getContent();
            // writing response to log
            Log.e("Http Response:", response.toString());
        } catch (ClientProtocolException e) {
            // writing exception to log
            e.printStackTrace();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        }
        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();
        }
        catch (Exception e)
        {

            Log.e("Handler", "Error 5");

        }

        return response;
    }

    /**
     * Making service call
     * @url - url to make request
     * @method - http request method
     * @params - http request params
     * */
    public String makeServiceCall(String url)
    {
    	
        try 
        {


            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            HttpGet httpGet = new HttpGet(url);
            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 10000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

            int timeoutSocket = 10000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent(); 
        } 
        catch (UnsupportedEncodingException e) 
        {
        	Log.e("Handler", "Error 1"+e);
        } 
        catch (ClientProtocolException e) 
        {
        	Log.e("Handler", "Error 2"+e);
        } 
        catch (IOException e) 
        {
        	Log.e("Handler", "Error 3"+e);
        }
        catch (Exception e) 
        {
        	Log.e("Handler", "Error 4"+e);
        }
 
        try 
        {
        	
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
           
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
                sb.append(line + "\n");
            }
            is.close();
            
            response = sb.toString();
        } 
        catch (Exception e) 
        {
        	
            Log.e("Handler", "Error 5");
        }

        return response;
 
    }



    public String getInternetData(String url) throws Exception {


        BufferedReader in = null;
        String data = null;

        try {
            HttpClient client = new DefaultHttpClient();
            client.getConnectionManager().getSchemeRegistry().register(getMockedScheme());

            Log.e("Service handler","url "+url);
            URI website = new URI(url);
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            response.getStatusLine().getStatusCode();
            Log.e("Service handler","Status code"+response.getStatusLine().getStatusCode());
            Log.e("Service handler","response"+response);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null) {
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
            return data;
        } finally {
            if (in != null) {
                try {
                    in.close();
                    return data;
                } catch (Exception e) {
                    Log.e("GetMethodEx", e.getMessage());
                }
            }
        }
    }

    public Scheme getMockedScheme() throws Exception {
        MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory();
        return new Scheme("https", mySSLSocketFactory, 443);
    }

    class MySSLSocketFactory extends SSLSocketFactory {
        javax.net.ssl.SSLSocketFactory socketFactory = null;

        public MySSLSocketFactory(KeyStore truststore) throws Exception {
            super(truststore);
            socketFactory = getSSLSocketFactory();
        }

        public MySSLSocketFactory() throws Exception {
            this(null);
        }

        @Override
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException,
                UnknownHostException {
            return socketFactory.createSocket(socket, host, port, autoClose);
        }

        @Override
        public Socket createSocket() throws IOException {
            return socketFactory.createSocket();
        }

        javax.net.ssl.SSLSocketFactory getSSLSocketFactory() throws Exception {
            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sslContext.init(null, new TrustManager[] { tm }, null);
            return sslContext.getSocketFactory();
        }
    }

}