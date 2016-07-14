package zt.qf.com.androidmvpdemo.activity.main.impl;

import com.android.volley.Response;

import zt.qf.com.androidmvpdemo.activity.main.MainModel;
import zt.qf.com.androidmvpdemo.activity.main.MainPresenter;
import zt.qf.com.androidmvpdemo.activity.main.MainView;
import zt.qf.com.androidmvpdemo.entity.QsTextEntity;
import zt.qf.com.androidmvpdemo.util.Uri;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainPresenterImpl implements MainPresenter<QsTextEntity> {
    private MainView mainView;
    private MainModel mainModel;
    private Response.Listener<QsTextEntity> res;
    public MainPresenterImpl(MainView mainView, Response.Listener<QsTextEntity> res) {
        this.mainView = mainView;
        this.res = res;
        mainModel = new MainModelImpl(this);
    }
    @Override
    public void onResume() {
        mainView.showProgress();
        mainModel.loadData(String.format(Uri.URL_TEXT,1),"qsText");
    }

    @Override
    public void onItemClick(int position) {
        mainView.showMessage("点击了"+position+"的位置");
    }

    @Override
    public void destory() {
        mainModel.cancelLoadData("qsText");
    }

    @Override
    public void onResponse(QsTextEntity qsTextEntity) {
        res.onResponse(qsTextEntity);
        mainView.hideProgress();
    }

}
