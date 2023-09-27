package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private int ID;
    private String FullName;
    private Date BirthDay;
    private int Phone;
    private String Email;
    private int Employee_type;
    private static int Employee_count = 0;
    private List<Certificate> certificate_type = new ArrayList<>();

    public Employee(String fullName, Date birthDay, int phone, String email, int employee_type, List<Certificate> certificate_type) {
        this.ID = ++Employee_count;
        this.FullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.Email = email;
        this.Employee_type = employee_type;
        this.certificate_type = certificate_type;
    }

    public Employee(String fullName, Date birthDay, int phone, String email, int employee_type) {
        this.ID = ++Employee_count;
        this.FullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.Email = email;
        this.Employee_type = employee_type;
    }

    public Employee(int id,String fullName, Date birthDay, int phone, String email, int employee_type, List<Certificate> certificate_type) {
        this.ID = ++Employee_count;
        this.FullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.Email = email;
        this.Employee_type = employee_type;
        this.certificate_type = certificate_type;
    }

    public Employee() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getEmployee_type() {
        return Employee_type;
    }

    public void setEmployee_type(int employee_type) {
        Employee_type = employee_type;
    }

    public List<Certificate> getCertificate_type() {
        return certificate_type;
    }

    public void setCertificate_type(List<Certificate> certificate_type) {
        this.certificate_type = certificate_type;
    }

    public String SelectEmployeeType() {
        if (Employee_type == 0) {
            return "Experience";
        } else if (Employee_type == 1) {
            return "Fresher";
        } else if (Employee_type == 2) {
            return "Intern";
        }
        return null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", FullName='" + FullName + '\'' +
                ", BirthDay=" + (new SimpleDateFormat("dd-MM-yyyy").format(BirthDay)) +
                ", Phone=" + Phone +
                ", Email='" + Email + '\'' +
                ", Employee_type=" + SelectEmployeeType() +
                ", certificate_type=" + certificate_type.size() +
                '}';
    }
}
