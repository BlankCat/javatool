package sort;

/**
 * Created by has on 2017/6/28.
 * 堆排序
 */
public class HeapSort {
    /*
    * 选择排序-堆排序
    *
    * 若以一维数组存储一个堆，则堆对应一个完全二叉树，且所有非叶结点的值，不大于其子女的值
    * 堆顶元素是最小的（小顶堆）
    *
    *
    * 已知H[s...m]除了H[s]外均满足堆的定义 调整H[s]，使之成为大顶堆，将第s个结点为根的子树筛选
    *
    * H：待调整的堆数组 s：待调整的数组元素的位置 length：数组长度
    */
    public static void HeapAdjust(int H[], int s, int length) {

        int tmp = H[s];
        int child = 2 * s + 1;// 左孩子结点位置

        while (child < length) {

            // 如果有右孩子，同时右孩子值>左孩子值
            if (child + 1 < length && H[child] < H[child + 1])
                child++;

            if (H[s] < H[child]) {// 较大的子结点>父节点
                H[s] = H[child];// 替换父节点
                s = child;// 重新设置，待调整的下一个结点位置
                child = 2 * s + 1;
            } else
                break;

            H[s] = tmp;// 交换
        }
    }

    /*
     * 初始堆进行调整 将H[0...length-1]建成堆 调整完后，第一个元素是序列最小的元素
     */
    public static void BuildingHeap(int H[], int length) {
        // 最有一个有孩子结点的位置是 i = (length - 1) / 2
        for (int i = (length - 1) / 2; i >= 0; i--) {
            HeapAdjust(H, i, length);
        }
    }

    public static void HeapSort(int H[]) {
        BuildingHeap(H, H.length);// 初始堆
        // 从最后一个元素开始调整
        for (int i = H.length - 1; i > 0; i--) {
            // 堆中最后一个元素和堆顶交换
            common.swap(H, i, 0);
            HeapAdjust(H, 0, i);// 调整
            common.print(H);
        }
    }

    public static void main(String[] args) {
        int a[]={3 ,1, 5, 7, 2, 4 ,6, 8 };
        HeapSort(a);
    }
}
