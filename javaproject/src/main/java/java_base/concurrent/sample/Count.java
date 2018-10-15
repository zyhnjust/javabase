package java_base.concurrent.sample;

public class Count {

	private long value=0;
	public synchronized long getCount(){
		return value;
	}
	public synchronized long incremental(){
		if(value==Long.MAX_VALUE){
			throw new IllegalStateException("count overflow. ");
		}
		return ++value;
	}

}
