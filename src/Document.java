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
		
		HtmlStr = new String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n");
		fileContents = new ArrayList<String>();
		Document.elements = new ArrayList<MDElement>();
		try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s;

	          int i =0;
	          
	          while((s = in.readLine()) != null){
	            	  fileContents.add(s+"\n");
	              i++;
	          }
	        
	          in.close();

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
		for(MDElement element : Document.elements)
		{ 
			element.accept(v);
			i++;
		}
		v.visit(this);
	}
	
	
	
}
