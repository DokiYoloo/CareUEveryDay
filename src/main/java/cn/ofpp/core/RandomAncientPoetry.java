package cn.ofpp.core;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

/**
 * 随机爱情古诗
 * @author DokiYolo
 * Date 2022-08-22
 */
public class RandomAncientPoetry {

    /**
     * github访问诗词接口概率性超时 超时从default随机返回
     */
    private static final AncientPoetry[] DEFAULT = new AncientPoetry[] {
            new AncientPoetry("晏几道", "生查子·狂花顷刻香", "天与短因缘，聚散常容易。"),
            new AncientPoetry("牛希济", "生查子·新月曲如眉", "红豆不堪看，满眼相思泪。"),
            new AncientPoetry("李商隐", "暮秋独游曲江", "深知身在情长在，怅望江头江水声。"),
            new AncientPoetry("元稹", "遣悲怀三首·其一", "今日俸钱过十万，与君营奠复营斋。"),
            new AncientPoetry("苏轼", "江城子·乙卯正月二十日夜记梦", "十年生死两茫茫，不思量，自难忘。"),
            new AncientPoetry("李商隐", "夜雨寄北", "君问归期未有期，巴山夜雨涨秋池。"),
            new AncientPoetry("李之仪", "卜算子·我住长江头", "只愿君心似我心，定不负相思意。"),
            new AncientPoetry("辛弃疾", "摸鱼儿·更能消几番风雨", "千金纵买相如赋，脉脉此情谁诉。"),
            new AncientPoetry("周邦彦", "六丑·落花", "恐断红、尚有相思字，何由见得。")
    };

    public static AncientPoetry getNext() {
        try {
            String res = HttpUtil.get("https://v1.jinrishici.com/shuqing/aiqing", 10000);
            return JSONUtil.parseObj(res).toBean(AncientPoetry.class);
        } catch (Exception e) {
            System.err.println("诗词调用失败，随机返回");
            return DEFAULT[RandomUtil.randomInt(0, DEFAULT.length)];
        }
    }

    static class AncientPoetry {
        private String author;
        private String origin;
        private String content;

        public AncientPoetry() {
        }

        public AncientPoetry(String author, String origin, String content) {
            this.author = author;
            this.origin = origin;
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public String getOrigin() {
            return origin;
        }

        public String getContent() {
            return content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
