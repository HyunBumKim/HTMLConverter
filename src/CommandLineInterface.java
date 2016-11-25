
import java.util.StringTokenizer;

public class CommandLineInterface {

	public String InputFileName;
    public String OutputFileName;
    public String Style;
    
	CommandLineInterface(String[] args)
	{
	      for(int i=0; i<args.length;i++){
	          if(args[i].indexOf("-")==0)
	             args[i]=args[i].replaceFirst("-", "");
	          else{
	             System.err.println("invalid option!");
	             return;
	          }
	          StringTokenizer st = new StringTokenizer(args[i],"/");
	          switch(st.nextToken()){
	             case "md":
	                InputFileName=st.nextToken();
	                //System.out.println(InputFileName);
	                break;
	             case "html":
	                OutputFileName=st.nextToken();
	                //System.out.println(OutputFileName);
	                break;
	             case "style":
	                Style=st.nextToken();
	                //System.out.println(Style);
	                break;
	             case "help":
	                System.out.println("-md/fileName.md");
	                System.out.println("fileName: the name of md file which will be converted into html");
	                System.out.println("");
	                System.out.println("-html/fileName.html");
	                System.out.println("fileName: the name of html file which will be created from md file:");
	                System.out.println("");
	                System.out.println("-style/styleName");
	                System.out.println("styleName : there are three types:");
	                System.out.println("1.  plain");
	                System.out.println("2.  fancy");
	                System.out.println("3.  slide");
	                System.exit(0);
	             default:System.err.println("WRONG INPUT : ERROR");
	          }
	       }
	    }
	}
	

