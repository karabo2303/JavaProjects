public abstract class BasketballPlayer implements Comparable<BasketballPlayer> {
    protected String name;
    protected int age;
    protected double height;

    public BasketballPlayer(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() { return name;}
    public int getAge() { return age;}
    public double getHeight() { return height; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setHeight(double height) { this.height = height; }

    public abstract void playStyle();
    
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Height: " + height + "m";
    }
    @Override
    public int compareTo(BasketballPlayer other) {
        return Integer.compare(this.age, other.age); // Sorting by age
    }
}
