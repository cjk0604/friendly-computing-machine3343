import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args){
		
		String csvFile = "new_node.txt"; // 1st attribute
        ArrayList<Node> test_nodes = new ArrayList<>(); // 2nd attribute
        ArrayList<String> node_information = new ArrayList<>(); // 3rd attribute

        // Create new instance ReadFile
        ReadFile files = new ReadFile(csvFile);
        // Function from ReadFile Class
        // read csv files
        files.readCSVFile(test_nodes, node_information);
        
        DijkstraAlgo DijkObject = DijkstraAlgo.getInstance();
        // Function 4 from DijkstraAlgo Class
        // initialize the edges
        DijkObject.initializeEdges(test_nodes, node_information);
        
        // Function 6 from DijkstraAlgo Class
        // Display all nodes and weight (distance) between them
        DijkObject.showAllNodeAndWeight(test_nodes);
       
       
		// nodes = {"LT1","LT2","LT3","LT4","LT5","LT6","LT7","LT8", ...};
       	ArrayList<Node> nodes = new ArrayList<>(); // 4th attribute
       	// Function 7 from DijkstraAlgo Class
       	// update test_nodes into nodes ArrayList
       	DijkObject.updateEdgesInNode(test_nodes, nodes);
       	
       	
     // ********************This is the user input part!!!!!!***********************
		//compute paths
       	// example " nodes.get(0) = "LT1"
       		
       		Node destNode = new Node(""); // 7th attribute
	    		System.out.println("Enter Source: ");
	    		Scanner scanner = new Scanner(System.in);// 6th attribute
	    		String source = scanner.nextLine(); // 8th attribute
	    		System.out.println("Enter Destination: ");
	    		String destination = scanner.nextLine(); // 9th attribute
	    		
	    		System.out.print(source + " ");
    	
	    		// Function 8 from DijkstraAlgo Class
	    		DijkObject.displayShortestpath(destNode, nodes, destination, source);
	    		
	    	 	scanner.close();
	    		
	    		
       	
       	System.out.println("Finished Search!");
      
				
		// ********************This is the user input part!!!!!!***********************
		

	}


}
