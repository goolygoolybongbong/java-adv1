package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(helloThread.currentThread().getName() + ": main() 호출 전");
        helloThread.start();
        System.out.println(helloThread.currentThread().getName() + ": main() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
