package manager;

import model.Intern;

import java.util.ArrayList;

public class InternManager implements IIntern<Intern> {
    ArrayList<Intern> listIntern = new ArrayList<>();

    @Override
    public void addIntern(Intern intern) {
        listIntern.add(intern);
    }

    @Override
    public ArrayList<Intern> showIntern() {
        return listIntern;
    }
}
