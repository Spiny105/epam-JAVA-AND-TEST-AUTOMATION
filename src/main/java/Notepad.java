public class Notepad {

    private int currentSize;
    private Note[] notes;

    public Notepad() {
        currentSize = 0;
        notes = new Note[100];
    }

    //Print notes in console
    public void printNotesOnConsole(){
        for (int i = 0; i < currentSize; i++)
        {
            System.out.println(notes[i].getData());
        }
    }

    //Add note in notepad
    public void addNote(Note note)
    {
        if (currentSize >= notes.length)
        {
            int newSize = notes.length + 100;
            Note[] temp = new  Note[newSize];
            System.arraycopy( notes, 0, temp, 0, notes.length );
            notes = temp;
        }

        notes[currentSize++] = note;

    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void addNote(String record)
    {
        this.addNote(new Note(record));
    }

    public void deleteNote(int indexToDelete)
    {
        //Проверяем выход за гарницу диапазона
        if ((indexToDelete < 0) || (indexToDelete > currentSize - 1))
        {
            throw  new IndexOutOfBoundsException("incorrect index");
        }

        //Проверяем, нужно ли уменьшить размер массива
        if ((currentSize % 100 == 0) && (currentSize > 100))
        {
            int newSize = notes.length - 100;
            Note[] temp = new Note[newSize];
            System.arraycopy(notes, 0, temp, 0, indexToDelete);
            System.arraycopy(notes, indexToDelete + 1, temp, indexToDelete, notes.length - indexToDelete);
        }
        else
        {
            System.arraycopy(notes, indexToDelete + 1, notes, indexToDelete, notes.length - 1 - indexToDelete);
        }

        currentSize--;
    }

    //Редактировать запись
    public void replaseNote(Note newNote, int index)
    {
        //Проверяем выход за гарницу диапазона
        if ((index < 0) || (index > currentSize - 1))
        {
            throw  new IndexOutOfBoundsException("incorrect index");
        }

        notes[index] = newNote;
    }

    //Редактировать запись
    public void replaseNote(String newText, int index)
    {
        //Проверяем выход за гарницу диапазона
        if ((index < 0) || (index > currentSize - 1))
        {
            throw  new IndexOutOfBoundsException("incorrect index");
        }

        notes[index].setData(newText);
    }
}
