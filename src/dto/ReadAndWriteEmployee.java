package dto;

import model.Certificate;
import model.Employee;

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
    File file = new File("data/Employee.csv");

    public void writeFile(ArrayList<Employee> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Employee employee : list
            ) {
                line += employee.getID() + "," + employee.getFullName() + "," + employee.getBirthDay() + "," + employee.getPhone() + "," + employee.getEmail() + "," + employee.getEmployee_type() + "," + employee.getCertificate_type().size() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public ArrayList<Employee> readFile() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
//                List<Certificate> cers = new ArrayList<Certificate>((Arrays.asList(data[6].split(","))));
//                Employee employee = new Employee(Integer.parseInt(data[0]), data[1],df.parse(data[2]) , Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), new ArrayList<Certificate>);
//                list.add(employee);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        return list;
    }
}
