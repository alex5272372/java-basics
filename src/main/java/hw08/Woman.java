package hw08;

public final class Woman extends Human {
    Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    void greetPet(String nickname) {
        System.out.println(String.format("Woman: Hello, %s!", getFamily().getPet(nickname).getNickname()));
    }

    void makeup() {
        System.out.println("I'm doing makeup");
    }

    @Override
    public String toString() {
        return "Woman" + super.toString();
    }
}
