import java.util.*;
public class main {
    public static void main(String[] args) {
        System.out.println("Enter a string to encode");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter the shift value:");
        int shift = scanner.nextInt();
        scanner.close();
        System.out.println(encode(input, shift));
    }
    public static String encode(String input, int shift) {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (alphabet.contains(c)) {
                int index = alphabet.indexOf(c);
                int newIndex = (index + shift) % alphabet.size();
                result.append(alphabet.get(newIndex));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}