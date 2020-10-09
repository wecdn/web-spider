package xyz.redpaper.red.spider.util;

import com.google.gson.Gson;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Json工具类
 */
public class JsonUtils {

    public static final String PROPERTITES_ORDER_JSON = "order.json";

    public static void main(String[] args) throws Exception {
        Map<String, String> m = readJson("order.json");
        System.out.println(m);
        System.out.println(m.get("day"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("day", "20201009");
        map.put("order", "113");
        writeJson("order.json", map);
        System.out.println(readJson("order.json"));
        System.out.println(SequenceUtils.getThousandSeq(Integer.valueOf(readJson("order.json").get("order"))+1));
    }

    /**
     * 从json中解析出map
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Map<String, String> readJson(String fileName) throws IOException {
        String classPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        try(FileReader fileReader = new FileReader(classPath+ File.separator+fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            Map<String, String> map = new Gson().fromJson(bufferedReader, Map.class);
            return map;
        }
    }

    /**
     * 写入json到指定文件
     * @param fileName 文件名
     * @param map
     * @throws IOException
     */
    public static void writeJson(String fileName, Map<String, String> map) throws IOException {
        String classPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String json = new Gson().toJson(map);
        try(FileWriter fileWriter = new FileWriter(classPath+ File.separator+fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(json);
        }
    }

}
