public class Josephus {
    public static int solve(int S, int N) {
        QueueLL<Integer> queue = new QueueLL<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i + 1); // Typically 1 indexed
        }
        // (FIXED) Currently gives penultimate for odd skip numbers and ultimate for even
        // numbers -- This was a problem with my queue.size() function!
        while (queue.size() > 1) {
            for (int i = 0; i < S - 1; i++) { // S - 1 because skip size is typically specified as nth person killed,
                // not n people skipped (Wikipedia)
                queue.enqueue(queue.dequeue());
            }
            queue.dequeue();
        }
        return queue.dequeue();
    }
}
