package sort;

/**
 * Created by has on 2017/6/28.
 * 冒泡排序
 */
public class bubbleSort {
    /*
    * 算法改进：加一个标志位，记录每趟排序最后一个进行交换的位置，下一次只需扫描到pos
    */
    public static void bubbleSort(int a[]) {
        int i = a.length - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    pos = j;
                    common.swap(a, j, j + 1);
                }
            }
            common.print(a);
            i = pos;
        }
    }

    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        bubbleSort(a);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
