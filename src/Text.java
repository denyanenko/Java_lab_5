import java.util.List;

//Клас, що представляє Текст
public class Text {
    private final List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = List.copyOf(sentences);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString());
        }
        return textString.toString();
    }
}
