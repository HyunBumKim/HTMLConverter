import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

public class MDParser {
		
	   public void FirstTextParser(ArrayList<String> fileContents, ArrayList<MDElement> elements)
	   {
		   
		  int i = 0;
		  ArrayList<String> buff = new ArrayList<String>();
		  
	      for(i = 0; i < fileContents.size(); i++)
	      {	
	      buff.clear();
	      String line = fileContents.get(i);
	      
	      // when line is a space string.
	      if(line.matches("^\\s*$"))
	      {
	    	  continue;
	      }
	      
	      String downline;
	      
	      //when line is a last line.
	      if(i == (fileContents.size()-1) )
	      { 
	    	  downline = ""; 
	      }
	      else 
	    	  downline = fileContents.get(i+1);
	    

	      
	      /////////////////////////code block///////////////////////////////////
	      if(line.matches(" + + + +\\S+(\\S|\\s|\r\n|\n|\r)*")||line.matches(" *\t+ *\\S+(\\S|\\s|\r\n|\n|\r)*"))
	      {
	    	  String bufStr = "";
	    	  
	    	  while(i < fileContents.size())
	    	  {

	    	      if(line.matches("^ + + + +(\\S|\\s|\r\n|\n|\r)*")||line.matches("^ *\t+(\\S|\\s|\r\n|\n|\r)*")||line.matches("^(\\s|\r\n|\n|\r)*$"))
	    	      {
	    		   bufStr += line.trim(); // remove space in front and back of line.
	    		   bufStr+="\n";
	    	      }
	    	      else 
	    	      { 
	    	    	  i--; // line is not in code block so this line has to be checked in order to know this line's element type
	    	    	  elements.add(new CodeBlock(bufStr));
	    	    	  break;
	    	      }
	    		 
	    	      i++;
	    	      if(i < fileContents.size())
	    	      {
	    	    	  line = fileContents.get(i);
	    	    	  if(i == fileContents.size()-1)
	    	    		  downline = "";
	    	    	  else
	    	    		  downline = fileContents.get(i+1); 
	    	      }
	    	      else if(i == fileContents.size())
	    	      {
	    	    	  elements.add(new CodeBlock(bufStr));
	    	    	  return;
	    	      }
	    	      else // when finishing dividing all elements of file
	    	    	  return;
	    	  }
	    	  continue;

	      }/////////////////////////quoted block///////////////////////
	      else if(line.matches("^\\s*>+(\\S|\\s|\r\n|\n|\r)*"))
	      {
	    	  buff.clear();
	    	  //buff.add("");
	    	  
	    	  String bufStr = "";
	    	  while(i < fileContents.size())
	    	  {
	    	      if(line.matches("^\\s*>+(\\S|\\s|\r\n|\n|\r)*"))
	    	      {
	    		   bufStr += line.substring(line.indexOf(">")+1); // except char ">"
	    	      }
	    	      else 
	    	      {
	    	    	  bufStr += line;
	    	      }
	    
	    		 
	    	       //when next line is a escape line of quotedBlock.
	    		 if(downline.matches("^(\\s|\r\n|\n|\r)*$"))
	    		  {
	    			  buff.add(bufStr);
	    			  elements.add(new QuotedBlock(buff));
	    			  i++;
	    			  break;
	    		  }
    		 
	    	      i++;
	    	      if(i < fileContents.size())
	    	      {
	    	    	  line = fileContents.get(i);
	    	    	  if(i == fileContents.size()-1)
	    	    		  downline = "";
	    	    	  else
	    	    		  downline = fileContents.get(i+1); 

	    	      }
	    	      else // when finishing dividing all elements of file
	    	    	  return;
	    	      
	    	     
	    	  }
	    	  continue;
	    	 
	      }
	     
	      //header  when downline is like === or ---
	      	if(downline.matches("^\\s*=+=+=+(\\s|\r\n|\n|\r)*$") || downline.matches("^\\s*-+-+-+(\\s|\r\n|\n|\r)*$"))//header와 horizontal 구분하도록 해야함
	    	  {    //when downline is horizonta line
	    		  if(line.matches("^(\\s|\r\n|\n|\r)*$") && downline.matches("^\\s*-+-+-+(\\s|\r\n|\n|\r)$")) // downline is horizontal line.
	    		  { 
	    			  i++; //next line is identified.
	    			  Horizonta horizonta = new Horizonta();
	    			  elements.add(horizonta);
	    			  continue;
	    		  }
	    		  else // {line and downline} is a header node.
	    		  {
	    			  buff.clear();
	    			  buff.add(line);
	    			  i++; // next line is identified.
	    			  Header header = new Header(buff,0); // this header doesn't have header level. 
	    			  elements.add(header);
	    			  continue;
	    		  }
	    	  }
	      ///////////////////////////////////when line is horizontal line///////////////////////////////
	      if(line.matches("^\\s*-+\\s*-+\\s*-+(\\s|\r\n|\n|\r)*$")|| line.matches("^\\s*[*]+\\s*[*]+\\s*[*]+(\\s|\r\n|\n|\r)*$"))
	      {
			  elements.add(new Horizonta());
			  continue;
	      }
	      
	      ///////////////////////////////////header that has the level like #header or ##header ( <h1> or <h2>)////////////////////////////////
	      if(line.matches("^\\s*#+(\\S|\\s|\r\n|\n|\r)*\\S+(\\S|\\s|\r\n|\n|\r)*$"))
	      {
	    	  // calculate the level of header
	    	 int indexOfShap = line.indexOf("#");
	    	 int j, headerLevel =1 ; 
	    	 for(j= indexOfShap+1 ; j<indexOfShap+6 &&j<line.length(); j++)
	    	 {
	    		 if(line.charAt(j) == '#')
	    			 headerLevel +=1 ;
	    		 else 
	    		 {
	    			 j -= 1;
	    			 break;
	    		 }
	    			 
	    	 }
	    	 if(j != line.length() && (line.charAt(j+1) == ' '||line.charAt(j+1) == '\t'))
	    	 { 
	    		 line = line.substring(j+2); //  remove # in front of line.
	    		 
	    	 //when there are '#' in end of line.
	    	 int lastIndexOfHash = 0;
	    	 if(line.matches("^\\s*(\\S|\\s|\r\n|\n|\r)*\\S+#+(\\s|\r\n|\n|\r)*$"))
	    	 { 
	    		 lastIndexOfHash = line.lastIndexOf("#");
	    		
	    	 //remove the '#' in end of line
	    		 for(j= lastIndexOfHash-1 ; j> lastIndexOfHash - headerLevel && j >0 ; j--)
	    		 {
	    			 if(line.charAt(j) != '#')
	    			 {
	    				 j += 1;
	    				 break;
	    			 }	 
	    		 }
	    		 line = line.substring(0,j);
	    	 }
	    	 
	    	 buff.clear();
	    	 buff.add(line);
	    	 elements.add(new Header(buff,headerLevel));
	    	 continue;
	    	 }
	      }
	      //////////////////////////////List////////////////////////////////////////////////////////
	      if(line.matches("^(\\+|-|\\*)(\\s|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*"))//unordered list
	      {
	    	  int temp=i+1;
	    	  int isordered=0;
	    	  String next_line=downline;
	    	  buff.clear();         //main string include all bufStr
	    	  
	    	  buff.add(line.substring(2));
	    	  while(next_line.matches("^(\\+|-|\\*)(\\s|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*")&& temp<fileContents.size()-1)
	    	  {
	    		  buff.add(next_line.substring(2));
	    		  temp++;
	    		  next_line = fileContents.get(temp);
	    	  }
	    	  i=temp-1;
	    	  if(next_line.matches("^(\\+|-|\\*)(\\s|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*"))
	    	  {
	    		  buff.add(next_line.substring(2));
	    		  i=temp;
	    	  }
	    	  
	    	  for(int j=0;j<buff.size();j++){
	    		  buff.set(j, "<li>"+buff.get(j).replace("\n", "")+"</li>\n");
	    	  }
	    	  elements.add(new ItemList(buff,isordered));
	    	  continue;
	      }
	      
	      if(line.matches("^[0-9]+\\.(\\s|\\r\\n|n|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*"))//ordered list
	      {
	    	  int j,temp=i+1;
	    	  int isordered=1;
	    	  String next_line=downline;
	    	  buff.clear();         //main string include all bufStr
	    	  
	    	  for(j=0;j<line.length();j++){
	    		  if(line.charAt(j)=='.'){
	    			  break;
	    		  }
	    	  }
	    	  
	    	  buff.add(line.substring(j+2));
	    	  while(next_line.matches("^[0-9]+\\.(\\s|\\r\\n|n|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*") && temp<fileContents.size()-1)
	    	  {
	    		  for(j=0;j<next_line.length();j++){
	    			  if(next_line.charAt(j)=='.'){
	    				  break;
	    			  }
	    		  }
	    		  buff.add(next_line.substring(j+2));
	    		  temp++;
	    		  next_line = fileContents.get(temp);
	    	  }
	    	  i=temp-1;
	    	  if(next_line.matches("^[0-9]+\\.(\\s|\\r\\n|n|\\r)+.{1,}(\\s|\\r\\n|\\n|\\r)*"))
	    	  {
	    		  buff.add(next_line.substring(j+3));
	    		  i=temp;
	    	  }
	    	  for(int k=0;k<buff.size();k++){
	    		  buff.set(k, "<li>"+buff.get(k).replace("\n", "")+"</li>\n");
	    		  
	    	  }
	    	  elements.add(new ItemList(buff,isordered));
	    	  continue;
	      }
////////////////////////////////////////////////Image   //////////////////////////////////////////////////////         
	      if(line.matches("^.{0,}!\\[.{1,}\\]\\(.{1,}\\).{0,}(\\s|\\r\\n|\\n|\\r)*")) 
	      {
	    	  line = line.replace("!", "");
	    	  buff.clear();         //main string include all bufStr
	    	  int centerIndex = line.indexOf("](");
	    	  int index1=0;
	    	  int index2=0;
	    	  
	    	  int quote_index =0;
	    	  for(index1=1;index1<=centerIndex;index1++){
	    		  if(line.charAt(centerIndex-index1)=='[')
	    			  break;
	    	  }
	    	  for(index2=centerIndex+1;index2<line.length();index2++){
	    		  
	    		  if(line.charAt(index2)==')')
	    			  break;
	    	  }
	    	  Parser(line.substring(0,centerIndex-index1),elements);//normal string
	    	  buff.add(line.substring(centerIndex-index1+1,centerIndex));//alt string
	    	  //image has title
	    	  if(line.matches("^.{0,}\\[.{1,}\\]\\(.{1,} +(\'|\")+.{1,}(\'|\")+\\).{0,}(\\s|\\r\\n|\\n|\\r)*"))
	    	  {
	    		  quote_index = line.indexOf("'");
	    		  if(quote_index == -1 ) quote_index = line.indexOf('"');
	    		  buff.add(line.substring(centerIndex+2,quote_index-1)); //image path string
	    		  buff.add(line.substring(quote_index,index2)); //image title string
	    		  Parser(line.substring(index2+1),elements);//normal string
	    		  elements.add(new Image(buff));
	    		  continue;
	    	  }
	    	  else
	    	  {
	    		  buff.add(line.substring(centerIndex+2,index2));//image path string
	    		  Parser(line.substring(index2+1),elements);//normal string
	    		  elements.add(new Image(buff));
	    		  continue;
	    	  }
	    	  
	      }
	      //////////////////////////////////////hyperlink///////////////////////////////////////////////////
	      if(line.matches("^.{0,}\\[.{1,}\\]\\([^\\\\\\*\\?\"<>\\%|]+\\).{0,}(\\s|\\r\\n|\\n|\\r)*")) //hyperlink
	      {
	    	  buff.clear();         //main string include all bufStr
	    	  int center_index = line.indexOf("](");
	    	  int index_1=0;
	    	  int index_2=0;
	    	  for(index_1=1;index_1<=center_index;index_1++){
	    		  if(line.charAt(center_index-index_1)=='[')
	    			  break;
	    	  }
	    	  for(index_2=center_index+1;index_2<line.length();index_2++){
	    		  if(line.charAt(index_2)==')')
	    			  break;
	    	  }
	    	  //buff.add(line.substring(0, center_index-index_1));//normal string
	    	  //Parser(line.substring(0,center_index-index_1),);
	    	  buff.add(line.substring(center_index-index_1+1,center_index));//reference string
	    	  buff.add(line.substring(center_index+2,index_2));//url link string
	    	  //buff.add(line.substring(index_2+1));//normal string
	    	  elements.add(new Link(buff));
	    	  continue;
	      }

	      /////////////StyleText Parser//////////////
		  Parser(line,elements);

	      if(i == (fileContents.size()-1))
	      { 
	    	  break;
	      }
	      }
	   }
	   static String tempStr="";
	   public void Parser(String line, ArrayList<MDElement> elements)
		{
			int i=0, end=0;
			ArrayList<String> buff = new ArrayList<String>();
			String tag=null;
			if(line.charAt(0)=='*' || line.charAt(0)=='_'){
	  	    	if((line.substring(0, 3).compareTo("***")==0) || (line.substring(0, 3).compareTo("___")==0)){
	  	    			for(i=3; i<line.length()-3; i++){
	  	    				if((line.substring(i,i+1).compareTo("*"))==0 || (line.substring(i,i+1).compareTo("_"))==0){
	  	    					if((line.substring(i,i+3).compareTo("***"))==0 || (line.substring(i,i+3).compareTo("___"))==0){
	  	    						buff.clear();
	  			  	    			MDParser.tempStr += line.substring(3, i);
	  			  	    			buff.add(MDParser.tempStr);
	  				  	    		tag="***";
	  				  	    		MDParser.tempStr="";
	  				  	    		StyleText styletext = new StyleText(buff,tag);
	  				  	    		elements.add(styletext);
	  				  	    		if(line.substring(0, 3).compareTo("***")==0){
	  				  	    			if((line.substring(3).indexOf("*")+7)<line.length()){
	  					  	    			Parser(line.substring(line.substring(3).indexOf("*")+6), elements);
	  					  	    		}
	  				  	    		}else if(line.substring(0, 3).compareTo("___")==0){
	  				  	    			if((line.substring(3).indexOf("_")+7)<line.length()){
	  					  	    			Parser(line.substring(line.substring(3).indexOf("_")+6), elements);
	  					  	    		}
	  				  	    		}
	  	    					}else{
	  	    						MDParser.tempStr+=line.substring(0, 1);
	  			  	    			Parser(line.substring(1), elements);
	  	    					}
	  	    					break;
	  	    				}
	  	    			}
	  	    			if(i==line.length()-3){
  	    					MDParser.tempStr+=line.substring(0, 1);
			  	    		Parser(line.substring(1), elements);
  	    				}
	  	    	}
	  	    	else if((line.substring(0, 2).compareTo("**")==0) || (line.substring(0, 2).compareTo("__")==0)){
	  	    			for(i=2; i<line.length()-2; i++){
	  	    				if((line.substring(i,i+1).compareTo("*")==0) || (line.substring(i,i+1).compareTo("_")==0)){
	  	    					if((line.substring(i,i+2).compareTo("**")==0) || (line.substring(i,i+2).compareTo("__")==0)){
	  	    						buff.clear();
	  			  	    			MDParser.tempStr += line.substring(2, i);
	  				  	    		buff.add(MDParser.tempStr);
	  				  	    		tag="**";
	  				  	    		MDParser.tempStr="";
	  				  	    		StyleText styletext = new StyleText(buff,tag);
	  				  	    		elements.add(styletext);
	  				  	    		if(line.substring(0, 2).compareTo("**")==0){
	  				  	    			if((line.substring(2).indexOf("*")+5)<line.length()){
	  					  	    			Parser(line.substring(line.substring(2).indexOf("*")+4), elements);
	  					  	    		}
	  				  	    		}else if(line.substring(0, 2).compareTo("__")==0){
	  				  	    			if((line.substring(2).indexOf("_")+5)<line.length()){
	  					  	    			Parser(line.substring(line.substring(2).indexOf("_")+4), elements);
	  					  	    		}
	  				  	    		}
	  	    					}else{
	  	    						MDParser.tempStr+=line.substring(0, 1);
	  			  	    			Parser(line.substring(1), elements);
	  	    					}
	  	    					break;
	  	    				}
	  	    			}
	  	    			if(i==line.length()-2){
  	    					MDParser.tempStr+=line.substring(0, 1);
			  	    		Parser(line.substring(1), elements);
  	    				}
	  	    	}
	  	    	else if((line.substring(0, 1).compareTo("*")==0) || (line.substring(0, 1).compareTo("_")==0)){
	  	    			for(i=1; i<line.length(); i++){
	  	    				if((line.charAt(i)=='*') || (line.charAt(i)=='_')){
		  	    			break;
	  	    				}
	  	    			}
	  	    			if(i==line.length()){
	  	    				MDParser.tempStr+=line.substring(0, 1);
		  	    			Parser(line.substring(1), elements);
	  	    			}else{
	  	    				buff.clear();
		  	    			MDParser.tempStr += line.substring(1, i);
			  	    		buff.add(MDParser.tempStr);
			  	    		tag="*";
			  	    		MDParser.tempStr="";
			  	    		StyleText styletext = new StyleText(buff,tag);
			  	    		elements.add(styletext);
			  	    		if(line.substring(0, 1).compareTo("*")==0){
			  	    			if((line.substring(1).indexOf("*")+3)<line.length()){
				  	    			Parser(line.substring(line.substring(1).indexOf("*")+2), elements);
				  	    		}
			  	    		}else if(line.substring(0, 1).compareTo("_")==0){
			  	    			if((line.substring(1).indexOf("_")+3)<line.length()){
				  	    			Parser(line.substring(line.substring(1).indexOf("_")+2), elements);
				  	    		}
			  	    		}
	  	    			}
	  	    	}
			}
			else{
	  	    	for(i=0; i<line.length(); i++){
	  	    		if((line.charAt(i)=='*') || (line.charAt(i)=='_')){
	  	    			break;
	  	    		}
	  	    	}
	  	    	if(i==line.length()){
	  	    		MDParser.tempStr+=line;
		  	   	 	buff.add(MDParser.tempStr);
		  	   		MDParser.tempStr="";		
		  	   		PlainText text = new PlainText(buff.get(0));
		  	   		elements.add(text);
	  	    	}else{
	  	    		buff.clear();
		  	   		buff.add(line.substring(0, i));
		  	   		PlainText text = new PlainText(buff.get(0));
		  	   		elements.add(text);
		  	   		Parser(line.substring(i),elements);
	  	    	}
	  	    }
		}
}
