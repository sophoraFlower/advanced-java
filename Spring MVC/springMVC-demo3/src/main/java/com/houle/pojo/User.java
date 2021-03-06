package com.houle.pojo;

public class User {
    private String username;
    private String password;
    private String gender;
    private String age;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +"username='" + username + '\'' + ", password='" + password + '\'' + ", gender='" + gender + '\'' +", age='" + age + '\'' + ", email='" + email + '\'' +'}';
    }
}