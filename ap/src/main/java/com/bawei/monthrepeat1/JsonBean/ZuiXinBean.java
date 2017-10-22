package com.bawei.monthrepeat1.JsonBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 张祺钒
 * on2017/10/20.
 */

public class ZuiXinBean implements Serializable {

    /**
     * date : 20171020
     * stories : [{"images":["https://pic1.zhimg.com/v2-ac971aae14bd3bd9d19f3c996d97288c.jpg"],"type":0,"id":9653150,"ga_prefix":"102015","title":"40 亿融资，300 亿估值，美团和它不设边界的生长"},{"images":["https://pic2.zhimg.com/v2-0819c2d417d30620d80bfdd0ce2a1aed.jpg"],"type":0,"id":9652455,"ga_prefix":"102014","title":"运动后的肌肉酸痛该如何缓解？"},{"images":["https://pic1.zhimg.com/v2-5f19c16d19f93aecff5be5f500f71f58.jpg"],"type":0,"id":9653117,"ga_prefix":"102013","title":"大家请看，这堆畸形怪状的色块，就是我眼中的足球运动员"},{"images":["https://pic1.zhimg.com/v2-7772942bed6609b2b4bd06039478a500.jpg"],"type":0,"id":9652785,"ga_prefix":"102012","title":"大误 · 回到游戏开始的地方"},{"images":["https://pic2.zhimg.com/v2-50914ae3eb3fe1e467c553d9f6e58a69.jpg"],"type":0,"id":9653142,"ga_prefix":"102011","title":"别光想着 100000+，你更需要了解好东西是如何写出来的"},{"images":["https://pic4.zhimg.com/v2-281acaabd1ae0188544610440f38eec3.jpg"],"type":0,"id":9652803,"ga_prefix":"102010","title":"做到这四点，在华尔街工作也能保持旺盛的精力"},{"images":["https://pic3.zhimg.com/v2-b1955856e3cc87bc464dd79e052de8a6.jpg"],"type":0,"id":9653002,"ga_prefix":"102009","title":"给每个人发放「无条件基本收入」会是件好事吗？听听李开复怎么说"},{"images":["https://pic1.zhimg.com/v2-9058b5a1800317747b3a9b1ea0cee378.jpg"],"type":0,"id":9653028,"ga_prefix":"102008","title":"行走衣架、王牌特工，迷妹簇拥之下，他让编剧绞尽脑汁"},{"images":["https://pic4.zhimg.com/v2-8ceaf0c097ffceaba75478d7af00ca53.jpg"],"type":0,"id":9652642,"ga_prefix":"102007","title":"人人都在用的「北京时间」，其实诞生在\u2026\u2026西安"},{"title":"LOL 主持人余霜：大家创造的激情和爱，让我站到舞台中央","ga_prefix":"102007","images":["https://pic3.zhimg.com/v2-f5519f187d3447a9c504589b3d978c06.jpg"],"multipic":true,"type":0,"id":9653039},{"images":["https://pic2.zhimg.com/v2-8f11b41f995ca5340510c1def1c003d1.jpg"],"type":0,"id":9652878,"ga_prefix":"102007","title":"投下 1000 亿建「达摩院」，阿里说：既要赚钱又要做科研"},{"images":["https://pic2.zhimg.com/v2-71b8e37a6c2bc7a21bcad1568e228881.jpg"],"type":0,"id":9652858,"ga_prefix":"102006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-ae44cb2497dd9ba37663b622440fab7a.jpg","type":0,"id":9653150,"ga_prefix":"102015","title":"40 亿融资，300 亿估值，美团和它不设边界的生长"},{"image":"https://pic1.zhimg.com/v2-8c8ac5b34e41c832d23e49eabcc2dcb8.jpg","type":0,"id":9653039,"ga_prefix":"102007","title":"LOL 主持人余霜：大家创造的激情和爱，让我站到舞台中央"},{"image":"https://pic4.zhimg.com/v2-92061a3a892db43428aac5a3e98780c7.jpg","type":0,"id":9652878,"ga_prefix":"102007","title":"投下 1000 亿建「达摩院」，阿里说：既要赚钱又要做科研"},{"image":"https://pic2.zhimg.com/v2-34b55073133fc1eed22289a2b54c6e55.jpg","type":0,"id":9653002,"ga_prefix":"102009","title":"给每个人发放「无条件基本收入」会是件好事吗？听听李开复怎么说"},{"image":"https://pic3.zhimg.com/v2-d4e414cb596af27f9d4f56318290d916.jpg","type":0,"id":9652295,"ga_prefix":"101916","title":"一见钟情的时候，人的大脑中都发生了什么？"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean implements Serializable {
        /**
      2015
         * title : 40 亿融资，300 亿估值，美团和它不设边界的生长
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;
    }

    public static class TopStoriesBean implements Serializable {
        /**
         * image : https://pic3.zhimg.com/v2-ae44cb2497dd9ba37663b622440fab7a.jpg
         * type : 0
         * id : 9653150
         * ga_prefix : 102015
         * title : 40 亿融资，300 亿估值，美团和它不设边界的生长
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
