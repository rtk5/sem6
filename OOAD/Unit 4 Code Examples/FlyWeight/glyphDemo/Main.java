public class Main {
    public static void main(String[] args) {
        Row row = new Row();

        String text = "AAB";

        for (char c : text.toCharArray()) {
            row.add(GlyphFactory.getCharacter(c));
        }

        row.draw("SampleContext");
    }
}