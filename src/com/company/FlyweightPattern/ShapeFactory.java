package com.company.FlyweightPattern;

import java.util.HashMap;

//Create a factory to generate object of concrete class based on given information
public class ShapeFactory
{
    //2. here it checks the circle object in the hashmap
    //3. it looks through the hashmap, and see if a circle exists with that color that should be used
    //4. so instead of creating a new color, it uses the circle object that was initially created
    //-- and gets the color associated with it
    private static final HashMap circleMap = new HashMap();
    
    //1. this is the method that gets called when a request comes to make a circle of a certain color
    public static Shape getCircle(String color)
    {
        //her matcher den på den farve der bliver forespurgt af "brugeren / client"
        //her er brugeren / client os, da vi selv angiver hvad farve vi gerne vil ha at cirklen skal have
        Circle circle = (Circle)circleMap.get(color);
        
        //hvis der ikke eksisterer et circle objekt med den farve vi vil ha
        if(circle == null)
        {
            //lav new circle med tilsvarende farve
            circle = new Circle(color);
            //put det ind i hashmap med color først, for så er det objekt vi skal bruge unik for hver farve og ikke omvendt
            circleMap.put(color,circle);
            System.out.println("Creating circle of color : " + color);
        }
        //returner ny circle objekt
        return circle;
    }
}
