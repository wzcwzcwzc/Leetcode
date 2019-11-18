import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class concurrentDemo {

    public static void main(String[] args) {

        Runnable runnable = new concurrentRun();
        Thread t1 = new Thread(runnable);
        t1.start();
    }
}

class concurrentRun implements Runnable{

    private Lock newLock = new ReentrantLock();

    public void run(){
        newLock.lock();

        try{

            for (int i = 0; i < 10; i++){
                System.out.println(i);
                if(i % 7 == 0){
                    System.out.print("百香果该吃火锅啦");
                }
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            newLock.unlock();

        }
    }
}
