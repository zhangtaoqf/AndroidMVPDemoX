package zt.qf.com.androidmvpdemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MyApp extends Application{
    private RequestQueue requestQueue;

    public static MyApp getApp() {
        return app;
    }

    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        //初始化Volley
        initVolley();
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private void initVolley() {
        requestQueue = Volley.newRequestQueue(this);
    }
}
