class ASCIIText {
    private StringBuilder text = new StringBuilder();

    public void append(char c) {
        text.append(c);
    }

    public String getText() {
        return text.toString();
    }
}