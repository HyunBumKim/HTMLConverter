import java.util.ArrayList;

public class Token implements MDElement{
public String contents;
public ArrayList<Token> tokens;
	
	public Token(String text) {
		contents = text;
}


	public void updateContents(){
		
	}

	
	public void accept(MDElementVisitor v){ 
			v.visit(this);
	}
}
	
