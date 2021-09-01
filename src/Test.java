import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/4/18 12:03 上午
 * @description a
 */
public class Test {
    public static void main(String[] args) {

        Data3 data3 = new Data3();
        new Thread(()->{
            data3.printA();
        },"A").start();
        new Thread(()->{
            data3.printB();
        },"B").start();
        new Thread(()->{
            data3.printC();
        },"C").start();


    }
}
class Data3{//资源类
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    public void printA(){
        lock.lock();
        try {
            System.out.println("A");
            //业务->判断-》执行-》通知
            while(number!=1)
            {
                //如果当前A不执行，会await，同时会释放掉这个锁，让其他线程进来。然后别的现场
                //执行完唤醒他之后，会重新获取锁，接着往下走。最后再释放锁。
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"->AAAAAAAAAAAAAAAA");
            number = 2;
            condition2.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            System.out.println("B");
            //业务->判断-》执行-》通知
            while(number!=2)
            {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"->BBBBBBBBBBBBBBBB");
            number = 3;
            condition3.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            //业务->判断-》执行-》通知
            System.out.println("C");
            while(number!=3)
            {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"->AAAAAAAAAAAAAAAA");
            number = 1;
            condition1.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
