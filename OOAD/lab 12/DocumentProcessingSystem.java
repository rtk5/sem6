interface DocumentHandler {
    void processDocument(String fileName);
}

class PDFHandler implements DocumentHandler {
    @Override
    public void processDocument(String fileName) {
        Logger.getInstance().log("Processing PDF file: " + fileName);
        System.out.println("PDF file processed: " + fileName);
    }
}

class WordHandler implements DocumentHandler {
    @Override
    public void processDocument(String fileName) {
        Logger.getInstance().log("Processing Word file: " + fileName);
        System.out.println("Word file processed: " + fileName);
    }
}

class ExcelHandler implements DocumentHandler {
    @Override
    public void processDocument(String fileName) {
        Logger.getInstance().log("Processing Excel file: " + fileName);
        System.out.println("Excel file processed: " + fileName);
    }
}

class DocumentFactory {
    public static DocumentHandler getDocumentHandler(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFHandler();
            case "word":
                return new WordHandler();
            case "excel":
                return new ExcelHandler();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

class Logger {
    private static Logger instance;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class DocumentProcessingSystem {
    public static void main(String[] args) {

        DocumentHandler pdf = DocumentFactory.getDocumentHandler("pdf");
        pdf.processDocument("file1.pdf");

        DocumentHandler word = DocumentFactory.getDocumentHandler("word");
        word.processDocument("file2.docx");

        DocumentHandler excel = DocumentFactory.getDocumentHandler("excel");
        excel.processDocument("file3.xlsx");
    }
}