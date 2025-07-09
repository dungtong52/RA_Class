import business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentBusiness appointmentBusiness = new AppointmentBusiness();

        do {
            System.out.println("\n********************* QUẢN LÝ LỊCH HẸN ********************\n" +
                    "1. Thêm lịch hẹn\n" +
                    "2. Hiển thị danh sách lịch hẹn\n" +
                    "3. Tìm kiếm lịch hẹn theo tên bệnh nhân\n" +
                    "4. Cập nhật lịch hẹn theo mã lịch hẹn\n" +
                    "5. Xóa lịch hẹn theo mã lịch hẹn\n" +
                    "6. Thống kê\n" +
                    "7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> appointmentBusiness.addAppointment(scanner);
                case 2 -> appointmentBusiness.displayAppointmentByDateASC();
                case 3 -> appointmentBusiness.findAppointmentByPatientName(scanner);
                case 4 -> appointmentBusiness.updateAppointmentById(scanner);
                case 5 -> appointmentBusiness.deleteAppointmentById(scanner);
                case 6 -> {
                    appointmentBusiness.statisticTotalAppointment();
                    appointmentBusiness.statisticGroupByDoctor();
                }
                case 7 -> System.exit(0);
                default -> System.err.println("Nhập vào số 1-7");
            }
        } while (true);
    }
}
