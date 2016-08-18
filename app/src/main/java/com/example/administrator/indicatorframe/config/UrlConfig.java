package com.example.administrator.indicatorframe.config;

/**
 * Created by wanxin on 2016-08-12.
 */
public class UrlConfig {


    public static class Path {
        public static final String FEATURED_BASE_URL = "http://api.fit-time.cn/";
        public static final String FEATURED_URL = "ftinfo/refreshInfos";
        public static final String FEATURED_ID_URL = "ftinfo/refreshInfoFeeds";
        public static final String FEATURED_BEAN_URL = "ftinfo/getInfoByIds";
    }

    public static class PublicKey {
        public static final String PAGE_SIZE = "page_size";
        public static final String CAT = "cat";
        public static final String LON = "lon";
    }

    public static class FeaturedPictureUrl{
        public static final String PICTURE_HEADER = "http://ft-info.fit-time.cn/";
        public static final String PICTURE_END = "@!small";
    }

    public static class FeaturedRecommendIdKey{
        public static final String PAGE_SIZE = "page_size";
    }
}
