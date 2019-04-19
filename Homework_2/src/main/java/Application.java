import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static  boolean exitRequared = false;
    static List<Film> filmCollection = new ArrayList<>();
    //Loop counter
    static int i = 0;

    static String controlString;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        try {
            loadFilmCollection();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Can't read film collection from file.\n" + e.getMessage());
        }

        while (true) {

            showMainMenu();
            controlString = scanner.nextLine();
            switch (controlString){
                case "e":
                    exitRequared = true;
                    break;

                case "a":
                    addNewFilm();
                    break;

                default:
                    if (isDigit(controlString)){
                        int filmIndex = Integer.parseInt(controlString);
                        showModifyMenu();

                        controlString = scanner.nextLine();

                        if (isDigit(controlString)){
                            Film film = filmCollection.get(filmIndex);
                            switch (controlString){
                                case "1":
                                    System.out.println("Enter new name of film");
                                    String newFIlmName = scanner.nextLine();
                                    film.setName(newFIlmName);
                                    break;
                                case "2":
                                    System.out.println("Enter name of actor");
                                    String nameOfActorToadd = scanner.nextLine();
                                    System.out.println("Enter the age of actor");
                                    int ageOfActorToAdd = scanner.nextInt();
                                    film.addActor(new Actor(nameOfActorToadd, ageOfActorToAdd));
                                    break;
                                case "3":
                                    System.out.println("Enter name of actor");
                                    String nameOfActorToRemove = scanner.nextLine();
                                    System.out.println("Enter the age of actor");
                                    int ageOfActorToRemove = scanner.nextInt();
                                    film.removeActor(new Actor(nameOfActorToRemove, ageOfActorToRemove));
                                    break;
                                case "4":
                                    for (Actor actor : film.getActors()){
                                        System.out.format("Actor %s. Age: %d\n", actor.getName(), actor.getAge());
                                    }
                                    break;
                            }
                        }
                    }
                    break;
            }

            if (exitRequared) {
                break;
            }
        }

        try {
            saveFilmCollection();
        }
        catch(IOException e) {
            System.out.println("Can't save film collection in file\n" + e.getMessage());
            return;
        }

    }

    private static void showMainMenu(){
        System.out.println("");
        System.out.println("Enter \"a\" to add new film");
        System.out.println("Enter \"e\" to exit");
        System.out.println("Select film:");

        i = 0;
        for (Film film :
                filmCollection) {
            System.out.format("%d - %s\n", i++, film.getName());
        }
    }

    private static void addNewFilm(){
        System.out.println("Enter the name of film");
        String name = scanner.nextLine();
        filmCollection.add(new Film(name));
    }

    private static boolean isDigit(String string){
        return  string.matches("[-+]?\\d+");
    }

    private static void showModifyMenu(){
        System.out.println("");
        System.out.println("Enter \"1\" to change name");
        System.out.println("Enter \"2\" to add actor");
        System.out.println("Enter \"3\" to remove actor");
        System.out.println("Enter \"4\" to show actors");
    }

    private static void saveFilmCollection() throws IOException{
            try(FileOutputStream fileOutputStream = new FileOutputStream("temp.out")) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(filmCollection);
                objectOutputStream.flush();
                objectOutputStream.close();
            }
    }

    private static void loadFilmCollection() throws IOException, ClassNotFoundException{
        try(FileInputStream fileInputStream = new FileInputStream("temp.out")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            filmCollection = (ArrayList<Film>) objectInputStream.readObject();
        }
    }

}
