import java.io.*;

class FallJSS5 {
	

	public static final double earthRadius = 6400000;	
	public static final double G0 = -9.8;				

	public static double CalcGA(double length)
	{
		return Math.pow(earthRadius/(earthRadius+length),2) * G0;
	}

	public static double CalcX(double y, double x_speed, double g)
	{	
		return x_speed * Math.sqrt(2*y/Math.abs(g));
	}
	
	public static double SearchMaxVal(double n[])
	{
		
		if( n==null || n.length==0)
			return 0;
		
		double max = 0;
		for (double d: n){
			if(d > max)
				max = d;
		}
		return max;
	}
	
    public static void main(String args[]) {
        double x[], y[], x_speed[];
        double g0[];
        int r,c;
        int MaxObj;
        String buf;
        
        try{
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        	System.out.print("飛翔物体の数を入力してください(>:");
        	buf = br.readLine();
			MaxObj = Integer.parseInt(buf);
			if(MaxObj <= 0)
			{
				return;
			}
			
			x_speed = new double[MaxObj];
			y = new double[MaxObj];
			g0 = new double[MaxObj];
			x = new double[MaxObj];
			for(int i=0; i<MaxObj; ++i){
				System.out.print((i+1) + "体目のX方向の初速を入力してください[m]:");
				buf = br.readLine();
				x_speed[i] = Integer.parseInt(buf);
				
				System.out.print((i+1) + "体目のy方向の初期値を入力してください:[m]:");
				buf = br.readLine();
				y[i] = Integer.parseInt(buf);
				
				g0[i] = CalcGA(y[i]);
				x[i] = CalcX(y[i], x_speed[i], g0[i]);
			}
			br.close();
			
			for(int i=0; i<MaxObj; ++i)
				System.out.println("飛翔物体"+(i+1)+"の落下予測地点[m]:" + x[i]);

			double distmax = SearchMaxVal(x);
			double hmax = SearchMaxVal(y);
			
			r = 10000;
			String writeBuf = "<html><head><style type=\"text/css\">";
			for(int i=0; i<MaxObj; ++i)
				writeBuf += "#flyingObject" + i + " { position:absolute; left:0px; top:30px; width:3em; }" + "#catchObject" + i + "{ position:absolute; left:0px; top:30px; width:3em; }";
			writeBuf += "</style><script type=\"text/javascript\"> var distmax = "+ distmax + ";var hmax = " + hmax + ";"; 
			for(int i=0; i<MaxObj; ++i){
				writeBuf += "var flyobj" + i + " = null;var catobj"+ i +" = null;var count" + i + " = 0; var theoval" + i + " = " + x[i] + ";var movedata"+ i +" = new Array"+"(";
	
				double  y_speed = 0;
				double g=0;	    	
		    	double xPos = 0;
		    	double yPos = y[i];
		    	c = 0;
		    	y_speed = 0;
				while( yPos >= 0 ) {
					g = CalcGA(yPos);
				    y_speed = y_speed + g/r;
				    xPos = xPos + x_speed[i]/r;
				    yPos = yPos + y_speed/r;
				    
				    c++;
				    if( c == r ) {
				        writeBuf +="" + xPos + "," + (hmax-yPos) + ",\n";
				        c = 0;
				    }
				}
				writeBuf +="" + xPos + "," + (hmax-yPos) + "); ";
			}
			
			for(int i=0; i<MaxObj; ++i){
writeBuf += "function doAnimLoop"  + i +"() {  flyobj" + i + ".style.left = parseFloat(movedata" + i + "[count" + i + "])*800/distmax + 'px';  flyobj" + i + ".style.top = parseFloat(movedata" + i + "[count" + i + "+1])*400/hmax + 'px';  count" + i + "+=2;  if( count" + i + " < movedata" + i + ".length ) {    setTimeout(doAnimLoop" + i + ",20);  } else {    if( (parseFloat(movedata" + i + "[count" + i + "-2]) - theoval" + i + " > 3) ||      (parseFloat(movedata" + i + "[count" + i + "-2]) - theoval" + i + " < -3)    ) {      flyobj" + i + ".style.background = 'red';    } else {      flyobj" + i + ".style.background = 'blue';    }  }}function doAnimStart" + i + "() {  flyobj" + i + " = document.getElementById('flyingObject" + i+ "');  flyobj" + i + ".style.left='0px';  flyobj" + i + ".style.top='0px';              catobj" + i + " = document.getElementById('catchObject" + i + "');  catobj" + i + ".style.left=theoval" + i + "*800/distmax +'px';  catobj" + i + ".style.top=400+'px';  doAnimLoop" + i + "();}";
			}
			
			writeBuf += "function doAnimStart(){";
			for(int i=0; i<MaxObj; ++i)
				writeBuf += "doAnimStart" + i +"();";
			writeBuf += "} window.onload = doAnimStart;</script></head><body>";
			for(int i=0; i<MaxObj; ++i)
				writeBuf +="<div id=\"flyingObject" + i+ "\">object" + i+ "</div> <div id=\"catchObject" + i+ "\">catch" + i+ "</div>";
			writeBuf += "</body></html>";

       }
        catch(Exception e)
		{
			System.out.print("Error:" + e);
		}
        return;
    }
}
