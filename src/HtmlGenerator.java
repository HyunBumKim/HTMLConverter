import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.tidy.Tidy;

public class HtmlGenerator {
	static String result="";
	HtmlGenerator(String outputFileName, Document document,String style)
	{
		String s;
		try {
		      MDElementVisitor visitor = null;
		      
		      switch(style)
		      {
		      case "plain":
		    	  System.out.println("visitor Plain");
		    	  visitor = new PlainVisitor();
		    	  break;
		      case "fancy":
		    	  visitor = new FancyVisitor();
		    	  break;
	     	    }
		      
		      document.accept(visitor);

		      System.out.println("=========html============");
		      System.out.print(Document.HtmlStr);
		      result = Document.HtmlStr;
		      
		      BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
		      
		      out.write(Document.HtmlStr);
		      out.close();
		      
			  FileInputStream file = new FileInputStream(outputFileName);
			  Tidy tidy = new Tidy();
			  
			  System.out.println("==================Jtidy checking HTML Syntax===================");
			  tidy.parse(file, System.out);
			  
			  if(tidy.getParseErrors() == 0)
					 System.out.println("Valid html Syntax!");
			  else
					System.out.println("Invalid html Syntax!");	
			  
			  file.close();
			      
		      ////////////////////////////////////////////////////////////////
		    } catch (IOException e) {
		        System.err.println(e); // 에러가 있다면 메시지 출력
		        System.exit(1);
		    }   
	}
}
