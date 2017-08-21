package sort;

/**
 * Created by has on 2017/6/28.
 * 希尔排序
 */
public class shellSort {
    public static void ShellInsertSort(int[] array, int dk) {

        for (int i = dk; i < array.length; i++) {

            // 如果满足插入条件
            if (array[i] < array[i - dk]) {

                int j = i - dk;
                // 存储待排序元素
                int x = array[i];
                // 后移一个元素
                array[i] = array[i - dk];

                // 查找有序表的插入位置
                for (; j >= 0 && x < array[j]; j -= dk) {
                    array[j + dk] = array[j];
                }

                // 插入到正确位置
                array[j + dk] = x;
            }

        }
    }

    public static void shellSort(int array[]) {
        int dk = array.length / 2;
        while (dk >= 1) {
            ShellInsertSort(array, dk);
            common.print(array);
            dk = dk / 2;
        }
    }
    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        shellSort(a);
    }
}
