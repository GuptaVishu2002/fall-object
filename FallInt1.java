    class FallInt1 {
        public static void main(String args[]) {
            int x, y, x_speed, y_speed;
            int g;
            int r,c;
            
            g = -10;
            r = 10000;
            c = 0;
            
            x = 0;
            y = 100000;
            x_speed = 800;
            y_speed = 0;
     
            while( y >= 0 ) {
                y_speed = y_speed + g/r;
                x = x + x_speed/r;
                y = y + y_speed/r;
                
                c++;
                if( c == r ) {
                    System.out.print("" + x + "," + (100000-y) + ",\n");
                    c = 0;
                }
            }
            System.out.print("" + x + "," + (100000-y) + "");
            System.out.print("estimated distance = " + x + "\n");
            
            return;
        }
    }
