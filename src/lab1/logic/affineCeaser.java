package lab1.logic;

public class affineCeaser {
    public static String encrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = c - 'A';
                int encrypted = (a * x + b) % 26;
                result.append((char) (encrypted + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1) {
                return i;
            }
        }
        return -1;
    }

    public static String decrypt(String cipher, int a, int b) {
        StringBuilder result = new StringBuilder();
        cipher = cipher.toUpperCase();

        int aInv = modInverse(a, 26);
        if (aInv == -1) {
            return "No modular inverse exists";
        }

        for (char c : cipher.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = c - 'A';
                int decrypted = (aInv * (x - b + 26)) % 26;
                result.append((char) (decrypted + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void attack(String cipher) {
        // coprime with 26
        int[] validA = {1,3,5,7,9,11,15,17,19,21,23,25};

        for (int a : validA) {
            for (int b = 0; b < 26; b++) {
                String decrypted = decrypt(cipher, a, b);
                System.out.println("a=" + a + " b=" + b + " -> " + decrypted);
            }
        }
    }

}
