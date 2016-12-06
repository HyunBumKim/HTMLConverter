import java.util.ArrayList;

public class Header extends Node {

	public int level;
	
	public Header(ArrayList<String> text ) {
		super(text);
		MDParser parser = new MDParser();
		parser.FirstTextParser(this.text, this.elements);
		this.type =1;
		
	}
	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();
		/*if(startIndex != 0)
			startIndex += -1;
			*/
		if(this.elements != null)
		{
			System.out.println("Node");
			for(MDElement element : this.elements)
			{
				element.accept(v);
			}
			v.visit(this);
		}
	}


}
