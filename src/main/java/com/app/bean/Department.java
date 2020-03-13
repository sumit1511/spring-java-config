package com.app.bean;

import java.util.Date;


public class Department {
    private  String deptName;
    private Date createdOn;

    public Department() {
    }

    public Department(String deptName, Date createdOn) {
        this.deptName = deptName;
        this.createdOn = createdOn;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
