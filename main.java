import java.util.*;
public class main {
    //Hier beginnt die Ausführung.
    //Abfragen werden getätigt und in ln.12 an encode() übergeben, das dann verschlüsselt und zurückgibt.
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); //erlaubt Eingaben von der Konsole
        System.out.println("Soll ver- oder entschlüsselt werden? (v/e):");
        if (scanner.nextLine().equals("e")){
            System.out.println("Hier String eingeben, der verschlüsselt werden soll:");
            String input = scanner.nextLine();
            System.out.println("Um wie viele Stellen soll verschoben werden?");
            int shift = scanner.nextInt();
            System.out.println(encode(input, shift));
        }
        else if(scanner.nextLine().equals("v")){
            System.out.println("Hier String eingeben, der entschlüsselt werden soll:");
            String input = scanner.nextLine();
            System.out.println("Um wie viele Stellen wurde verschoben?");
            int shift = 26-scanner.nextInt(); //verschiebt zurück, um zu entschlüsseln
            System.out.println(encode(input, shift));
        }
        else{
            System.out.println("Ungültige Eingabe. Bitte 'v' oder 'e' eingeben.");
            return;
        }
        scanner.close();
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