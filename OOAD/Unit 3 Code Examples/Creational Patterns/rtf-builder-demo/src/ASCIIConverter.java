class ASCIIConverter implements TextConverter {

    private ASCIIText asciiText = new ASCIIText();

    public void convertCharacter(char c) {
        asciiText.append(c);
    }

    public void convertParagraph() {
        asciiText.append('\n');
    }

    public ASCIIText getASCIIText() {
        return asciiText;
    }
}