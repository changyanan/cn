package com.example.demospringmvc.test;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author changyanan1
 */
public class ClassScanner {
    /**
     * @param packAgeName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> scanClass(String packAgeName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();
        String path = packAgeName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);
        int index = 0;
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            if (resource.getProtocol().contains("jar")) {
                JarURLConnection urlConnection = (JarURLConnection) resource.openConnection();
                String jarFilePath = urlConnection.getJarFile().getName();
                classList.addAll(getClassFromJar(jarFilePath, path));
            }
        }
        return classList;
    }

    /**
     * @param jarFilePath
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Collection<? extends Class<?>> getClassFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        JarFile jarFile = new JarFile(jarFilePath);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();
            if (name.startsWith(path) && name.equals(".class")) {
                String classFullName = name.replace("/", ".")
                        .substring(0, name.length() - 6);
                classes.add(Class.forName(classFullName));
            }
        }
        return classes;
    }
}
