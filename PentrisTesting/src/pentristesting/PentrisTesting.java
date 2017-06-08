package pentristesting;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

public class PentrisTesting {

    static JFrame frame;
    static ArrayList blocks = new ArrayList<Block>();
    static Block currentBlock;
    static boolean youLose = false;
    public static int[][] colBoard = new int[25][10];
    static JFrame jf = new JFrame("Practice");
    public static int col = 0;

    public static void main(String[] args) throws LineUnavailableException {

        GraphicsBoard colorBoard = new GraphicsBoard();

        jf.add(colorBoard);

        jf.setSize(800, 700);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        populateBlocksList();

        pickBlock();            //randomly generates index and sets that block to currentBlock
        currentBlock.createGrid();

        for (int a = 0; a < 5; a++) //copies the current block to the big boardArray
        {
            for (int b = 0; b < 10; b++) {
                if (currentBlock.getBlockArrayCoordinates(a, b) == 2) {
                    Board.getBoardArray()[a][b] = currentBlock.getBlockArrayCoordinates(a, b);
                    colBoard[a][b] = col;
                }
            }
        }

        for (int a = 0; a < 25; a++) //prints the boardArray pre-shift 
        {
            for (int b = 0; b < 10; b++) {
                System.out.print(Board.getBoardArray()[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println();

        jf.addKeyListener(new KeyListener() {
            @Override

            public void keyTyped(KeyEvent ke) {
                ke.getKeyCode();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                if (code == KeyEvent.VK_LEFT) {
                    System.out.println("LEFTLEFTLEFTLEFTLEFTLEFTLEFTLEFTLEFT");
                    try {
                        System.out.println("shiftLeft Called");
                        shiftLeft();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    reprint();
                    placingBlock();
                    newBlock();
                    poppingLines();
                    try {
                        losing();
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (code == KeyEvent.VK_RIGHT) {
                    try {
                        System.out.println("shiftRight Called");

                        shiftRight();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    reprint();
                    placingBlock();
                    newBlock();
                    poppingLines();
                    try {
                        losing();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (code == KeyEvent.VK_UP) {
                    try {
                        System.out.println("rotate Called");

                        rotate();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    reprint();
                    placingBlock();
                    newBlock();
                    poppingLines();
                    try {
                        losing();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    try {
                        System.out.println("shiftDown Called");

                        shiftDown();
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    reprint();
                    placingBlock();
                    newBlock();
                    poppingLines();
                    try {
                        losing();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(PentrisTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                int code = ke.getKeyCode();

                if (code == KeyEvent.VK_DOWN) {
                }
                if (code == KeyEvent.VK_UP) {
                }
                if (code == KeyEvent.VK_RIGHT) {
                }
                if (code == KeyEvent.VK_LEFT) {
                }
            }
        });

    }

    public static void shiftDown() throws LineUnavailableException //shifts the current Block down one 
    {
        boolean shouldItMove = true;
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 10; x++) {
                if (Board.getBoardArray()[y][x] == 2) {
                    if (y == 24) {
                        shouldItMove = false;
                    } else if (Board.getBoardArray()[y + 1][x] == 1) {
                        shouldItMove = false;
                    }
                }
            }
        }
        if (shouldItMove == true) {
            for (int y = 24; y >= 0; y--) {
                for (int x = 0; x < 10; x++) {
                    if (Board.getBoardArray()[y][x] == 2) {
                        Board.getBoardArray()[y + 1][x] = Board.getBoardArray()[y][x];
                        colBoard[y + 1][x] = col;
                        Board.getBoardArray()[y][x] = 0;
                        colBoard[y][x] = 0;
                    }
                }
            }
        }
    }

    public static void shiftRight() throws LineUnavailableException //shifts the current Block right one
    {
        boolean shouldItMove = true;
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 10; x++) {
                if (Board.getBoardArray()[y][x] == 2) {
                    if (x == 9) {
                        shouldItMove = false;
                        return;
                    } else if (Board.getBoardArray()[y][x + 1] == 1) {
                        shouldItMove = false;
                        return;
                    }
                }
            }
        }
        if (shouldItMove == true) {
            for (int y = 0; y < 25; y++) {
                for (int x = 9; x >= 0; x--) {
                    if (Board.getBoardArray()[y][x] == 2) {
                        Board.getBoardArray()[y][x + 1] = Board.getBoardArray()[y][x];
                        colBoard[y][x + 1] = col;
                        Board.getBoardArray()[y][x] = 0;
                        colBoard[y][x] = 0;

                    }
                }
            }
        }
    }

    public static void shiftLeft() throws LineUnavailableException //shifts the current Block left one
    {
        boolean shouldItMove = true;
        int temp = 0;
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 10; x++) { //x was equal to 0 init.
                if (Board.getBoardArray()[y][x] == 2) {
                    if (x == 0) {
                        shouldItMove = false;
                        return;
                    } else if (Board.getBoardArray()[y][x - 1] == 1) {
                        shouldItMove = false;
                        return;
                    }
                }
            }
        }

        if (shouldItMove == true) {
            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 10; x++) {
                    if (Board.getBoardArray()[y][x] == 2) {
                        Board.getBoardArray()[y][x - 1] = Board.getBoardArray()[y][x];
                        colBoard[y][x - 1] = col;
                        Board.getBoardArray()[y][x] = 0;
                        colBoard[y][x] = 0;

                    }
                }
            }
        }
    }

    public static void rotate() throws LineUnavailableException //rotates the current Block 90 degrees clockwise
    {
        int x1 = 0, x2 = 0, y1 = 10, y2 = 0;
        int[][] origArr = new int[5][5];
        int[][] tempArr = new int[5][5];
        int[][] colOrigArr = new int[5][5];
        int[][] colTempArr = new int[5][5];
        //boolean shouldItMove = true;

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 10; j++) {
                if (Board.getBoardArray()[i][j] == 2) {
                    if (i >= x1 && x1 == 0) {
                        x1 = i;     //top row of array
                    }
                    if (j <= y1) {
                        y1 = j;     //left column of array
                    }
                }
            }
        }

        if (y1 < 6) {   //pull small array if the block is in columns 1-5
            if (x1 < 21) {
            } else if (x1 == 21) {
                x1 = x1 - 1;
            } else if (x1 == 22) {
                x1 = x1 - 2;
            } else if (x1 == 23) {
                x1 = x1 - 3;
            } else if (x1 == 24) {
                x1 = x1 - 4;
            }
        } else if (y1 == 6) {   //pull small array if the block is in column 6
            y1 = y1 - 1;
            if (x1 < 21) {
            } else if (x1 == 21) {
                x1 = x1 - 1;
            } else if (x1 == 22) {
                x1 = x1 - 2;
            } else if (x1 == 23) {
                x1 = x1 - 3;
            } else if (x1 == 24) {
                x1 = x1 - 4;
            }
        } else if (y1 == 7) {   //pull small array if the block is in column 7
            y1 = y1 - 2;
            if (x1 < 21) {
            } else if (x1 == 21) {
                x1 = x1 - 1;
            } else if (x1 == 22) {
                x1 = x1 - 2;
            } else if (x1 == 23) {
                x1 = x1 - 3;
            } else if (x1 == 24) {
                x1 = x1 - 4;
            }
        } else if (y1 == 8) {   //pull small array if the block is in column 8
            y1 = y1 - 3;
            if (x1 < 21) {
            } else if (x1 == 21) {
                x1 = x1 - 1;
            } else if (x1 == 22) {
                x1 = x1 - 2;
            } else if (x1 == 23) {
                x1 = x1 - 3;
            } else if (x1 == 24) {
                x1 = x1 - 4;
            }
        } else if (y1 == 9) {   //pull small array if the block is in column 9
            y1 = y1 - 4;
            if (x1 < 21) {
            } else if (x1 == 21) {
                x1 = x1 - 1;
            } else if (x1 == 22) {
                x1 = x1 - 2;
            } else if (x1 == 23) {
                x1 = x1 - 3;
            } else if (x1 == 24) {
                x1 = x1 - 4;
            }
        }

        for (int i = 0; i < 5; i++) {       //Transfering to small array
            for (int j = 0; j < 5; j++) {
                origArr[i][j] = Board.getBoardArray()[x1][y1];
                colOrigArr[i][j] = colBoard[x1][y1];
                y1++;
            }
            x1++;
            y1 = y1 - 5;
        }

        for (int i = 0; i < 5; i++) {       //printing origArr
            for (int j = 0; j < 5; j++) {
                System.out.print(origArr[i][j] + " ");

            }
            System.out.println("");
        }
        System.out.println("");

        int a = 4;
        for (int i = 0; i < 5; i++) {       //setting values from origArr to tempArr (rotated Array) 
            for (int j = 0; j < 5; j++) {
                tempArr[i][j] = origArr[a][i];
                colTempArr[i][j] = colOrigArr[a][i];
                a--;
            }
            a = 4;
        }
        for (int i = 0; i < 5; i++) {       //printing tempArr
            for (int j = 0; j < 5; j++) {
                System.out.print(tempArr[i][j] + " ");
            }
            System.out.println("");
        }

        boolean rotate = true;          //checking if rotating is possible
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tempArr[i][j] == 2 && origArr[i][j] == 1) {
                    rotate = false;
                }
            }
        }

        if (rotate == true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (origArr[i][j] == 2) {        //"erasing" the old shape
                        origArr[i][j] = 0;
                        colOrigArr[i][j] = 0;
                    }
                    if (tempArr[i][j] == 2) {       //setting the new shape
                        origArr[i][j] = tempArr[i][j];
                        colOrigArr[i][j] = colTempArr[i][j];
                    }
                }
            }

            x1 = x1 - 5;
            for (int i = 0; i < 5; i++) {       //Transfering small array back to big array
                for (int j = 0; j < 5; j++) {
                    Board.getBoardArray()[x1][y1] = origArr[i][j];
                    colBoard[x1][y1] = colOrigArr[i][j];
                    y1++;
                }
                x1++;
                y1 = y1 - 5;
            }
        }
    }

    public static void reprint() //prints the boardArray post-shift 
    {
        for (int a = 0; a < 25; a++) {
            for (int b = 0; b < 10; b++) {
                System.out.print(Board.getBoardArray()[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println("");

    }

    public static void populateBlocksList() //adds blocks to array list once
    {
        blocks.add(new IBlock4());
        blocks.add(new JBlock4());
        blocks.add(new LBlock4());
        blocks.add(new SBlock4());
        blocks.add(new TBlock4());
        blocks.add(new OBlock4());
        blocks.add(new ZBlock4());
        blocks.add(new IBlock5());
        blocks.add(new JBlock5());
        blocks.add(new LBLock5());
        blocks.add(new SBlock5());
        blocks.add(new TBlock5());
        blocks.add(new ZBlock5());
        blocks.add(new UBlock());
        blocks.add(new TurtleBlockA());
        blocks.add(new TurtleBlockB());
    }

    public static void pickBlock() //randomly generates index number and chooses that block from array list
    {
        int choice = 0;

        choice = (int) (Math.random() * (blocks.size() - 1));
        currentBlock = (Block) (blocks.get(choice));
        col = currentBlock.getColor();

        currentBlock.createGrid();

        for (int a = 0; a < 5; a++) //copies the current block to the big boardArray
        {
            for (int b = 0; b < 10; b++) {
                if (currentBlock.getBlockArrayCoordinates(a, b) == 2) {
                    Board.getBoardArray()[a][b] = currentBlock.getBlockArrayCoordinates(a, b);
                    colBoard[a][b] = col;
                }
            }
        }
    }

    public static void poppingLines() //break full lines and shift everything down
    {
        int count = 0;
        int row = 0;
        do {
            for (int i = 24; i >= 0; i--) {
                for (int j = 9; j >= 0; j--) {
                    if (Board.getBoardArray()[i][j] == 1) {
                        count = count + 1;
                    }
                }
                if (count == 10) {
                    row = i;
                    break;
                } else {
                    count = 0;
                }
            }

            if (count == 10) {
                for (int j = 0; j < 10; j++) {
                    Board.getBoardArray()[row][j] = 0;
                    colBoard[row][j] = 0;
                }

                for (int i = row; i >= 0; i--) {
                    for (int j = 9; j >= 0; j--) {
                        if (i != 0) {
                            Board.getBoardArray()[i][j] = Board.getBoardArray()[i - 1][j];
                            colBoard[i][j] = colBoard[i - 1][j];

                        }
                    }
                }
            }
        } while (count == 10);

    }

    public static void newBlock() {
        int count2 = 0;
        for (int a = 0; a < 25; a++) {
            for (int b = 0; b < 10; b++) {
                if (Board.getBoardArray()[a][b] == 2) {
                    count2++;
                }
            }
        }

        if (count2 == 0) {
            pickBlock();
        }

    }

    public static void placingBlock() //when block is dropped it changes to 1's
    {

        for (int a = 0; a < 25; a++) {
            for (int b = 0; b < 10; b++) {
                if (Board.getBoardArray()[a][b] == 2) {
                    if (a == 24) {  //checking if block is in last row
                        for (int i = 0; i < 25; i++) {
                            for (int j = 0; j < 10; j++) {
                                if (Board.getBoardArray()[i][j] == 2) {
                                    Board.getBoardArray()[i][j] = 1;
                                    //System.out.println("PLACED");
                                    // colBoard[i][j] = 1;
                                }
                            }
                        }
                    } else if (Board.getBoardArray()[a + 1][b] == 1) {  //checking if block has hit a 1 so it turns into 1's too
                        for (int i = 0; i < 25; i++) {
                            for (int j = 0; j < 10; j++) {
                                if (Board.getBoardArray()[i][j] == 2) {
//                                    try {
//                                        Thread.sleep(100);
//                                    } catch (InterruptedException ex) {
//                                        Logger.getLogger(GraphicsBoard.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
                                    Board.getBoardArray()[i][j] = 1;

                                    // colBoard[i][j] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void losing() throws LineUnavailableException //checks if you lose the game - placed block in 5th row
    {
        for (int i = 0; i < 10; i++) {
            if (Board.getBoardArray()[4][i] == 1) {
                youLose = true;
            }
        }

        if (youLose == true) {
            System.out.println("YOU LOSE");
            menu();
            System.exit(1);
        }

    }

    public static Board menu() throws LineUnavailableException {
        System.out.println("SHOULD DISPLAY A LOSE SCREEN\nWITH SCORE AND OPTION TO GO TO THE MENU");
        //selected by clicking on buttons (???) in menu
        int difficultySelected = 100;//very easy mode by default
        //100 for very easy, 90 for easy, 80 for medium, 75 for hard, 65 for very hard

        //Game Modes - G mode (doesn't drop on its own)
        //Very Easy, Easy, Medium, Hard
        //Carlos - !!!!!!!!!
        //Instructions 
        Board board = new Board(difficultySelected);
        return board;

    }
}
