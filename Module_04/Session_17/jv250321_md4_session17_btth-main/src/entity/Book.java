package entity;

public class Book {
    private String bookId;
    private String bookName;
    private String title;
    private int pages;
    private String author;
    private float price;
    private int type_id;
    private String type_name;
    private boolean status;

    public Book() {
    }

    public Book(String bookId, String bookName, String title, int pages, String author, float price, int type_id, String type_name, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.price = price;
        this.type_id = type_id;
        this.type_name = type_name;
        this.status = status;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Mã sách: %s - Tên sách: %s - Tiêu đề: %s - Số trang: %d\n" +
                        "Tác giả: %s - Giá: %f - Loại sách: %s - Trạng thái: %s",
                this.bookId, this.title, this.pages, this.author, this.price, this.type_name,
                this.status ? "Hoạt động" : "Không hoạt động");
    }
}
