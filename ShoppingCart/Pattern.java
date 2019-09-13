public class Pattern{
	//define colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_WHITE = "\u001b[37;1m";
	public static final String ANSI_CYAN = "\u001b[36;1m";
	public static final String ANSI_MAGNETA = "\u001b[35;1m"; //unequal no of parameters exception
	public static final String ANSI_BLUE = "\u001b[34;1m";   //Unsupported Formats exception
	public static final String ANSI_YELLOW = "\u001b[33;1m"; //duplicate item exception
	public static final String ANSI_GREEN = "\u001b[32;1m"; //common usage
	public static final String ANSI_BLACK = "\u001b[30;1m"; //item not foun? exception
	public static final String ANSI_RED = "\u001b[31;1m";
	String result;
	
	public String[] banner = {
								"?????????????????????????????????????????????????",
								"???                                           ???",
								"???  "+"\u001b[32;1m"+"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN"+"\u001B[0m"+"     ???",
								"???  "+"\u001b[32;1m"+"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"+"\u001B[0m"+"   ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMN"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM          Dumb Minds             MMM"+"\u001B[0m"+"  ???",	
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",	
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",	
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",		
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMM                                 MMM"+"\u001B[0m"+"  ???",	
								"???  "+"\u001b[32;1m"+"MMM                                 MMN"+"\u001B[0m"+"  ???",
								"???  "+"\u001b[32;1m"+"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"+"\u001B[0m"+"   ???",
								"???  "+"\u001b[32;1m"+"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN"+"\u001B[0m"+"    ???",
								"???                                           ???",
								"?????????????????????????????????????????????????",
								"?????????????????????????????????????????????????"	,
								" Youtube : \u001b[34;1m"+"https://youtube.com/c/Dumbminds/"+"\u001B[0m",
								" Facebook : \u001b[34;1m"+"https://www.facebook.com/dumbminds01/"+"\u001B[0m",
								" Blogger : \u001b[34;1m"+"https://dumbmindsblog.blogspot.com/"+"\u001B[0m",
							};
	public static String print(String content, String color){
		if(color.equals("red")) return ANSI_RED+content+ANSI_RESET;
		if(color.equals("green")) return ANSI_GREEN+content+ANSI_RESET;
		if(color.equals("black")) return ANSI_BLACK+content+ANSI_RESET;
		if(color.equals("yellow")) return ANSI_YELLOW+content+ANSI_RESET;
		if(color.equals("blue")) return ANSI_BLUE+content+ANSI_RESET;
		if(color.equals("magneta")) return ANSI_MAGNETA+content+ANSI_RESET;
		if(color.equals("cyan")) return ANSI_CYAN+content+ANSI_RESET;
		if(color.equals("white")) return ANSI_WHITE+content+ANSI_RESET;
		else return content;
	}
	public static String interrupt(String name){
		if(name.equals("(add)$ ")) return print(name,"green");
		if(name.equals("$ ")) return print(name,"green");
		if(name.equals("(remove)$ ")) return print(name,"green");
		if(name.equals("(update)$ ")) return print(name,"green");
		if(name.equals("ItemNotFound Exception")) return print("{"+name+"}","black");
		if(name.equals("DuplicateItem Exception")) return print("{"+name+"}","yellow");
		if(name.equals("UnsupportedFormats Exception")) return print("{"+name+"}","blue");
		if(name.equals("UnEqualNumberOfParameters Exception")) return print("{"+name+"}","magneta");
		else return print(name,"white");
	}
}
