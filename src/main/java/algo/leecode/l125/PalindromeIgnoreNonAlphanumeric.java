/**
 * 
 */
package java_base.algo.leecode.l125;

/**
 * @author Homer
 *
 */
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 * �������������Ŷ���ȥ�͵��Ŷ��������ַ���������ͬ��Ϊ���ģ��磺1h3gkg3h1�ǻ���
 * @author tong
 *
 */
public class PalindromeIgnoreNonAlphanumeric {
    public static void main(String[] args) {
     //����ʹ��javax.swing.JOptionPane���е�showInputDialog()������ʾ�û�������ĸ�������ִ�
        String s = JOptionPane.showInputDialog("�����������ַ���:");  
        //����isPalindromeByBuffer()����
        String output = s + (isPalindromeByBuffer(s)?"��":"����")+"���ġ�";
        JOptionPane.showMessageDialog(null, output);
        
        s = JOptionPane.showInputDialog("�����������ַ���:");
        //����isPalindromeByCharAt()����
        output = s + (isPalindromeByCharAt(s)?"��":"����")+"���ġ�";      
        JOptionPane.showMessageDialog(null, output);
        
        //ʹ��Scanner(System.in)������ʾ�û������ַ���
  System.out.println("�����������ַ���:");
  Scanner in=new Scanner(System.in);
  String strOrigin=in.next(); 
  //����isPalindromeByCharAtSingle()����
  System.out.print(strOrigin + (isPalindromeByCharAtSingle(s)?"��":"����")+"���ġ�");

 


    }
    
    /**
    * ͨ������StringBuffer�Ķ����reverse()���������жϷ�תǰ���ַ����Ƿ���ȣ�ȷ���Ƿ�Ϊ����
    * @param s
    * @return
    */
    public static boolean isPalindromeByBuffer(String s) {
        String strOrigin = filterLetterAndDigit(s);
        //��strOrigin��Ϊ�������������һ��StringBuffer����
        StringBuffer strBuf = new StringBuffer(strOrigin);
        //����StringBuffer�����Դ���reverse()���������ַ�����ת��������toString()����һ��String�����ַ���
        String strAfterReverse = strBuf.reverse().toString();  
        //ͨ��equals()�����ж�ԭ�����ַ����ͷ�ת����ַ����Ƿ���ȣ���ȷ���Ƿ�Ϊ����
        return strOrigin.equals(strAfterReverse);
    }
    
    /**
    * ͨ���ַ����еĶԳ�λ���ַ����Ƿ���ͬ���ж��Ƿ�Ϊ����,����������������low��high���ֱ��Ӧ�ַ����Գ�λ�õ�index
    * @param s
    * @return
    */
    public static boolean isPalindromeByCharAt(String s) {
     //low��high�ֱ��Ӧ�ַ����Գ�λ�õ�index���Դ����ж����жԳ�λ���ַ��Ƿ���ͬ
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;  // ���ǻ���
            low++;
            high--;
        }
        return true;          // �ǻ���
    }
    
    /**
    * ͨ���ַ����еĶԳ�λ���ַ����Ƿ���ͬ���ж��Ƿ�Ϊ����,��������һ������i����Ӧ�ַ����Գ�λ�õ�index
    * @param s
    * @return
    */
    public static boolean isPalindromeByCharAtSingle(String s) {
     //ͨ���Գ��±�Ĺ�ϵʹ��һ�����������ж����жԳ�λ���ַ��Ƿ���ͬ
     for(int i=0;i<s.length()/2;i++){
      //ֻ�е�ǰһ���ַ����ͺ�һ���ַ�����Ӧλ����ͬ����ô���ǻ��ģ�ֻ����һ���Գ�λ�õ��ַ���ͬ�Ͳ��ǻ���
      if(s.charAt(i)!=s.charAt(s.length()-i-1)){
       return false;
      }
     }
        
        return true;  
    }
    
    /**
    * ͨ������Character.isLetterOrDigit(Char char)������ĸ�������֣��ж���ĸ�������ֵ�����Ƿ�Ϊ����
    * @param s
    * @return String
    */
    public static String filterLetterAndDigit(String s) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
             //����StringBuffer��append(Char char)����,���������ĸ�������ּ�������
                strBuf.append(s.charAt(i));
            }
        }
        //����String���ͣ���Ҫ��StringBufferת��ΪString����Ҫ����StringBuffer�����toString()����
        return strBuf.toString();
    }
    
}