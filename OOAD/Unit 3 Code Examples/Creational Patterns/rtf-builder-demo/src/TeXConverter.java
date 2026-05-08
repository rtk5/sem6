class TeXConverter implements TextConverter {

    private TeXText texText = new TeXText();

    public void convertCharacter(char c) {
        texText.append(String.valueOf(c));
    }

    public void convertParagraph() {
        texText.append("\\par ");
    }

    public TeXText getTeXText() {
        return texText;
    }
}