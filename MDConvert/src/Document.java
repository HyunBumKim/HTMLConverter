import java.util.ArrayList;

public class Document implements MDElement {
	ArrayList<MDElement> elements;
	private ArrayList<String> fileContents;
	
	Document(ArrayList<String> fileContents)
	{
		this.fileContents = fileContents;
	}
	
	public void updateElements()
	{
		
	}
	
	public void accept(MDElementVisitor v)
	{
		for(MDElement element : this.elements)
		{
			element.accept(v);
		}
		v.visit(this);
		
	}
	
	
	
}
