package hw07;

public final class Man extends Human {
    Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    void greetPet() {
        System.out.println(String.format("Man: Hello, %s!", getFamily().getPet().getNickname()));
    }

    void repairCar() {
        System.out.println("I'm doing repair car");
    }

    @Override
    public String toString() {
        return "Man" + super.toString();
    }
}
