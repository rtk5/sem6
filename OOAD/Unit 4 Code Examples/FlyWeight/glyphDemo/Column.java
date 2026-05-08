import java.util.ArrayList;
import java.util.List;

public class Column implements Glyph {
    private List<Glyph> children = new ArrayList<>();

    public void add(Glyph g) {
        children.add(g);
    }

    @Override
    public void draw(String context) {
        for (Glyph g : children) {
            g.draw(context);
        }
    }

    @Override
    public boolean intersects(String point, String context) {
        return false;
    }
}