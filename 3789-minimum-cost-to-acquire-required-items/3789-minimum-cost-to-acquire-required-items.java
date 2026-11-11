class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long p1 = (long)cost1*need1;
        long p2 = (long)cost2*need2;
        long act_need = Math.max(need1,need2);
        long overall = act_need*costBoth;
        long common = Math.min(need1,need2);
        long mix = common*costBoth+((need1-common)*cost1)+((need2-common)*cost2);
        return Math.min(p1+p2,Math.min(overall,mix));
    }
}