import java.util.*;

public class Find_combinationII {
    class Solution {
        private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }

            for (int i = ind; i < arr.length; i++) {
                if (i > ind && arr[i] == arr[i - 1]) continue;
                if (arr[i] > target) break;

                ds.add(arr[i]);
                findCombinations(i + 1, arr, target - arr[i], ans, ds);
                ds.remove(ds.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            findCombinations(0, candidates, target, ans, new ArrayList<>());
            return ans;
        }
    }

    public static void main(String[] args) {
        Find_combinationII solution = new Find_combinationII();
        Solution combinator = solution.new Solution();

//        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int[] candidates = { 1,1,1,2,2};
        int target = 4;

        List<List<Integer>> result = combinator.combinationSum2(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
