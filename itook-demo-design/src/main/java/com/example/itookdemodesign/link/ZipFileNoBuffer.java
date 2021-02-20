package com.example.itookdemodesign.link;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.util.zip.ZipOutputStream;

/**
 * @author changyanan1
 */
public class ZipFileNoBuffer {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int sum2 = IntStream.of(nums).parallel().sum();
        System.out.println(sum2);
    }
}
