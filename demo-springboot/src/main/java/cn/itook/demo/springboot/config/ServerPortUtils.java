package cn.itook.demo.springboot.config;

import java.util.Random;

/**
 * @author changyanan1
 */
public class ServerPortUtils {
    /**
     * @return
     */
    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max) % (max - min + 1) + min;
        boolean using = NetUtils.isLoclePortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }
}
