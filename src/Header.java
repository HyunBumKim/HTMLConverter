import java.util.ArrayList;

public class Header extends Node {

	public int level;
	
	public Header(ArrayList<String> text,int headerLevel) {
		super(text);
		level = headerLevel;		
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
		}
		v.visit(this);
		
	}


}
