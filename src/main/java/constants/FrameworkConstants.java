package constants;

import utils.PropertyUtils;

import java.io.File;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    private static final String resourcePath = System.getProperty("user.dir") +"/resources/";
    private static final String apkFilePath = "/Users/chinhluu/downloads/app-relese.apk";
    private static final String propertiesFilePath = System.getProperty("user.dir") +"/resources/config/config.properties";
    private static final String captureScreenPath = System.getProperty("user.dir") + "/reports/screenshots" ;
    private  static  final  String recordScreenPath = System.getProperty("user.dir")+"/reports/videos";

    private  static  final  String reportPath = System.getProperty("user.dir")+"/reports";
    public  static String getResourcePath(){
        return resourcePath;
    }
    public  static String getApkFilePath(){
        return apkFilePath;
    }
    public  static String getPropertiesFilePath(){
        return propertiesFilePath;
    }
    public static String getCaptureScreenPath(){  return captureScreenPath; }
    public static String getreportPath(){  return reportPath; }
    public static String getRecordScreenPath(){  return recordScreenPath; }

}
