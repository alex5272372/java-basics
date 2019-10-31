package hw10;

import java.util.Calendar;

public final class Man extends Human {
    Man(String name, String surname, Calendar birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    void greetPet(String nickname) {
        System.out.println(String.format("Man: Hello, %s!", getFamily().getPet(nickname).getNickname()));
    }

    void repairCar() {
        System.out.println("I'm doing repair car");
    }

    @Override
    public String toString() {
        return "Man" + super.toString();
    }
}
