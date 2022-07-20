import java.util.*;

public class Main {
    public static void main(String[] args) {
        int row, col = 0;

        //b. getting users input 
        Scanner in = new Scanner(System.in);

        //user input for starting node
        System.out.println("-Starting Node-");
        // while {
            do {
                System.out.println("Enter the starting node, specifying the row (x) Ensuring it is greater than 0: ");
                row = in.nextInt();
            } while ( !(row > 0) ); 
            do {
                System.out.println("Enter the starting node, specifying the column (y) Ensuring it is greater than 0: ");
                col = in.nextInt();
            } while (!(col > 0));
        // System.out.println("Enter the starting node, specifying the row and column (x y): ");
        // row = in.nextInt(); //save input in respected x,y -> row/columns
        // col = in.nextInt();
        
        // while (row < 0 & col < 0){
        //     System.out.println("NO path");
        // }
        Node firstNode = new Node(row, col);//save users input in firstNode as the starting node

        ////user input for goal node
        //do-while loop to ensure it is a poristive number for it be pathable  b i.
        System.out.println("-Goal Node-");
        // while {
            do {
                System.out.println("Enter the goal node, specifying the row (x) Ensuring it is greater than 0: ");
                row = in.nextInt();
            } while ( !(row > 0) ); 
            do {
                System.out.println("Enter the goal node, specifying the column (y) Ensuring it is greater than 0: ");
                col = in.nextInt();
            } while (!(col > 0));
        // System.out.print("Enter the goal node, specifying the row and column (x y): ");
        // row = in.nextInt(); //save input in respected x,y -> row/columns
        // col = in.nextInt();
        // if (row < 0){
        //     System.out.println("NO path");
        // }
        // if (col < 0){
        //     System.out.println("NO path");
        // }
        Node goalNode = new Node(row, col); //save users input in goalNode as the final/goal node

        int rows = 15;
        int cols = 15;

        //generating path using our 15*15 and implementing blocks - 10% = 21 blocks in the environemnt 
        Astarr path = new Astarr(rows, cols, firstNode, goalNode);
        int[][] blocksArray = new int[][]{{(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
            (int) (Math.random()*10)}};
            
            row = 0;
            col = 0;

            //b. i. displaying environemnt
        System.out.println("Envrionment:");
        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int block = 0;
                for (int b = 0; b < blocksArray.length; b++) { //displays the blocked nodes
                    row = blocksArray[b][0];
                    col = blocksArray[b][1];
                    if(row==i && col==j) {
                        System.out.print("*"+" ");
                        block=1;
                    }
                }
                if(block==0)
                System.out.print("<>"+" "); //actual output of envuronement 
            }
            System.out.println("\n");
        }
        path.generateBlocks(blocksArray);
        List<Node> optimalPath = path.findPath();

        System.out.println("-Path-");
        System.out.println("From Start Node to Goal Node:");
        for (Node node : optimalPath) {
            //outputs path
            System.out.print("["+node.getRow()+","+node.getCol()+"] ");
        }
    }
}