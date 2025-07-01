package session07.practice.presentation;

import session07.practice.entity.Cat;
import session07.practice.entity.Dog;
import session07.practice.entity.Pet;

import java.util.Scanner;

public class PetManagement {
    public static Pet[] pets = new Pet[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********QUẢN LÝ THÚ CƯNG***************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListPet();
                    break;
                case 2:
                    createPet(scanner);
                    break;
                case 3:
                    petSpeak();
                    break;
                case 4:
                    deletePet(scanner);
                    break;
                case 5:
                    searchPetByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    public static void displayListPet() {
        for (int i = 0; i < currentIndex; i++) {
            pets[i].displayData();
        }
    }

    public static void createPet(Scanner scanner) {
        System.out.println("Nhập vào loại thú cưng cần thêm (Cat|Dog):");
        String petType = scanner.nextLine();
        switch (petType) {
            case "Cat":
                pets[currentIndex] = new Cat();
                pets[currentIndex].inputData(scanner);
                break;
            default:
                pets[currentIndex] = new Dog();
                pets[currentIndex].inputData(scanner);
                break;
        }
        currentIndex++;
    }

    public static void petSpeak() {
        for (int i = 0; i < currentIndex; i++) {
            pets[i].speak();
        }
    }

    public static void deletePet(Scanner scanner) {
        System.out.println("Nhập vào mã thú cưng cần xóa:");
        String petId = scanner.nextLine();
        int indexDelete = findIndexById(petId);
        if (indexDelete != -1) {
            for (int i = indexDelete; i < currentIndex - 1; i++) {
                pets[i] = pets[i + 1];
            }
            pets[currentIndex - 1] = null;
            currentIndex--;
        } else {
            System.err.println("Không tìm thấy mã thú cưng!!!");
        }
    }

    public static int findIndexById(String petId) {
        for (int i = 0; i < currentIndex; i++) {
            if (pets[i].getPetId().equals(petId)) {
                return i;
            }
        }
        return -1;
    }

    public static void searchPetByName(Scanner scanner) {
        int cntPets = 0;
        System.out.println("Nhập vào tên thú cưng cần tìm:");
        String petName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (pets[i].getPetName().toLowerCase().contains(petName.toLowerCase())) {
                pets[i].displayData();
                cntPets++;
            }
        }
        System.out.printf("Tìm thấy %d thú cưng có tên chứa %s\n", cntPets, petName);
    }
}
