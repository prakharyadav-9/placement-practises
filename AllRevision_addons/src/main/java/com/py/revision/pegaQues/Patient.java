package com.py.revision.pegaQues;

import java.util.*;

public class Patient implements PatientOperations {

    String name;
    List<Integer> mybookedSlots = new ArrayList<>();
    Patient(String name){
        this.name=name;
    }

    @Override
    public void availSlots(Hospital hospital) {
        System.out.println("Patient "+name+" viewing :: slots avaliable -> "+Arrays.toString(hospital.slots));
    }

    @Override
    public void bookSlot(int slotIdx,Hospital hospital) {
        if(hospital.slots[slotIdx]==null || hospital.slots[slotIdx].patient!=null){
            System.err.println(name + " your slot cannot be booked for slot::"+slotIdx+", please again see the slots..");
            return;
        }
        hospital.slots[slotIdx].patient = this;
        mybookedSlots.add(slotIdx);
    }

    @Override
    public void enquireStatus(Hospital hospital) {
        for(int mybookedSlot: mybookedSlots ){
            if(hospital.slots[mybookedSlot]!=null && hospital.slots[mybookedSlot].patient.name.equalsIgnoreCase(name)){
                System.out.println(name+"'s booking is "+mybookedSlot);
            }
        }
        // System.out.println(name+"'s booking is "+mySlot);
    }
    
    @Override
    public String toString(){
        return "("+name+")";
    }
}
