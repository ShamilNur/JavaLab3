package ru.kpfu.itis.group903.nurkaev.threads.pool;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

public class Main {
    public static void main(String[] args) {
        Runnable task1 = newTask('A');
        Runnable task2 = newTask('B');
        Runnable task3 = newTask('C');
        Runnable task4 = newTask('D');

//        // 1) Одна задача - один поток
//        ThreadPool threadPool1 = new ThreadPool(1);
//        threadPool1.submit(task1);

//        // 2) Две задачи - один поток (поочередно выполнить каждую)
//        ThreadPool threadPool2 = new ThreadPool(1);
//        threadPool2.submit(task1);
//        threadPool2.submit(task2);

//        // 3) Три задачи - три потока (каждый поток выполняет свою задачу)
//        ThreadPool threadPool3 = new ThreadPool(3);
//        threadPool3.submit(task1);
//        threadPool3.submit(task2);
//        threadPool3.submit(task3);
//
        // 4) Четыре задачи - три потока (три потока выполняют три задачи, четвертая задача выполняется первым свободным)
        ThreadPool threadPool4 = new ThreadPool(3);
        threadPool4.submit(task1);
        threadPool4.submit(task2);
        threadPool4.submit(task3);
        threadPool4.submit(task4);
    }

    private static Runnable newTask(char c) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ' ' + c);
            }
        };
    }
}
