public class Main {
    public static void main(String[] args) {
        Adventurer adventurer = new Adventurer("15F6B6B5L16R8B16F20L6F13F11R", 0, 0);
        System.out.println("Path: " + adventurer.getPath());

        adventurer.walk();
        System.out.println("Starting coordinates: " + "(" + adventurer.getX1() + ", " + adventurer.getY1() + ")");
        System.out.println("Ending coordinates: " + "(" + adventurer.getX2() + ", " + adventurer.getY2() + ")");
        System.out.println("Euclidian distance: " + adventurer.euclidianDist());
    }    
}
