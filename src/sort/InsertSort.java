package sort;

/**
 * Created by has on 2017/6/28.
 * 直接插入排序
 */
public class InsertSort {
    public static void InsertSort(int array[]) {

        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i - 1]) {// 小于，则后面向前移动

                int j = i - 1;
                int temp = array[i];// 哨兵，存储待排序元素
                array[i] = array[i - 1];// 先后移一个位置

                //temp < array[j] !!!
                for (; j >= 0 && temp < array[j]; j--) {
                    array[j + 1] = array[j];
                }

                array[j + 1] = temp;// 插入到正确位置
            }

            common.print(array);
        }
    }

    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        InsertSort(a);
    }
}
