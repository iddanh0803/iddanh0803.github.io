package Bai2;

public class ManageHospital {
       private Doctor doctor;
       private Patient patient;

       public Doctor getDoctor() {
              return doctor;
       }

       @Override
       public String toString() {
              return "ManageHospital{" +
                      "doctor=" + doctor.toString() +
                      ", patient=" + patient.toString() +
                      '}';
       }

       public void setDoctor(Doctor doctor) {
              this.doctor = doctor;
       }

       public Patient getPatient() {
              return patient;
       }

       public void setPatient(Patient patient) {
              this.patient = patient;
       }

       public ManageHospital() {
       }

       public ManageHospital(Doctor doctor, Patient patient) {
              this.doctor = doctor;
              this.patient = patient;
       }
}
