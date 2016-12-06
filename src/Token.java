import java.util.ArrayList;

public class Token implements MDElement{
public ArrayList<String> contents;
public ArrayList<MDElement> elements;
public int startIndex;
public int type;

	@SuppressWarnings("unchecked")
	public Token(ArrayList<String> contents) {
		if(contents!=null)
		{
			contents = (ArrayList<String>)contents.clone();
			System.out.println("token");
		
		elements = new ArrayList<MDElement>();
		(new MDParser()).FirstTextParser(this.contents,this.elements);
		}
}


	public void updateContents(){
		
	}

	
	public void accept(MDElementVisitor v)
	{ 
		startIndex = Document.HtmlStr.length();
		System.out.println("token");
		if(this.elements!=null)
		{
			System.out.println("token");
			for(MDElement element : this.elements)
			{
				element.accept(v);
			}
		}
				v.visit(this);
		
	}
	
}
	
