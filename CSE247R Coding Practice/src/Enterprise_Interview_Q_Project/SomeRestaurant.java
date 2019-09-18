
/**
 * Original problem created by PTK
 * This strange restaurant, for some reason, keep receiving wrong orders of plate colors from the company that sells good quality plates.
 * The owner of the restaurant wants her employees to filter out the colors she does not want to send them back to the company.
 * The plates come from the company in dish caddies.
 * Design an object-oriented approach to make this work.
 */

import java.util.Iterator;
import java.util.Stack;

/* A plate object that has a field called color */
class Plate {
    private String color;

    public Plate(String color) {
        this.color = color;
    }

    public String getPlateColor() {
        return this.color;
    }
}

/* A dish caddy that can store multiple plates. Uses Stack data structure behind-the-scenes */
class DishCaddy {
    private Stack<Plate> dishCaddy;

    public DishCaddy() {
        this.dishCaddy = new Stack<Plate>();
    }

    public Stack<Plate> getDishCaddy() {
        return this.dishCaddy;
    }

    public Plate getTopPlate() {
        return this.dishCaddy.peek();
    }

    public Plate throwTopPlate() {
        return this.dishCaddy.pop();
    }

    public void insertPlate(Plate plate) {
        this.dishCaddy.push(plate);
    }

    public void print() {
        int count = 1;
        for(Plate plate: this.dishCaddy) {
            System.out.print("plate " + count + ") " + plate.getPlateColor() + "\n");
            count++;
        }
    }
 }

public class SomeRestaurant {
     public static DishCaddy filterPlates(DishCaddy caddy, String filter) {
        DishCaddy tempCaddy = new DishCaddy();

        Iterator<Plate> itr = caddy.getDishCaddy().iterator();

        while(itr.hasNext()) {
            /* If the current top plate is the unwanted color, take it out from the caddy */
            if(caddy.getTopPlate().getPlateColor() == filter) {
                caddy.throwTopPlate();
            }
            /* If we want to keep the current top plate, temporarily place it in another caddy */
            else {
                tempCaddy.insertPlate(caddy.throwTopPlate());
            }
        }

        /* Transfer all the plates from the temporary caddy back to original caddy */
        for(Plate plate: tempCaddy.getDishCaddy()) {
            caddy.insertPlate(plate);
        }

        return caddy;
     }

     public static void main(String[] args) {
         DishCaddy caddy = new DishCaddy();
         caddy.insertPlate(new Plate("red"));
         caddy.insertPlate(new Plate("yellow"));
         caddy.insertPlate(new Plate("white"));
         caddy.insertPlate(new Plate("blue"));
         caddy.insertPlate(new Plate("red"));
         caddy.insertPlate(new Plate("green"));
         caddy.insertPlate(new Plate("white"));
         caddy.insertPlate(new Plate("green"));
         caddy.insertPlate(new Plate("red"));
         caddy.insertPlate(new Plate("green"));
         caddy.insertPlate(new Plate("blue"));
         caddy.insertPlate(new Plate("yellow"));

         System.out.println("After filtering out the plates, these are what remain: ");
         filterPlates(caddy, "white").print();

     }
}