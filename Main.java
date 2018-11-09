import java.util.List;

public class Main {

    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(7, 8));

        //Se realiza la operacion para obtener los numeros menores a 1/2
        System.out.println("Los numero menores a un medio son: ");
        var unmedio = new Rational(1, 2);
        rationals.stream().filter(r -> r.isLessThan(unmedio)).forEach(System.out::println);

        //Se realiza la operacion para sumar todos los numeros racionales
        System.out.println("La suma total de los numeros racionales es: ");
        var cero = new Rational(0,1);
        var total = cero;
        total = rationals.stream().reduce(cero,(x,y) -> x.plus(y));
        System.out.println(total);

        //Se realiza la operacion para obtener el numero mayor de los racionales
        System.out.println("El numero mayor de los racionales es: ");
        var nmayor = cero;
        nmayor = rationals.stream().reduce(cero, (x,y) -> x.getGreater(y));
        System.out.println(nmayor);

        //Se realiza la operacion para sumar todos numeradores y obtener los siguientes datos: número de elementos
        //la suma de los numeradores, el numerador menor, el mayor y el promedio
        System.out.println("La suma de todos los numeradores es: ");
        int sumaN;
        sumaN = rationals.stream().mapToInt(r -> r.getNumerator()).reduce(0, Integer::sum);
        System.out.println(sumaN);

        System.out.println("El numero de elementos es: ");
        int numeroE;
        numeroE =  (int)rationals.stream().count();
        System.out.println(numeroE);

        System.out.println("\nNumerador menor:"+rationals.stream().mapToInt(Rational::getNumerator).min().getAsInt());

        System.out.println("\nNumerador mayor:"+rationals.stream().mapToInt(Rational::getNumerator).max().getAsInt());

        System.out.println("\nPromedio es:"+ sumaN / numeroE);

    }
}
