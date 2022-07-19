import java.util.*;
// a. environment should be a 15x15 tile-based world that randomly generates nodes that are unpathable (blocks) in 10% of 
// the nodes (This should be done each time the program compiles ensuring that there are different environment makeups 
// each run.)
// b. The program should display the generated environment when the program runs, and should allow the user to 
// select a starting node and goal node. (done via text input into the console )
// once the start and goal nodes have been defined, the program should run the A* algorithm to find a path.
// i. The path should be displayed (series of [x,y] nodes, highlighting nodes, or actually moving the agent) if one exists, 
// ii. or a message indicating that a path could not be found.  
// c. user should be able to continue specifying starting and goal nodes after paths have been found.

public class Astarr {
    private static int set_hv_cost = 10; //the set horizontal and vertical cost to 10 
    private int hvCost;
    private Node[][] area;
    //used for start and goal node
    private Node firstNode;
    private Node goalNode;
    //create open and closed lists
    private PriorityQueue<Node> openList;
    private Set<Node> closedSet;

    //first constructor
    public Astarr(int rows, int cols, Node firstNode, Node goalNode, int hvCost) {
        this.hvCost = hvCost;
        setfirstNode(firstNode);
        setgoalNode(goalNode);
        this.area = new Node[rows][cols];
        this.openList = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node node0, Node node1) {
                return Integer.compare(node0.getF(), node1.getF());
            }
        });
        setNodes();
        this.closedSet = new HashSet<>();
    }

    public Astarr(int rows, int cols, Node firstNode, Node goalNode) {
        this(rows, cols, firstNode, goalNode, set_hv_cost);
    }

    private void setNodes() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                Node node = new Node(i, j);
                node.calculateHeuristic(getgoalNode());
                this.area[i][j] = node;
            }
        }
    }

    public void generateBlocks(int[][] blocksArray) {
        for (int i = 0; i < blocksArray.length; i++) {
            int row = blocksArray[i][0];
            int col = blocksArray[i][1];
            setBlock(row, col);
        }
    }

    public List<Node> findPath() {
        openList.add(firstNode);

        while (!isEmpty(openList)) {
            Node currentNode = openList.poll();
            closedSet.add(currentNode);
            
            if (isgoalNode(currentNode)) {
                return getPath(currentNode);
            } else {
                addNextNodes(currentNode);
            }
        }
        return new ArrayList<Node>();
    }

    private List<Node> getPath(Node currentNode) {
        List<Node> path = new ArrayList<Node>();
        path.add(currentNode);
        Node parent;
        while ((parent = currentNode.getParent()) != null) {
            path.add(0, parent);
            currentNode = parent;
        }
        return path;
    }

    private void addNextNodes(Node currentNode) {
        addTopRow(currentNode);
        addMiddleRow(currentNode);
        addBottomRow(currentNode);
    }

    private void addBottomRow(Node currentNode) {
        int row = currentNode.getRow();
        int col = currentNode.getCol();
        int lowerRow = row + 1;
        if (lowerRow < getarea().length) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, lowerRow, lowerRow); //getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            if (col + 1 < getarea()[0].length) {
                checkNode(currentNode, col + 1, lowerRow, lowerRow); //getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            checkNode(currentNode, col, lowerRow, getHvCost());
        }
    }

    private void addMiddleRow(Node currentNode) {
        int row = currentNode.getRow();
        int col = currentNode.getCol();
        int middleRow = row;
        if (col - 1 >= 0) {
            checkNode(currentNode, col - 1, middleRow, getHvCost());
        }
        if (col + 1 < getarea()[0].length) {
            checkNode(currentNode, col + 1, middleRow, getHvCost());
        }
    }

    private void addTopRow(Node currentNode) {
        int row = currentNode.getRow();
        int col = currentNode.getCol();
        int upperRow = row - 1;
        if (upperRow >= 0) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, upperRow, upperRow);
            }
            if (col + 1 < getarea()[0].length) {
                checkNode(currentNode, col + 1, upperRow, upperRow);
            }
            checkNode(currentNode, col, upperRow, getHvCost());
        }
    }

    private void checkNode(Node currentNode, int col, int row, int cost) {
        Node nextNode = getarea()[row][col];
        if (!nextNode.isBlock() && !getClosedSet().contains(nextNode)) {
            if (!getOpenList().contains(nextNode)) {
                nextNode.setNodeData(currentNode, cost);
                getOpenList().add(nextNode);
            } else {
                boolean changed = nextNode.checkStartCost(currentNode, cost);
                if (changed) {
                    //updates the open list by addiing or removing the changed node to update the queue                    
                    getOpenList().remove(nextNode);
                    getOpenList().add(nextNode);
                }
            }
        }
    }

    private boolean isgoalNode(Node currentNode) {
        return currentNode.equals(goalNode);
    }

    private boolean isEmpty(PriorityQueue<Node> openList) {
        return openList.size() == 0;
    }

    private void setBlock(int row, int col) {
        this.area[row][col].setBlock(true);
    }

    public Node getfirstNode() {
        return firstNode;
    }

    public void setfirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getgoalNode() {
        return goalNode;
    }

    public void setgoalNode(Node goalNode) {
        this.goalNode = goalNode;
    }

    public Node[][] getarea() {
        return area;
    }

    public void setarea(Node[][] area) {
        this.area = area;
    }

    public PriorityQueue<Node> getOpenList() {
        return openList;
    }

    public void setOpenList(PriorityQueue<Node> openList) {
        this.openList = openList;
    }

    public Set<Node> getClosedSet() {
        return closedSet;
    }

    public void setClosedSet(Set<Node> closedSet) {
        this.closedSet = closedSet;
    }

    public int getHvCost() {
        return hvCost;
    }

    public void setHvCost(int hvCost) {
        this.hvCost = hvCost;
    }

}