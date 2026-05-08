public interface Glyph {
    void draw(String context);
    boolean intersects(String point, String context);
}