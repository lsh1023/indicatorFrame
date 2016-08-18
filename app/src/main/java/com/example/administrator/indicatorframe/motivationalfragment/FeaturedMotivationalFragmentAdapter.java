package com.example.administrator.indicatorframe.motivationalfragment;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.indicatorframe.R;
import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.config.UrlConfig;

import java.util.List;

/**
 * Created by Administrator on 2016-08-13.
 */
public class FeaturedMotivationalFragmentAdapter extends BaseQuickAdapter<FeaturedBean.InfosFeaturedBean>{
    public FeaturedMotivationalFragmentAdapter(int layoutResId, List<FeaturedBean.InfosFeaturedBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FeaturedBean.InfosFeaturedBean infosFeaturedBean) {
        Log.i("TAG...........",infosFeaturedBean.getTitle());
        baseViewHolder.setText(R.id.tv_title,infosFeaturedBean.getTitle());
        baseViewHolder.setText(R.id.tv_subtitle,infosFeaturedBean.getContent());
        baseViewHolder.setText(R.id.tv_comment,String.valueOf(infosFeaturedBean.getCommentCount()));
        baseViewHolder.setText(R.id.tv_star,String.valueOf(infosFeaturedBean.getShareCount()));
        baseViewHolder.setText(R.id.tv_praise,String.valueOf(infosFeaturedBean.getPraiseCount()));
        String pictureUrl = UrlConfig.FeaturedPictureUrl.PICTURE_HEADER+ Uri.parse(infosFeaturedBean.getPhoto()).getLastPathSegment()+UrlConfig.FeaturedPictureUrl.PICTURE_END;
        Glide.with(baseViewHolder.convertView.getContext())
                .load(pictureUrl)
                .into((ImageView) baseViewHolder.getView(R.id.iv_logo));
        //((SimpleDraweeView)baseViewHolder.getView(R.id.iv_logo)).setImageURI(Uri.parse(pictureUrl));
    }
}
