public class MarkdownConv {
//private static ArrayList<String> node;
	static String InputFileName;
    static String OutputFileName ;
    static String Style;
    static String[] argsCpy;
    
    
public static void main(String[] args) {
	
	if(args.length==0)
    {
       System.err.println("Error : No Input Files");
       System.exit(-1);
    }
	try{
		argsCpy = args.clone();
		
		InputFileName = new String();								
	    OutputFileName = new String();
	
	CommandLineInterface CLInterface = new CommandLineInterface(argsCpy);
	
	InputFileName = CLInterface.InputFileName;
	OutputFileName = CLInterface.OutputFileName;
	Style = CLInterface.Style;
	
	MDParser parser;
	parser = new MDParser(InputFileName);
	
	HtmlGenerator converter = new HtmlGenerator(OutputFileName,parser.document,CLInterface.Style);

	}catch(Exception e){
		System.out.println("<this argument null>\n");
		System.out.println(e);
	}
	
 }
}

