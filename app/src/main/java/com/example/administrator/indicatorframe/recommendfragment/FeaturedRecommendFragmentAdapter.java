package com.example.administrator.indicatorframe.recommendfragment;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.indicatorframe.R;
import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.config.UrlConfig;

import java.util.List;

/**
 * Created by wanxin on 2016-08-14.
 */
public class FeaturedRecommendFragmentAdapter extends BaseQuickAdapter<FeaturedBean.InfosFeaturedBean> {

    public FeaturedRecommendFragmentAdapter(int layoutResId, List<FeaturedBean.InfosFeaturedBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FeaturedBean.InfosFeaturedBean infosFeaturedBean) {
        baseViewHolder.setText(R.id.tv_item_title,infosFeaturedBean.getTitle());
        baseViewHolder.setText(R.id.tv_item_like,String.valueOf(infosFeaturedBean.getPraiseCount()));
        String pictureUrl = UrlConfig.FeaturedPictureUrl.PICTURE_HEADER+ Uri.parse(infosFeaturedBean.getPhoto()).getLastPathSegment()+UrlConfig.FeaturedPictureUrl.PICTURE_END;
        Glide.with(baseViewHolder.convertView.getContext())
                .load(pictureUrl)
                .into((ImageView) baseViewHolder.getView(R.id.iv_item_logo));
    }
}
