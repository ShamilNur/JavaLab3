/**
 * @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

package ru.kpfu.itis.group903.nurkaev.threads.jar;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.IntegerConverter;
import ru.kpfu.itis.group903.nurkaev.threads.utils.StringToURLConverter;

import java.net.URL;
import java.util.List;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = {"--mode"})
    public String mode;

    @Parameter(names = {"--count"}, converter = IntegerConverter.class)
    public int count;

    @Parameter(names = {"--files"}, converter = StringToURLConverter.class)
    public List<URL> files;

    @Parameter(names = {"--folder"})
    public String folder;
}