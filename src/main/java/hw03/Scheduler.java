package hw03;

public class Scheduler {
    private String[][] scedule;

    public Scheduler() {
        scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[1][0] = "Monday";
        scedule[2][0] = "Tuesday";
        scedule[3][0] = "Wednesday";
        scedule[4][0] = "Thursday";
        scedule[5][0] = "Friday";
        scedule[6][0] = "Saturday";
    }

    public String getDay(int day) {
        return scedule[day][0];
    }

    public int getDay(String day) {
        for(int i = 0; i < 7; i++) {
            if(scedule[i][0].equalsIgnoreCase(day)) {
                return i;
            }
        }
        return -1;
    }

    public String getScedule(String day) {
        int i = getDay(day);
        if(i == -1) {
            return "Sorry, I don't understand you, please try again.";
        } else {
            return "Your tasks for " + scedule[i][0] + ": " + scedule[i][1];
        }
    }

    public void setScedule(int day, String task) {
        this.scedule[day][1] = task;
    }
}
