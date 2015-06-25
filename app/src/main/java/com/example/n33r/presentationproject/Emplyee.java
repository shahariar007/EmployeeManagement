package com.example.n33r.presentationproject;

/**
 * Created by N33R on 6/6/2015.
 */
public class Emplyee {
    String name;
    String phone;
    String email;
    String birthday;
    String nid;
    String salary;
    String id;

    public Emplyee(String id,String name,String phone,String email, String birthday, String nid,  String salary) {
        this.name = name;
        this.salary = salary;
        this.nid = nid;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.id=id;
    }

    public Emplyee(String name, String phone, String email, String birthday, String nid, String salary) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.nid = nid;
        this.salary = salary;
    }

    public Emplyee() {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getId() {
        return id;
    }

    public String getNid() {
        return nid;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
