package session07.practice.entity;

import session07.practice.presentation.PetManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Pet implements IPet {
    private String petId;
    private String petName;
    private int petAge;

    public Pet() {
    }

    public Pet(String petId, String petName, int petAge) {
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.petId = inputPetId(scanner);
        this.petName = inputPetName(scanner);
        this.petAge = inputPetAge(scanner);
    }

    public String inputPetId(Scanner scanner) {
        String petIdRegex = "[CD]\\d{3}";
        System.out.println("Nhập vào mã thú cưng:");
        do {
            String petId = scanner.nextLine();
            if (petId != null && !petId.trim().isEmpty()) {
                if (Pattern.matches(petIdRegex, petId)) {
                    //Kiểm tra duy nhất
                    boolean isExists = false;
                    for (int i = 0; i < PetManagement.currentIndex; i++) {
                        if (PetManagement.pets[i].getPetId().equals(petId)) {
                            isExists = true;
                            break;
                        }
                    }
                    if (!isExists) {
                        return petId;
                    }
                    System.err.println("Mã thú cưng đã tồn tại, vui lòng nhập lại");
                } else {
                    System.err.println("Mã thú cưng gồm 4 ký tự bắt đầu là C|D, 3 ký tự sau là số, vui lòng nhập lại");
                }
            } else {
                System.err.println("Vui lòng nhập mã thú cưng");
            }

        } while (true);
    }

    public String inputPetName(Scanner scanner) {
        System.out.println("Nhập vào tên thú cưng:");
        do {
            String petName = scanner.nextLine();
            if (petName.length() >= 20 && petName.length() <= 50) {
                return petName;
            }
            System.err.println("Tên thú cưng phải từ 20-50 ký tự, vui lòng nhập lại");
        } while (true);
    }

    public int inputPetAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi thú cưng:");
        do {
            if (scanner.hasNextInt()) {
                int petAge = Integer.parseInt(scanner.nextLine());
                if (petAge > 0) {
                    return petAge;
                }
                System.err.println("Tuổi thú cưng phải lớn hơn 0, vui lòng nhập lại");
            } else {
                System.err.println("Tuổi thú cưng là số nguyên, vui lòng nhập lại");
            }

        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã: %s - Tên: %s - Tuổi: %d\n", this.petId, this.petName, this.petAge);
    }

    public abstract void speak();
}
