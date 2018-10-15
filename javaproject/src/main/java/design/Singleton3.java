package design;


//���}�ǑНh�� ͬ���Ĺ����Դ� 
// �䌍�㏊Ҳ�ǿ��Եġ� ֻ��Ч���Ե͡� 

public class Singleton3 {
	
	private static Singleton3 instance;
	public static synchronized Singleton3 getInstance(){
		if(instance==null){
			instance = new Singleton3();
		}
		return instance;
	}
	public static void Singleton3(){
		System.out.println("init");
	}

	public void getString(){
		System.out.println("init print");
	
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton3 s1 = Singleton3.getInstance();
		s1.getString();
	}

}
