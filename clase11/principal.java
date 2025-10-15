public class principal {
    public static void main(String[] args) {
        CuentaBancaria banco = new CuentaBancaria("luis", "104001", 1000);
        banco.depositar(70000);
        banco.retiro(30000);
        System.out.println(banco.toString());

        CuentaBancaria cuenta2 = new CuentaBancaria("didier", "127423", 19000);
        cuenta2.depositar(-100);
        cuenta2.retiro(20000);
        System.out.println(cuenta2.toString());

        System.out.println("-------------------------------------");

        Producto p0 = new Producto("zapatos", "ropa", 300, 200);
        System.out.println(p0.calcularSubT());
        System.out.println(p0.Apliclardescuento());
        System.out.println(p0.toString());

        System.out.println("despues de agregar mas cantidad");
        p0.agregarCantidad(20);
        System.out.println(p0.toString());
        

    }
}