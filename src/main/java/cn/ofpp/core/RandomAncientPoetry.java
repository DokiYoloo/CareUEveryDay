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
        String res = HttpUtil.get("https://v1.jinrishici.com/shuqing/aiqing", 4000);
        return JSONUtil.parseObj(res).toBean(AncientPoetry.class);
    }

    static class AncientPoetry {
        private String author;
        private String origin;
        private String content;

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
