
package pentristesting;

public class JBlock4 extends Block {

    private int[][] jBlock = new int[5][10];

    public JBlock4() {
        super.setColor(3);
        this.jBlock = jBlock;
    }

    public int[][] getjBlock() {
        return jBlock;
    }
    
//    public void rotation(int x) {       // !!!!!
//        if (x == 0) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    jBlock[i][j] = 0;
//                }
//            }
//            jBlock[4][5] = 2;
//            jBlock[2][4] = 2;
//            jBlock[3][4] = 2;
//            jBlock[4][4] = 2;
//
//        } else if (x == 1) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    jBlock[i][j] = 0;
//                }
//            }
//            jBlock[4][4] = 2;
//            jBlock[4][5] = 2;
//            jBlock[4][6] = 2;
//            jBlock[4][7] = 2;
//
//        } else if (x == 2) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    jBlock[i][j] = 0;
//                }
//            }
//            jBlock[4][4] = 2;
//            jBlock[4][5] = 2;
//            jBlock[4][6] = 2;
//            jBlock[4][7] = 2;
//
//        } else if (x == 3) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 10; j++) {
//                    jBlock[i][j] = 0;
//                }
//            }
//            jBlock[2][5] = 2;  
//            jBlock[3][5] = 2;
//            jBlock[3][6] = 2;
//            jBlock[4][6] = 2;
//        }
//    }


    //@Override
    public void createGrid() {
        jBlock[2][5] = 2;
        jBlock[3][5] = 2;
        jBlock[4][5] = 2;
        jBlock[4][4] = 2;
    }

    @Override
    public int getBlockArrayCoordinates(int x, int y) {
        return jBlock [x][y];
    }

    @Override
    public String toString() {
        String word = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                word = word + jBlock[i][j] + " ";
            }
            word = word + "\n";
        }
        return word;
    }
}
