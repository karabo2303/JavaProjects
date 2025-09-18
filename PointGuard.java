public class PointGuard extends BasketballPlayer {
    private double assistsPerGame;

    public PointGuard(String name, int age, double height, double assistsPerGame) {
        super(name, age, height);
        this.assistsPerGame = assistsPerGame;
    }

    public double getAssistsPerGame() { return assistsPerGame; }
    public void setAssistsPerGame(double assistsPerGame) { this.assistsPerGame = assistsPerGame; }

    @Override
    public void playStyle() {
        System.out.println(name + " controls the game's tempo and makes plays.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Point Guard, Assists/Game: " + assistsPerGame;
    }
}
