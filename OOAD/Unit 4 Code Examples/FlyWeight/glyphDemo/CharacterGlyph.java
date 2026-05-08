public class CharacterGlyph implements Glyph {
    private char c; // intrinsic state

    public CharacterGlyph(char c) {
        System.out.println("Character glyph Object created for :" + c);
        this.c = c;
    }

    @Override
    public void draw(String context) {
        System.out.println("Drawing character '" + c + "' with context: " + context);
    }

    @Override
    public boolean intersects(String point, String context) {
        return false;
    }
}