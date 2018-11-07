    class FallJS {
        public static void main(String args[]) {
            double x, y, x_speed, y_speed;
            double g;
            int r,c;
            
            g = -10;
            r = 10000;
            c = 0;
            
            x = 0;
            y = 100000;
            x_speed = 800;
            y_speed = 0;
            
            System.out.print("<html><head><style type=\"text/css\">#flyingObject { position:absolute; left:0px; top:30px; width:3em; }#catchObject { position:absolute; left:0px; top:30px; width:3em; }</style><script type=\"text/javascript\">var flyobj = null;var catobj = null;var count = 0;var distmax = 140000;var hmax = 100000;var theoval = 113137.08498984762;var movedata = new Array(");
     
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
            /* System.out.print("estimated distance = " + x + "\n"); */
            
            System.out.print("); function doAnimLoop() {  flyobj.style.left = parseFloat(movedata[count])*800/distmax + 'px';  flyobj.style.top = parseFloat(movedata[count+1])*400/hmax + 'px';  count+=2;  if( count < movedata.length ) {    setTimeout(doAnimLoop,20);  } else {    if( (parseFloat(movedata[count-2]) - theoval > 3) ||      (parseFloat(movedata[count-2]) - theoval < -3)    ) {      flyobj.style.background = 'red';    } else {      flyobj.style.background = 'blue';    }  }}function doAnimStart() {  flyobj = document.getElementById('flyingObject');  flyobj.style.left='0px';  flyobj.style.top='0px';              catobj = document.getElementById('catchObject');  catobj.style.left=theoval*800/distmax +'px';  catobj.style.top=400+'px';  doAnimLoop();}window.onload = doAnimStart;</script></head><body><div id=\"flyingObject\">object</div><div id=\"catchObject\">catch</div></body></html>");
            return;
        }
    }
