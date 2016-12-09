import java.util.ArrayList;

public class StyleText extends Token{

	public StyleText(ArrayList<String> text) {
		super(text);
	      
	}
	public StyleText(ArrayList<String> text, String tag ) {
	      super(text);
	
	      if(tag.compareTo("*")==0){
	         this.type =5;
	      }else if(tag.compareTo("**")==0){
	         this.type =6;
	      }else if(tag.compareTo("***")==0){
	         this.type =7;
	      }
	   }

}
