public class Notepad {

    Record[] records;

    public Notepad(Record[] records) {
        this.records = records;
    }

    public Notepad() {
    }

    //Получить записи, хрнимые в болокноте
    public Record[] getRecords() {
        return records;
    }

    //Добавить запись
    public void addRecord(Record record)
    {
        Record[] temp;

        if (records == null) {
            temp = new Record[]{record};
        }
        else {
            temp = new Record[records.length + 1];

            for (int i = 0; i < records.length; i++)
            {
                temp[i] = records[i];
            }

            temp[temp.length - 1] = record;
        }

        records = temp;
    }

    //Добавить запись
    public void addRecord(String record)
    {
        this.addRecord(new Record(record));
    }

    //Ударить запись
    public void deleteRecord(int indexToDelete)
    {
        //Если выход за границу диапазона
        if ( (records == null) || (records.length - 1 < indexToDelete) || (indexToDelete < 0) ) {
            return;
        }

        //Обработка случая, когда длянна массива равна 1
        if (records.length == 1)
        {
            records = null;
            return;
        }

        Record[] temp = new Record[records.length - 1];

        for (int i = 0; i < indexToDelete; i++){
            temp[i] = records[i];
        }

        for (int i = indexToDelete + 1; i < records.length; i++)
        {
            temp[i - 1] = records[i];
        }

        records = temp;
    }

    //Редактировать запись
    public void replaseRecord(Record newRecord, int index)
    {
        //Если выход за границу диапазона
        if ( (records == null) || (records.length - 1 < index) || (index < 0) ) {
            return;
        }

        records[index] = newRecord;
    }

    //Редактировать запись
    public void replaseRecord(String newRecord, int index)
    {
        replaseRecord(new Record(newRecord), index);
    }
}
