package ml.cloverkit.innerclasses.control;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
