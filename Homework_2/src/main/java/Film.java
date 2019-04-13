import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable{

    private String name;
    private List<Actor> actors = new ArrayList<>();

    public Film(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null) ? ("") : (name);
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    public void clearActors(){
        actors.clear();
    }

    public void removeActor(final Actor actor){
        actors.removeIf(x -> (x.getAge() == actor.getAge()) && (x.getName().equals(actor.getName())));
    }

    public  List<Actor> getActors(){
        return  new ArrayList<Actor>(actors);
    }

}
