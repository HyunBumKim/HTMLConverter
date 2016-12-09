import java.util.ArrayList;

public class Link extends Token{
   String linkElements; 
	
   public Link(ArrayList<String> txt) {
      super(null);
      //this.linkElements = new String();
      this.linkElements = "<a href=\"" + txt.get(1) + "\">"+txt.get(0)+"</a>";
   }
   public void accept(MDElementVisitor v)
   {
      startIndex = Document.HtmlStr.length();
      v.visit(this);
      
   }

}

