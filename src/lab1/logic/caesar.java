package lab1.logic;

public class caesar {
    public static String encrypt(String plaintext, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    // decrypt
    public static String decrypt(String ciphertext, int key) {
        return encrypt(ciphertext, 26 - key);
    }

    public static String attack(String ciphertext) {
        StringBuilder s = new StringBuilder();
        for (int key = 0; key < 26; key++) {
            s.append(decrypt(ciphertext, key));
            s.append("\n");
        }
        return s.toString();
    }

    // Main
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("CAESAR CIPHER");
        System.out.println("=".repeat(60));

        String plaintext = "HELLO WORLD";
        int key = 3;

        System.out.println("Plaintext:  " + plaintext);
        System.out.println("Key:        " + key);

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted:  " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted:  " + decrypted);

        // Attack
        attack("KHOOR");
    }

}
