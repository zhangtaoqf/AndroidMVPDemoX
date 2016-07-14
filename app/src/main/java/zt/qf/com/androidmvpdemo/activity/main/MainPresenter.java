package zt.qf.com.androidmvpdemo.activity.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public interface MainPresenter<T> {
    //就绪状态展示数据
    public void onResume();
    //item的点击事件
    public void onItemClick(int position);
    //界面销毁的处理
    public void destory();
    //获取来自Model层的数据
    public void onResponse(T t);
}
