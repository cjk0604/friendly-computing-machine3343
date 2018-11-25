import java.util.ArrayList;

//define Node
class Node implements Comparable<Node>{
	
	public final String value;
	public Edge[] adjacencies;
	public double shortestDistance = Double.POSITIVE_INFINITY;
	public Node parent;

	public Node(String val){
		value = val;
	}

	public String toString(){
			return value;
	}
	
	public Node toNode() {
		return this;
	}

	public int compareTo(Node other){
		return Double.compare(shortestDistance, other.shortestDistance);
	}

}

