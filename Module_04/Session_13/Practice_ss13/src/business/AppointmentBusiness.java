package business;

import entry.Appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    public List<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Scanner scanner) {
        Appointment newAppointment = new Appointment();
        newAppointment.inputData(scanner);
        appointmentList.add(newAppointment);
        System.out.println("Thêm lịch hẹn mới thành công!");
    }

    public void displayAppointmentByDateASC() {
        System.out.println("Danh sách lịch hẹn khám sắp xếp theo ngày hẹn tăng dần:");
        appointmentList.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public void findAppointmentByPatientName(Scanner scanner) {
        System.out.print("Nhập tên bệnh nhân cần tìm lịch hẹn:");
        String patientName = scanner.nextLine();
        List<Appointment> appointmentListByPatientName = appointmentList.stream()
                .filter(appointment -> appointment.getPatientName().toLowerCase().contains(patientName.toLowerCase()))
                .toList();
        if (appointmentListByPatientName.isEmpty()) {
            System.out.println("không tìm thấy lịch hẹn của bệnh nhân này");
        } else {
            appointmentListByPatientName.forEach(System.out::println);
        }
    }

    public void updateAppointmentById(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn muốn cập nhật: ");
        String idUpdate = scanner.nextLine();
        appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentId().equalsIgnoreCase(idUpdate)).findFirst()
                .ifPresentOrElse(appointment -> {
                            boolean isExit = false;
                            do {
                                System.out.println("1. Cập nhật tên bệnh nhân");
                                System.out.println("2. Cập nhật số điện thoại");
                                System.out.println("3. Cập nhật ngày khám");
                                System.out.println("4. Cập nhật bác sĩ khám");
                                System.out.println("5. Thoát");
                                System.out.print("Lựa chọn của bạn:");
                                int choice = Integer.parseInt(scanner.nextLine());
                                switch (choice) {
                                    case 1 -> appointment.inputPatientName(scanner);
                                    case 2 -> appointment.inputPhoneNumber(scanner);
                                    case 3 -> appointment.inputAppointmentDate(scanner);
                                    case 4 -> appointment.inputDoctor(scanner);
                                    case 5 -> isExit = true;
                                    default -> System.err.println("Vui lòng chọn từ 1-5");
                                }
                            }
                            while (!isExit);
                        },
                        () -> System.out.println("Không tìm thấy mã khám bệnh: " + idUpdate)
                );

    }

    public void deleteAppointmentById(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn muốn xóa: ");
        String idDelete = scanner.nextLine();
        appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentId().equalsIgnoreCase(idDelete)).findFirst()
                .ifPresentOrElse(appointment -> {
                    System.out.print("Ban có chắc chắn muốn xóa không (Y|N): ");
                    if (scanner.nextLine().equalsIgnoreCase("Y")) {
                        appointmentList.remove(appointment);
                    }
                }, () -> System.out.println("Không tìm thấy mã lịch hẹn " + idDelete));
    }

    public void statisticTotalAppointment() {
        long countAppointment = appointmentList.stream().count();
        System.out.println("Tổng số lịch hẹn: " + countAppointment);
    }

    public void statisticGroupByDoctor() {
        Map<String, Long> statistic = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));
        for (Map.Entry<String, Long> entry : statistic.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}