package com.company;
public class Segment {
    private Point p1, p2;
    public Segment(Point p1, Point p2){
        this.p1=p1;
        this.p2=p2;
    }

    public Point getP1() {
        return p1;
    }

    //   public void setP1(Point p1) {
    //       this.p1 = p1;
    //  }

    public Point getP2() {
        return p2;
    }

    //   public void setP2(Point p2) {
    //       this.p2 = p2;
    //   }
    public double dst(){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    public String toSvg(){
        return String.format("<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"black\" />", p1.x, p1.y, p2.x, p2.y);
    }
    Segment[] perpendicular(Segment segment,Point point){
        double a,b,r;
        a=(segment.getP2().y-segment.getP1().y/segment.getP2().x-segment.getP1().x);
        a=-1/a;
        b=point.y-a*point.x;
        r=segment.dst();
        double x0= point.x;
        double y0= point.y;
        double sqrt=Math.sqrt(-y0*y0+(2*b+2*a*x0)*(y0)+r*r-b*b-2*a*x0*b-a*x0*x0);
        double x1=x0-sqrt;
        double y1=y0-sqrt;
        double x2=sqrt+x0;
        double y2=b+a*x2;
        return new Segment[]{
                new Segment(point,new Point(x1,y1)),
                new Segment(point,new Point(x2,y2))
        };
    }
}
