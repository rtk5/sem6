import java.util.HashMap;
import java.util.Map;

class ColorFactory {
    private static final Map<String, Color> colors = new HashMap<>();

    public static Color getColor(String colorName) {
        if (!colors.containsKey(colorName)) {
            colors.put(colorName, new PenColor(colorName));
            System.out.println("Creating new color: " + colorName);
        }
        return colors.get(colorName);
    }
}
