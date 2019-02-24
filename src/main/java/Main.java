public class Main {

    public static void main(String[] args) {
        //Test notepad instance
        Notepad notepad = new Notepad();

        //Delete one note
        notepad.addNote("Test note","Some text");
        System.out.println(notepad.toString());

        if (!notepad.deleteNote(0)) {
            System.out.println("===== Error occurred ====");
        }
        System.out.println("===== After deleting test note ====");
        System.out.println(notepad.toString());

        //add 110 notes in notepad
        for (int i = 0; i < 110; i++) {
            if (!notepad.addNote("Header " + i, "Text " + i)) {
                System.out.println("===== Error occurred ====");
            }
        }

        System.out.println("===== After adding notes in notepad ====");
        System.out.println(notepad.toString());

        //Edit note 2
        if (!notepad.replaseNote(new Note("New header for note 2", "New text for note 2"), 2)) {
            System.out.println("===== Error occurred ====");
        }
        System.out.println("===== After editing note 2 in notepad ====");
        System.out.println(notepad.toString());

        //Delete las note
        if (!notepad.deleteNote(notepad.getCurrentSize() - 1)) {
            System.out.println("===== Error occurred ====");
        }
        System.out.println("===== After deleting the last note ====");
        System.out.println(notepad.toString());


        //Delete penultimate note
        if (!notepad.deleteNote(notepad.getCurrentSize() - 2)) {
            System.out.println("===== Error occurred ====");
        }
        System.out.println("===== After deleting penultimate note ====");
        System.out.println(notepad.toString());


        //Delete 30 notes
        for (int i = 0; i < 30; i++) {
            if (!notepad.deleteNote(3)) {
                System.out.println("===== Error occurred ====");
            }
        }

        System.out.println("===== After removing 30 notes ====");
        System.out.println(notepad.toString());

        //Delete note with wrong index
        System.out.println("===== Deleting with wrong index (index = 200) ====");
        if (!notepad.deleteNote(200)) {
            System.out.println("===== Error occurred ====");
        }
        System.out.println(notepad.toString());
    }

}
