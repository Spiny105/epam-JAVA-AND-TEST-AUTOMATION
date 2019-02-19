public class Main {

    public static void main(String[] args)
    {
        //Объект для проверки работоспособности
        Notepad notepad = new Notepad();

        //Проверка удаления одной записис из начала блокнота
        notepad.addRecord("Тестовая запись ");
        notepad.printRecordsOnConsole();
        System.out.println("===== После удаления тестовой записи ====");
        notepad.deleteRecord(0);
        notepad.printRecordsOnConsole();

        //Добавляем записи в
        for (int i = 0; i < 110; i++)
            notepad.addRecord("Запись " + i);

        System.out.println("===== После добавления ====");
        notepad.printRecordsOnConsole();

        //Редактируем записи в блокноте
        notepad.replaseRecord(new Note("Редактируем запись 2"), 2);

        System.out.println("===== После редактирования ====");
        notepad.printRecordsOnConsole();

        //Удаляем запись из блокнота
        for (int i = 0; i < 30; i++)
            notepad.deleteRecord(3);

        System.out.println("===== После удаления ====");
        notepad.printRecordsOnConsole();
    }

}
