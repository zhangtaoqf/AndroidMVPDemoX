package zt.qf.com.androidmvpdemo.activity.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public interface MainView {
    //显示进度
    public void showProgress();
    //隐藏进度
    public void hideProgress();
    //打印信息
    public void showMessage(String msg);
}
