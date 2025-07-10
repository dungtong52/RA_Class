package practice.business;

import practice.entity.Appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    public static List<Appointment> listAppointments = new ArrayList<Appointment>();

    public static void addAppointment(Scanner scanner) {
        Appointment appointment = new Appointment();
        appointment.inputData(scanner);
        listAppointments.add(appointment);
    }

    public static void displayAppointments() {
        listAppointments.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public static void searchAppointmentByPatientName(Scanner scanner) {
        System.out.println("Nhập vào tên bệnh nhân cần tìm:");
        String patientName = scanner.nextLine();
        List<Appointment> results = listAppointments.stream()
                .filter(appointment -> appointment.getPatientName().toLowerCase().contains(patientName.toLowerCase()))
                .toList();
        if (results.isEmpty()) {
            System.out.printf("Không tìm thấy lịch khám có tên bệnh nhân là %s\n", patientName);
        } else {
            results.forEach(System.out::println);
        }
    }

    public static void updateAppointment(Scanner scanner) {
        System.out.println("Nhập vào mã lịch khám cần cập nhật:");
        String appointmentId = scanner.nextLine();
        listAppointments.stream()
                .filter(appointment -> appointment.getAppointmentId().equals(appointmentId)).findFirst()
                .ifPresentOrElse(appointment -> {
                    //thực hiện cập nhật
                    boolean isExit = true;
                    do {
                        System.out.println("1. Cập nhật tên bệnh nhân");
                        System.out.println("2. Cập nhật số điện thoại");
                        System.out.println("3. Cập nhật ngày khám");
                        System.out.println("4. Cập nhật bác sĩ khám");
                        System.out.println("5. Thoát");
                        System.out.print("Lựa chọn của bạn:");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập vào tên bệnh nhân mới:");
                                appointment.setPatientName(scanner.nextLine());
                                break;
                            case 2:
                                System.out.println("Nhập vào số điện thoại mới:");
                                appointment.setPhoneNumber(scanner.nextLine());
                                break;
                            case 3:
                                System.out.println("Nhập vào ngày khám mới:");
                                appointment.setAppointmentDate(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                break;
                            case 4:
                                System.out.println("Nhập vào bác sĩ khám mới:");
                                appointment.setDoctor(scanner.nextLine());
                                break;
                            case 5:
                                isExit = false;
                                break;
                            default:
                                System.err.println("Vui lòng chọn từ 1-5");
                        }
                    } while (isExit);
                }, () -> {
                    System.out.println("Không tìm thấy mã khám bệnh " + appointmentId);
                });
    }

    public static void deleteAppointment(Scanner scanner) {
        System.out.println("Nhập vào mã lịch khám cần xóa:");
        String appointmentId = scanner.nextLine();
        listAppointments.stream()
                .filter(appointment -> appointment.getAppointmentId().equals(appointmentId))
                .findFirst()
                .ifPresentOrElse(appointment -> {
                    //Thực hiện xóa
                    System.out.printf("Bạn có chắc chắn muốn xóa lịch khám %s không (Y/N)?\n", appointmentId);
                    if (scanner.nextLine().equalsIgnoreCase("Y")) {
                        listAppointments.remove(appointment);
                    }
                }, () -> {
                    System.out.println("Không tìm thấy mã lịch khám " + appointmentId);
                });
    }

    public static void statictisTotalAppointment() {
        long cntAppoinntment = listAppointments.stream().count();
        System.out.println("Tổng số lịch khám: " + cntAppoinntment);
    }

    public static void statictisByDoctor() {
        Map<String, Long> mapStatictis =
                listAppointments.stream().collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));
        for (Map.Entry<String, Long> entry : mapStatictis.entrySet()) {
            System.out.printf("Bác sĩ %s : %d lịch khám\n", entry.getKey(), entry.getValue());
        }
    }
}
