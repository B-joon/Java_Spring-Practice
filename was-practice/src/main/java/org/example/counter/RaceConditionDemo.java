package org.example.counter;

// 여러 프로세스 or Thread가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태를 RaceCondition
public class RaceConditionDemo {
    // 멀티 Thread 환경에서 하나의 객체를 공유하면 원치않는 결과가 나온다.
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
