package msu.elder.Model;

public class YNGame {
    int choice;
    Boolean TrueLocation;
    String Location;

    public YNGame() {
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Boolean getTrueLocation() {
        return TrueLocation;
    }

    public void setTrueLocation(Boolean trueLocation) {
        TrueLocation = trueLocation;
    }

    public YNGame(int choice, Boolean trueLocation) {
        this.choice = choice;
        TrueLocation = trueLocation;
    }

    public String getLocation() {
        return Location;
    }

    public YNGame(String location) {
        Location = location;
    }

    public void setLocation(String location) {
        Location = location;

    }
}
