package com.app.config;

import com.app.bean.Department;
import com.app.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Configuration
@PropertySource("app.properties")

public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public Date customDate(){
        String []d = environment.getProperty("deptCreatedOn").split("\\|");
        try {
            return new SimpleDateFormat(d[1].trim()).parse(d[0].trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Bean
    public Department department(){
        Department dept =new Department();
        dept.setDeptName(environment.getProperty("deptName"));
        dept.setCreatedOn(customDate());
        return dept;
    }
    @Bean
    public Employee employee(){
        Employee employee = new Employee();
        employee.setName(environment.getProperty("empName"));
        employee.setAge(environment.getProperty("empAge",Integer.class));
        employee.setSalary(environment.getProperty("empSalary",Double.class));
        employee.setTaskList(environment.getProperty("empTasks", ArrayList.class));
        employee.setDepartment(department());
        return employee;
    }
}

