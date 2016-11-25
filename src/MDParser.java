import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MDParser {
	
	Document document;
	ArrayList<String> fileContents;
	String fileString;

	MDParser(String InputFileName)
	{
		 
		 fileContents = new ArrayList<String>();
		 fileString = new String();
		 
		 
		 try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s;
	        
	          while((s = in.readLine()) != null){
	             fileContents.add(s);
	             fileString += (s +"\n");
	          }
	        
	          in.close();
	          
	          document = new Document(fileContents);
	          FirstTextParser(fileContents);
	        
	          
	       }
	       catch(IOException e){
	          System.err.println(e);
	          System.exit(1);
	       }
		 catch(NullPointerException e)
		 {
			 System.out.println(e);
			 System.out.println("java [program name] -md/[InputFile] -html/[OutputFile] -style/[style]");
		 }
		}
	
	public String Parser(String st)
	   {
	      int i=0;
	      if(st.indexOf("**")!=-1) {}
	         
	      return st;
	   }

	   
	   public void FirstTextParser(ArrayList<String> fileContents2)
	   {
		   
		//  String buff;
	      String[] st1; 
	      
	      String line = fileContents2.get(0);
	      String downline = fileContents2.get(1);
	      
	      line = line.trim();
	      downline=downline.trim();
	    
	      st1 = line.split("");
	      
	      //header
	      if(downline.contains("===") || downline.contains("---"))//header와 horizontal 구분하도록 해야함
	      {
	    	  Header header = new Header(line);
	    	  header.level =0; //this header doesn't have header level. 
	    	  this.document.elements.add(header);
	    	  return;
	      }
	      
	      StringTokenizer st2 = new StringTokenizer(line, ".");// for checking order list
	      
	      if(st1[0]==">")
	      {
	    	 //quotedBlock node생성 
	         //st.substring(1)
	         //st[1]부터 plain string token으로 보낸다
	      }
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
	         //st[2]부터 list node parser으로 보낸다
	      }
	      else if(isStringNum(st2.nextToken()))
	      {
	         //st1.nextToken;
	         //st1.nextToken을 order list parser으로 보낸다
	      }
	      else if(st1[0]=="-" && line.replaceAll("-", "").length()==0)
	      {
	         //해당 string 줄 위의 라인을 제목으로 만든다
	      }
	      else if(st1[0]=="=" && line.replaceAll("=", "").length()==0)
	      {
	         //해당 string 줄 위의 라인을 제목으로 만든다
	      }
	      else if((line.replaceAll(" ", "").indexOf("***")==0) && line.replaceAll("*", "").length()==0)
	      {
	         //해당 line의 문자를 전부 삭제 후 horizontal line 삽입
	      }
	      else if((line.replaceAll(" ", "").indexOf("---")==0) && line.replaceAll("-", "").length()==0)
	      {
	         //해당 line의 문자를 전부 삭제 후 horizontal line 삽입
	      }
	   //return st;
	      
	      /*
	       * 윗줄이 list형태라면 해당 줄도 list 형식을 띈다
	       * 이 경우 제목 형식은 의미가 없다
	       * */
	   }

	   private boolean isStringNum(String nextToken) {
	   // TODO Auto-generated method stub
	   return false;
	}


	
}
