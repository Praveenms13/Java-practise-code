import java.util.ArrayList;
import java.util.List;
import java.io.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee id: "
                + id
                + ", Name: "
                + name
                + ", Department: "
                + department
                + ", Salary"
                + salary;
    }
}
class EmployeeDemo {
    private static final String FILE_NAME = "employee.ser";
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Praveen", "CSE", 10000));
        employeeList.add(new Employee(1, "Praveen 1", "ECE", 20000));
        employeeList.add(new Employee(1, "Praveen 2", "EEE", 30000));
        serializeEmployees(employeeList);
        List<Employee> deserializedEmployees = deSerializeEmployees();
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }
    private static void serializeEmployees(List<Employee> employeeList){
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
        } catch (Exception e) {
            System.out.println("Error while Serializing: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing stream: " + e.getMessage());
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    private static List<Employee> deSerializeEmployees() throws IOException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File not found...");
            }
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            employees = (List<Employee>) ois.readObject();
        } catch (IOException e){
            System.out.println("Error while DeSerializing: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                  ois.close();
                } catch (IOException e) {
                    System.out.println("Error closing stream: " + e.getMessage());
                }
            }
        }
        return employees;
    }
}