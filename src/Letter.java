//Клас, що представляє літеру
public class Letter{
    private final char value;

    public Letter(char value) throws IllegalArgumentException {
        if (!Character.isLetterOrDigit(value)) {
            throw new IllegalArgumentException("Value must be a letter");
        }
        this.value = value;
    }

    public char getValue(){
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
