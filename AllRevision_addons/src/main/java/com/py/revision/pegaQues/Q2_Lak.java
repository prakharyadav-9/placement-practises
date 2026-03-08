package com.py.revision.pegaQues;

public class Q2_Lak {
    public static void main(String [] args){
        Hospital h1 = new Hospital(4);

        Doctor dinu = new Doctor("dinu", h1),
                sandi = new Doctor("sandi", h1);

        dinu.availSlots();
        sandi.availSlots();
        dinu.setSlot(0);
        sandi.setSlot(3);
        dinu.setSlot(3);
        dinu.availSlots();
        dinu.setSlot(1);
        sandi.availSlots();
        sandi.updateSlot(3, 2);
        Patient rahul = new Patient("rahul");        

        rahul.availSlots(h1);
        rahul.bookSlot(0, h1);
        rahul.enquireStatus(h1);
        dinu.cancelMySlot(0);
        System.out.println("After dinu canceling the appointment");
        rahul.enquireStatus(h1);
    }
}
