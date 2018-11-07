import java.io.*;
 
    class FallFloat {
        public static void main(String args[]) {
            float x, y, x_speed, y_speed;
            float g;
            
            g = -10;
            
            x = 0;
            y = 100000;
            x_speed = 0;
            y_speed = 0;
            
            String buf;
			try{
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
				buf = br.readLine();
				x_speed = Float.parseFloat(buf);
            
            while( y >= 0 ) {
                y_speed = y_speed + g/100000;
                x = x + x_speed/100000;
                y = y + y_speed/100000;
            }
            System.out.print("estimated distance = " + x + "\n");
            } 
            catch(Exception e) {
          	System.out.print("Error:" + e);
     	    }
            
            
            return;
        }
    }
