class MedianFinder {

    // Max heap: stores smaller half
    PriorityQueue<Integer> queue_left = new PriorityQueue<>(Collections.reverseOrder());

    // Min heap: stores larger half
    PriorityQueue<Integer> queue_right = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {

        if (queue_left.isEmpty() || num <= queue_left.peek()) {
            queue_left.add(num);
        } else {
            queue_right.add(num);
        }

        // Left has more than 1 extra element
        if (queue_left.size() > queue_right.size() + 1) {
            queue_right.add(queue_left.poll());
        }

        // Right has more elements
        else if (queue_left.size() < queue_right.size()) {
            queue_left.add(queue_right.poll());
        }
    }

    public double findMedian() {

        if (queue_left.size() == queue_right.size()) {
            return (queue_left.peek() + queue_right.peek()) / 2.0;
        }

        return queue_left.peek();
    }
}