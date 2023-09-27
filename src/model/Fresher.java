package model;

import java.util.Date;
import java.util.List;

public class Fresher extends Employee {
    private int id;
    private Date Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher(String fullName, Date birthDay, int phone, String email, int employee_type, List<Certificate> certificate_type, int id, Date graduation_date, String graduation_rank, String education) {
        super(fullName, birthDay, phone, email, employee_type, certificate_type);
        this.id = id;
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    public Fresher(int id, Date graduation_date, String graduation_rank, String education) {
        this.id = id;
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(Date graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "id=" + id +
                ", Graduation_date=" + Graduation_date +
                ", Graduation_rank='" + Graduation_rank + '\'' +
                ", Education='" + Education + '\'' +
                '}';
    }
}
