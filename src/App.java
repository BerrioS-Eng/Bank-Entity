import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayClientObject arrayobj1; 
        
        int n; 
        String cedula, nombre; 
        char sexo; 
        double saldo; 

        System.out.print("Ingrese numero de posiciones a reservar:");
        n = scanner.nextInt(); 
        arrayobj1 = new ArrayClientObject(n); 
        scanner.nextLine(); 

        System.out.println("Ingrese los datos del cliente");
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
        
        //Mostrando elementos del arreglo
        for(int i=0; i < arrayobj1.getCantReal(); i++){
            System.out.print(arrayobj1.showElements(i).getNombre() + " | ");
        }

        //Probando método deleteClient()
        arrayobj1.deleteClient("000");
        System.out.println();

        //Mostrando elementos del arreglo
        for(int i=0; i < arrayobj1.getCantReal(); i++){
            System.out.print(arrayobj1.showElements(i).getNombre() + " | ");
        }

        scanner.close();
    }   
}
