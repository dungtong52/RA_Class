package entry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("AppointmentId: %s - Patient Name: %s - Phone Number: %s - Appointment Date: %s - Doctor Name: %s\n",
                this.appointmentId, this.patientName, this.phoneNumber, formatter.format(this.appointmentDate), this.doctor);
    }

    public void inputData(Scanner scanner) {
        this.appointmentId = inputAppointmentId(scanner);
        this.patientName = inputPatientName(scanner);
        this.phoneNumber = inputPhoneNumber(scanner);
        this.appointmentDate = inputAppointmentDate(scanner);
        this.doctor = inputDoctor(scanner);
    }

    public String inputAppointmentId(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn: ");
        return scanner.nextLine();
    }

    public String inputPatientName(Scanner scanner) {
        System.out.print("Nhập tên bệnh nhận: ");
        return scanner.nextLine();
    }

    public String inputPhoneNumber(Scanner scanner) {
        System.out.print("Nhập số điện thoại của bệnh nhân: ");
        return scanner.nextLine();
    }

    public LocalDate inputAppointmentDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Nhập ngày hẹn khám: ");
        return LocalDate.parse(scanner.nextLine(), formatter);
    }

    public String inputDoctor(Scanner scanner) {
        System.out.println("Nhập tên bác sĩ phụ trách");
        return scanner.nextLine();
    }

}
