import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {

    Actor actor;

    @Test
    public void getAge() {
        int expectedAge = 30;

        actor = new Actor("Chris", expectedAge);
        assertEquals("getAge method failure", actor.getAge(), expectedAge);
    }

    @Test
    public void setAge() {
        int initialAge = 20;
        actor = new Actor("Chris", initialAge);

        int expectedAge = 30;
        actor.setAge(expectedAge);
        assertEquals("setAge method failure", actor.getAge(), expectedAge);
    }

    @Test
    public void getName() {
        int initialAge = 30;
        String expectedName = "Chris";

        actor = new Actor(expectedName, initialAge);
        assertEquals("getName method failure", actor.getName(), expectedName);
    }

    @Test
    public void setName() {
        int initialAge = 30;
        String initialName = "Tom";
        String expectedName = "Chris";

        actor = new Actor(initialName, initialAge);
        actor.setName(expectedName);
        assertEquals("setName method failure", actor.getName(), expectedName);
    }
}