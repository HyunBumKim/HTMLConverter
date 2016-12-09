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
	    	  
	    	 System.out.println("����");
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
	      if(line.matches(" + + +\\S+(\\S|\\s|\r\n|\n|\r)*")||line.matches(" *\t+ *\\S+(\\S|\\s|\r\n|\n|\r)*"))
	      {
	    	  String bufStr = "";
	    	  
	    	  while(i < fileContents.size())
	    	  {
	    		 
	    		  if(line == null)
	    		  {
	    			if(bufStr!=null)
	    				elements.add(new CodeBlock(bufStr));
	    	    	break;
	    		  }
	    	      if(line.matches("^ + + +(\\S|\\s|\r\n|\n|\r)*")||line.matches("^ *\t+(\\S|\\s|\r\n|\n|\r)*")||line.matches("^(\\s|\r\n|\n|\r)*$"))
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
	      	if(downline.matches("^\\s*=+=+=+(\\s|\r\n|\n|\r)*$") || downline.matches("^\\s*-+-+-+(\\s|\r\n|\n|\r)*$"))//header�� horizontal �����ϵ��� �ؾ���
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
	      /*if(line.matches("^([+]|-|[*])\\s.{1,}"))//unordered list
	         {
	            int j,temp=i+1;
	            int isordered=0;
	            String next_line=downline;
	            System.out.println("ul item list");
	            buff.clear();         //main string include all bufStr
	            
	            buff.add(line.substring(line[3]));
	            while(next_line.matches("^([+]|-|[*])\\s.{1,}"))
	            {
	               buff.add(line.substring(line[3]));
	               temp++;
	               next_line = fileContents.get(temp);
	            }
	            i=temp-1;
	            ItemList(buff,isordered);
	         }
	         
	         if(line.matches("^[0-9]{1,}[.]\\s.{1,}"))//ordered list
	         {
	            int j,temp=i+1;
	            int isordered=1;
	            String next_line=downline;
	            System.out.println("ol item list");
	            buff.clear();         //main string include all bufStr
	            
	            for(j=0;j<line.length();j++){
	               if(line[j]=='\\s'){
	                  break;
	               }
	            }
	            buff.add(line.substring(line[j+1]));
	            while(next_line.matches("^[0-9]{1,}[.]\\s.{1,}"))
	            {
	               for(j=0;j<next_line.length();j++){
	                  if(line[j]=='\\s'){
	                     break;
	                  }
	               }
	               buff.add(line.substring(line[j+1]));
	               temp++;
	               next_line = fileContents.get(temp);
	            }
	            i=temp-1;
	            ItemList(buff,isordered);
	         }
	         
	         
	         if(line.matches("^.{0,}\[.{1,}\]\(.{1,}\).{0,})")) //hyperlink
	         {
	            System.out.println("hyperlink");
	            buff.clear();         //main string include all bufStr
	            int center_index = line.indexOf("](");
	            int index_1=0;
	            int index_2=0;
	            for(int index_1=1;index_1<=center_index;index_1++){
	               if(line[center_index-index_1=='[')
	                  break;
	            }
	            for(int index_2=center_index+1;index_2<line.length();index_2++){
	               if(line[index_2]==')')
	                  break;
	            }
	            buff.add(line.substring(0, index_1));//normal string
	            buff.add(line.substring(index_1+1,center_index));//reference string
	            buff.add(line.substring(center_index+2,index_2));//url link string
	            buff.add(line.substring(index_2+1));//normal string
	            Link(buff);
	         }
	         */
	      //if(line.matches("^\\s*!\\[+]"))
	    
/////////////StyleText Parser//////////////
		  Parser(line,elements);
	     
	      if(i == (fileContents.size()-1) )
	      { 
	    	  break;
	      }
	      
	
	      }
	   }

	   
	   public void Parser(String line, ArrayList<MDElement> elements)
		{
			int end=0;
			ArrayList<String> buff = new ArrayList<String>();
			String tag=null;
			if(line.charAt(0)=='*' || line.charAt(0)=='_'){
	  	    	if((line.substring(0, 3).compareTo("***")==0) || (line.substring(0, 3).compareTo("___")==0)){
	  	    		buff.clear();
	  	    		buff.add(line.substring(3, line.substring(3).indexOf("***")+3));
	  	    		tag="***";
	  	    		StyleText styletext = new StyleText(buff,tag);
	  	    		elements.add(styletext);
	  	    		if((line.substring(3).indexOf("*")+6)<=line.length()){
	  	    			System.out.println("3"+line.substring(line.substring(3).indexOf("*")+6));
	  	    			Parser(line.substring(line.substring(3).indexOf("*")+6), elements);
	  	    		}
	  	    	}
	  	    	else if((line.substring(0, 2).compareTo("**")==0) || (line.substring(0, 2).compareTo("__")==0)){
	  	    		System.out.println(1111111);
	  	    		buff.clear();
	  	    		buff.add(line.substring(2, line.substring(2).indexOf("**")+2));
	  	    		tag="**";
	  	    		StyleText styletext = new StyleText(buff,tag);
	  	    		elements.add(styletext);
	  	    		if((line.substring(2).indexOf("*")+4)<=line.length()){
	  	    			Parser(line.substring(line.substring(2).indexOf("*")+4), elements);
	  	    		}
	  	    	}
	  	    	else if((line.substring(0, 1).compareTo("*")==0) || (line.substring(0, 1).compareTo("_")==0)){
	  	    		buff.clear();
	  	    		buff.add(line.substring(1, line.substring(1).indexOf("*")+1));
	  	    		tag="*";
	  	    		StyleText styletext = new StyleText(buff,tag);
	  	    		elements.add(styletext);
	  	    		if((line.substring(1).indexOf("*")+2)<=line.length()){
	  	    			Parser(line.substring(line.substring(1).indexOf("*")+2), elements);
	  	    		}
	  	    	}else{
	  	    		
	  	    	}
	  	    }else{
	  	   	  if((end=line.indexOf("*"))!=-1 || (end=line.indexOf("_"))!=-1){
	  	   		  buff.clear();
	  	   		  buff.add(line.substring(0, end));
	  	   		  PlainText text = new PlainText(buff.get(0));
	  	   		  elements.add(text);
	  	   		  Parser(line.substring(end),elements);
	  	   	  }else{
	  	   		 PlainText text = new PlainText(line);
	  	   		 elements.add(text);
	  	   	  }
	  	    }
		}
}