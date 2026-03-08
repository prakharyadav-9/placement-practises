package com.py.revision.pegaQues;

public class Slot {
    String time;
    int idx;
    Patient  patient;
    Doctor doctor;
    Slot (){}
    Slot(int idx,Doctor doctor){
        this.idx = idx;
        this.doctor = doctor;
    }

    String isBooked(){
        return patient!=null?"slot booked":"slot is available";
    }

    @Override
    public String toString(){
        return "{"+idx+", "+doctor.toString()+", "+isBooked()+"}";
    }
}
