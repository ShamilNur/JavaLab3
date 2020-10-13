package ru.kpfu.itis.group903.nurkaev.threads.jar;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.IntegerConverter;
import ru.kpfu.itis.group903.nurkaev.threads.utils.StringToURLConverter;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

@Parameters(separators = "=")
public class Args {
    @Parameter(names = {"--mode"})
    public String mode;

    @Parameter(names = {"--count"}, converter = IntegerConverter.class)
    public int count;

    @Parameter(names = {"--files"}, converter = StringToURLConverter.class)
    public ArrayList<URL> files;

    @Parameter(names = {"--folder"})
    public String folder;
}
