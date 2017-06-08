
package pentristesting;

public class TurtleBlockB extends Block {

    private int[][] turtleBlockB = new int[5][10];

    public TurtleBlockB() {
        super.setColor(9);
        this.turtleBlockB = turtleBlockB;
    }

    public int[][] getTurtleBlockB() {
        return turtleBlockB;
    }

    //@Override
    public void createGrid() {
        turtleBlockB[3][4] = 2;
        turtleBlockB[3][5] = 2;
        turtleBlockB[4][4] = 2;
        turtleBlockB[4][5] = 2;
        turtleBlockB[4][6] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return turtleBlockB[x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + turtleBlockB[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
