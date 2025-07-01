package static_final;

public class Demo {
    public static void main(String[] args) {
        //RikkeiEication --> lớp được gọi -> scann toàn bộ các thuộc tính tĩnh --> khởi tạo duy nhất 1 lần và nạp vào bộ nhớ
        //--> dùng chung cho tất cả các đối tượng
        RikkeiEdication guest1 = new RikkeiEdication();//Khởi tạo biến cntVisited = 0 của đối tượng guest1
        guest1.visitedWebsite();
        System.out.println("Số lượng truy cập hiện tại là: " + RikkeiEdication.cntVisited);//1
        RikkeiEdication guest2 = new RikkeiEdication();//KHởi tạo biến cntVisited = 0 của đối tượng guest2
        guest2.visitedWebsite();
        System.out.println("Số lượng truy cập hiện tại là: " + RikkeiEdication.cntVisited);//2
        RikkeiEdication guest3 = new RikkeiEdication();//Khởi tạo biến cntVisited = 0 của đối tượng guest3
        guest3.visitedWebsite();
        System.out.println("Số lượng truy cập hiện tại là: " + RikkeiEdication.cntVisited);//3
//        RikkeiEdication re = new RikkeiEdication();
//        re.add(7,10);
        System.out.println("Tổng 2 số là: " + RikkeiEdication.add(7, 10));
    }
}
