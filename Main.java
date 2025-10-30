public class Main {
    public static void main(String[] args) {
        for (int i = 10; i < 15; i++) {
            int average = 0;
            int numOfValues = 0;
            for (int j = 0; j < 5; j++) {
                int newNumber = Birthday.generateUntilRepeated(i);
                System.out.println(newNumber);
                average = (average * numOfValues) + newNumber;
                numOfValues++;
                average /= numOfValues; // Could be made into a single-line operation -- thought this was more readable
            }
            // System.out.println("N: " + i + ", Average: " + average);
        }
    }
}
