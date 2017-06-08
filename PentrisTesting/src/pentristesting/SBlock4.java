
package pentristesting;

public class SBlock4 extends Block {

    private int[][] sBlock = new int[5][10];

    public SBlock4() {
        super.setColor(5);
        this.sBlock = sBlock;
    }

    public int[][] getSBlock() {
        return sBlock;
    }

    public int getsBlock(int x, int y) {
        return sBlock[x][y];
    }

//    public void rotation(int x) {
//        if (x == 0) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    sBlock[i][j] = 0;
//                }
//            }
//            sBlock[3][5] = 2;
//            sBlock[3][6] = 2;
//            sBlock[4][5] = 2;
//            sBlock[4][4] = 2;
//
//        } else if (x == 1) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    sBlock[i][j] = 0;
//                }
//            }
//            
//            sBlock[2][5] = 2;
//            sBlock[3][5] = 2;
//            sBlock[3][6] = 2;
//            sBlock[4][6] = 2;
//
//        } else if (x == 2) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    sBlock[i][j] = 0;
//                }
//            }
//            sBlock[3][5] = 2;
//            sBlock[3][6] = 2;
//            sBlock[4][5] = 2;
//            sBlock[4][4] = 2;
//
//        } else if (x == 3) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    sBlock[i][j] = 0;
//                }
//            }
//            sBlock[2][5] = 2;
//            sBlock[3][5] = 2;
//            sBlock[3][6] = 2;
//            sBlock[4][6] = 2;
//        }
//
//    }

    //@Override
    public void createGrid() {
        sBlock[3][5] = 2;
        sBlock[3][6] = 2;
        sBlock[4][5] = 2;
        sBlock[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return sBlock [x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + sBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }

}
