import java.util.*;

public class Main {
    public static void main(String[] args) {
        int row, col = 0;

        //b. getting users input 
        Scanner in = new Scanner(System.in);

        //user input for starting node
        System.out.println("Enter the starting node, specifying the row and column (x y): ");
        row = in.nextInt(); //save input in respected x,y -> row/columns
        col = in.nextInt();
        Node firstNode = new Node(row, col);

        ////user input for goal node
        System.out.print("Enter the goal node, specifying the row and column (x y): ");
        row = in.nextInt(); //save input in respected x,y -> row/columns
        col = in.nextInt();
        Node goalNode = new Node(row, col);
        int rows = 15;
        int cols = 15;

        //generating path using Astar
        Astarr path = new Astarr(rows, cols, firstNode, goalNode);
        int[][] blocksArray = new int[][]{{(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), 
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
                for (int b = 0; b < blocksArray.length; b++) { //displays somes blocks
                    row = blocksArray[b][0];
                    col = blocksArray[b][1];
                    if(row==i && col==j) {
                        System.out.print("*"+" ");
                        block=1;
                    }
                }
                if(block==0)
                System.out.print("<>"+" ");
            }
            System.out.println("\n");
        }
        path.generateBlocks(blocksArray);
        List<Node> optimalPath = path.findPath();
        for (Node node : optimalPath) {
            System.out.print("["+node.getRow()+","+node.getCol()+"] ");
        }
    }
}