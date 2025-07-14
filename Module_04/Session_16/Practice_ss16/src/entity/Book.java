package entity;

import validation.Validation;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private String bookTitle;
    private int bookPages;
    private String author;
    private float bookPrice;
    private int typeId;
    private String typeName;
    private boolean bookStatus;

    public Book() {
    }

    public Book(String bookId, String bookName, String bookTitle, int bookPages, String author, float bookPrice, int typeId, String typeName, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.bookPages = bookPages;
        this.author = author;
        this.bookPrice = bookPrice;
        this.typeId = typeId;
        this.typeName = typeName;
        this.bookStatus = bookStatus;
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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        this.bookId = inputBookId(scanner);
        this.bookName = inputBookName(scanner);
        this.bookTitle = inputBookTitle(scanner);
        this.bookPages = inputBookPages(scanner);
        this.author = inputAuthor(scanner);
        this.bookPrice = inputPrice(scanner);
        this.typeId = inputTypeId(scanner);
        this.bookStatus = true;
    }

    public String inputBookId(Scanner scanner) {
        final int MAX_LENGTH = 5;
        while (true) {
            System.out.print("Nhập vào mã sách: ");
            String bookId = scanner.nextLine();
            if (Validation.isValidLength(bookId, MAX_LENGTH)) {
                return bookId;
            } else {
                System.err.println("Mã sách nhập vào không hợp lệ!");
            }
        }
    }

    public String inputBookName(Scanner scanner) {
        final int MAX_LENGTH = 100;
        while (true) {
            System.out.print("Nhập vào tên sách: ");
            String bookName = scanner.nextLine();
            if (Validation.isValidLength(bookName, MAX_LENGTH)) {
                return bookName;
            } else {
                System.err.println("Tên sách không được bỏ trống hoặc quá 100 ký tự!");
            }
        }
    }

    public String inputBookTitle(Scanner scanner) {
        final int MAX_LENGTH = 200;
        while (true) {
            System.out.print("Nhập vào tiêu đề sách: ");
            String bookTitle = scanner.nextLine();
            if (Validation.isValidLength(bookTitle, MAX_LENGTH)) {
                return bookTitle;
            } else {
                System.err.println("Tiêu đề sách không được bỏ trống hoặc quá 200 ký tự!");
            }
        }
    }

    public int inputBookPages(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào số trang sách: ");
            String bookPages = scanner.nextLine();
            if (Validation.isPositiveInteger(bookPages)) {
                return Integer.parseInt(bookPages);
            } else {
                System.err.println("Số trang sách nhập vào không hợp lệ!");
            }
        }
    }

    public String inputAuthor(Scanner scanner) {
        final int MAX_LENGTH = 200;
        while (true) {
            System.out.print("Nhập vào tác giả sách: ");
            String author = scanner.nextLine();
            if (Validation.isValidLength(author, MAX_LENGTH)) {
                return author;
            } else {
                System.err.println("Tên tác giả không được bỏ trống hoặc quá 200 ký tự!");
            }
        }
    }

    public float inputPrice(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào giá của sách: ");
            String price = scanner.nextLine();
            if (Validation.isPositiveFloat(price)) {
                return Float.parseFloat(price);
            } else {
                System.err.println("Giá tiền nhập vào phải là số thực > 0!");
            }
        }
    }

    public int inputTypeId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào mã loại sách: ");
            String typeId = scanner.nextLine();
            if (Validation.isPositiveInteger(typeId)) {
                return Integer.parseInt(typeId);
            } else {
                System.err.println("Mã loại sách nhập vào không hợp lệ!");
            }
        }
    }

    public boolean inputStatus(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào trạng thái sách (true | false): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Nhập vào không hợp lệ!");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s - Name: %s - Title: %s - Pages: %d - Author: %s - Price: %.1f - Type ID: %d - Status: %s",
                this.bookId, this.bookName, this.bookPrice, this.bookPages, this.author, this.bookPrice,
                this.typeId, this.bookStatus ? "Hoạt động" : "Không hoạt động");
    }
}
