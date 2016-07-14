package zt.qf.com.androidmvpdemo.activity.main.impl;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import zt.qf.com.androidmvpdemo.MyApp;
import zt.qf.com.androidmvpdemo.activity.main.MainModel;
import zt.qf.com.androidmvpdemo.activity.main.MainPresenter;
import zt.qf.com.androidmvpdemo.entity.QsTextEntity;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainModelImpl implements MainModel {
    private MainPresenter mainPresenter;
    public MainModelImpl(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }
    public void loadData(String url,String tag)
    {
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        QsTextEntity qsTextEntity = gson.fromJson(response, QsTextEntity.class);
                        mainPresenter.onResponse(qsTextEntity);
                    }
                },
                null
        );
        request.setTag(tag);
        MyApp.getApp().getRequestQueue().add(request);
    }

    @Override
    public void cancelLoadData(String tag) {
        MyApp.getApp().getRequestQueue().cancelAll(tag);
    }
}
