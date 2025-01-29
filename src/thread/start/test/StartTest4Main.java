package thread.start.test;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        PrintWork a = new PrintWork("A", 1000);
        PrintWork b = new PrintWork("B", 500);

        Thread aThread = new Thread(a, "A-Thread");
        Thread bThread = new Thread(b, "B-Thread");

        aThread.start();
        bThread.start();
    }

    static class PrintWork implements Runnable {

        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while(true) {
                log(this.content);
                try {
                    sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
