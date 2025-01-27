package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(helloRunnable);
            thread1.start();
        }

        log("main() end");
    }
}
