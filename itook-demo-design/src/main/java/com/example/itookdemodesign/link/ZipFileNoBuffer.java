package com.example.itookdemodesign.link;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author changyanan1
 */
public class ZipFileNoBuffer {
    @Test
    public void test1() {
        File file = new File("1.mp4");
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(file))) {

        } catch (Exception e) {

        }
    }
}
