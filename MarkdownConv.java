import java.io.*;
import java.util.ArrayList;
	
public class MarkdownConv {

	private static ArrayList<String> node;
	
	public static void main(String[] args) {
		node = new ArrayList<String>();
	    
	    if(args.length==0){
	       System.err.println("input Filename...");
	       System.exit(1);
	    }
	    
	    for(int i=1; i<args.length;i++){
	       if(args[i].indexOf("-")==0)
	          args[i]=args[i].replaceFirst("-", "");
	       else{
	          System.err.println("invalid option!");
	          return;
	       }
	       switch(args[i]){
	          case "help":
	          default:
	       }
	    }
	    try{
	       BufferedReader in = new BufferedReader(new FileReader(args[0]));
	       String s;
	       
	       while((s = in.readLine()) != null){
	          node.add(s);
	       }
	       in.close();
	    }
	    catch(IOException e){
	       System.err.println(e);
	       System.exit(1);
	    }
	}
}
