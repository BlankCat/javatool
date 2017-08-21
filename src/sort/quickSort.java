package sort;

/**
 * Created by has on 2017/6/28.
 * 快速排序
 */
public class quickSort {
    public static int partition(int a[], int low, int high) {
        int privotKey = a[low];
        while (low < high) {
            while (low < high && a[high] >= privotKey) {
                high--;
            }
            common.swap(a, low, high);
            while (low < high && a[low] <= privotKey) {
                low++;
            }
            common.swap(a, low, high);
        }
        common.print(a);
        return low;
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int privotLoc = partition(a, low, high);
            quickSort(a, low, privotLoc - 1);
            quickSort(a, privotLoc + 1, high);
        }
    }
    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
//        HeapSort(a);
    }
}
