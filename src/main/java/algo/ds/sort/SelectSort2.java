package algo.ds.sort;

import java.util.Arrays;

public class SelectSort2 {

    public static void selectSort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int flag = i; // ����ǰ�±궨��Ϊ��Сֵ�±�
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {// a[j] < temp ��С��������a[j] > temp �Ӵ�С����
                    temp = a[j];
                    flag = j; // �����С�ڵ�ǰ��Сֵ�Ĺؼ��ֽ��˹ؼ��ֵ��±긳ֵ��flag
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 49,38,65,97,76,13,27,49 };
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
    
}