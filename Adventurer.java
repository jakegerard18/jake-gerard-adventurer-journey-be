import java.util.ArrayList;
import java.util.Arrays;

class Adventurer {
    private String path;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private final String NUM_RGX = "[0-9]+";
    private final String DIR_RGX = "[FBRL]";


    public Adventurer(String path, int x1, int y1) {
        this.path = path;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
    }

    public int getX1() {
        return this.x1;
    };

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public String getPath() {
        return this.path;
    }

    public void walk() {
        ArrayList<String> parsedPath = parsePathHardWay();

        if (!validPath(parsedPath)) {
            throw new Error("The given path is invalid.");
        }

        for(int i = 0; i < parsedPath.size() - 1; i += 2) {
            int numSteps = Integer.parseInt(parsedPath.get(i));
            String direction = parsedPath.get(i + 1);

            switch(direction) {
                case "F":
                    this.y2 += numSteps;
                    break;
                case "B":
                    this.y2 -= numSteps;
                    break;
                case "R":
                    this.x2 += numSteps;
                    break;
                case "L":
                    this.x2 -= numSteps;
                    break;
            }
        }
    }

    public double euclidianDist() {
        int deltaX = this.x1 - this.x2;
        int deltaY = this.y1 - this.y2;

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    private ArrayList<String> parsePathEasyWay() {
        String[] splitPath = this.path.splitWithDelimiters(DIR_RGX, 0);
        return new ArrayList<String>(Arrays.asList(splitPath));
    }

    private ArrayList<String> parsePathHardWay() {
        ArrayList<String> parsedPath = new ArrayList<>();
        char[] pathChars = this.path.toCharArray();
        String stepStr = "";

        for (int i = 0; i < pathChars.length; i++) {
            if (String.valueOf(pathChars[i]).matches(NUM_RGX)) {
                stepStr = stepStr + pathChars[i];
            }
            else if (String.valueOf(pathChars[i]).matches(DIR_RGX)) {
                parsedPath.add(stepStr);
                parsedPath.add(String.valueOf(pathChars[i]));
                stepStr = "";
            }
        }

        return parsedPath;
    }

    private boolean validPath(ArrayList<String> parsedPath) {
        if (parsedPath.size() < 2) {
            return false;
        } 
        else if (parsedPath.size() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < parsedPath.size(); i++) {
            if (i % 2 == 0 && !parsedPath.get(i).matches(NUM_RGX)) {
                return false;
            }
            else if (i % 2 == 1 && !parsedPath.get(i).matches(DIR_RGX)) {
                return false;
            }
        }

        return true;
    }
}
