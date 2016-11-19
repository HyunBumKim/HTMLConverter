import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MDParser {
	
	ArrayList<String> fileContents;

	MDParser(String InputFileName)
	{
		 try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s;
	          while((s = in.readLine()) != null){
	             fileContents.add(s);
	          }
	          //dc.set(temp);
	          in.close();
	       }
	       catch(IOException e){
	          System.err.println(e);
	          System.exit(1);
	       }
	}
	
	
}
