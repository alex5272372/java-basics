package hw07;

public final class Woman extends Human {
    Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    void greetPet() {
        System.out.println(String.format("Woman: Hello, %s!", getFamily().getPet().getNickname()));
    }

    void makeup() {
        System.out.println("I'm doing makeup");
    }

    @Override
    public String toString() {
        return "Woman" + super.toString();
    }
}
