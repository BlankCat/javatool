package tool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by has on 2017/6/28.
 * 一个人射箭，每次分数在0至10之间，已知射箭10次，得分是50分，编程计算总共有多少种可能？

 例如：
 10 10 10 10 10 0 0 0 0 0
 0 0 0 0 0 10 10 10 10 10
 是两种情况
 */
public class Main5 {
    public static void main(String[] args) {

        Main5 a = new Main5();

        // 总分20分，射箭5次，每次0~10分
        List<List<Integer>> c = a.combine(20, 5, 10);

        // 打印结果
        for (List<Integer> list : c) {
            System.out.println(list);
        }
    }

    Integer[] stack;// 存储单次结果
    List<List<Integer>> result;// 存储结果集

    /**
     *
     * @param totalScore
     *            最后得分
     * @param totalTimes
     *            射击次数
     * @param maxScore
     *            每次射箭的最大分数
     * @return
     */
    public List<List<Integer>> combine(int totalScore, int totalTimes,
                                       int maxScore) {

        stack = new Integer[totalTimes];
        result = new ArrayList<List<Integer>>();

        dfs(0, 0, totalScore, totalTimes, maxScore);

        return result;
    }

    public void dfs(int p, int curScore, int totalScore, int totalTimes,
                    int maxScore) {

        if (p == totalTimes && curScore == totalScore) {
            result.add(new ArrayList<Integer>(Arrays.asList(stack)));
            return;
        }

        if (p == totalTimes || curScore > totalScore) {
            return;
        }

        for (int i = 0; i < maxScore; i++) {
            stack[p] = i;
            dfs(p + 1, curScore + i, totalScore, totalTimes, maxScore);
        }
    }
}
