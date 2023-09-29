package dto;

import jdk.nashorn.internal.parser.JSONParser;
import manager.ExperienceManager;
import model.*;

import java.io.*;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReadAndWriteEmployee {
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    File file = new File("data/Employee.csv");

    public void writeFile(ArrayList<Employee> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Employee employee : list
            ) {
                line += employee.getID() + "," + employee.getFullName() + "," + df.format(employee.getBirthDay()) + "," + employee.getPhone() + "," + employee.getEmail() + "," + writeEmployeeType(employee) + ",Certificate" + ", " + writeCertificate(employee) + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String writeCertificate(Employee employee) {
        String str = "";
        for (Certificate certificate : employee.getCertificate_type()
        ) {
            str += certificate.getCertificatedID() + "," + certificate.getCertificateName() + "," + certificate.getCertificateRank() + "," + certificate.getCertificatedDate() + ";";
        }
        return str;
    }

    public String writeEmployeeType(Employee employee) {
        if (employee.getEmployee_type() == 0) {
            return "Experience";
        }
        if (employee.getEmployee_type() == 1) {
            return "Fresher";
        }
        if (employee.getEmployee_type() == 2) {
            return "Intern";
        }
        return null;
    }



    public ArrayList<Employee> readFile() {
        ArrayList<Employee> list = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",Certificate,");
                String[] firstData = data[0].split(",");
                System.out.println(data[0]);
                Employee employee = new Employee(Integer.parseInt(firstData[0]), firstData[1], df.parse(firstData[2]), Integer.parseInt(firstData[3]), firstData[4], readEmployeeType(firstData[5]), readCertificate(data[1]));
                list.add(employee);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int readEmployeeType(String str) {
        int i;
        if (str.equals("Experience")) {
            return i = 0;
        } else if (str.equals("Fresher")) {
            return i = 1;
        } else {
            return i = 2;
        }
    }

    public List<Certificate> readCertificate(String str) {
        List<Certificate> certificateList = new ArrayList<>();
        String[] newStrArr = str.split(";");
        for (String string : newStrArr
        ) {
            if (string != null && !string.equals(" ")) {
                String[] StringData = string.split(",");
                Certificate certificate = new Certificate(Integer.parseInt(StringData[0].trim()), StringData[1], Integer.parseInt(StringData[2]), StringData[3]);
                certificateList.add(certificate);
            }
        }
        return certificateList;
    }
}
