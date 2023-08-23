public class CaesarsCipher {

    // Declare constants needed
    private static final char LOW_LETTER_A = 'a';
    private static final char LOW_LETTER_Z = 'z';
    private static final char CAP_LETTER_A = 'A';
    private static final char CAP_LETTER_Z = 'Z';
    private static final int ALPHABET_SIZE = 26;

    // Method that starts the process of ciphering text, takes in string message and an integer offset
    public String cipher(String message, int offset) {
        offset %= ALPHABET_SIZE; // Ensures offset is not greater than alphabet
        char[] character = message.toCharArray();
        offsetBy(character, offset); // calls method to shift each character in string by offset
        return new String(character);
    }

    // initiates loop to change each character by offset
    private void offsetBy(char[] character, int offset) {
        for (int i = 0; i < character.length; i++) {
            character[i] = offsetChar(character[i], offset); // Calls the method that shifts the character
        }
    }

    // Figures out which group character belongs to then shifts appropriately
    private char offsetChar(char c, int offset) {
        if (c == ' ') {
            return c; // ensures spaces are left alone
        }
        if (c >= LOW_LETTER_A && c <= LOW_LETTER_Z) {
            c += (char) offset;

            if (c < LOW_LETTER_A) {
                return (char) (c + ALPHABET_SIZE);
            }
            if (c > LOW_LETTER_Z) {
                return (char) (c - ALPHABET_SIZE);
            }
            return c;
        }
        if (c >= CAP_LETTER_A && c <= CAP_LETTER_Z) {
            c += (char) offset;

            if (c < CAP_LETTER_A) {
                return (char) (c + ALPHABET_SIZE);
            }
            if (c > CAP_LETTER_Z) {
                return (char) (c - ALPHABET_SIZE);
            }
    }
            return c;

    }

    public static void main(String[] args) {
        String myText = "This is my testing text";
        int offset = 2;

        CaesarsCipher cipher = new CaesarsCipher();
        String cipheredText = cipher.cipher(myText, offset);
        System.out.println(cipheredText);

        String decipheredText = cipher.cipher(cipheredText, -2);
        System.out.println(decipheredText);
    }
}
