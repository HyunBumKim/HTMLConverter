import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer; 

public class MDParser {
   
   ArrayList<String> fileContents;
   public String Parser(String st)
   {
      int i=0;
      if(st.indexOf("**")!=-1) {}
    	  
      return st;
   }
   
   public String FirstTextParser(String st)
   {
      String[] st1 = {}; 
      //st를 저장할 array가 필요 그래서 임의로 st1 array 생성
      for(int i=0;i<st.length();i++){
    	  st1[i] = st;
      }
      StringTokenizer st2 = new StringTokenizer(st, ".");
      if(st1[0]==">")
      {
         //st.substring(1)
         //st[1]부터 plain string token으로 보낸다
      }
      else if((st1[0]=="*" || st1[0]=="+" || st1[0]=="-") && (st1[1]==" " || st1[1]=="\t"))
      {
         //st.substring(2);
         //st[2]부터 token parser으로 보낸다
      }
      else if(isStringNum(st2.nextToken()))
      {
         //st1.nextToken;
         //st1.nextToken을 token parser으로 보낸다
      }
      else if(st1[0]=="-" && st.replaceAll("-", "").length()==0)
      {
         //해당 string 줄 위의 라인을 제목으로 만든다
      }
      else if(st1[0]=="=" && st.replaceAll("=", "").length()==0)
      {
         //해당 string 줄 위의 라인을 제목으로 만든다
      }
      else if((st.replaceAll(" ", "").indexOf("***")==0) && st.replaceAll("*", "").length()==0)
      {
         //해당 line의 문자를 전부 삭제 후 horizontal line 삽입
      }
      else if((st.replaceAll(" ", "").indexOf("---")==0) && st.replaceAll("-", "").length()==0)
      {
         //해당 line의 문자를 전부 삭제 후 horizontal line 삽입
      }
	return st;
      
      /*
       * 윗줄이 list형태라면 해당 줄도 list 형식을 띈다
       * 이 경우 제목 형식은 의미가 없다
       * */
   }

   private boolean isStringNum(String nextToken) {
	// TODO Auto-generated method stub
	return false;
}

MDParser(String InputFileName)
   {
       fileContents = new ArrayList<String>();
       try{
             BufferedReader in = new BufferedReader(new FileReader(InputFileName));
             String s = null;
             //String temp = null;
             while((s = in.readLine()) != null)
             {
                fileContents.add(s);
             }
             in.close();
          }
          catch(IOException e)
          {
             System.err.println(e);
             System.exit(1);
          }
       /////////////////read done//////////////////   
   }
   
   
}
