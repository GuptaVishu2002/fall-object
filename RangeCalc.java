class RangeCalc
{
RangeCalc(int speed, int angleInDegrees)
{
int g, angleInRads, range;
g = 10;

angleInRads = angleInDegrees*Math.PI/180;
range = 2*speed*speed*Math.sin(angleInRads)*Math.cos(angleInRads)/g;
System.out.println("Range="+range+"meters");
}
public static void main(String[]arg)
{
new RangeCalc(20,45);
}
}
