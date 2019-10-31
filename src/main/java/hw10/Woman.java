package hw10;

import java.util.Calendar;

public final class Woman extends Human {
    Woman(String name, String surname, Calendar birthDate, int iq) {
        super(name, surname, birthDate, iq);
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
