package com.evalumate.DataModel;

public class User extends Answerer {
    public String username;
    public String password;
    public String gender;
    public int age;
    public String relationshipStatus;

    public User() {
        super(0,"USER", null, null,null,null);
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setRelationStatus(String status) {
        this.relationshipStatus = status;
        return this;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public User setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public User setMname(String mname) {
        this.mname = mname;
        return this;
    }

}
