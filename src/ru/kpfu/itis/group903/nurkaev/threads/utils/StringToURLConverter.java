package ru.kpfu.itis.group903.nurkaev.threads.utils;

import com.beust.jcommander.IStringConverter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

public class StringToURLConverter implements IStringConverter<List<URL>> {
    @Override
    public List<URL> convert(String files) {
        String[] urls = files.split(",");
        List<URL> urlList = new ArrayList<>();
        for (String url : urls) {
            try {
                urlList.add(new URL(url));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return urlList;
    }
}
