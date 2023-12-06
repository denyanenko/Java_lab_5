import java.util.ArrayList;
import java.util.List;

//Клас, що представляє Речення
public class Sentence {
    private final List<SentenceElement> elements;

    public Sentence(List<SentenceElement> elements) {

        this.elements = new ArrayList<>(elements);
    }

    public List<SentenceElement> getElements() {
        return elements;
    }


    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (SentenceElement element : elements) {
            sentenceString.append(element.toString());
        }
        return sentenceString.toString();
    }
}
