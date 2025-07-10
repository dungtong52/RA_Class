import practice.business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*************QUẢN LÝ LỊCH HẸN****************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn");
            System.out.println("5. Xóa lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    AppointmentBusiness.addAppointment(scanner);
                    break;
                case 2:
                    AppointmentBusiness.displayAppointments();
                    break;
                case 3:
                    AppointmentBusiness.searchAppointmentByPatientName(scanner);
                    break;
                case 4:
                    AppointmentBusiness.updateAppointment(scanner);
                    break;
                case 5:
                    AppointmentBusiness.deleteAppointment(scanner);
                    break;
                case 6:
                    AppointmentBusiness.statictisTotalAppointment();
                    AppointmentBusiness.statictisByDoctor();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }
        } while (true);
    }
}
