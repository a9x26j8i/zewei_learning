package com.evalumate.DataModel;

public class Peer extends Answerer{
    public long peerOfId;

    public Peer(long peerOfId) {
        super(0,"USER", null, null,null,null);
        this.peerOfId = peerOfId;
    }

    public Peer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Peer setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public Peer setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public Peer setMname(String mname) {
        this.mname = mname;
        return this;
    }
}
