
import java.util.HashMap;
import java.util.Map;

public class GlyphFactory {

    private static final Map<Character, Glyph> cache = new HashMap<>();

    public static Glyph getCharacter(char c) {
        Glyph glyph = cache.get(c);

        if (glyph == null) {
            glyph = new CharacterGlyph(c);
            cache.put(c, glyph);
        }

        return glyph;
    }
}
