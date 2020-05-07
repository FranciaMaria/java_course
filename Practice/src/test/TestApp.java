package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import patterns.Employee;
import patterns.MyCalendar;

public class TestApp {

    public static void main(String[] args) {
        // write your code here
        MyCalendar mc1 = MyCalendar.getInstance();
        mc1.setDay(20);
        mc1.setMonth(5);
        mc1.setYear(2020);

        MyCalendar mc2 = MyCalendar.getInstance();

        System.out.println(mc2.getDay() + "." + mc2.getMonth() + "." + mc2.getYear() + ".");

        Employee employee1 = new Employee.Builder(1).firstName("Zvonko").lastName("Bogdan").country("Serbia").build();

        Employee employee2 = new Employee.Builder(2).firstName("Bill").lastName("Gates").country("USA").build();

        System.out.println(employee1);
        System.out.println(employee2);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            System.out.println(objectMapper.writeValueAsString(employee1));
            System.out.println(objectMapper.writeValueAsString(employee2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
