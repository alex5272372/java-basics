package hw03;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Main {
    private static void initScheduler(Scheduler scheduler) {
        scheduler.setScedule(0, "do home work");
        scheduler.setScedule(1, "go to courses; watch a film");
        scheduler.setScedule(2, "go to work office");
        scheduler.setScedule(3, "shopping in the mall");
        scheduler.setScedule(4, "sleeping; watching TV");
        scheduler.setScedule(5, "cooking; eating");
        scheduler.setScedule(6, "go to the gym");
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        initScheduler(scheduler);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please, input the day of the week:");
            String day = sc.next();

            if(day.equalsIgnoreCase("exit")) {
                return;

            } else if(day.equalsIgnoreCase("change") || day.equalsIgnoreCase("reschedule")) {
                int i = scheduler.getDay(sc.next());
                if(i == -1) {
                    System.out.println("Sorry, I don't understand you, please try again.");
                } else {
                    System.out.println("Please, input new tasks for " + scheduler.getDay(i) + ".");
                    sc.nextLine();
                    scheduler.setScedule(i, sc.nextLine());
                }

            } else {
                System.out.println(scheduler.getScedule(day));
                sc.nextLine();
            }
        }
    }
}
