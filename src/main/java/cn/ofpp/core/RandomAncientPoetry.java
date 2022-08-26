package cn.ofpp.core;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

/**
 * 随机爱情古诗
 * @author DokiYolo
 * Date 2022-08-22
 */
public class RandomAncientPoetry {

    public static AncientPoetry getNext() {
        // String res = HttpUtil.get("https://v1.jinrishici.com/shuqing/aiqing", 4000);
        return new AncientPoetry();
    }

    static class AncientPoetry {
        private String author;
        private String origin;
        private String content;

        public String getAuthor() {
            return "韦庄";
        }

        public String getOrigin() {
            return "应天长·别来半岁音书绝";
        }

        public String getContent() {
            return "别来半岁音书绝，一寸离肠千万结。";
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
