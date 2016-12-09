import java.util.ArrayList;

public class QuotedBlock extends Node{

	public QuotedBlock(ArrayList<String> text) {
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
