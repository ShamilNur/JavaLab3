package ru.kpfu.itis.group903.nurkaev.threads.pool;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

// wait, notify, synchronized
public class ThreadPool {
    // очередь задач
    private final Deque<Runnable> tasks;

    public ThreadPool(int threadsCount) {
        tasks = new ConcurrentLinkedDeque<>();
        // пул потоков
        PoolWorker[] threads = new PoolWorker[threadsCount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }


    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.push(task);
            tasks.notify();
        }
    }

    // класс - рабочий поток
    private class PoolWorker extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                }

                Runnable currentTask = tasks.removeLast();
                currentTask.run();
            }
        }
    }
}