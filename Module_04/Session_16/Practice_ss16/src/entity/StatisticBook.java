package entity;

public class StatisticBook {
    private String author;
    private int countBook;

    public StatisticBook() {
    }

    public StatisticBook(String author, int countBook) {
        this.author = author;
        this.countBook = countBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @Override
    public String toString() {
        return String.format("Author: %s - Count: %d", this.author, this.countBook);
    }
}
