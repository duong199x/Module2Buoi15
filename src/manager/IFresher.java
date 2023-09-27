package manager;

import java.util.ArrayList;

public interface IFresher<E> {
    public void addFresher(E e);

    public ArrayList<E> showFresher();
}
