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
	parser = new MDParser();
	System.out.println(InputFileName);
	Document document = new Document(InputFileName,parser);
	System.out.println("1");
	
	@SuppressWarnings("unused")
	HtmlGenerator converter = new HtmlGenerator(OutputFileName,document,CLInterface.Style);

	}catch(Exception e){
		System.out.println("<this argument null>\n");
		System.out.println(e);
	}
	
 }
}

