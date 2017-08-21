package sort;

/**
 * Created by has on 2017/6/28.
 * 归并排序
 */
public class MergeSort {
    private static void MergeSort(int[] a) {
        System.out.println("开始排序");
        Sort(a, 0, a.length - 1);
    }

    private static void Sort(int[] a, int left, int right) {

        // !!!等于的时候就是一个数，不用比较了！
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);

        common.print(a);
    }

    private static void merge(int[] r, int i, int m, int n) {

        int[] rf = new int[r.length];

        // k是rf数组的下标
        // tmpI记录i的初始位置
        // j是r右边的游标
        int k = i;
        int tmpI = i;
        int j = m + 1;

        for (; i <= m && j <= n; k++) {
            if (r[i] < r[j]) {
                rf[k] = r[i++];
            } else {
                rf[k] = r[j++];
            }
        }

        // 将左边剩余的合并
        while (i <= m) {
            rf[k++] = r[i++];
        }

        // 将右边剩余的合并
        while (j <= n) {
            rf[k++] = r[j++];
        }

        i = tmpI;

        // 复制数组
        while (i <= n) {
            r[i] = rf[i];
            i++;
        }
    }
    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        MergeSort(a);
    }
}
