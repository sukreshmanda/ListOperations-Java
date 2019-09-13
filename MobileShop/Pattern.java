public class Pattern{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_WHITE = "\u001b[37;1m";
	public static final String ANSI_CYAN = "\u001b[36;1m";
	public static final String ANSI_MAGNETA = "\u001b[35;1m"; 
	public static final String ANSI_BLUE = "\u001b[34;1m";   
	public static final String ANSI_YELLOW = "\u001b[33;1m"; 
	public static final String ANSI_GREEN = "\u001b[32;1m"; 
	public static final String ANSI_BLACK = "\u001b[30;1m"; 
	public static final String ANSI_RED = "\u001b[31;1m";
	public static String[] banner = {
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
	public static String print(String name){
		return ANSI_WHITE+name+ANSI_RESET;
	}
	public static String print(String name, String color){
		String result;
		if(color.equals("red")) result = ANSI_RED+name+ANSI_RESET;
		else if(color.equals("blue")) result = ANSI_BLUE+name+ANSI_RESET;
		else if(color.equals("black")) result = ANSI_BLACK+name+ANSI_RESET;
		else if(color.equals("green")) result = ANSI_GREEN+name+ANSI_RESET;
		else if(color.equals("yellow")) result = ANSI_YELLOW+name+ANSI_RESET;
		else if(color.equals("magneta")) result = ANSI_MAGNETA+name+ANSI_RESET;
		else if(color.equals("cyan")) result = ANSI_CYAN+name+ANSI_RESET;
		else result=name;
		return result;
	}
}
