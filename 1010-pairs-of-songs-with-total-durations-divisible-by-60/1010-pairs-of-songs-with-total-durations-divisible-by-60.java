class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int t : time) {

            int rem = t % 60;
            int complement = (60 - rem) % 60;

            count += map.getOrDefault(complement, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
