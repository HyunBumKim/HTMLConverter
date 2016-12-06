import java.util.ArrayList;

public class QuotedBlock extends Node{

	public QuotedBlock(ArrayList<String> text) {
		super(text);
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
		}
			v.visit(this);
		
	}
}
