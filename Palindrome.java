public class Palindrome {
    public static boolean check(String word) {
        word = word.toLowerCase().replaceAll("( |,|-|\\.)", ""); // Regular expression for the replace
        StackLL<Character> wordStack = new StackLL<>();
        for (int i = 0; i < word.length(); i++) {
            wordStack.push(word.charAt(i));
        }
        String reverseWord = "";
        while (!wordStack.isEmpty()) {
            reverseWord += wordStack.pop();
        }
        return word.equals(reverseWord);
    }
}
