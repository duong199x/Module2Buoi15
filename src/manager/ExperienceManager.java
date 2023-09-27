package manager;

import model.Experience;

import java.util.ArrayList;

public class ExperienceManager implements IExperience<Experience> {
    ArrayList<Experience> listExperience = new ArrayList<>();

    @Override
    public void addExperience(Experience experience) {
        listExperience.add(experience);
    }

    @Override
    public ArrayList<Experience> showExperience() {
        return this.listExperience;
    }
}
