package sort;

/**
 * Created by has on 2017/6/28.
 * 简单选择排序
 */
public class selectSort {
    /*
    * 选择排序-简单选择排序
    * 基本思想：在一组要排序的数中，选取最小的与第一个位置交换
    */
    public static int SelectMinKey(int a[], int i) {
        int k = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[k] > a[j])
                k = j;
        }
        return k;
    }

    public static void selectSort(int a[]) {
        int key;
        for (int i = 0; i < a.length; i++) {
            key = SelectMinKey(a, i);
            if (key != i) {
                common.swap(a, i, key);
            }
            common.print(a);
        }
    }
    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        selectSort(a);
    }
}
