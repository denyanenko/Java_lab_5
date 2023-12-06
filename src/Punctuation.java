//Клас, що представляє Розділовий знак
public class Punctuation  extends SentenceElement {
    private final char value;

    public Punctuation(char value) throws IllegalArgumentException {
        if (Character.isLetterOrDigit(value)) {
            throw new IllegalArgumentException("Value must be a punctuation");
        }
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
