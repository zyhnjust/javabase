package java_base.concurrent.sample.cha5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Homer
 * This is second memory code 
 * ��Ϊ��һ���汾��HashMap������compute ��ʱ������Ҫͬ���� �����Ļ��� ֻ��һ���̷߳��ʡ�
 * �����ʱ��Ļ��� Ч�ʱȽϵ��¡� 
 * �ڶ����汾�ظĳ��� ConcurrentHashMap, ����map��������֤�̰߳�ȫ�� ���Բ���Ҫsynchronize�� 
 * 
 * ����汾��Ȼ���Ÿ��õĲ������ܣ� ������Ϊ�������в��㡣 �����߳�ͬʱ���м����ʱ�� ÿ������ȥ���㡣 ��ʵ����һ��������㹻�ˡ� ����һ��ֻ��Ҫ�ȴ�ǰһ������ļǹ��Ϳ����ˡ� 
 * ���⣬ ���ֻ���ṩ���γ�ʼ���Ķ��󻺴棬 ������ܻᵼ�¼������Σ�������ȫ���ա� 
 * 
 * �������汾ʵ�����̵߳��õ�ʱ�� ����Ѿ���һ�������ڽ��У� ����߳̾ͻ�ȴ��� ��ѯ�����֮�󷵻أ� �������Լ��ټ���һ�顣 ʹ��FutureTask 
 * 
 * ���ʵ�ֱȽ����㣬 ��Ϊ�����űȽϺõĲ����ԡ� 
 * �������Ѿ���������� ��ô���������ء� ��������߳��ڼ���ý���� ��ô�µ��̻߳�ȴ�ֱ������������
 */

public class Memorizer3<A, V> implements Computable<A, V>{
//	private final Map<A, V> cache = new HashMap<A, V>();
	private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	private final Computable<A, V> c;
	
	public Memorizer3(Computable<A, V> c){
		this.c =c;
	}
	
	//remove synchronized 
	//note, here A��must is final
	public V compute(final A arg) throws InterruptedException{
		Future<V> result = cache.get(arg);
		
		if(result == null){
			Callable cal = new Callable<V>(){
				public V call()throws InterruptedException {
					return c.compute(arg);
				}
			};
			FutureTask<V> ft = new FutureTask<V>(cal);
			result = ft;
			cache.put(arg, ft);
			ft.run();// here will compute 
		}

		try {
			return result.get();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw launderThroable(e.getCause());
		}
		return null;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how to test
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ExpensiveFunction func = new ExpensiveFunction();
		Memorizer1 mem = new Memorizer1(func);
		
		Thread t1 = new Thread();
		t1.start();
		// question, whether it should be static
		
		
	}
}
	

