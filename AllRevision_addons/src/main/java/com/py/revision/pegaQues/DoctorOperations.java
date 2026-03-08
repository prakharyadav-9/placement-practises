package com.py.revision.pegaQues;

/**
 * Doctor
 */
public interface DoctorOperations {
    
    // void embadeSlots(Slot []slots);
    void availSlots();

    void setSlot(int slotIdx);
    void cancelMySlot(int slotIdx);
    void updateSlot(int prevSlot,int newSlot);
    
} 
