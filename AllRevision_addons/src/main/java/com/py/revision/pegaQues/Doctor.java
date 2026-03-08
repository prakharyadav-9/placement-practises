package com.py.revision.pegaQues;

import java.util.Arrays;

public class Doctor implements DoctorOperations {

    String name;
    // private Slot[] slots;
    Hospital myHospital;

    Doctor(String name,Hospital hospital){
        this.name = name;
        // this.slots = hospital.slots;
        myHospital = hospital;
    }

    @Override
    public void availSlots() {
        System.out.println("Doctor "+name+"'s' view :: slots available -> "+Arrays.toString(myHospital.slots));
    }

    @Override
    public void setSlot(int slotIdx) {
        Slot slotInfo = new Slot(slotIdx, this);
        if(myHospital.slots[slotInfo.idx] ==  null){
            myHospital.slots[slotInfo.idx]=slotInfo;

            System.out.println(name+"'s Slot booked");
        }else{
            System.err.println("Sorry "+name+" slot::"+slotIdx+" cannot be booked!! please check again the avaliable slots");
        }
    }

    @Override
    public void updateSlot(int prevSlot, int newSlot) {
        if(myHospital.slots[prevSlot]!=null && myHospital.slots[newSlot]==null){
            myHospital.slots[newSlot] = myHospital.slots[prevSlot];
            myHospital.slots[newSlot].idx=newSlot;
            myHospital.slots[prevSlot] = null;
        }else{
            System.err.println("Opps slots cannot be updated");
        }
    }

    @Override
    public String toString(){
        return "{Doctor - "+name+"}";
    }

    @Override
    public void cancelMySlot(int slotIdx) {
        if(myHospital.slots[slotIdx].doctor.name.equalsIgnoreCase(name)){
            myHospital.slots[slotIdx] = null;
        }else{
            System.err.println("Sorry "+name+"!! you cannot cancel someone else's slot");
        }
    }
    
}
