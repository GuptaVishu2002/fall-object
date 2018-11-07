import java.io.*;
  
    class FallInt {
        public static void main(String args[]) {
            int x, y, x_speed, y_speed;
            int g;
            
            g = -10000;
            
            x = 0;
            y = 100000;
            x_speed = 0;
            y_speed = 0;
           	String buf;
           	
			try{
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
				buf = br.readLine();
				x_speed = Integer.parseInt(buf);
		      
            while( y >= 0 ) {
                y_speed = y_speed + g/5000;
                x = x + x_speed/5000;
                y = y + y_speed/5000;
            }
            System.out.print("estimated distance = " + x + "\n");
            } 
            catch(Exception e) {
          		System.out.print("Error:" + e);
     	    }
            
            return;
        }
    }
