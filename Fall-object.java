import java.io.*;
 
    class FallDouble {
        public static void main(String args[]) {
            double x,tX, y, x_speed, y_speed;
            double g;
            
            //supposed gravity of earth
            g = -10;
            //distance travelled by object on x-axis
            x = 0;	
            //theoritical distance	
            tX = 0;
            //Height from which the object is dropped
            y = 100000;
            //speed of object on x-axis
            x_speed = 0;
            //speed of the object on y-axis
            y_speed = 0;
            
            String buf;
            
			try{
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
				//Enter the speed of the object when it is set to motion
				System.out.print("Enter Speed \n");
				buf = br.readLine();
				x_speed = Integer.parseInt(buf);
				
				//Enter the height from which the object is being dropped
				System.out.print("Enter Height \n");
				buf = br.readLine();
				y = Integer.parseInt(buf);
		      
		        //theoritically calculating the distance travelled by the object
                tX = x_speed * Math.sqrt(-2 * y / g);
                
                //Calculating the estimated distance travelled by the object (near to actual distance travelled by the object)
		        while( y >= 0 ) {
		            y_speed = y_speed + g/100000;
		            x = x + x_speed/100000;
		            y = y + y_speed/100000;

		        }

				//Output of the theoritical and estimated distance travelled by the object
		        System.out.print("theoritical distance = " + tX + "\n");
		        System.out.print("estimated distance = " + x + "\n");
		         } 
		        catch(Exception e) {
		      	System.out.print("Error:" + e);
		 	 }
		        
		     return;
        }
    }