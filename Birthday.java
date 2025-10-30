public class Birthday {
    private static int generateRandom(int N) {
        return (int) Math.floor(Math.random() * N);
    }

    private static boolean containsNumber(int num, QueueLL<Integer> queue) {
        for (int i = 0; i < queue.size(); i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
            System.out.println(temp);
            if (num == temp) {
                return true;
            }
        }
        return false;
    }

    public static int generateUntilRepeated(int N) {
        QueueLL<Integer> alreadyGenerated = new QueueLL<>();
        alreadyGenerated.enqueue(generateRandom(N));
        int random = generateRandom(N);
        while (!containsNumber(random, alreadyGenerated)) {
            alreadyGenerated.enqueue(random);
            random = generateRandom(N);
        }
        return alreadyGenerated.size();
    }
}
