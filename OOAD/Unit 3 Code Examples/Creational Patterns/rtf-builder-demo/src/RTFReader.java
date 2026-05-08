class RTFReader {

    private TextConverter builder;

    public RTFReader(TextConverter builder) {
        this.builder = builder;
    }

    public void parse(String rtfText) {
        for (char c : rtfText.toCharArray()) {
            if (c == '\n') {
                builder.convertParagraph();
            } else {
                builder.convertCharacter(c);
            }
        }
    }
}