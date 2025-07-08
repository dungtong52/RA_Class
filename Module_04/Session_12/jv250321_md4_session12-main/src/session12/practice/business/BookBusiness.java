package session12.practice.business;

import session12.practice.entity.Book;

import java.util.*;

public class BookBusiness {
    public static Map<String, Book> mapBooks = new HashMap<>();

    public static void addBook(Scanner scanner) {
        Book book = new Book();
        book.inputData(scanner);
        if (mapBooks.containsKey(book.getBookId())) {
            System.err.println("Mã sách đã tồn tại");
            return;
        }
        mapBooks.put(book.getBookId(), book);
    }

    public static void displayBooks() {
        for (Book book : mapBooks.values()) {
            System.out.println(book);
        }
    }

    public static void updateBook(Scanner scanner) {
        System.out.println("Nhập vào mã sách cần cập nhật:");
        String bookId = scanner.nextLine();
        if (mapBooks.containsKey(bookId)) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sách");
                System.out.println("2. Cập nhật giá sách");
                System.out.println("3. Cập nhật tiêu đề");
                System.out.println("4. Cập nhật tác giả");
                System.out.println("5. Cập nhật số lượng");
                System.out.println("6. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên sách mới:");
                        mapBooks.get(bookId).setBookName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá mới của sách:");
                        mapBooks.get(bookId).setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Cập nhật tiêu đề mới của sách:");
                        mapBooks.get(bookId).setTitle(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Cập nhật tác giả mới của sách:");
                        mapBooks.get(bookId).setAuthor(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Cập nhật số lượng mới của sách:");
                        mapBooks.get(bookId).setQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-6");
                }
            } while (isExit);
        } else {
            System.err.println("Mã sách không tồn tại");
        }
    }

    public static void deleteBook(Scanner scanner) {
        System.out.println("Nhập vào mã sách cần xóa:");
        String bookId = scanner.nextLine();
        if (mapBooks.containsKey(bookId)) {
            mapBooks.remove(bookId);
        } else {
            System.err.println("Mã sách không tồn tại");
        }
    }

    public static void searchBookByName(Scanner scanner) {
        System.out.println("Nhập vào tên sách cần tìm:");
        String bookNameSearch = scanner.nextLine();
        for (Book book : mapBooks.values()) {
            if (book.getBookName().toLowerCase().contains(bookNameSearch.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public static void sortBookByPriceASC(Scanner scanner) {
        List<Book> listBooks = new ArrayList<>(mapBooks.values());
        Collections.sort(listBooks, new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                return Float.compare(o1.getPrice(), o2.getPrice());
            }
        });
        mapBooks.clear();
        for (Book book : listBooks) {
            mapBooks.put(book.getBookId(), book);
        }
    }

    public static void searchBookMaxPrice() {
        float maxPrice = Float.MIN_VALUE;
        for (Book book : mapBooks.values()) {
            if (book.getPrice() > maxPrice) {
                maxPrice = book.getPrice();
            }
        }
        System.out.println("Các sách có giá lớn nhất là:");
        for (Book book : mapBooks.values()) {
            if (book.getPrice() == maxPrice) {
                System.out.println(book);
            }
        }
    }

    public static void statictisBook() {
        int quantityExist = 0;
        float valueExist = 0;
        for (Book book : mapBooks.values()) {
            quantityExist += book.getQuantity();
            valueExist += book.getPrice() * book.getQuantity();
        }
        System.out.printf("Tổng số lượng tồn kho: %d - Giá trị kho: %.1f\n", quantityExist, valueExist);
    }
}
