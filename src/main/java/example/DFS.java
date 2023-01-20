package example;

import java.util.ArrayList;
import java.util.List;

/**
 * the template of DFS
 * how to solve question by using DFS
 *
 *
 */
public class DFS {
    public static void dfs(String input, List<String> path, List<List<String>> result, String current) {

        // 是否找到结果
        boolean findResult = false;

        //非法
        boolean valid = false;

        //可以剪枝
        boolean canPrune = false;

        if (findResult) {
            result.set(0, path);
        }

        if (valid) {
            return;
        }

        if (canPrune) {
            return;
        }

        for(String n : current) {
            path.add(n); //把下一个点加入中间结果中
            dfs(input, path, result, < 更新后的 current >)
            path.pop(); //恢复中间结果
        }

    }


    //通常需要做的就是把参数定义好，并调用 dfs
    public static List<List<String>> main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        String input = "";
        String target = "";
        dfs(input, path, result, target);
        return result;
    }
}
