import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

public class MDParser {
		
	public String Parser(String st)
	   {
	      int i=0;
	      if(st.indexOf("**")!=-1) {}
	         
	      return st;
	   }

	   
	   public void FirstTextParser(ArrayList<String> fileContents, ArrayList<MDElement> elements)
	   {
		   
		  int i = 0;
		  ArrayList<String> buff = new ArrayList<String>();
	     // String[] st1; 
	   //   boolean stop = false;
		 
	      for(i = 0; i < fileContents.size(); i++)
	      {
	    	 
	      buff.clear();
	      String line = fileContents.get(i);
	      System.out.println(i+"��° line : "+line);
	      
	      // when line is a space string.
	      if(line.matches("^\\s*$"))
	      {
	    	  
	    	 System.out.println("����");
	    	  continue;
	      }
	      
	      String downline;
	      System.out.println(i+"��° ? "+fileContents.size());
	      //when line is a last line.
	      if(i == (fileContents.size()-1) )
	      { 
	    	  downline = ""; 
	    	  System.out.println("downline :null ");
	      }
	      else 
	    	  downline = fileContents.get(i+1);
	    
	      //code block �� �տ� space �����ϸ� �ȵȴ�. 
	      
	    
	   //   StringTokenizer st2 = new StringTokenizer(line, ".");// for checking order list
	      System.out.println("line : " +line+ "finish");
	      
	      //quoted block 
	      if(line.matches("^\\s*>+(\\S|\\s|\r\n|\n|\r)*"))
	      {
	    	  buff.clear();
	    	  //buff.add("");
	    	  
	    	  String bufStr = "";
	    	  while(i < fileContents.size())
	    	  {
	    		  System.out.println(i +"line >> �ִ�.");
	    		  
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
	    			  System.out.println("downline escape : "+downline);
	    			  buff.add(bufStr);
	    			  elements.add(new QuotedBlock(buff));
	    			  break;
	    		  }
	    		  else
	    		  {
	    			  System.out.println("downline : "+downline);
	    		  }
	    	  
	    		 
	    	      i++;
	    	      if(i < fileContents.size())
	    	      {
	    	    	  line = fileContents.get(i);
	    	    	  if(i == fileContents.size()-1)
	    	    		  downline = "";
	    	    	  else
	    	    		  downline = fileContents.get(i+1); 
	    	    	  System.out.println(i);
	    	    	  if(downline.length()==0) System.out.println("ok");
	    	      }
	    	      else // when finishing dividing all elements of file
	    	    	  return;
	    	     
	    	  }
	    	 //quotedBlock node���� 
	         //st.substring(1)
	         //st[1]���� plain string token���� ������
	      }
	      //header  when downline is like === or ---
	      else if(downline.matches("^\\s*=+=+=+(\\s|\r\n|\n|\r)*$") || downline.matches("^\\s*-+-+-+(\\s|\r\n|\n|\r)*$"))//header�� horizontal �����ϵ��� �ؾ���
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
	    			  Header header = new Header(buff);
	    			  header.level = 0; // this header doesn't have header level. 
	    			  elements.add(header);
	    			  continue;
	    		  }
	    	  }
	      else{
	     System.out.println("=====plain���� =====line = "+line);
	      elements.add(new PlainText(line));
	      }
	      if(i == (fileContents.size()-1) )
	      { 
	    	  System.out.println("finish :null ");
	    	  break;
	      }
	      
	      /*
	      else if(st1[0] == "#")
	      {
	    	  //check that string 'line' is header node
	    	  HeaderChecker headerchecker = new HeaderChecker(line);
	    	  Header header = new Header(headerchecker.text);
	    	  header.level = headerchecker.headerLevel;
	    	  document.elements.add(header);
	    	 
	      }
	      
	      else if((st1[0]=="*" || st1[0]=="+" || st1[0]=="-") && (st1[1]==" " || st1[1]=="\t"))
	      {
	         //st.substring(2);
	         //st[2]���� list node parser���� ������
	      }
	      else if(isStringNum(st2.nextToken()))
	      {
	         //st1.nextToken;
	         //st1.nextToken�� order list parser���� ������
	      }
	      else if(st1[0]=="-" && line.replaceAll("-", "").length()==0)
	      {
	         //�ش� string �� ���� ������ �������� �����
	      }
	      else if(st1[0]=="=" && line.replaceAll("=", "").length()==0)
	      {
	         //�ش� string �� ���� ������ �������� �����
	      }
	      else if((line.replaceAll(" ", "").indexOf("***")==0) && line.replaceAll("*", "").length()==0)
	      {
	         //�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
	      }
	      else if((line.replaceAll(" ", "").indexOf("---")==0) && line.replaceAll("-", "").length()==0)
	      {
	         //�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
	      }
	   //return st;
	      
	      /*
	       * ������ list���¶�� �ش� �ٵ� list ������ ���
	       * �� ��� ���� ������ �ǹ̰� ����
	       * */
	      }
	   }

	   private boolean isStringNum(String nextToken) {
	
	   return false;
	}


	
}
