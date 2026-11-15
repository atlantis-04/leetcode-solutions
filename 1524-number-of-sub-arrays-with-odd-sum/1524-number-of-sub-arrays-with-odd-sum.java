class Solution {
    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        map.put(1, 0);

        long sum = 0;
        long count = 0;

        for(int x : arr) {

            sum += x;

            int parity = (int)(sum % 2);

            int opposite = 1 - parity;

            count += map.get(opposite);

            map.put(parity, map.get(parity) + 1);
        }

        return (int)(count % mod);
    }
}