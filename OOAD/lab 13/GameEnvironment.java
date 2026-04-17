import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// Flyweight — stores shared intrinsic state
class TreeType {
    private String type;
    private String color;
    private String texture;

    TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + type + " [color=" + color +
                           ", texture=" + texture + "] at (" + x + ", " + y + ")");
    }
}

// Flyweight Factory — ensures shared instances
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String type, String color, String texture) {
        String key = type + color + texture;
        if (!treeTypes.containsKey(key)) {
            System.out.println("Creating new TreeType: " + type);
            treeTypes.put(key, new TreeType(type, color, texture));
        }
        return treeTypes.get(key);
    }

    public static int getTotalTypes() { return treeTypes.size(); }
}

// Context — stores extrinsic state (position) + reference to flyweight
class Tree {
    private int x, y;
    private TreeType treeType;

    Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        treeType.draw(x, y);
    }
}

public class GameEnvironment {
    public static void main(String[] args) {
        List<Tree> forest = new ArrayList<>();

        // Thousands of trees — but only a few shared TreeType objects
        TreeType oak   = TreeFactory.getTreeType("Oak",   "Green", "RoughBark");
        TreeType pine  = TreeFactory.getTreeType("Pine",  "DarkGreen", "SmoothBark");
        TreeType maple = TreeFactory.getTreeType("Maple", "Orange", "FlatLeaf");

        forest.add(new Tree(10, 20, oak));
        forest.add(new Tree(30, 40, pine));
        forest.add(new Tree(50, 60, oak));   // reuses oak flyweight
        forest.add(new Tree(70, 80, maple));
        forest.add(new Tree(90, 10, pine));  // reuses pine flyweight

        for (Tree t : forest) t.draw();

        System.out.println("\nTotal trees: " + forest.size());
        System.out.println("Total TreeType objects in memory: " + TreeFactory.getTotalTypes());
    }
}