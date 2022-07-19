public class Node {
	private int row, col, f, g, h;
	private Node parent;
	private boolean isBlock; //when calculating the path
	
	public Node(int r, int c){ // int t
		super();
		row = r;
		col = c;
// 		type = t;
// 		parent = null;
		//type 0 is traverseable, 1 is not
	}
	
	//new methods
	public void calculateHeuristic(Node goalNode) { //used in SetNodes for calulcating the heuristic
        this.h = Math.abs(goalNode.getRow() - getRow()) + Math.abs(goalNode.getCol() - getCol());
    }
    
    public void setNodeData(Node currentNode, int cost) { //used in filepath when checking for betterpath, if the new g cost is less than the original g cost, set the node with the new g cost
        int gCost = currentNode.getG() + cost;
         setParent(currentNode);
         setG(gCost);
         calculateFinalCost();
    }
    
    public boolean checkBetterPath(Node currentNode, int cost) { //used in checkNode in filepath in order to remove/add to the openlist (nodes discovered by not visisted yet)
        int gCost = currentNode.getG() + cost;
        if (gCost < getG()) {
            setNodeData(currentNode, cost);
            
            return true;
        }
         return false;
    }
    
    private void calculateFinalCost() { //used in setNodeData
        int finalCost = getG() + getH();
        setF(finalCost);
    }
	//mutator methods to set values
	public void setF(int value){
		f = g + h;
	}
	public void setG(int value){
		g = value;
	}
	public void setH(int value){
		h = value;
	}
	public void setParent(Node n){
		parent = n;
	}
	
	//accessor methods to get values
	public int getF(){
		return f;
	}
	public int getG(){
		return g;
	}
	public int getH(){
		return h;
	}
	public Node getParent(){
		return parent;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	
	//updated to include isBlock
	public boolean isBlock() {
        	return isBlock;
    	}
    
    	public void setBlock(boolean isBlock) {
        	this.isBlock = isBlock;
    	}
	
	public boolean equals(Object in){
		//typecast to Node
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	public String toString(){
		return "Node: " + row + "_" + col;
	}
	
}