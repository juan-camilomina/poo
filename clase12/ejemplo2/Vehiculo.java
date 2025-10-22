public class Vehiculo {
  protected String marca ;
   protected int velocidad ;
 public Vehiculo ( String marca ) {
this . marca = marca ;
this . velocidad = 0;
}
public void acelerar () { velocidad += 10; }
public String info () {
return " V e h i c u l o " + marca + " va a " + velocidad + " km / h " ;
}
}