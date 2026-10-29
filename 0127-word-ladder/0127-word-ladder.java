class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            String word = curr.first;
            int steps = curr.second;

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char[] arr = word.toCharArray();
                    arr[i] = ch;

                    String replacedWord = new String(arr);

                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
