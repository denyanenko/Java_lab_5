import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String inputText = "Думи мої, думи мої,\n" +
                "Лихо мені з вами!\n" +
                "Нащо стали на папері\n" +
                "Сумними рядами?..\n" +
                "Чом вас вітер не розвіяв\n" +
                "В степу, як пилину?\n" +
                "Чом вас лихо не приспало,\n" +
                "Як свою дитину?...\n" +
                "За карії оченята,\n" +
                "За чорнії брови\n" +
                "Серце рвалося, сміялось,\n" +
                "Виливало мову,\n" +
                "Виливало, як уміло,\n" +
                "За темнії ночі,\n" +
                "За вишневий сад зелений,\n" +
                "За ласки дівочі...\n" +
                "За степи та за могили,\n" +
                "Що на Україні,\n" +
                "Серце мліло, не хотіло\n" +
                "Співать на чужині...\n";
        int lengthToRemove = 4;
        if (inputText == null) {
            System.out.println("text is null");
            return;
        }
        Text text = transformText(inputText);
        System.out.println("Текст до редагування:\n");
        System.out.println(text);
        modifyText(text, lengthToRemove);
        System.out.println("Видалення слів, що починаються з приголосної довжиною " + lengthToRemove + "\n");
        System.out.println(text);


    }

    public static Text transformText(String elements) {
        ArrayList<Sentence> text = new ArrayList<>();
        ArrayList<SentenceElement> sentence = new ArrayList<>();
        ArrayList<Letter> word = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            char symbol = elements.charAt(i);
            if (Character.isLetterOrDigit(symbol)) {
                word.add(new Letter(symbol));
                if (i == elements.length() - 1) {
                    sentence.add(new Word(word));
                    text.add(new Sentence(sentence));
                }
            } else {
                if (!word.isEmpty()) {
                    sentence.add(new Word(word));
                    word.clear();
                }
                sentence.add(new Punctuation(symbol));
                if ((Character.isWhitespace(symbol) && i != 0 && ".!?".contains(String.valueOf(elements.charAt(i - 1)))) || i == elements.length() - 1) {
                    text.add(new Sentence(sentence));
                    sentence.clear();
                }

            }
        }
        return new Text(text);
    }

    public static void modifyText(Text text, int lengthToRemove) {
        for (Sentence sentence : text.getSentences()) {
            for (int i = 0; i < sentence.getElements().size(); i++) {
                SentenceElement element = sentence.getElements().get(i);
                if (sentence.getElements().get(i).getClass() == Word.class) {
                    if (((Word) element).getLetters().size() == lengthToRemove && startsWithConsonant((Word) element)) {
                        sentence.getElements().remove(element);

                        if (i == 0 || ((Punctuation) sentence.getElements().get(i - 1)).getValue() == '\n') {
                            Punctuation nextPunctuation = (Punctuation) sentence.getElements().get(i);
                            if (Character.isWhitespace(nextPunctuation.getValue())) {
                                sentence.getElements().remove(nextPunctuation);
                                i--;
                            }

                        } else {
                            Punctuation beforePunctuation = (Punctuation) sentence.getElements().get(i - 1);
                            sentence.getElements().remove(beforePunctuation);
                            i--;
                        }
                    }

                }
            }
        }
    }

    public static boolean startsWithConsonant(Word word) {
        char firstLetter = Character.toLowerCase(word.getLetters().get(0).getValue());
        return "бвгґджзйклмнпрстфхцчшщ".contains(String.valueOf(firstLetter));
    }
}
