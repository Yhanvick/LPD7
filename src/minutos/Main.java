package minutos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	//creo mi objeto scanner para poder leer la entrada del usuario e importo el scanner con java.util.Scanner
        Scanner sc = new Scanner(System.in);
        
        //ahora puedo declarar mis variables en las que voy a almacenar el día, la hora y los minutos que el usuario va a ingresar
        String dia;
        int hora, minutos;

        //establezco mi bucle while en donde voy a solicitar el día. Uso mi método .nextLine() para poder leer la entrada como una cadena de texo. 
        //Mi método toLowerCase() me ayuda a transforma todo el input del usuario a letras minusculas para poder leer de forma adecuada la cadena de texto y mi método trim() me ayuda a eliminar los espacios en blanco antes y despues del texto del usuario para evitar errores.
        //de con todos mis métodos anteriores puede comparar el input con lunes, martes, miercoles, jueves y viernes (que estan en minisculas y sin espacios) con mi método equals()
        while (true) {
            System.out.print("Introduce un día de la semana (lunes a viernes): ");
            dia = sc.nextLine().toLowerCase().trim();
            if (!dia.equals("lunes") && !dia.equals("martes") && !dia.equals("miercoles") &&
                !dia.equals("jueves") && !dia.equals("viernes")) { 
                System.out.println("Día inválido. Por favor, introduce un día válido.");
                continue;
            } // si alguno de los dias no es valido se reinicia el bucle al igual que en los demas continue;
            
            //hora
            System.out.print("Introduce la hora (0-23): ");
            while (!sc.hasNextInt()) { //hasNextInt es un método del scanner para poder comprobar si la entrada es un número entero que deuvelve true si es cierto
                System.out.println("Hora inválida. Por favor, introduce un número válido.");
                sc.next();
            }
            hora = sc.nextInt();
            if (hora < 0 || hora > 23) { //que no sea menor que 0 ni mayor a 23
                System.out.println("Hora inválida. Por favor, introduce una hora válida.");
                sc.nextLine();
                continue; // si la hora no es válida se reinicia
            }

            // minutos
            System.out.print("Introduce los minutos (0-59): ");
            while (!sc.hasNextInt()) {
                System.out.println("Minutos inválidos. Por favor, introduce un número válido.");
                sc.next();
            }
            minutos = sc.nextInt();
            if (minutos < 0 || minutos > 59) { // que los minutos no sean menores a 0 ni mayores a 59
                System.out.println("Minutos inválidos. Por favor, introduce minutos válidos.");
                sc.nextLine();
                continue; //si los minutos no son válidos se reinica el bucle 
            }

            // Calcular los minutos restantes usando el método minutosRestantesParaFin
            int minutosHastaFinDeSemana = minutosRestantesParaFin(dia, hora, minutos);
            if (minutosHastaFinDeSemana >= 0) {
                System.out.println("Faltan " + minutosHastaFinDeSemana + " minutos para el fin de semana.");
                break; //aquí puedo terminar mi ciclo while pues ya se tiene las 3 entradas válidas
            }
        }
        sc.close();
    }

    // metodo para calcular minutos restantes, donde a cada día le asigno un díaNumerico, 0, 1, 2, 3 o 4 
    public static int minutosRestantesParaFin(String dia, int hora, int minutos) {
        int diaNumerico;
        //verifico si los !dias no son iguales a:
        if (dia.equals("lunes")) {
            diaNumerico = 0;
        } else if (dia.equals("martes")) {
            diaNumerico = 1;
        } else if (dia.equals("miercoles")) {
            diaNumerico = 2;
        } else if (dia.equals("jueves")) {
            diaNumerico = 3;
        } else {
            diaNumerico = 4; // Viernes
        }

        int minutosFinSemana = 4 * 24 * 60 + 15 * 60; // aqio puedo calcular los minutos desde el lunes hasta el día viernes 
        int minutosActuales = diaNumerico * 24 * 60 + hora * 60 + minutos; // calcula los minutos totales desde el inicio de la semana hasta el momento actual
        return minutosFinSemana - minutosActuales; // por lo tanto tengo que restar, y la diferencia serán los minutos restantes hasta el fin de semana 
    }
}

/*
 Crear un programa en Java que realice lo siguiente:
Debe solicitar al usuario un día de la semana (de lunes a viernes).
Debe solicitar al usuario una hora (horas y minutos).
Debe calcular cuantos minutos faltan para el fin de semana. Se considera que el fin de semana comienza el viernes a las 15:00 hrs.
Debe mostrar el resultado por consola.
Debe ser capaz de identificar si los datos de entrada son válidos (día de la semana válido, hora válida, minutos válidos), en caso contrario debe mandar un mensaje de error y volver a solicitar los datos.*/

/*
 *Documentación del Scanner https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 *Método hasNextInt https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#hasNextInt()
 * Métodos de la clase String https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * Método toLowerCase https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#toLowerCase()
 * Método trim https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim()
 *Operadores en Java https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 *Estructuras de control (while, if) https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html
 */


