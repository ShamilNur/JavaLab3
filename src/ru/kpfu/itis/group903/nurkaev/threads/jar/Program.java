/**
 * @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

package ru.kpfu.itis.group903.nurkaev.threads.jar;

import com.beust.jcommander.JCommander;
import ru.kpfu.itis.group903.nurkaev.threads.utils.Downloader;

import java.io.IOException;

public class Program {

    public static void main(String[] argv) {
        Args args = new Args();

        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);

        System.out.println(args.mode);
        System.out.println(args.count);
        System.out.println(args.files);
        System.out.println(args.folder);
        Downloader downloader = new Downloader(args.mode, args.count, args.files, args.folder);
        downloader.download();
    }
}

