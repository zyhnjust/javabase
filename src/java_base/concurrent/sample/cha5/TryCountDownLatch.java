/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.util.concurrent.CountDownLatch;

/**
 * @author Homer
 *
 *���� ����ȷ��ĳЩ�ָ�����������ɺ�ż���ִ�С�
 *ȷ��ĳ��������������Ҫ��������Դ����ʼ��֮��ż���ִ�С� 
 *
 *����״̬����һ���������� ����������ʼ����Ϊһ�������� ��ʾ��Ҫ�ȴ����¼������� 
countdown �����ǵݼ��������� ��ʾ��һ���¼������ˡ� 
await ����
	Causes the current thread to wait until the latch has counted down to zero

����ʾ����
�������� 
��һ�����أ� ��ʼ�ţ� ����˵ϣ��һ������ʼִ�С� �������ŵȴ��� 
�ڶ������أ� �ǽ����ţ� ÿ���߳��������һ��������ǵ��ý����ŵ�countdown����һ�������ʹ�����̸߳�Ч�ĵȴ������̶߳�ִ����ɡ� 
����start �Ǹ� startDate  ��1 ���˼���
endDate �����5 ���н������ǵġ� 
cool

 */
public class TryCountDownLatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long time = timeTasks(5, new Player(10));
			System.out.println("time: " + time);
			// this time should be executed the last one. 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException
	{
		final CountDownLatch startDate = new CountDownLatch(1);
		final CountDownLatch endDate = new CountDownLatch(nThreads);
		
		for(int i=0; i< nThreads; i++){
			Thread t = new Thread(){
				public void run(){
					try{
						startDate.await();
						try{
							task.run();
						}finally{
							System.out.println("finally " + System.currentTimeMillis());
							endDate.countDown();
						}
					}catch(InterruptedException ignored){}
				}
			};
			t.start();
			
			//sleep 1 seconds
			Thread.sleep(1000L);
			// check start time. the time should be same. all the thread will start at same time.
			// result
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			time: 133228046
		}

		long start = System.nanoTime();
		startDate.countDown();
		endDate.await();
		long end = System.nanoTime();
		return end-start;
	}

}
