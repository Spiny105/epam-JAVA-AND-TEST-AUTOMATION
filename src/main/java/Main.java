public class Main {

    public static void main(String[] args)
    {
        Notepad notepad = new Notepad();

        //Добавляем записи в блокнот
        notepad.addRecord("Запись 0");
        notepad.addRecord("Запись 1");
        notepad.addRecord("Запись 2");
        notepad.addRecord("Запись 3");

        System.out.println("===== После добавления ====");
        notepad.printRecordsOnConsole();

        //Редактируем записи в блокноте
        notepad.replaseRecord(new Record("Редактируем запись 2"), 2);

        System.out.println("===== После редактирования ====");
        notepad.printRecordsOnConsole();

        //Удаляем запись из блокнота
        notepad.deleteRecord(1);

        System.out.println("===== После удаления ====");
        notepad.printRecordsOnConsole();
    }

}
