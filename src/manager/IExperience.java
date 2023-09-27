package manager;

import java.util.ArrayList;

public interface IExperience<E> {
    public void addExperience(E e);

    public ArrayList<E> showExperience();
}
