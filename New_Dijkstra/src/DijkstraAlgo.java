import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class DijkstraAlgo{
/* Dijkstra Algorithm
 * 
 *
 */
	// Function 1
	public static void computePaths(Node source){
		source.shortestDistance=0;

		//implement a priority queue
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(source);

		while(!queue.isEmpty()){
			Node u = queue.poll();

			/*visit the adjacencies, starting from 
			the nearest node(smallest shortestDistance)*/
			
			for(Edge e: u.adjacencies){

				Node v = e.target;
				double weight = e.weight;

				//relax(u,v,weight)
				double distanceFromU = u.shortestDistance+weight;
				if(distanceFromU<v.shortestDistance){

					/*remove v from queue for updating 
					the shortestDistance value*/
					queue.remove(v);
					v.shortestDistance = distanceFromU;
					v.parent = u;
					queue.add(v);

				}
			}
		}
	}

	// Function 2
	public static List<Node> getShortestPathTo(Node target){

		//trace path from target to source
		List<Node> path = new ArrayList<Node>();
		for(Node node = target; node!=null; node = node.parent){
			path.add(node);
		}


		//reverse the order such that it will be from source to target
		Collections.reverse(path);

		return path;
	}
	
	// Function 3
	public static String calculateEstimatedTime(double distance) {
		// average human walking speed 1.4m per second
		double totalTimeTaken = Double.parseDouble(String.format("%.2f", (distance / 1.4)));
		int timeInMinute = (int)totalTimeTaken / 60;
		
		
		if(timeInMinute >= 1) {
			totalTimeTaken = (totalTimeTaken - timeInMinute * 60);
			return timeInMinute + " minutes " + Double.parseDouble(String.format("%.2f", totalTimeTaken)) + " seconds";
		}
		else {
			return totalTimeTaken + " seconds";
		}
	}
	
	// Function 4
	// initialize the edges
	public static void initializeEdges(ArrayList<Node> test_nodes, ArrayList<String> node_information) {
		String cvsSplitBy = ",";
		for(Node n: test_nodes) {
    		int index = 0;
    		ArrayList<Edge> temp_edges = new ArrayList<Edge>();
    		for(String s: node_information) {
    			String[] split_info = s.split(cvsSplitBy);
	    			
	    			if(n.toString().equals(split_info[5])) {
	    				for(Node node_oneMore: test_nodes) {
	    					if(node_oneMore.toString().equals(split_info[6])) {
	    						temp_edges.add(new Edge(node_oneMore.toNode(), Integer.parseInt(split_info[7])));
	    						index++;
	    					}
	    				}
	    			}
	    			else if(n.toString().equals(split_info[6])){
	    				for(Node node_oneMore: test_nodes) {
	    					if(node_oneMore.toString().equals(split_info[5])) {
	    						temp_edges.add(new Edge(node_oneMore.toNode(), Integer.parseInt(split_info[7])));
	    						index++;
	    					}
	    				}
	    			}
	    		}
	    		
	    		//update the distance (weight) between nodes next each other
	    		Edge[] temp_edges_array = new Edge[temp_edges.size()];
	    		for(int i = 0; i < temp_edges.size(); i++) {
	    			temp_edges_array[i] = temp_edges.get(i);
	    		}
	    		n.adjacencies = new Edge[temp_edges_array.length];
	    		for(int i = 0; i < temp_edges_array.length; i++) {
	    			n.adjacencies[i] = temp_edges_array[i];
	    			//System.out.println(temp_edges_array[i]);
	    			//System.out.println(n.adjacencies[i]);
	    		}
	    }
	}

	// Function 5
	// read csv files
	public static void readCSVFile(String csvFile, ArrayList<Node> test_nodes, ArrayList<String> node_information) {
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String headerLine = br.readLine();	// Ignore the first row, header
            System.out.println("Header, first row is skipped");
            while ((line = br.readLine()) != null) {
            		
            		// add each line in ArrayList
            		node_information.add(line);
                // use comma as separator
                String[] test_node = line.split(cvsSplitBy);
                
                String node_name = test_node[1];
                // For debugging if all data are sucessfully extracted from csv file
                /*
                System.out.println("node [node name= " + test_node[1] + 
                		" , node_start=" + test_node[5] + 
                		", node_finish =" + test_node[6] + 
                		", weight (distance between them) =" + test_node[7] + "]");
                	*/
                
              //initialize the graph base on the CityU Campus map
                test_nodes.add(new Node(node_name));
                
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
	}

	
	// Function 6
	// to display Edge, Node and weight (distance)
	public static void showAllNodeAndWeight(ArrayList<Node> test_nodes) {
		
		for(Node n: test_nodes) {
	   		for(Edge s: n.adjacencies) {
	   			System.out.println("From: '" + n + "'"
	   			+ "To: '" + s.target + "' "
	   			+ " the Weight (distnace) is: " + s.weight + "m");
	   		}
		}
		
	}
	
	// Function 7
	// update edges into node
	public static void updateEdgesInNode(ArrayList<Node> test_nodes, ArrayList<Node> nodes) {
		for(Node n: test_nodes) {
       		nodes.add(n);
       	}
	}
	
	// Function 8
	// Display shortest path in console
	public static void displayShortestpath(Node destNode, ArrayList<Node> nodes, String destination, String source) {
		
		for (int counter = 0; counter < nodes.size(); counter++) {
			if (nodes.get(counter).toString().equals(source)) {
				computePaths(nodes.get(counter)); // Sets source
			}
			if (nodes.get(counter).toString().equals(destination)) {
				destNode = nodes.get(counter); // Sets Destination
			}
		}
		
		// Print shortest paths and distance
		// example " nodes.get(12) = "LT13"
		List<Node> path = getShortestPathTo(destNode);
		System.out.println("Path: " );
		for(Node n: path) {
			
			if(path.get(path.size()-1).equals(n)) {
				
				System.out.print(n + " (Destination)!" + '\n');
				System.out.println("Distance to " + 
						n + ": " + n.shortestDistance + "m");
				
				
				System.out.println("Estimated Time Taken to " + 
						n + ": " + calculateEstimatedTime(n.shortestDistance));
			}
			else {
				System.out.print(n + " -> " );
			}
		}
		
	}

}
