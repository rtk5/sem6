class PenColor implements Color {
    private final String color;

    public PenColor(String color) {
        this.color = color;
    }

    @Override
    public void applyColor(String shape) {
        System.out.println("Drawing " + shape + " with color " + color);
    }
}
