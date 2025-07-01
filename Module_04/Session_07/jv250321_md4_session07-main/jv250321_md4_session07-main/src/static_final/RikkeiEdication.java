package static_final;

public class RikkeiEdication {
    public static int cntVisited = 0;

    public int getCntVisited() {
        return cntVisited;
    }

    public void setCntVisited(int cntVisited) {
        this.cntVisited = cntVisited;
    }

    public void visitedWebsite() {
        cntVisited++;
    }

    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
