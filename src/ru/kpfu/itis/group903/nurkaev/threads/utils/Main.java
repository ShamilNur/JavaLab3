package ru.kpfu.itis.group903.nurkaev.threads.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

public class Main {
    public static void main(String[] args) {
        String mode = "one-thread";
        int count = 1;
        List<URL> files = null;
        try {
            files = new ArrayList<>(Arrays.asList(
                    new URL("https://sun7-8.userapi.com/c840727/v840727329/3425e/c7nOTCctjEs.jpg"),
                    new URL("https://sun9-47.userapi.com/3Qpl4KW0Ep0ooOlbpslXsyMgZ9cZBBoF8wVtnw/-gISq5PYz1o.jpg")));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        String folder = "C:/test";

        Downloader downloader = new Downloader(mode, count, files, folder);
        downloader.download();
    }
}
