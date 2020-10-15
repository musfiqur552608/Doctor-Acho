package com.example.doctoracho;

public class modelNe {
    String name, email, age, empI, gender;
    modelNe()
    {

    }

    public modelNe(String name, String email, String age, String empI, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.empI = empI;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmpI() {
        return empI;
    }

    public void setEmpI(String empI) {
        this.empI = empI;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
