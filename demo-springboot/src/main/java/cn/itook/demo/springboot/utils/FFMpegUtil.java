package cn.itook.demo.springboot.utils;

import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author changyanan1
 */
public class FFMpegUtil {
    /**
     * Windows下 ffmpeg.exe的路径
     */
    private static String ffmpegEXE = "D:\\apache\\ffmpeg-N-100560-g5f9632e491-win64-gpl-vulkan\\bin\\ffmpeg.exe";

    public static void main(String[] args) throws IOException {
        List<String> command = new ArrayList<String>();
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("开始执行");
        command.add(ffmpegEXE);
        command.add("-i");
        command.add("E:\\video\\原.mp4");
        command.add("-vcodec");
        command.add("hevc");
        command.add("-acodec");
        command.add("copy");
        command.add("E:\\video\\现.mp4");
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = null;
        try {
            process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用这种方式会在瞬间大量消耗CPU和内存等系统资源，所以这里我们需要对流进行处理
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        while (br.readLine() != null) {
        }
        if (br != null) {
            br.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
        stopWatch.stop();
    }
}
