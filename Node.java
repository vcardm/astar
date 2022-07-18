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
	public void calculateHeuristic(Node finalNode) {
        this.h = Math.abs(finalNode.getRow() - getRow()) + Math.abs(finalNode.getCol() - getCol());
    }
    
    public void setNodeData(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
         setParent(currentNode);
         setG(gCost);
         calculateFinalCost();
    }
    
    public boolean checkBetterPath(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        if (gCost < getG()) {
            setNodeData(currentNode, cost);
            
            return true;
        }
         return false;
    }
    
    private void calculateFinalCost() {
        int finalCost = getG() + getH();
        setF(finalCost);
    }
	//mutator methods to set values
	public void setF(){
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
	
	public boolean equals(Object in){
		//typecast to Node
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	public String toString(){
		return "Node: " + row + "_" + col;
	}
	
}
