
/**
 * 
 */
package java_base.concurrent.sample.cha5;

/**
 * @author Homer
 *
 */
import java.util.concurrent.CountDownLatch;


public class Player implements Runnable {

    private int id;
//    private CountDownLatch begin;
//    private CountDownLatch end;
    public Player(int i
//    		, CountDownLatch begin, CountDownLatch end
    		) {
        // TODO Auto-generated constructor stub
        super();
        this.id = i;
//        this.begin = begin;
//        this.end = end;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            System.out.println("Play"+id+" arrived." + System.currentTimeMillis());

//            begin.await();        //�ȴ�begin��״̬Ϊ0
            Thread.sleep((long)(Math.random()*100));    //�������ʱ�䣬���˶�Ա���ʱ��
        }catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
//            end.countDown();    //ʹend״̬��1�����ռ���0
        }
    }
}