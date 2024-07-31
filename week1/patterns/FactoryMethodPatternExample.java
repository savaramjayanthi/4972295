public class FactoryMethodPatternExample {

    // Document interface
    public interface Document {
        void open();
    }

    // Concrete WordDocument class
    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    // Concrete PdfDocument class
    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    // Concrete ExcelDocument class
    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Abstract DocumentFactory class
    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete WordDocumentFactory class
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    // Concrete PdfDocumentFactory class
    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    // Concrete ExcelDocumentFactory class
    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Main method to demonstrate the Factory Method Pattern
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
