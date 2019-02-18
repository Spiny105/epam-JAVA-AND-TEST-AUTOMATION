import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Notepad note = new Notepad();

        //Добавляем записи в блокнот
        note.addRecord("Запись 0");
        note.addRecord("Запись 1");
        note.addRecord("Запись 2");
        note.addRecord("Запись 3");

        for (Record r : note.getRecords())
        System.out.println(r.getData());

        //Редактируем записи в блокноте
        note.replaseRecord(new Record("Редактируем запись 2"), 2);

        System.out.println("===== После редактирования ====");
        for (Record r : note.getRecords())
            System.out.println(r.getData());

        //Удаляем запись из блокнота
        note.deleteRecord(1);

        System.out.println("===== После удаления ====");
        for (Record r : note.getRecords())
            System.out.println(r.getData());
    }

}
