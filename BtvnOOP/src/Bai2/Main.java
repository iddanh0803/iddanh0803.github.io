package Bai2;

public class Main {
    public static void main(String[] args){
        ManageHospital manageHospital = new ManageHospital();
        Patient patient = new Patient("bệnh án số 1","2/4/2023");
        patient.setName("Someone ");
        patient.setAge(33);
        manageHospital.setPatient(patient);


        Doctor doctor = new Doctor("Đa khoa","2h");
        doctor.setName("Somenone ");
        doctor.setAge(44);
        manageHospital.setDoctor(doctor);
        System.out.println(manageHospital);
    }
}
