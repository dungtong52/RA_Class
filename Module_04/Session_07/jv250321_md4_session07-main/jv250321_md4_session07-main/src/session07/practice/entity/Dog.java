package session07.practice.entity;

public class Dog extends Pet {
    public Dog() {
    }

    public Dog(String petId, String petName, int petAge) {
        super(petId, petName, petAge);
    }

    @Override
    public void speak() {
        System.out.println("Gâu gâu");
    }
}
