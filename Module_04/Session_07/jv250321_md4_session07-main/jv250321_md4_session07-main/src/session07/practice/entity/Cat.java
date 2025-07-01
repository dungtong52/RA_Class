package session07.practice.entity;

public class Cat extends Pet {
    public Cat() {
    }

    public Cat(String petId, String petName, int petAge) {
        super(petId, petName, petAge);
    }

    @Override
    public void speak() {
        System.out.println("Meo Meo");
    }
}
