//*Weekly Assignment: Employee Management System*
//        Problem Statement:
//        You are tasked with creating a simple Employee Management System. The system should be able to perform basic operations on a list of employees. Each employee has the following attributes:
//        Employee ID (unique identifier)
//        Name
//        Position
//        Salary
//        You need to implement the following functionalities:
//        1.Add Employee:
//        -Implement a method to add a new employee to the system.
//        2.Remove Employee:
//        -Implement a method to remove an employee from the system based on their Employee ID.
//        3.Display Employee Information:
//        -Implement a method to display the information of a specific employee based on their Employee ID.
//
//        4.Display All Employees:
//        -Implement a method to display the information of all employees in the system.
//        5.Calculate Total Salary:
//        -Implement a method to calculate and display the total salary of all employees.
//        6.Sort Employees by Salary:
//        -Implement a sorting algorithm to sort the employees based on their salary in ascending order.
//
//        Constraints:
//        The Employee ID should be unique.
//        The system should handle at least 100 employees.
//        Use an appropriate data structure for efficient retrieval and modification of employee information.
//
//        7.Search Employees:
//        -Implement a method to search for employees based on their name, position, or salary range.
//        8.Update Employee Information:
//        -Implement a method to update the information of an existing employee.
//        9.Performance Improvement:
//        -Optimize the data structure and algorithms for better performance, especially for searching and updating operations.
//        10.Serialization:
//        -Implement serialization and deserialization to save and load employee data from a file.
//
//        11.Use Interfaces and Inheritance:
//        -Create an interface for the Employee and different classes for different types of employees (e.g., FullTimeEmployee, PartTimeEmployee) that implement the interface.
//        12.Exception Handling:
//        -Implement proper exception handling for scenarios like invalid inputs, duplicate Employee IDs, etc.
//
//
//
//        This assignment is designed to test your understanding of core Java concepts like classes, objects, methods, data structures, and basic algorithms for sorting. Good luck!
package Weekly_Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee
{
    private int id;
    private String name;
    private String contact;
   public Employee(int id,String name,String contact)
    {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
        //Methods to get the values of data of Employee
        public int getid()
        {
            return id;
        }
        public String getName()
        {
            return name;
        }
        public String getContact()
        {
            return contact;
        }

        //Methods to update values of Employee Data
        public void setid(int id)
        {
            this.id=id;
        }
        public void setName(String name)
        {
            this.name=name;
        }
        public void setContact(String contact)
        {
            this.contact = contact;
        }
        public abstract double calcSalary();

    //To print the object we will override the toString function
    public String toString()
    {
        return "[Id="+getid()+" Name="+getName()+" Mobile No.="+getContact()+" Salary="+calcSalary()+"]";
    }
}
class FullTime extends Employee
{
    private double salary;
    //constructor to initialize the values of FullTime Employee
   public FullTime(int id,String name,String contact,double salary)
    {
        super(id,name,contact);
        this.salary=salary;
    }
    //To update the salary
        public double setSalary(double salary)
        {
            this.salary=salary;
            return salary;
        }

    @Override
   public double calcSalary()
    {
        return salary;
    }
}
class PartTime extends Employee {
    private double salary;
    private int workHours;

    public PartTime(int id, String name, String contact, double salary, int workHours) {
        super(id, name, contact);
        this.salary = salary;
        this.workHours = workHours;
    }
    public double setSalary(double salary)
    {
        this.salary=salary;
        return salary;
    }
    public int setworkHours(int workHours)
    {
        this.workHours=workHours;
        return workHours;
    }

    @Override
    public double calcSalary() {
        return salary * workHours;
    }
}
    class Management
    {

        Scanner sc = new Scanner(System.in);
        private List<Employee> employeeList ;
        public Management()
        {
            employeeList=new ArrayList<>();
        }

        //Methods
        //1. Add Employee
        public void addEmployee(Employee employee)
        {
            employeeList.add(employee);
            System.out.println("Employee Added Successfully");
        }

        //2. Remove Employee
        public  void removeEmployee(int id)
        {
            Employee employeetoRemove= null;
            for(Employee employee: employeeList)
            {
                if(employee.getid()==id)
                {
                    employeetoRemove=employee;
                    break;
                }
            }
            employeeList.remove(employeetoRemove);
            System.out.println("Employee is removed successfully");
        }

        //3 Display a specific Employee Information
        public void displayEmployeeinfo(int id)
        {
            Employee employeetoDisplay=null;
            for(Employee employee : employeeList)
            {
                if(employee.getid()==id)
                {
                    employeetoDisplay=employee;
                    break;
                }
            }
            System.out.println("Id = "+employeetoDisplay);
        }

        //4. Display All Employees
        public void displayAllEmployees()
        {
            System.out.println("All the Employees are: ");
            for(Employee employee : employeeList)
            {
                System.out.println(employee);
            }
        }
        //5. Update the information of Employee
        public void updateInfo(int id)
        {
            Employee employeetoUpdate = null;
            FullTime fullt=null;
            PartTime pt=null;
            for(Employee employee: employeeList)
            {
                if (employee.getid() == id) {
                    employeetoUpdate = employee;
//                    fullt = (FullTime) employee;
//                    pt = (PartTime) employee;
                    break;
                }
            }
                while(true)
                {
                    System.out.println("Update");
                    System.out.println("0. Exit");
                    System.out.println("1. Name");
                    System.out.println("2. Contact");
                    int n=sc.nextInt();
                    if(n==0)
                    {
                        System.out.println("Updation Done");
                        break;
                    }
                    switch (n)
                    {
                        case 1:
                        {
                            System.out.println("Enter new Name");
                            sc.nextLine();
                            String name=sc.nextLine();
                            employeetoUpdate.setName(name);
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Enter new Contact");
                            String contact = sc.next();
                            employeetoUpdate.setContact(contact);
                            break;
                        }

                        default:
                            System.out.println("You have entered invalid Option");
                    }
                }
        }

        //6. Update the salary of employee
        public void updateSalary(int id)
        {
            System.out.println("Enter Type of Customer Salary");
            System.out.println("1. Full Time");
            System.out.println("2. Part Time");
            int n1=sc.nextInt();

            if(n1==1)
            {
                System.out.println("Enter new salary");
                double salary= sc.nextDouble();
                FullTime fullt=null;
                for(Employee employee : employeeList)
                {
                    if(employee.getid()==id)
                    {
                        fullt=(FullTime) employee;
                        fullt.setSalary(salary);
                    }
                    else
                    {
                        System.out.println("The employee is not present");
                    }
                }
                System.out.println("Salary after updation");
            }
            else if(n1==2)
            {
                PartTime pt = null;
                System.out.println("Enter new salary");
                double salary = sc.nextDouble();
                System.out.println("Enter the no. of hours work done");
                int workhours= sc.nextInt();
                for(Employee employee : employeeList)
                {
                    if(employee.getid()==id)
                    {
                        pt=(PartTime)employee;
                        break;
                    }
                    else
                    {
                        System.out.println("The employee is not present");
                    }
                }
                if(pt!=null)
                {
                    pt.setSalary(salary);
                    pt.setworkHours(workhours);
                }
                else if(pt==null)
                {
                    System.out.println("This id employee is Full Time Employee");
                }
                System.out.println("Salary after updation");
            }
            else
            {
                System.out.println("You have Entered a wrong Input");
            }
        }

        //7. Calculate Total Annual Salary
        public double totalSalary(int id)
        {
            Employee emptofindtotalsal=null;
            for(Employee employee: employeeList)
            {
                if(employee.getid()==id)
                {
                    emptofindtotalsal=employee;
                }
            }
            double msal=emptofindtotalsal.calcSalary();
            double total= msal*12;
            return total;
        }
    }

public class Employee_Mngment
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        Management mng=new Management();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");

        while(true)
        {
            int n=enter();
            if(n==0)
            {
                System.out.println("Exiting");
                break;
            }
            switch(n)
            {
                case 1:
                {
                    Employee employee=adde();
                    mng.addEmployee(employee);
//                    enter();
                    break;
                }
                case 2:
                {
                    System.out.println("Enter id of employee whom you want to remove");
                    int id= sc.nextInt();
                    mng.removeEmployee(id);
//                    enter();
                    break;
                }
                case 3:
                {
                    System.out.println("Enter id of Emoloyee whome Information you want to display");
                    int id=sc.nextInt();
                    mng.displayEmployeeinfo(id);
//                    enter();
                    break;
                }
                case 4:
                {
                    mng.displayAllEmployees();
//                    enter();
                    break;
                }
                case 5:
                {
                    System.out.println("Enter id of employee whome information you want to change");
                    int id=sc.nextInt();
                    mng.updateInfo(id);
                    System.out.println("New Information is: ");
                    mng.displayEmployeeinfo(id);
                    break;
                }
                case 6:
                {
                    System.out.println("Enter the id whose salary you want to edit");
                    int id=sc.nextInt();
                    mng.updateSalary(id);
                    mng.displayEmployeeinfo(id);
                    break;
                }
                case 7:
                {
                    System.out.println("Enter the id of employee whose total Annual Salary you want to calculate");
                    int id=sc.nextInt();
                    System.out.println("Annually Salary of Employee is");
                    System.out.println(mng.totalSalary(id));
                }
                default:
                    System.out.println("You have Entered an Invalid Option");
                    break;
            }
        }

    }

    public static Employee adde()
    {
        System.out.println("Choose one option");
        System.out.println("1. Add Full Time Employee");
        System.out.println("2. Add Part Time Employee");
        int n=sc.nextInt();
        Employee employee = null;
        if(n==1)
        {
            System.out.println("Enter an id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name of Employee");
            String name=sc.nextLine();
            System.out.println("Enter the phone no.");
            String contact=sc.next();
            System.out.println("Enter salary per month");
            double salary=sc.nextDouble();
             employee= new FullTime(id,name,contact,salary) ;
        }
        else if(n==2)
        {
            System.out.println("Enter an id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name of Employee");
            String name=sc.nextLine();
            System.out.println("Enter the phone no.");
            String contact=sc.next();
            System.out.println("Enter salary per month");
            double salary=sc.nextDouble();
            System.out.println("Enter the no. of hours when worked");
            int workhour=sc.nextInt();
            employee= new PartTime(id,name,contact,salary,workhour) ;
        }
        return employee;
    }
    public static int enter()
    {
        System.out.println("Select one option");
        System.out.println("0. Exit");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Display Employee Information");
        System.out.println("4. Display All Employees Info");
        System.out.println("5. Update Employee Info");
        System.out.println("6. Change Salary of Employee");
        System.out.println("7. Calculate Total Salary ");
        int n=sc.nextInt();
        return n;
    }
}
