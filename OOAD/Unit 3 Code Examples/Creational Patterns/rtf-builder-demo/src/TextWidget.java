class TextWidget {
    private StringBuilder content = new StringBuilder();

    public void append(char c) {
        content.append(c);
    }

    public void newLine() {
        content.append("\n");
    }

    public String getContent() {
        return content.toString();
    }
}