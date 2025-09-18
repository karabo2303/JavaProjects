public class Center extends BasketballPlayer {
    private double blocksPerGame;

    public Center(String name, int age, double height, double blocksPerGame) {
        super(name, age, height);
        this.blocksPerGame = blocksPerGame;
    }

    public double getBlocksPerGame() { return blocksPerGame; }
    public void setBlocksPerGame(double blocksPerGame) { this.blocksPerGame = blocksPerGame; }

    @Override
    public void playStyle() {
        System.out.println(name + " dominates the paint and protects the rim.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Center, Blocks/Game: " + blocksPerGame;
    }
}
