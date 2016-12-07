import java.util.ArrayList;

public class StyleText extends Token{

	public StyleText(ArrayList<String> text, String tag ) {
	      super(text);
	      if(tag.compareTo("*")==0){
	         this.type =5;
	      }else if(tag.compareTo("**")==0){
	         this.type =6;
	      }else if(tag.compareTo("***")==0){
	         this.type =7;
	      }
	   }
	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();

		if(this.elements != null)
		{
			for(MDElement element : this.elements)
			{
				element.accept(v);
			}
			v.visit(this);
		}
	}
}
