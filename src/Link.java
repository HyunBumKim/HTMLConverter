import java.util.ArrayList;

public class Link extends Node{
	
	public Link(ArrayList<String> txt) {
		super(null);
		this.text = new ArrayList<String>();
		this.text.add(0,"<a href=\"" + txt.get(1) + "\">"+txt.get(0)+"</a>");
	}
	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();
		v.visit(this);
		
	}

}
