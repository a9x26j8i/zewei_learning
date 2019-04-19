package com.evalumate.DataModel;

public class Answerer {
    public long id;
    public String type;
    public String email;
    public String fname;
    public String lname;
    public String mname;

    public Answerer(int id,
                    String type,
                    String email,
                    String fname,
                    String lname,
                    String mname){
        this.id = id;
        this.type = type;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
    }
}


