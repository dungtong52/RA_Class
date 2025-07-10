package practice.entity;

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

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã lịch khám:");
        this.appointmentId = scanner.nextLine();
        System.out.println("Nhập vào tên bệnh nhân:");
        this.patientName = scanner.nextLine();
        System.out.println("Nhập vào số điện thoại:");
        this.phoneNumber = scanner.nextLine();
        this.appointmentDate = inputAppointmentDate(scanner);
        System.out.println("Nhập vào tên bác sĩ khám:");
        this.doctor = scanner.nextLine();
    }

    public LocalDate inputAppointmentDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhập vào ngày hẹn khám:");
        do {
            try {
                LocalDate appointmentDate = LocalDate.parse(scanner.nextLine(), formatter);
                return appointmentDate;
            } catch (Exception e) {
                System.err.println("Ngày hẹn khám không đúng định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Mã lịch khám: %s - Bệnh nhân: %s - SĐT: %s - Ngày khám: %s - Bác sĩ: %s",
                this.appointmentId, this.patientName, this.phoneNumber, formatter.format(this.appointmentDate), this.doctor);
    }
}
