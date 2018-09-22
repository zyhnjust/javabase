package algo.ds.sort;

public class BubbleSort2 {

	/**
	 * ð������ĵ�һ��ʵ��, û���κ��Ż�
	 * @param a
	 * @param n
	 */
	public static void bubbleSort1(int [] a, int n){
	    int i, j;

	    for(i=0; i<n; i++){//��ʾn��������̡�
	        for(j=1; j<n-i; j++){
	            if(a[j-1] > a[j]){//ǰ������ִ��ں�������־ͽ���
	                //����a[j-1]��a[j]
	                int temp;
	                temp = a[j-1];
	                a[j-1] = a[j];
	                a[j]=temp;
	            }
	        }
	    }
	}// end
	
	/**
	 * ����һ����־�������һ�˷����˽�������Ϊtrue������Ϊfalse�����������һ��û�з���������˵�������Ѿ���ɡ�
	 * @param a
	 * @param n
	 */
	public static void bubbleSort2(int [] a, int n){
	    int j, k = n;
	    boolean flag = true;//�����˽�����Ϊtrue, û������Ϊfalse����һ���ж�ʱ�����־λtrue��
	    while (flag){
	        flag=false;//ÿ�ο�ʼ����ǰ��������flagΪδ�����
	        for(j=1; j<k; j++){
	            if(a[j-1] > a[j]){//ǰ������ִ��ں�������־ͽ���
	                //����a[j-1]��a[j]
	                int temp;
	                temp = a[j-1];
	                a[j-1] = a[j];
	                a[j]=temp;

	                //��ʾ����������;
	                flag = true;
	            }
	        }
	        k--;//��Сһ�������β�߽�
	    }//end while
	}//end
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};

	    BubbleSort2.bubbleSort1(arr, arr.length);

	    //�Ż���һ�£� ���Ǽ��˸�flage
	    BubbleSort2.bubbleSort2(arr, arr.length);

	    for(int i:arr){
	        System.out.print(i+",");
	    }
	}

}
