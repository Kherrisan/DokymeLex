package com.seu.cose.dokyme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zdksc on 2017/12/6.
 */
public class Logger {
    private static String format = "[level] time filename(line:linenum) content";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *
     * @param newFormat contains keywords including level,time,filename,linenum,content.
     */
    public static void setFormat(String newFormat) {
        format = newFormat;
    }

    public static void debug(String content) {
        output("DEBUG", content);
    }

    public static void error(String content) {
        output("ERROR", content);
    }

    public static void error(Exception error) {
        output("ERROR", error.getMessage());
    }

    private static void output(String level, String content) {
        String time = dateFormat.format(new Date());
        String filename = getFilename();
        String linenum = "" + getLineInfo();
        System.out.println(
                format.replace("level", level)
                        .replace("time", time)
                        .replace("filename", filename)
                        .replace("linenum", linenum)
                        .replace("content", content)
        );
    }

    private static String getFilename() {
        StackTraceElement ste = new Throwable().getStackTrace()[3];
        return ste.getFileName();
    }

    private static int getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[3];
        return ste.getLineNumber();
    }

    public static void main(String[] args) {
        Logger.error("Test error");
        Logger.debug("测试 Debug");
        Logger.error(new IOException("测试IO错误"));
    }
}
