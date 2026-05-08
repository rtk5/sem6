class TextWidgetConverter implements TextConverter {

    private TextWidget widget = new TextWidget();

    public void convertCharacter(char c) {
        widget.append(c);
    }

    public void convertParagraph() {
        widget.newLine();
    }

    public TextWidget getTextWidget() {
        return widget;
    }
}