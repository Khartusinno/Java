package com.company;

import java.util.Locale;

public class Polygon {
    private Point points[];
    public Polygon(int x){
        points=new Point [x];
    }
    public void setPoint(int index, Point newPoint){
        points[index]=newPoint;
    }
    public void setPoints(Point newPoints[]){
        points=newPoints;
    }
    public String toSvg(){
        String s;
                for(Point point: points){
                    s=s+point.x+","+point.y+" ";
                }
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" style\"stroke:black\">",s);
    }
}
