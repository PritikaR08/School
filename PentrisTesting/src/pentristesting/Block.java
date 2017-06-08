
package pentristesting;

public abstract class Block {

    //    private int width, height, x, y, imgX, imgY;
    private int color;

    public int[][] blockArray = new int[5][10];

    public int[][] getBlockArray() {
        return blockArray;
    }

    public int getBlockArrayCoordinates(int x, int y) {
        return blockArray[x][y];
    }

    public abstract void createGrid();

    public int getColor() {
        return color;
    }
    
    

    public void setColor(int color) {
        this.color = color;
    }

}
