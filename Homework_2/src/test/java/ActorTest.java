import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {

    Actor actor;

    @Test
    public void getAgeTest() {
        int expectedAge = 30;

        actor = new Actor("Chris", expectedAge);
        assertEquals("getAge method failure", expectedAge, actor.getAge());
    }

    @Test
    public void setAgeTest() {
        int initialAge = 20;
        actor = new Actor("Chris", initialAge);

        int expectedAge = 30;
        actor.setAge(expectedAge);
        assertEquals("setAge method failure", expectedAge, actor.getAge());
    }

    @Test
    public void getNameTest() {
        int initialAge = 30;
        String expectedName = "Chris";

        actor = new Actor(expectedName, initialAge);
        assertEquals("getName method failure", expectedName, actor.getName());
    }

    @Test
    public void setNameTest() {
        int initialAge = 30;
        String initialName = "Tom";
        String expectedName = "Chris";

        actor = new Actor(initialName, initialAge);
        actor.setName(expectedName);
        assertEquals("setName method failure", expectedName, actor.getName());
    }

    @Test
    public void setNullNameTest(){
        int initialAge = 30;
        String initialName = null;

        actor = new Actor(initialName, initialAge);
        assertEquals("Actor name is not empty","", actor.getName().toString());
    }
}