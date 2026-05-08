class TeXText {
    private StringBuilder text = new StringBuilder();

    public void append(String s) {
        text.append(s);
    }

    public String getText() {
        return text.toString();
    }
}