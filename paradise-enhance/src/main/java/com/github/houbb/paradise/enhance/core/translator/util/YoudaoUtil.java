package com.github.houbb.paradise.enhance.core.translator.util;


import com.alibaba.fastjson.JSON;
import com.github.houbb.paradise.enhance.core.translator.exception.TranslatorException;
import com.github.houbb.paradise.enhance.core.translator.vo.YoudaoVo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 有道翻译API申请成功
 API key：477661285
 keyfrom：20170413PersonApi
 创建时间：2017-04-13
 网站名称：20170413PersonApi
 网站地址：http://20170413PersonApi.com
 * @author houbinbin
 */
public class YoudaoUtil {


    /**
     * 讲英语转化为中文
     * @param queryWord 必须要首先做好分词
     * @return 翻译结果
     * @throws TranslatorException 转换异常
     */
    public static String transEnglishToChinese(String queryWord) throws TranslatorException {
        try {
            URL url = new URL("http://fanyi.youdao.com/openapi.do");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.addRequestProperty("encoding", "UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.setRequestMethod("POST");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("keyfrom=20170413PersonApi&key=477661285&type=data&doctype=json&version=1.1&q="+queryWord);
            bw.flush();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine()) != null){
                builder.append(line);
            }

            bw.close();
            osw.close();
            os.close();

            br.close();
            isr.close();
            is.close();

            String result = builder.toString();
            YoudaoVo vo = JSON.parseObject(result, YoudaoVo.class);
            return vo.getTranslation().get(0);
        } catch (IOException e) {
            throw new TranslatorException(e);
        }
    }

}
