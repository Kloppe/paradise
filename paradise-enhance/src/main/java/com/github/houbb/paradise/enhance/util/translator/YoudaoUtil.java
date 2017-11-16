package com.github.houbb.paradise.enhance.util.translator;


import com.alibaba.fastjson.JSON;
import com.github.houbb.paradise.enhance.vo.YoudaoVo;

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
 */
public class YoudaoUtil {


    /**
     * 讲英语转化为中文
     * @param queryWord 必须要首先做好分词
     * @return
     * @throws Exception
     */
    public static String transEnglishToChinese(String queryWord) throws Exception {
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
    }


//    /**
//     * 获取独一无二的列表信息
//     * @param sourcePath
//     * @return
//     */
//    public static Set<String> getSetString(String sourcePath)
//    {
//        List<String> stringList = FileUtil.getFileContentEachLine(sourcePath, 0);
//        Set<String> stringSet = new HashSet<String>(stringList);
//        return stringSet;
//    }
//
//    public static void Execute(String sourcePath) throws Exception {
//        List<String> stringList = FileUtil.getFileContentEachLine(sourcePath, 0);
////        Set<String> stringSet = getSetString(sourcePath);
//        for(String string : stringList)
//        {
//            String queryKey = StringUtil.getQueryKey(string);
//            String result = transEnglishToChinese(queryKey);
//            System.out.println(string+" "+result);
//        }
//    }

    //1.读取
    //2. 分词  根据下划线 大小写
    public static void main(String[] args) throws Exception {
//        final String path = PathUtil.getAppResourcesPath()+"/temp/original/Fields.txt";
//        Execute(path);

        System.out.println(transEnglishToChinese("hello"));
    }

}
