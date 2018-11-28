import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args){
		
		String csvFile = "node.txt"; // 1st attribute
        ArrayList<Node> test_nodes = new ArrayList<>(); // 2nd attribute
        ArrayList<String> node_information = new ArrayList<>(); // 3rd attribute

        // Function 5 from DijkstraAlgo Class
        // read csv files
        DijkstraAlgo.readCSVFile(csvFile, test_nodes, node_information);
        
        // Function 4 from DijkstraAlgo Class
        // initialize the edges
        DijkstraAlgo.initializeEdges(test_nodes, node_information);
        
        // Function 6 from DijkstraAlgo Class
        // Display all nodes and weight (distance) between them
        DijkstraAlgo.showAllNodeAndWeight(test_nodes);
       
       
		//Node[] nodes = {"LT1","LT2","LT3","LT4","LT5","LT6","LT7","LT8", ...};
       	ArrayList<Node> nodes = new ArrayList<>(); // 4th attribute
       	// Function 7 from DijkstraAlgo Class
       	// update test_nodes into nodes ArrayList
       	DijkstraAlgo.updateEdgesInNode(test_nodes, nodes);
       	
       	
       	
     // ********************This is the user input part!!!!!!***********************
		//compute paths
       	// example " nodes.get(0) = "LT1"
       	
		Node destNode = new Node("");
		System.out.println("Enter Source: ");
		Scanner scanner = new Scanner(System.in);
		String source = scanner.nextLine();
		System.out.println("Enter Destination: ");
		String destination = scanner.nextLine();
		scanner.close();
		System.out.print(source);
	
		// Function 8 from DijkstraAlgo Class
		DijkstraAlgo.displayShortestpath(destNode, nodes, destination, source);
				
		// ********************This is the user input part!!!!!!***********************
		

	}


}
