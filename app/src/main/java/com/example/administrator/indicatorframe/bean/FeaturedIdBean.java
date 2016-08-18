package com.example.administrator.indicatorframe.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016-08-16.
 */
public class FeaturedIdBean {
    /**
     * status : 1
     * infoFeeds : [{"id":1101,"status":1,"infoId":973,"createTime":1471324118000},{"id":1100,"status":1,"infoId":972,"createTime":1471299971000},{"id":1099,"status":1,"infoId":968,"createTime":1471260305000},{"id":1098,"status":1,"infoId":969,"createTime":1471244466000},{"id":1097,"status":1,"infoId":379,"createTime":1471215386000},{"id":1096,"status":1,"infoId":331,"createTime":1471167854000},{"id":1095,"status":1,"infoId":966,"createTime":1471140778000},{"id":1094,"status":1,"infoId":506,"createTime":1471126591000},{"id":1092,"status":1,"infoId":965,"createTime":1471089050000},{"id":1091,"status":1,"infoId":963,"createTime":1471057097000},{"id":1090,"status":1,"infoId":964,"createTime":1471019821000},{"id":1089,"status":1,"infoId":403,"createTime":1470988961000},{"id":1087,"status":1,"infoId":961,"createTime":1470934475000},{"id":1086,"status":1,"infoId":960,"createTime":1470913878000},{"id":1085,"status":1,"infoId":959,"createTime":1470892320000},{"id":1084,"status":1,"infoId":958,"createTime":1470847207000},{"id":1083,"status":1,"infoId":547,"createTime":1470834557000},{"id":1082,"status":1,"infoId":953,"createTime":1470801397000},{"id":1081,"status":1,"infoId":954,"createTime":1470779555000},{"id":1080,"status":1,"infoId":956,"createTime":1470746312000},{"id":1077,"status":1,"infoId":952,"createTime":1470715205000},{"id":1076,"status":1,"infoId":951,"createTime":1470674936000},{"id":1074,"status":1,"infoId":950,"createTime":1470663968000},{"id":1073,"status":1,"infoId":947,"createTime":1470625230000},{"id":1072,"status":1,"infoId":946,"createTime":1470585868000},{"id":1069,"status":1,"infoId":259,"createTime":1470574768000},{"id":1068,"status":1,"infoId":944,"createTime":1470543720000},{"id":1067,"status":1,"infoId":189,"createTime":1470530252000},{"id":1066,"status":1,"infoId":63,"createTime":1470487366000},{"id":1065,"status":1,"infoId":943,"createTime":1470454659000},{"id":1064,"status":1,"infoId":942,"createTime":1470436204000},{"id":1063,"status":1,"infoId":938,"createTime":1470431574000},{"id":1062,"status":1,"infoId":941,"createTime":1470397487000},{"id":1061,"status":1,"infoId":934,"createTime":1470367827000},{"id":1059,"status":1,"infoId":937,"createTime":1470349031000},{"id":1057,"status":1,"infoId":930,"createTime":1470282508000},{"id":1054,"status":1,"infoId":935,"createTime":1470262429000},{"id":1051,"status":1,"infoId":931,"createTime":1470193601000},{"id":1049,"status":1,"infoId":932,"createTime":1470175531000},{"id":1048,"status":1,"infoId":929,"createTime":1470139239000},{"id":1047,"status":1,"infoId":927,"createTime":1470124834000},{"id":1046,"status":1,"infoId":925,"createTime":1470090622000},{"id":1044,"status":1,"infoId":926,"createTime":1470054600000},{"id":1042,"status":1,"infoId":923,"createTime":1470021124000},{"id":1041,"status":1,"infoId":922,"createTime":1470003087000},{"id":1040,"status":1,"infoId":921,"createTime":1469969564000},{"id":1039,"status":1,"infoId":913,"createTime":1469953119000},{"id":1038,"status":1,"infoId":920,"createTime":1469918212000},{"id":1037,"status":1,"infoId":915,"createTime":1469876393000},{"id":1036,"status":1,"infoId":916,"createTime":1469851178000},{"id":1035,"status":1,"infoId":914,"createTime":1469833114000},{"id":1034,"status":1,"infoId":910,"createTime":1469780887000},{"id":1033,"status":1,"infoId":425,"createTime":1469773573000},{"id":1032,"status":1,"infoId":276,"createTime":1469746177000},{"id":1031,"status":1,"infoId":907,"createTime":1469703202000},{"id":1030,"status":1,"infoId":908,"createTime":1469688766000},{"id":1028,"status":1,"infoId":899,"createTime":1469657327000},{"id":1027,"status":1,"infoId":901,"createTime":1469619209000},{"id":1026,"status":1,"infoId":900,"createTime":1469610053000},{"id":1025,"status":1,"infoId":904,"createTime":1469592050000}]
     * last : false
     */

    @SerializedName("status")
    private int status;
    @SerializedName("last")
    private boolean last;
    /**
     * id : 1101
     * status : 1
     * infoId : 973
     * createTime : 1471324118000
     */

    @SerializedName("infoFeeds")
    private List<InfoFeedsFeaturedIdBean> infoFeeds;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<InfoFeedsFeaturedIdBean> getInfoFeeds() {
        return infoFeeds;
    }

    public void setInfoFeeds(List<InfoFeedsFeaturedIdBean> infoFeeds) {
        this.infoFeeds = infoFeeds;
    }

    public static class InfoFeedsFeaturedIdBean {
        @SerializedName("id")
        private int id;
        @SerializedName("status")
        private int status;
        @SerializedName("infoId")
        private int infoId;
        @SerializedName("createTime")
        private long createTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
    }
}
