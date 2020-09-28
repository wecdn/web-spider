package xyz.redpaper.red.spider.wx.util;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 文件操作类
 */
public class FileUtils {

    public static void main(String[] args) {
//        newFolder("D://zzz/aaa/a.txt");
        delFile("D://zzz/a.txt");
    }

    /**
     * 创建文件夹，支持多级目录
     * @param path
     */
    public static void newFolder(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    /**
     * 删除文件
     * 1. 如目标文件内存在子文件，则无法删除，无异常
     * 2. 如目标文件不存在，无法删除，无异常
     * @param path
     */
    public static void delFile(String path){
        File file = new File(path);
        file.delete();
    }

    /**
     * 批量删除文件
     * 1. 如目标文件内存在子文件，则无法删除，无异常
     * 2. 如目标文件不存在，无法删除，无异常
     * @param paths
     */
    public static void batchDelFile(List<String> paths){
        for(String path : paths){
            delFile(path);
        }
    }
}
