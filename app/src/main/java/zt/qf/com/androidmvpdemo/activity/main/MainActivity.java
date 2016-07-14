package zt.qf.com.androidmvpdemo.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;

import zt.qf.com.androidmvpdemo.R;
import zt.qf.com.androidmvpdemo.activity.main.impl.MainPresenterImpl;
import zt.qf.com.androidmvpdemo.adapter.QsTextAdapter;
import zt.qf.com.androidmvpdemo.entity.QsTextEntity;

public class MainActivity extends AppCompatActivity implements MainView,Response.Listener<QsTextEntity>, AdapterView.OnItemClickListener {

    private ListView listView;
    private QsTextAdapter adapter;
    private MainPresenterImpl mainPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = ((ProgressBar) findViewById(R.id.progressBarId));
        listView = ((ListView) findViewById(R.id.listViewId));
        adapter = new QsTextAdapter(this);
        listView.setAdapter(adapter);
        mainPresenter = new MainPresenterImpl(this,this);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(QsTextEntity response) {
        adapter.addAll(response.getItems());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainPresenter.onItemClick(position);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.destory();
        super.onDestroy();
    }
}
