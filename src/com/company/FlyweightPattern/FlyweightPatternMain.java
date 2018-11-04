package com.company.FlyweightPattern;

public class FlyweightPatternMain
{
    public static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};
    
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        //lav 100.000.000 objekter
        for(int i=0; i < 500000; ++i) {
            //her vil vi lave et nyt objekt
            //men i stedet for at bruge new, så forespørger vi bare vores factory om det eksisterer
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            //så setter man bare nogle random værdier på hvor objektet skal være i universet
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            //størrelse af cirklen
            circle.setRadius(100);
            //"tern" her printer vi bare til konsol
            circle.draw();
        }
    
        long endTime = System.currentTimeMillis();
    
        System.out.println("In FLYWEIGHT that took: " +  (endTime-startTime) + "ms");
        
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
