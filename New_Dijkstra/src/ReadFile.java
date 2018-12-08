import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	private static String csvFile;
	
	public ReadFile(String csvFile) {
		ReadFile.csvFile = csvFile;
	}
	
	public static void readCSVFile(ArrayList<Node> test_nodes, ArrayList<String> node_information) {
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String headerLine = br.readLine();	// Ignore the first row, header
            System.out.println("Start the Application");
            while ((line = br.readLine()) != null) {
            		
            		// add each line in ArrayList
            		node_information.add(line);
                // use comma as separator
                String[] test_node = line.split(cvsSplitBy);
                
                String node_name = test_node[1];

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
}
