import java.util.List;
//Клас, що представляє Слово
public class Word extends SentenceElement {
    private final List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = List.copyOf(letters);
    }

    public List<Letter> getLetters() {
        return letters;
    }


    @Override
    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letter letter : letters) {
            wordString.append(letter.toString());
        }
        return wordString.toString();
    }
}
