package lww;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class Lottery {
    private static final int THREAD_COUNT = 16;
    private static final int NUMBER_COUNT = 6;
    private static final Set<Integer> numbers = Collections.synchronizedSet(new HashSet<>()); // ConcurrentHashMap.newKeySet();
    private static final SecureRandom random = new SecureRandom();
    private static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < THREAD_COUNT; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    pickNumber();
                }
            };
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        log("numbers: " + numbers);
    }

    private synchronized static void pickNumber() {
        while(numbers.size() < NUMBER_COUNT) {
            int i = random.nextInt(1, 46);
            boolean add = numbers.add(i);
            if(!add) {
                log("number collision: " + i);
            }
        }
    }
}
