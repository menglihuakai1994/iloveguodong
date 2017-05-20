



import java.util.ArrayList;

public class BowlingGame {
    
    public int getBowlingScore(String bowlingCode) {
    	int sumall=0;
    	int sum1to8=0;
    	int sum9to10=0;
    	int num9=0;
    	int num10=0;
    	String[] strarray=bowlingCode.split("\\|"); 
    	String str9=strarray[8];
    	String str10=strarray[9];
    	//根据第九个和第十格组合分类   	
    	if(str10.equals("X")){
    		//10格为strike
    		String str12=strarray[11];
    		if(str9.equals("X")){
        		//10格为strike,9格为strike
    			num9=20+string2Num(getNthChar(str12, 1));
    			if(str12.indexOf("/")!=-1){
    				num10=20;
    			}else{
    				num10=10+string2Num(getNthChar(str12, 1))+
    				string2Num(getNthChar(str12, 2));
    			}
        		     		
        		
        	}else if(str9.indexOf("/")!=-1){
        		//10格为strike,9格为spare
        		num9=20;
    			if(str12.indexOf("/")!=-1){
    				num10=20;
    			}else{
    				num10=10+string2Num(getNthChar(str12, 1))+
    				string2Num(getNthChar(str12, 2));
    			}
        	}else{
        		//10格为strike,9格为普通
        		num9=string2Num(getNthChar(str9, 1))+
        				string2Num(getNthChar(str9, 2));
    			if(str12.indexOf("/")!=-1){
    				num10=20;
    			}else{
    				num10=10+string2Num(getNthChar(str12, 1))+
    				string2Num(getNthChar(str12, 2));
    			}
        	}
    		
    		
    	}else if(str10.indexOf("/")!=-1){
    		//10格为spare
    		String str12=strarray[11];
    		if(str9.equals("X")){
        		//10格为spare,9格为strike
    			num9=20;
        		num10=10+string2Num(getNthChar(str12, 1));
        		
        		
        	}else if(str9.indexOf("/")!=-1){
        		//10格为spare,9格为spare
        		num9=10+string2Num(getNthChar(str9, 1));
        		num10=10+string2Num(getNthChar(str12, 1));
        	}else{
        		//10格为spare,9格为普通
        		num9=string2Num(getNthChar(str9, 1))+string2Num(getNthChar(str9, 2));
        		num10=10+string2Num(getNthChar(str12, 1));
        	}
    		
    	}else{
    		//10格为普通
    		if(str9.equals("X")){
        		//10格为普通,9格为strike
        		 num9=10+string2Num(getNthChar(str10, 1))+
        				string2Num(getNthChar(str10, 2));
        		 num10=string2Num(getNthChar(str10, 1))+
        				string2Num(getNthChar(str10, 2));
        		        		
        	}else if(str9.indexOf("/")!=-1){
        		//10格为普通,9格为spare
        		 num9=10+string2Num(getNthChar(str10, 1));
        		 num10=string2Num(getNthChar(str10, 1))+
         				string2Num(getNthChar(str10, 2));	
        	}else{
        		//10格为普通,9格为普通
        		num9=string2Num(getNthChar(str9, 1))+
        				string2Num(getNthChar(str9, 2));
        		 num10=string2Num(getNthChar(str10, 1))+
        				string2Num(getNthChar(str10, 2));
        	}
    	}
    	sum1to8=getFront8(strarray);
    	sum9to10=num9+num10;	
    	sumall=sum9to10+sum1to8;
    	return sumall;
    }
    //获取前八格的分数
    public static int getFront8(String[] stringarray){
    	int sum=0;
    	for(int i=0;i<8;i++){
    		String str1=stringarray[i];
    		if(str1.equals("X")){
    			//这一格为strike
    			String str2=stringarray[i+1];
    			if(str2.equals("X")){
    				sum=sum+20+string2Num(getNthChar(stringarray[i+2], 1));
    			}else if(str2.indexOf("/")!=-1){
    				sum=sum+20;
    			}else{
    				sum=sum+10+string2Num(getNthChar(str2, 1))+string2Num(getNthChar(str2, 2));
    			}
    		}else if(str1.indexOf("/")!=-1){
    			//这一格为spare
    			sum=sum+10+string2Num(getNthChar(stringarray[i+1], 1));
    		}else{
    			//这一格为普通
    			sum=sum+string2Num(getNthChar(str1, 1))+string2Num(getNthChar(str1, 2));
    		}
    		
    	}
   
    	
    	return sum;
    }
    //获取字符串的第i个字符
    public static String getNthChar(String s,int num){
    	String c=s.substring(num-1,num);
    	return c;
    } 	
    public static int string2Num(String s){
    	int num;
    	/*
    	 * switch(s) 

    	{ 
    	case "-": num=0;break; 
    	case "1": num=1;break; 
    	case "2": num=2;break;  
    	case "3": num=3;break; 
    	case "4": num=4;break; 
    	case "5": num=5;break; 
    	case "6": num=6;break; 
    	case "7": num=7;break; 
    	case "8": num=8;break; 
    	case "9": num=9;break; 
    	case "X": num=10;break; 

    	default: System.out.println("出错了"); num=0;break; 

    	}
    	 */
    	if (s.equals("-")){
    		num=0;
    	}else if(s.equals("1")){
    		num=1;
    	}else if(s.equals("2")){
    		num=2;
    	}else if(s.equals("3")){
    		num=3;
    	}else if(s.equals("4")){
    		num=4;
    	}else if(s.equals("5")){
    		num=5;
    	}else if(s.equals("6")){
    		num=6;
    	}else if(s.equals("7")){
    		num=7;
    	}else if(s.equals("8")){
    		num=8;
    	}else if(s.equals("9")){
    		num=9;
    	}else if(s.equals("X")){
    		num=10;
    	}else{
    		num=0;
    	}
    	
    	return num;
    }
}