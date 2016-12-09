
public class Horizonta extends Node {
 
	public Horizonta() {
	  super();
	}
	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();
		v.visit(this);
		
	}

}
