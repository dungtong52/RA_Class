package session12.practice.entity;

import session12.practice.business.BookBusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static session12.practice.business.BookBusiness.mapBooks;

public class Book {
    private String bookId;
    private String bookName;
    private float price;
    private String title;
    private String author;
    private int quantity;

    public Book() {
    }

    public Book(String bookId, String bookName, float price, String title, String author, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner) {
        this.bookId = inputBookId();
        this.bookName = inputBookName(scanner);
        this.price = inputPrice(scanner);
        System.out.println("Nhập vào tiêu đề sách:");
        this.title = scanner.nextLine();
        System.out.println("Nhập vào tác giả sách:");
        this.author = scanner.nextLine();
        this.quantity = inputQuantity(scanner);
    }

    public String inputBookId() {
        if (mapBooks.isEmpty()) {
            return "B001";
        }
        int max = Integer.MIN_VALUE;
        for (String bookId : mapBooks.keySet()) {
            int intBookId = Integer.parseInt(bookId.substring(1));
            if (intBookId > max) {
                max = intBookId;
            }
        }
        //max = 5 --> 005
        return String.format("B%03d", max + 1);
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("Nhập vào tên sách:");
        do {
            String bookName = scanner.nextLine();
            if (bookName.length() >= 10 && bookName.length() <= 50) {
                boolean isExist = false;
                for (Book book : mapBooks.values()) {
                    if (book.getBookName().equals(bookName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return bookName;
                }
                System.err.println("Tên sách đã tồn tại, vui lòng nhập lại");
            } else {
                System.err.println("Tên sách có độ dài từ 10-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập vào giá của sách:");
        do {
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    return price;
                }
                System.err.println("Giá sách có giá trị lớn hơn 0, vui lòng nhập lại");
            } catch (NumberFormatException e) {
                System.err.println("Giá sách là một số thực, vui lòng nhập lại");
            }
        } while (true);
    }

    public Date inputCreated(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập vào ngày xuất bản của sách:");
        do {
            String createdStr = scanner.nextLine();
            try {
                return sdf.parse(createdStr);
            } catch (Exception e) {
                System.err.println("Ngày xuất bản có định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (true);

    }

    public int inputQuantity(Scanner scanner) {
        System.out.println("Nhập vào số lượng sách:");
        do {
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0) {
                    return quantity;
                }
                System.err.println("Số lượng sách phải có giá trị lớn hơn hoặc bằng 0, vui lòng nhập lại");
            } catch (Exception e) {
                System.err.println("Số lượng sách là số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return String.format("Mã sách: %s - Tên sách: %s - Tiêu đề: %s\n - Giá: %.1f - Tác giả: %s - Số lượng: %d",
                this.bookId, this.bookName, this.title, this.price, this.author, this.quantity);
    }
}
