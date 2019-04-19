public class Note {

    private String text;
    private String header;

    public Note(String header, String text) {

        this.text = text;
        this.header = header;
    }

    public Note() {
        text = "";
        header = "";
    }

    @Override
    public String toString() {
        return this.getHeader() + ": \n" + this.getText();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
