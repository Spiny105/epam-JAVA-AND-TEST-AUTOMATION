import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilmTest {

    Film film;

    @Test
    public void getName() {

        String expectedName = "Armageddon";
        film = new Film(expectedName);
        assertEquals("getName method failure", film.getName(), expectedName);
    }

    @Test
    public void setName() {
        String expectedName = "Winnie the Pooh";
        String initialName = "Armageddon";
        film = new Film(initialName);
        film.setName(expectedName);
        assertEquals("setName method failure", film.getName(), expectedName);
    }

    @Test
    public void addActor() {
        film = new Film("Armageddon");
        Actor actorToAdd = new Actor("Chris", 30);

        int initialNumberOfActors = film.getActors().size();

        film.addActor(actorToAdd);
        List<Actor> collectionAfterAdding = film.getActors();

        assertEquals("More or less than one element was added", collectionAfterAdding.size(), initialNumberOfActors + 1);
        assertTrue("The collection of actors does not contain the added element",collectionAfterAdding.contains(actorToAdd));
    }

    @Test
    public void clearActors() {
        film = new Film("Armageddon");
        film.addActor(new Actor("Chris", 30));
        film.addActor(new Actor("Nikolas", 25));
        film.addActor(new Actor("German", 37));
        film.addActor(new Actor("Doris", 24));
        film.clearActors();
        assertTrue("Collection of actors is not empty", film.getActors().size() == 0);
    }

    @Test
    public void removeActor() {

        Actor actorToRemove = new Actor("Doris", 24);
        Actor actorToAdd_1 = new Actor("Chris", 30);
        Actor actorToAdd_2 = new Actor("Nikolas", 25);
        Actor actorToAdd_3 = new Actor("German", 37);

        film = new Film("Armageddon");
        film.addActor(actorToAdd_1);
        film.addActor(actorToAdd_2);
        film.addActor(actorToAdd_3);
        film.addActor(actorToRemove);

        film.removeActor(actorToRemove);
        List<Actor> collectionAfterRemovingActor = film.getActors();
        assertFalse("Removed actor is still contains in collection of actors", collectionAfterRemovingActor.contains(actorToRemove));
        assertTrue("Wrong element removed", collectionAfterRemovingActor.contains(actorToAdd_1));
        assertTrue("Wrong element removed", collectionAfterRemovingActor.contains(actorToAdd_2));
        assertTrue("Wrong element removed", collectionAfterRemovingActor.contains(actorToAdd_3));
    }

    @Test
    public void getActors() {

        film = new Film("Armageddon");
        film.clearActors();

        List<Actor> actorsToAdd = new ArrayList<>();
        actorsToAdd.add(new Actor("Chris", 30));
        actorsToAdd.add(new Actor("Chris", 24));
        actorsToAdd.add(new Actor("Chris", 27));

        for (Actor actorToAdd: actorsToAdd) {
            film.addActor(actorToAdd);
        }

        List<Actor> actorsCollectionInFilm = film.getActors();
        for (Actor actor: actorsToAdd) {
            assertTrue("getActorsFailure. Not all added actors contains in collection", actorsCollectionInFilm.contains(actor));
        }

        assertEquals("Wrong number of actors", actorsToAdd, actorsCollectionInFilm);
    }
}