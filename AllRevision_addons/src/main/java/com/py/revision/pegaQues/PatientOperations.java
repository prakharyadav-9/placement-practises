package com.py.revision.pegaQues;

public interface PatientOperations {
    void availSlots(Hospital hospital);
    void bookSlot(int slot,Hospital hospital);
    void enquireStatus(Hospital hospital);

}
