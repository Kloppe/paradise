package com.github.houbb.paradise.enhance.core.translator.impl;


import com.github.houbb.paradise.enhance.constant.translator.GoogleLanguageEnum;
import com.github.houbb.paradise.enhance.core.translator.Translator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *  谷歌翻译
 * @author houbinbin
 */
public class GoogleTranslator implements Translator<String> {

    /**
     * 待翻译的文本
     */
    private String text;

    /**
     * 原始语言类型
     */
    private String srcLang;

    /**
     * 目标语言类型
     */
    private String targetLang;

    /**    
     *  谷歌翻译    
     *    
     * @param text 文本    
     * @param srcLang src lang    
     * @param targetLang 目标语言    
     */    
    public GoogleTranslator(String text, String srcLang, String targetLang) {
        this.text = text;
        this.srcLang = srcLang;
        this.targetLang = targetLang;
    }

    /**    
     *  谷歌翻译    
     *    
     * @param text 文本    
     * @param targetLang 目标语言    
     */    
    public GoogleTranslator(String text, String targetLang) {
        this(text, "", targetLang);
    }


    /**    
     * 新的实例    
     *    
     * @param text 文本    
     * @param srcLang src lang    
     * @param targetLang 目标语言    
     * @return com.github.houbb.paradise.enhance.core.translator.impl.GoogleTranslator    
     */    
    public static GoogleTranslator newInstance(String text, String srcLang, String targetLang) {
        return new GoogleTranslator(text, srcLang, targetLang);
    }

    /**    
     * 新的实例    
     *    
     * @param text 文本    
     * @param targetLang 目标语言    
     * @return com.github.houbb.paradise.enhance.core.translator.impl.GoogleTranslator    
     */    
    public static GoogleTranslator newInstance(String text, String targetLang) {
        return new GoogleTranslator(text, "", targetLang);
    }


    /**    
     * 翻译    
     *    
     * @return java.lang.String    
     * @throws java.lang.Exception if any    
     */    
    @Override
    public String translate() throws Exception {
        return execute(text, srcLang, targetLang);
    }


    /**
     * 进行翻译 如果乳腺异常则返回指定的默认值
     * @param defaultVal
     * @return
     */
    public String translateOrDefault(final String defaultVal) {
        try {
            return translate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultVal;
    }

    /**    
     * 翻译    
     *    
     * @param texts 文本    
     * @param srcLang src lang    
     * @param targetLang 目标语言    
     * @return java.lang.String    
     * @throws java.lang.Exception if any    
     */    
    public String[] translate(String[] texts, String srcLang, String targetLang)
            throws Exception {

        StringBuilder content = new StringBuilder();
        int size = texts.length;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                content.append(texts[i]).append("{*}");
            } else {
                content.append(texts[i]);
            }
        }
        String[] temps = execute(content.toString(), srcLang, targetLang).split("\\{\\*\\}");
        size = temps.length;
        //去除左右空白字符
        for (int i = 0; i < size; i++) {
            temps[i] = temps[i].trim();
        }
        return temps;
    }

    /**
     * 发送翻译请求
     *
     * @param text       要翻译的内容
     * @param srcLang    源语言
     * @param targetLang 目标语言
     * @return 目标语言
     * @throws Exception 翻译失败
     */
    private String execute(final String text, final String srcLang,
                           final String targetLang) throws Exception {
        Document document = Jsoup.connect("https://translate.google.cn/")
                .data("sl", srcLang)
                .data("ie", "UTF-8")
                .data("oe", "UTF-8")
                .data("text", text)
                .data("tl", targetLang)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
//                .cookie("Cookie", "Cookie PREF=ID=8daa1f767f10d1fe:U=f5ac701cf7d3f2e0:FF=0:LD=en:CR=2:TM=1277174286:LM=1289370601:S=q7yslRWEZs3uK1H8; NID=39=UO-TWo9HzzjHc-d_wYm7BVR1cH33KpqaN5h5877_i29nERA93FeG1GSuV3ZSvsOx8D-TnHKpB9m0KhZRH8U9uPwoE-arYd0bAyAlILyXZxLO2_TyGQhJpcMiOLVEuCpq; SID=DQAAAHoAAADMlGzeKhnGkbkIJ36tVO0ZPXgmQ6Cth7Oa6geyyE1WJooW8P01uKUHNrsRkjggvFMAWIWB9J5i18z0F6GjC_oV79mSwXEDGuRFGhRnDyJdid3ptjFW0pIyt4_2D6AMIqtOWF71aWdvY7IvAU1AWMNs8fBZHAOgRqtf3aCUkr36ZA; HSID=A6-YJTnhjBdFWukoR")
                .cookie("Cookie", "NID=101=IxXmFpFshaY43MPgpE-1LlE-CJUDmXHXaXk-yN13vShZ0VwfJb8AOefXmeRmfGWW3-56oCWYPQDXqcKNRrIuEubTZV4ZpO8nL6F1PZPDE0ILUVGzZuMxhNfarad0TM5-; _ga=GA1.3.109626246.1492094023")
                .timeout(2000000)
                .get();

        Element element = document.getElementById("result_box");
        return element.text();
    }

    /**    
     * 主要    
     *    
     * @param args ARGS    
     */    
    public static void main(String[] args) {
        String text = "你今天真好看";
        Translator translate = new GoogleTranslator(text, GoogleLanguageEnum.ENGLISH.langInfo());
        try {
            System.out.println(translate.translate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
