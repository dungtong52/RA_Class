package entity;

import validation.Validation;

import java.util.Scanner;

public class BookType {
    private int id;
    private String name;
    private String description;
    private boolean status;

    public BookType() {
    }

    public BookType(int id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.name = inputTypeName(scanner);
        this.description = inputDescription(scanner);
        this.status = true;
    }

    public String inputTypeName(Scanner scanner) {
        final int MAX_LENGTH = 100;
        while (true) {
            System.out.print("Nhập vào tên loại sách: ");
            String typeName = scanner.nextLine();
            if (Validation.isValidLength(typeName, MAX_LENGTH)) {
                return typeName;
            } else {
                System.err.println("Tên loại sách không được bỏ trống hoặc quá 100 ký tự!");
            }
        }
    }

    public boolean inputStatus(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào trạng thái danh mục (true | false): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Nhập vào không hợp lệ!");
            }
        }
    }

    public String inputDescription(Scanner scanner) {
        while (true) {
            System.out.print("Nhập vào mô tả loại sách: ");
            String description = scanner.nextLine();
            if (Validation.isNotEmpty(description)) {
                return description;
            } else {
                System.err.println("Mô tả không được để trống!");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d - Type Name: %s - Description: %s - Status: %s",
                this.id, this.name, this.description, this.status ? "Active" : "Deactive");
    }
}
