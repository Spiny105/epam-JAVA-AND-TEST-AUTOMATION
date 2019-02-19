import java.lang.reflect.Array;
import java.util.Arrays;

public class Notepad {

    private int currentSize;
    private Note[] notes;

    public Notepad() {
        currentSize = 0;
        notes = new Note[100];
    }

    //Распечатать в консоль хранимые записи
    public void printRecordsOnConsole(){
        for (int i = 0; i < currentSize; i++)
            System.out.println(notes[i].getData());
    }

    //Добавить запись
    public void addRecord(Note note)
    {
        if (currentSize >= notes.length)
        {
            int newSize = notes.length + 100;
            Note[] temp = new  Note[newSize];

            System.arraycopy( notes, 0, temp, 0, notes.length );

            temp[currentSize++] = note;
            notes = temp;
        }
        else
        {
            notes[currentSize++] = note;
        }
    }

    //Добавить запись
    public void addRecord(String record)
    {
        this.addRecord(new Note(record));
    }

    //Удалить запись
    public void deleteRecord(int indexToDelete)
    {
        //Проверяем выход за гарницу диапазона
        if ((indexToDelete < 0) || (indexToDelete > currentSize - 1)) {
            throw  new IndexOutOfBoundsException("Выход за диапазон массива с записями");
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
    public void replaseRecord(Note newNote, int index)
    {
        //Проверяем выход за гарницу диапазона
        if ((index < 0) || (index > currentSize - 1)) {
            throw  new IndexOutOfBoundsException("Выход за диапазон массива с записями");
        }

        notes[index] = newNote;
    }

    //Редактировать запись
    public void replaseRecord(String newText, int index)
    {
        //Проверяем выход за гарницу диапазона
        if ((index < 0) || (index > currentSize - 1)) {
            throw  new IndexOutOfBoundsException("Выход за диапазон массива с записями");
        }

        notes[index].setData(newText);
    }
}
