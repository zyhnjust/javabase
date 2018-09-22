package java_base.concurrent.sample.cha5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Homer
 * This is second memory code 
 * ��Ϊ��һ���汾��HashMap������compute ��ʱ������Ҫͬ���� �����Ļ��� ֻ��һ���̷߳��ʡ�
 * �����ʱ��Ļ��� Ч�ʱȽϵ��¡� 
 * �ڶ����汾�ظĳ��� ConcurrentHashMap, ����map��������֤�̰߳�ȫ�� ���Բ���Ҫsynchronize�� 
 * 
 * 
 */

public class Memorizer2<A, V> implements Computable<A, V>{
//	private final Map<A, V> cache = new HashMap<A, V>();
	private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

	private final Computable<A, V> c;
	
	public Memorizer2(Computable<A, V> c){
		this.c =c;
	}
	
	//remove synchronized 
	public V compute(A arg) throws InterruptedException{
		V result = cache.get(arg);
		if(result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
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
	

