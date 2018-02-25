package com.github.houbb.paradise.common.util;

import com.github.houbb.paradise.common.constant.FileTypeConstant;
import com.github.houbb.paradise.common.exception.ParadiseCommonRuntimeException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件路径工具类
 *
 * @version 1.0.0
 * @see Path 文件 NIO
 */
public final class FilePathUtil {

    private FilePathUtil(){}

    /**
     * 获得对应的PATH列表。
     * @param dir 文件夹
     * @param glob 文件正则
     * @return 路径列表
     */
    public static List<Path> getPathList(String dir, String glob)
    {
        List<Path> list = new LinkedList<>();
        Path root = Paths.get(dir);

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(root, glob)){
            for (Path path : stream) {
                list.add(path);
            }
        } catch (IOException e) {
            throw new ParadiseCommonRuntimeException(e);
        }
        return list;
    }

    /**
     * 获取指定文件夹下对应的某类型文件
     * @param dir 文件夹路径
     * @param glob 文件正则表达式
     * @return path list
     */
    public static List<Path> getDirFileNames(String dir, String glob) {
        List<Path> list = new LinkedList<>();
        Path root = Paths.get(dir);

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(root, glob)){
            for (Path path : stream) {
                list.add(path.getFileName());
            }
        } catch (IOException e) {
            throw new ParadiseCommonRuntimeException(e);
        }
        return list;
    }


    /** 获取某一路径下的所有文件
     * @see #getDirFileNames(String, String) 指定此处的glob为 *.*
     * @param dir 文件夹
     * @return 路径列表
     */
    public static List<Path> getAllDirFileNames(String dir)
    {
        return getDirFileNames(dir, FileTypeConstant.Glob.ALL);
    }


    /**
     * 获得列表下对应的文件字符串形式
     * @param dir 文件夹
     * @param glob 文件正则
     * @return 文件名称列表
     */
    public static List<String> getDirFileNameStrs(String dir, String glob)
    {
        List<String> list = new LinkedList<>();
        Path root = Paths.get(dir);

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(root, glob)){
            for (Path path : stream) {
                list.add(path.getFileName().toString());
            }
        } catch (IOException e) {
            throw new ParadiseCommonRuntimeException(e);
        }
        return list;
    }

}


