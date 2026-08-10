class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int k, int n, int[] arr, int start, List<Integer> sublist) {

        if (n < 0) return;

        if (n == 0 && sublist.size() == k) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        if (sublist.size() == k) return;

        for (int i = start; i < arr.length; i++) {

            sublist.add(arr[i]);

            // i + 1 because each number can be used only once
            solve(k, n - arr[i], arr, i + 1, sublist);

            sublist.remove(sublist.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        solve(k, n, arr, 0, new ArrayList<>());

        return result;
    }
}