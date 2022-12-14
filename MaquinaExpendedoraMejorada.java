public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Cuenta los billetes
    private int contadorBilletesVendidos;
    // Da un premio
    private boolean premio;
    // Maximo de billetes para vender
    private int maximoBilletesVendidos;
    // Da premio cada 4 billetes
    private int numeroBilletesQuedanParaPremio;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioBillete, int maximoDeBilletesVendidos) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        contadorBilletesVendidos = 0;
        premio = premioBillete;
        maximoBilletesVendidos = maximoDeBilletesVendidos;
        numeroBilletesQuedanParaPremio = 3;
    }

    public MaquinaExpendedoraMejorada(boolean premioBillete, int maximoDeBilletesVendidos) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "leon";
        estacionDestino = "palencia";
        contadorBilletesVendidos = 0;
        premio = premioBillete;
        maximoBilletesVendidos = maximoDeBilletesVendidos;
        numeroBilletesQuedanParaPremio = 3;
    }

    /**
     * Devuelve la cantidad de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return contadorBilletesVendidos;
    }

    /**
     * Imprime la cantidad de billetes vendidos
     */
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Se han vendido " + contadorBilletesVendidos + " billetes de tren de " + estacionOrigen + " a " + estacionDestino + ".");
    }

    /**
     * Vacia el dinero de la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int dineroAcumulado;
        if (balanceClienteActual == 0) {
            dineroAcumulado = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("Error: Hay una operaci?n en curso.");
            dineroAcumulado = -1;
        }
        return dineroAcumulado;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (contadorBilletesVendidos < maximoBilletesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("Todos los billetes est?n vendidos.");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        int descuentoBillete = (precioBillete * 25) / 100;
        if (contadorBilletesVendidos < maximoBilletesVendidos) {
            if (cantidadDeDineroQueFalta <= 0) { 
                if(premio == true && numeroBilletesQuedanParaPremio == 0) {
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();
                    System.out.println("##################");
                    System.out.println("El billete de tren tiene un descuento de " + descuentoBillete + " euros.");
                    System.out.println("##################");

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    // Cuenta los billetes que se venden
                    contadorBilletesVendidos = contadorBilletesVendidos + 1;
                    // Vuelve a reiniciar el contador de dar premio al cuarto billete vendido
                    numeroBilletesQuedanParaPremio = 3;
                }
                else {
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    // Cuenta los billetes que se venden
                    contadorBilletesVendidos = contadorBilletesVendidos + 1;
                    // Resta los billetes vendidos hasta llegar al cuarto billete para dar premio
                    numeroBilletesQuedanParaPremio = numeroBilletesQuedanParaPremio - 1;
                }
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");

            } 
        }
        else {
            System.out.println("Todos los billetes est?n vendidos.");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
