package zt.qf.com.androidmvpdemo.activity.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public interface MainModel {
    //加载数据
    public void loadData(String url,String tag);
    //取消加载数据
    public void cancelLoadData(String tag);
}
