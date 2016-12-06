import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Document implements MDElement {
	static ArrayList<MDElement> elements;
	static String HtmlStr; 
    ArrayList<String> fileContents;
	
	@SuppressWarnings("unchecked")
	Document(String InputFileName,MDParser parser)
	{
		
		HtmlStr = new String();
		fileContents = new ArrayList<String>();
		Document.elements = new ArrayList<MDElement>();
		
		try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s;
	          System.out.println("5");
	          int i =0;
	          
	          while((s = in.readLine()) != null){
	              if(i != 0)
	            	  fileContents.add(s+"\n");
	              i++;
	             System.out.println(s);
	          }
	        
	          in.close();
	          System.out.println("5");
	          parser.FirstTextParser(fileContents,Document.elements);
	          
	        
	          
	       }
	       catch(IOException e){
	          System.err.println(e);
	          System.exit(1);
	       }
		 catch(NullPointerException e)
		 {
			 System.out.println(e);
			 System.out.println("java [program name] -md/[InputFile] -html/[OutputFile] -style/[style]");
		 }
	
	}
	
	public void updateElements()
	{
		
	}
	
	public void accept(MDElementVisitor v)
	{
		int i =0;
		System.out.println("Document");
		for(MDElement element : Document.elements)
		{ 
			
			System.out.println("element num = "+i);
			element.accept(v);
			i++;
		}
		v.visit(this);
		
	}
	
	
	
}
