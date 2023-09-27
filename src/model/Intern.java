package model;

import java.util.Date;
import java.util.List;

public class Intern extends Employee {
    private int id;
    private String Majors;
    private int Semester;
    private String University_name;

    public Intern(String fullName, Date birthDay, int phone, String email, int employee_type, List<Certificate> certificate_type, int id, String majors, int semester, String university_name) {
        super(fullName, birthDay, phone, email, employee_type, certificate_type);
        this.id = id;
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }

    public Intern(int id, String majors, int semester, String university_name) {
        this.id = id;
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "id=" + id +
                ", Majors='" + Majors + '\'' +
                ", Semester=" + Semester +
                ", University_name='" + University_name + '\'' +
                '}';
    }
}
