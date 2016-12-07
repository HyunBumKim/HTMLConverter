import java.util.ArrayList;

public class Link extends Node{
	public Link(ArrayList<String> text) {
		super(text);
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
