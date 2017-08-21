package sort;

/**
 * Created by has on 2017/6/28.
 */
public class common {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
