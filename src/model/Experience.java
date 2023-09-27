package model;

import java.util.Date;
import java.util.List;

public class Experience extends Employee {
    private int id;
    private int ExpInYear;
    private String ProSkill;

    public Experience(String fullName, Date birthDay, int phone, String email, int employee_type, List<Certificate> certificate_type, int id, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, employee_type, certificate_type);
        this.id = id;
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public Experience(int id, int expInYear, String proSkill) {
        this.id = id;
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public Experience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", ExpInYear=" + ExpInYear +
                ", ProSkill='" + ProSkill + '\'' +
                '}';
    }
}
