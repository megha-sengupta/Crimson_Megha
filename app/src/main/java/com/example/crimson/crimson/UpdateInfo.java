package com.example.crimson.crimson;

import java.time.LocalDateTime;

public class UpdateInfo {
    public String amt,ctry;
    public LocalDateTime date;

    public UpdateInfo() {
    }

    public UpdateInfo(String amount, String name, LocalDateTime dateTime)
    {
        this.date=dateTime;
        this.amt=amount;
        this.ctry=name;

    }
    public UpdateInfo(String name){
        this.ctry= name;
    }

    public UpdateInfo getCurrentInfo(){
        return this;
    }


}
