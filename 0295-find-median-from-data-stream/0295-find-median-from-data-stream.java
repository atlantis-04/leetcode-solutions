
class MedianFinder {

    // Max heap: stores smaller half
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Min heap: stores larger half
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {

        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        // maxHeap has more than 1 extra element
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

        // minHeap has more elements
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}