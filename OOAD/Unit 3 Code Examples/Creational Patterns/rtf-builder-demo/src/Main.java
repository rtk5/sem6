public class Main {
    public static void main(String[] args) {

        String sampleText = "Hello World\nBuilder Pattern";

        // ASCII Conversion
        ASCIIConverter asciiBuilder = new ASCIIConverter();
        RTFReader reader1 = new RTFReader(asciiBuilder);
        reader1.parse(sampleText);
        System.out.println("ASCII Output:");
        System.out.println(asciiBuilder.getASCIIText().getText());

        // TeX Conversion
        TeXConverter texBuilder = new TeXConverter();
        RTFReader reader2 = new RTFReader(texBuilder);
        reader2.parse(sampleText);
        System.out.println("\nTeX Output:");
        System.out.println(texBuilder.getTeXText().getText());

        // TextWidget Conversion
        TextWidgetConverter widgetBuilder = new TextWidgetConverter();
        RTFReader reader3 = new RTFReader(widgetBuilder);
        reader3.parse(sampleText);
        System.out.println("\nTextWidget Output:");
        System.out.println(widgetBuilder.getTextWidget().getContent());
    }
}