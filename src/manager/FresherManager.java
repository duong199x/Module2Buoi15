package manager;

import model.Fresher;

import java.util.ArrayList;

public class FresherManager implements IFresher<Fresher> {
    ArrayList<Fresher> listFreshers = new ArrayList<>();

    @Override
    public void addFresher(Fresher fresher) {
        listFreshers.add(fresher);
    }

    @Override
    public ArrayList<Fresher> showFresher() {
        return listFreshers;
    }
}
