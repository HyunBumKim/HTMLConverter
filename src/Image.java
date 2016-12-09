import java.util.ArrayList;

public class Image extends Token {
	 String linkElements; 
		
	 public Image(ArrayList<String> contents) {
	      super(null);
	      if(contents.size() == 3)
	      {
	    	  this.linkElements = "<img scr = \"" + contents.get(1) + "\"  alt = \""+contents.get(0)+"\""
	    			  + " tyle = "+contents.get(2)+">\n";
	      }
	      else
	      {
	    	  this.linkElements = "<img scr = \"" + contents.get(1) + "\"  alt = \""+contents.get(0)+"\">\n";

	      }
	   }
	   public void accept(MDElementVisitor v)
	   {
	      startIndex = Document.HtmlStr.length();
	      v.visit(this);
	      
	   }

}
