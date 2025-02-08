package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

// 직접 생성해서 사용하지 말라고 추상화
public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            // ThreadPoolExecutor로 타입 캐스팅을 해야 getPoolSize(), getActiveCount() 메서들르 사용할 수 있다
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks +
                    ", completedTask=" + completedTask + "]");
        } else {
            log(executorService.toString());
        }
    }
}
