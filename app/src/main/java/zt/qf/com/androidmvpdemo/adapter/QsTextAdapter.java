package zt.qf.com.androidmvpdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import zt.qf.com.androidmvpdemo.R;
import zt.qf.com.androidmvpdemo.entity.QsTextEntity;
import zt.qf.com.androidmvpdemo.util.Uri;

/**
 * Created by Administrator on 2016/7/14.
 */
public class QsTextAdapter extends MBaseAdapter<QsTextEntity.ItemsBean> {
    private Context context;

    public QsTextAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = getInflater().inflate(R.layout.item_qstext,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }

        //设置内容
        QsTextEntity.ItemsBean item = getItem(position);
        if(item.getContent()!=null)
        {
            viewHolder.content.setText(item.getContent());
        }
        if(item.getUser()!=null && item.getUser().getLogin()!=null)
        {
            viewHolder.loginName.setText(item.getUser().getLogin());
        }

        //设置图片 内容

        if(item.getUser()!=null && item.getUser().getIcon()!=null)
        {
            int id = item.getUser().getId();
            String iconUrl = String.format(Uri.URL_USER_ICON,id/10000,id,item.getUser().getIcon());
            /*AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(200);*/
            Glide.with(context).load(android.net.Uri.parse(iconUrl)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.thumb);
        }

        return convertView;
    }

    class ViewHolder
    {
        private TextView loginName,content;
        private ImageView thumb;

        public ViewHolder(View convertView) {
            loginName = ((TextView) convertView.findViewById(R.id.loginName_text_itemqs));
            thumb = ((ImageView) convertView.findViewById(R.id.thumb_text_itemqs));
            content = ((TextView) convertView.findViewById(R.id.content_text_itemqs));
        }
    }
}
