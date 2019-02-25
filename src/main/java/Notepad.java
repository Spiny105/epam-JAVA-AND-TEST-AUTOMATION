public class Notepad {

    private int currentSize;
    private Note[] notes;

    private static final int NOTEPAD_MINIMUM_SIZE = 100;

    public Notepad() {
        currentSize = 0;
        notes = new Note[NOTEPAD_MINIMUM_SIZE];
    }

    //Add note in notepad
    public boolean addNote(Note note) {
        if (note == null) {
            return false;
        }

        //Check for the need to resize the array
        if (currentSize >= notes.length) {
            int newSize = notes.length + NOTEPAD_MINIMUM_SIZE;
            Note[] temp = new  Note[newSize];
            System.arraycopy( notes, 0, temp, 0, notes.length );
            notes = temp;
        }

        notes[currentSize++] = note;

        return true;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Note[] getNotes(){
        Note[] newArray = new Note[currentSize];
        System.arraycopy(notes, 0, newArray, 0, currentSize);
        return newArray;
    }

    public Note getNote(int index){

        if ((index < 0) || (index > currentSize - 1)) {
            return null;
        }

        return new Note(notes[index].getHeader(), notes[index].getText());
    }

    public boolean addNote(String header, String text) {
        return this.addNote(new Note(header, text));
    }

    public boolean deleteNote(int indexToDelete) {
        //Array out of range check
        if ((indexToDelete < 0) || (indexToDelete > currentSize - 1)) {
            return false;
        }

        //Check for the need to resize the array
        if ((currentSize % NOTEPAD_MINIMUM_SIZE == 0) && (currentSize > NOTEPAD_MINIMUM_SIZE)){
            int newSize = notes.length - NOTEPAD_MINIMUM_SIZE;
            Note[] temp = new Note[newSize];
            System.arraycopy(notes, 0, temp, 0, indexToDelete);
            System.arraycopy(notes, indexToDelete + 1, temp, indexToDelete, notes.length - indexToDelete);
            notes = temp;
        }
        else {
            System.arraycopy(notes, indexToDelete + 1, notes, indexToDelete, notes.length - 1 - indexToDelete);
        }

        currentSize--;

        return true;
    }

    public boolean replaceNote(Note newNote, int index) {
        if (newNote == null) {
            return false;
        }

        //Array out of range check
        if ((index < 0) || (index > currentSize - 1)) {
            return false;
        }

        notes[index] = newNote;

        return true;
    }

    public boolean replaceNote(String newHeader, String newText, int index) {
        //Array out of range check
        if ((index < 0) || (index > currentSize - 1)) {
            return false;
        }

        notes[index].setHeader(newHeader);
        notes[index].setText(newText);
        return true;
    }
}
