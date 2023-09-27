package view;

import manager.EmployeeManager;
import manager.ExperienceManager;
import manager.FresherManager;
import manager.InternManager;
import model.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    Scanner inputDate = new Scanner(System.in);
    SimpleDateFormat dB = new SimpleDateFormat("dd-MM-yyyy");
    EmployeeManager listEmployee = new EmployeeManager();
    ExperienceManager listExperience = new ExperienceManager();
    FresherManager listFresher = new FresherManager();
    InternManager listIntern = new InternManager();

    public void MainMenu() {
        int choice;
        do {
            System.out.println("===Menu===\n1.Thêm nhân viên\n2.Sửa nhân viên\n3.Xóa nhân viên\n4.Hiển thị thông tin cơ bản của nhân viên\n5.Hiển thị thông tin chi tiết của nhân viên\n6.Tìm tất cả các nhân viên experience\n7.Tìm tất cả các nhân viên fresher\n8.Tìm tất cả các nhân viên intern\n9.Thêm bằng cấp cho nhân viên\n10.Hiển thị bằng cấp nhân viên\n0.Thoát");
            System.out.println("nhập lựa chọn:");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAddEmployee();
                    break;
                case 2:
                    showMenuEditEmployee();
                    break;
                case 3:
                    showMenuDeleteEmployee();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showDetailEmployee();
                    break;
                case 6:
                    showAllExperience();
                    break;
                case 7:
                    showAllFresher();
                    break;
                case 8:
                    showAllIntern();
                    break;
                case 9:
                    showAddCertificateEmployee();
                    break;
                case 10:
                    showCertificateEmployee();
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAddEmployee() {
        System.out.println("===Menu Add===");
        System.out.println("Nhập tên:");
        String name = inputString.nextLine();
        System.out.println("Nhập ngày tháng năm sinh:");
        Date dateBirth;
        try {
            dateBirth = dB.parse(inputDate.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nhập số điện thoại");
        int phoneNumber = inputInt.nextInt();
        System.out.println("Nhập email:");
        String email = inputString.nextLine();
        System.out.println("Chọn loại nhân viên:");
        System.out.println("0.Experience\n1.Fresher\n2.Intern");
        int choice;
        choice = inputInt.nextInt();
        switch (choice) {
            case 0: {
                System.out.println("===Experience Add Menu===");
                System.out.println("Số năm kinh nghiệm:");
                int ExpInYear = inputInt.nextInt();
                System.out.println("Kỹ năng chuyên môn ");
                String ProSkill = inputString.nextLine();
                Employee newEmPloyee = new Employee(name, dateBirth, phoneNumber, email, choice);
                listEmployee.addEmployee(newEmPloyee);
                Experience newExperience = new Experience(newEmPloyee.getID(), ExpInYear, ProSkill);
                listExperience.addExperience(newExperience);
                System.out.println("===> Thêm nhân viên Experience thành công");
            }
            break;
            case 1: {
                System.out.println("===Fresher Add Menu===");
                System.out.println("Thời gian tốt nghiệp:");
                Date Graduation_dateDate;
                try {
                    Graduation_dateDate = dB.parse(inputDate.nextLine());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Xếp loại tốt nghiệp:");
                String Graduation_rank = inputString.nextLine();
                System.out.println("Trường tốt nghiệp:");
                String Education = inputString.nextLine();
                Employee newEmPloyee = new Employee(name, dateBirth, phoneNumber, email, choice);
                listEmployee.addEmployee(newEmPloyee);
                Fresher newFresher = new Fresher(newEmPloyee.getID(), Graduation_dateDate, Graduation_rank, Education);
                listFresher.addFresher(newFresher);
                System.out.println("===> Thêm nhân viên Fresher thành công");
            }
            break;
            case 2: {
                System.out.println("===Intern Add Menu===");
                System.out.println("Chuyên ngành đang học:");
                String Majors = inputString.nextLine();
                System.out.println("Học kì đang học:");
                int Semester = inputInt.nextInt();
                System.out.println("Tên trường đang học:");
                String University_name = inputString.nextLine();
                Employee newEmPloyee = new Employee(name, dateBirth, phoneNumber, email, choice);
                listEmployee.addEmployee(newEmPloyee);
                Intern newIntern = new Intern(newEmPloyee.getID(), Majors, Semester, University_name);
                listIntern.addIntern(newIntern);
                System.out.println("===> Thêm nhân viên Intern thành công");
            }
            break;
        }
    }

    public void showMenuEditEmployee() {
        System.out.println("===Menu Edit===");
        System.out.println("Nhập id nhân viên muốn sửa:");
        int idEdit = inputInt.nextInt();
        Employee employeeEdit = listEmployee.findEmployee(idEdit);
        System.out.println("Nhập tên:");
        String name = inputString.nextLine();
        System.out.println("Nhập ngày tháng năm sinh:");
        Date dateBirth;
        try {
            dateBirth = dB.parse(inputDate.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nhập số điện thoại");
        int phoneNumber = inputInt.nextInt();
        System.out.println("Nhập email:");
        String email = inputString.nextLine();
        Employee newEmployee = new Employee(name, dateBirth, phoneNumber, email, employeeEdit.getEmployee_type(), employeeEdit.getCertificate_type());
        listEmployee.editEmployee(idEdit, newEmployee);
    }

    public void showMenuDeleteEmployee() {
        System.out.println("===Delete Menu===");
        System.out.println("Nhập id muốn xóa");
        int idDelete = inputInt.nextInt();
        listEmployee.deleteEmployee(idDelete);
    }

    public void showAll() {
        ArrayList<Employee> newList = listEmployee.showEmployee();
        for (Employee item : newList
        ) {
            System.out.println(item);
        }
    }

    public void showDetailEmployee() {
        System.out.println("danh sách nhân viên");
        showAll();
        System.out.println("chọn id nhân viên muốn hiển thị");
        int choiceEmployee = inputInt.nextInt();
        ArrayList<Employee> newList = listEmployee.showEmployee();
        //Hiển thị theo Experience
        for (Employee item : newList
        ) {
            if (choiceEmployee == item.getID() && item.getEmployee_type() == 0) {
                ArrayList<Experience> newListExperience = listExperience.showExperience();
                for (Experience experience : newListExperience
                ) {
                    if (item.getID() == experience.getId()) {
                        System.out.println(experience);

                    }
                }
            }
        }
        //Hiển thị theo Fresher
        for (Employee item : newList
        ) {
            if (choiceEmployee == item.getID() && item.getEmployee_type() == 1) {
                ArrayList<Fresher> newListFresher = listFresher.showFresher();
                for (Fresher fresher : newListFresher
                ) {
                    if (item.getID() == fresher.getId()) {
                        System.out.println(fresher);

                    }
                }
            }
        }
        //Hiển thị theo Intern
        for (Employee item : newList
        ) {
            if (choiceEmployee == item.getID() && item.getEmployee_type() == 2) {
                ArrayList<Intern> newListIntern = listIntern.showIntern();
                for (Intern intern : newListIntern
                ) {
                    if (item.getID() == intern.getId()) {
                        System.out.println(intern);

                    }
                }
            }
        }
    }

    public void showAllExperience() {
        ArrayList<Employee> newList = listEmployee.showEmployee();
        for (Employee item : newList
        ) {
            if (item.getEmployee_type() == 0) {
                System.out.println(item);
            }

        }
    }

    public void showAllFresher() {
        ArrayList<Employee> newList = listEmployee.showEmployee();
        for (Employee item : newList
        ) {
            if (item.getEmployee_type() == 1) {
                System.out.println(item);
            }

        }
    }

    public void showAllIntern() {
        ArrayList<Employee> newList = listEmployee.showEmployee();
        for (Employee item : newList
        ) {
            if (item.getEmployee_type() == 2) {
                System.out.println(item);
            }

        }
    }

    public void showAddCertificateEmployee() {
        showAll();
        System.out.println("Nhập id nhân viên muốn thêm:");
        int idAdd = inputInt.nextInt();
        Employee findEmployee = listEmployee.findEmployee(idAdd);
        System.out.println("nhập certificatedID");
        int certificatedID = inputInt.nextInt();
        System.out.println("certificateName");
        String certificateName = inputString.nextLine();
        System.out.println("certificateRank");
        int certificateRank = inputInt.nextInt();
        System.out.println("certificatedDate");
        String certificatedDate = inputString.nextLine();
        Certificate newCertificate = new Certificate(certificatedID, certificateName, certificateRank, certificatedDate);
        List<Certificate> listCertificate = findEmployee.getCertificate_type();
        listCertificate.add(newCertificate);
        findEmployee.setCertificate_type(listCertificate);
    }

    public void showCertificateEmployee() {
        showAll();
        System.out.println("nhập id muốn xem bằng cấp");
        int idAdd = inputInt.nextInt();
        Employee findEmployee = listEmployee.findEmployee(idAdd);
        List<Certificate> listCertificate = findEmployee.getCertificate_type();
        for (Certificate certificate : listCertificate
        ) {
            System.out.println(certificate);
        }
    }
}
