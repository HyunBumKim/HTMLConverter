import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.tidy.Tidy;

public class HtmlGenerator {

	HtmlGenerator(String outputFileName, Document document,String style)
	{
		try {
		      ////////////////////////////////////////////////////////////////
		      //BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
			
				/*
		      MDElementVisitor visitor = null;
		      
		      switch(style)
		      {
		      case "plain":
		    	  visitor = new PlainVisitor();
		    	  break;
		      case "fancy":
		    	  visitor = new FancyVisitor();
		    	  break;
		      case "slide":
		    	  visitor = new SlideVisitor();
		    	  break;
		      }
		      
		      document.accept(visitor);
*/
		      //out.write(document.elements.get(0).text); out.newLine();
		      //out.write(s); out.newLine();
			  BufferedWriter out = new BufferedWriter(new FileWriter("text.html"));
			  Tidy tidy = new Tidy();
			  
			  if(tidy.getParseErrors() == 0)
					 System.out.println("Valid html Syntax!");
			  else
					System.out.println("Invalid html Syntax!");	
			  
		      out.close();
		      ////////////////////////////////////////////////////////////////
		    } catch (IOException e) {
		        System.err.println(e); // ������ �ִٸ� �޽��� ���
		        System.exit(1);
		    }
	}
	
	
}
