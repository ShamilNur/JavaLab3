package ru.kpfu.itis.group903.nurkaev.threads.jar;

import com.beust.jcommander.JCommander;
import ru.kpfu.itis.group903.nurkaev.threads.utils.Downloader;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

public class Program {
    public static void main(String[] argv) {
        Args args = new Args();

        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);

        Downloader downloader = new Downloader(args.mode, args.count, args.files, args.folder);
        downloader.download();
    }
}
