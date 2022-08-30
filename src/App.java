import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayClientObject arrayobj1; 
        
        int n; 
        String cedula, nombre; 
        char sexo, opcion; 
        double saldo, valor, sumatoria;
        boolean flag; 
        Client cliente; 

        System.out.print("Ingrese numero de posiciones a reservar:");
        n = scanner.nextInt(); 
        arrayobj1 = new ArrayClientObject(n); 
        scanner.nextLine(); 

        System.out.println("Ingrese los datos del cliente(/* en cedula para salir):");
        System.out.print("Cédula: ");
        cedula = scanner.nextLine(); 
        while(!cedula.equals("/*")){
            
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            System.out.print("Sexo: ");
            sexo = scanner.next().charAt(0);
            System.out.print("Saldo: ");
            saldo = scanner.nextDouble();
            scanner.nextLine(); 

            arrayobj1.addClient(cedula, nombre, sexo, saldo); 

            System.out.print("Cédula: ");
            cedula = scanner.nextLine();
        }
       
        //MENÚ
        do {//Se muestra el menú en consola al menos una vez
            System.out.println();
            System.out.println("\t\t----- Menú -----");
            System.out.println("\t1. Ingresar un nuevo cliente.");
            System.out.println("\t2. Retirar un cliente.");
            System.out.println("\t3. Calcular sumatoria de saldo hombres.");
            System.out.println("\t4. Calcular sumatoria de saldo mujeres.");
            System.out.println("\t5. Clientes con saldo mayor a determinada cantidad.");
            System.out.println("\t6. Hacer deposito.");
            System.out.println("\t7. Hacer retiro.");
            System.out.println("\t8. Consultar saldo.");
            System.out.println("\t9. Salir.");
            System.out.println();
            //Se válida que el caracter(opcion) ingresado esté dentro de las opciones posibles
            do {
                System.out.print("Ingrese una opción: ");
                opcion = scanner.next().charAt(0);
    
                if(opcion < '0' || opcion > '9'){
                    System.out.println("\t\tLa opción no es correcta!!");
                }
            } while (opcion < '0' || opcion > '9');
            scanner.nextLine();
            //Condicional multiple para llamar a los métodos según la opción
            switch(opcion){
                case '1': //Pide los datos para crear al cliente y llama al método addClient() para agregarlo al arreglo
                    System.out.println("\n\t\tDatos para ingresar al cliente:");
                    System.out.print("\t\tCédula: ");
                    cedula = scanner.nextLine();
                    System.out.print("\t\tNombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("\t\tSexo: ");
                    sexo = scanner.next().charAt(0);
                    System.out.print("\t\tSaldo: ");
                    saldo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("\t\tIngresando un nuevo cliente...");
                    flag = arrayobj1.addClient(cedula, nombre, sexo, saldo);
                    if(flag){
                        System.out.println("\t\t\tSe agregó el cliente correctamente");
                    } else {
                        System.out.println("\t\t\tEl cliente ya existe");
                    }
                    break;
                case '2': //Pide una cédula y llama al método deleteClient() para eliminar el cliente
                    System.out.println("\t\tDatos para retirar al cliente:");
                    System.out.print("\t\tCédula: ");
                    cedula = scanner.nextLine();
                    System.out.println("\t\tRetirando cliente...");
                    flag = arrayobj1.deleteClient(cedula);
                    if(flag){
                        System.out.println("\t\t\tCliente retirado correctamente!!");
                    } else {
                        System.out.println("\t\t\tEl cliente no se encuentra en la base de datos");
                    }
                    break;
                case '3': //Sumatoria de saldos de las hombres
                    sumatoria = arrayobj1.sumatoriaSaldosHombres(); 
                    System.out.println("\t\t\tLa sumatoria de saldos de clientes hombres es " 
                                        +  sumatoria);
                    break;
                case '4':  //Sumatoria de saldos de las mujeres
                    sumatoria = arrayobj1.sumatoriaSaldosMujeres(); 
                    System.out.println("\t\t\tLa sumatoria de saldos de clientes mujeres es " 
                                        +  sumatoria);
                    break;
                case '5': //Pide una cantidad y recorre el arreglo de objetos llamando al método clientList()
                    System.out.print("\t\tDigite una cantidad: ");
                    valor = scanner.nextDouble(); 
                    System.out.println("\t\tA continuación los clientes con saldo mayor" +
                                                " o igual a " + valor);
                    for(int i=0; i < arrayobj1.getCantReal(); i++){
                        cliente = arrayobj1.clientList(i, valor);
                        if(cliente != null){
                            System.out.println("\t\t\t" + cliente.getCedula() + " | " + 
                                                cliente.getNombre() + " | " + cliente.getSaldo());
                        }
                    }
                    break;
                case '6': //Pide los datos y llama al método makeDeposit() para hacer deposito
                    System.out.print("\t\tCédula: ");
                    cedula = scanner.nextLine();
                    System.out.print("\t\tDigite una cantidad: ");
                    valor = scanner.nextDouble();
                    System.out.println("\t\tRealizando operación...");
                    flag = arrayobj1.makeDeposit(cedula, valor);
                    if(flag){
                        System.out.println("\t\t\tTransacción exitosa!!");
                    } else {
                        System.out.println("\t\t\tTransacción fallida, no existe el cliente.");
                    }
                    break;
                case '7': //Pide los datos y llama al método retiro() para hacer un retiro
                    System.out.print("\t\tCédula: ");
                    cedula = scanner.nextLine();
                    System.out.print("\t\tDigite una cantidad: ");
                    valor = scanner.nextDouble();
                    System.out.println("\t\tRealizando operación...");
                    flag = arrayobj1.retiro(cedula, valor);
                    if(flag){
                        System.out.println("\t\t\tTransacción exitosa!!");
                    } else {
                        System.out.println("\t\t\tTransacción fallida");
                        System.out.println("\t\t\tEl cliente no se encuentra en la base de datos ó" +
                                            " el monto a retirar supera el saldo");
                    }
                    break;
                case '8': //Consulta saldo del cliente según la cédula proporcionada
                    System.out.println("\t\tDatos para consultar saldo:");
                    System.out.print("\t\tCédula: ");
                    cedula = scanner.nextLine();
                    System.out.println("\t\tConsultando saldo...");
                    cliente = arrayobj1.consultarSaldo(cedula);
                    if(cliente != null){
                        System.out.println("\t\t\tEstimad@ Sr@. " + cliente.getNombre() + 
                                            ", su saldo actual es " + cliente.getSaldo());
                    } else {
                        System.out.println("\t\t\tEl cliente no se encuentra en la base de datos");
                    }
                    break;
                case '9':
                System.out.println("\t\tFin de la aplicación!!");
                    break;
            }

        } while (opcion != '9');

        scanner.close();
    }   
}
