/**
 * @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

package ru.kpfu.itis.group903.nurkaev.threads.utils;

import ru.kpfu.itis.group903.nurkaev.threads.pool.ThreadPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Downloader {

    private final List<URL> files;
    private final String folder;
    private final ThreadPool threadPool;

    public Downloader(String mode, int count, List<URL> files, String folder) {
        if (mode.equals("one-thread")) {
            threadPool = new ThreadPool(1);
        } else if (mode.equals("multi-thread")) {
            threadPool = new ThreadPool(count);
        } else {
            throw new IllegalArgumentException("Unknown mode");
        }
        this.files = files;
        this.folder = folder;
    }

    public void download() {
        for (URL url : files) {
            String urlString = url.toString();
            String imageName = urlString.substring(urlString.lastIndexOf('/'));
            threadPool.submit(() -> {
                try (InputStream in = url.openStream();
                     FileOutputStream out = new FileOutputStream(new File(folder + imageName))) {
                    int i;
                    while ((i = in.read()) != -1) {
                        out.write(i);
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }

    // для предварительного теста
    public static void main(String[] args) throws IOException {
        String mode = "one-thread";
        int count = 1;
        List<URL> files = new ArrayList<>(Arrays.asList(
                new URL("https://sun7-8.userapi.com/c840727/v840727329/3425e/c7nOTCctjEs.jpg"),
                new URL("https://sun9-47.userapi.com/3Qpl4KW0Ep0ooOlbpslXsyMgZ9cZBBoF8wVtnw/-gISq5PYz1o.jpg")));
        String folder = "C:/test";

        Downloader downloader = new Downloader(mode, count, files, folder);
        downloader.download();
    }
}
