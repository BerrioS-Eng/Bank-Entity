public class ArrayClientObject {
    private int cantReservada, cantReal; 
    private Client[] arrayClient; 

    //Constructor
    public ArrayClientObject(int cantReservada){
        this.cantReservada = cantReservada; 
        arrayClient = new Client[cantReservada]; 
        cantReal = 0; 
    }

    //Getters
    public int getCantReal(){
        return cantReal; 
    }

    //Métodos requeridos
    public boolean addClient(String cedula, String nombre, char sexo, double saldo){
        boolean thereIsOne = true; 
        //Evalua la cantidad elementos en el arreglo, si existe al menos un elemento
        //se recorre y se compara el atributo cedula de cada elemento con la cedula que llega como
        //la cedula que llega como parametro. 
        if(cantReal > 0){
            for(int i=0; i < cantReal; i++){
                if(cedula.equals(arrayClient[i].getCedula())){
                    thereIsOne = false;
                    break; 
                }
            }
        }
        //Evalua la variable booleana que indica si hay al menos una igualdad,
        //de ser falso se procede a ingresar el nuevo cliente
        if(thereIsOne){
            arrayClient[cantReal++] = new Client(cedula, nombre, sexo, saldo); 
        }
         
        return thereIsOne;
    }

    public boolean deleteClient(String cedula){
        //Luego de tener la posición del cliente a eliminar con ayuda del método
        //clientSearch(), se procede a eliminar el cliente sobrescribiendo ese cliente
        //con el cliente de la posición contigua.
        int index = clientSearch(cedula);
        if(index != -1){
            for(;index < cantReal-1; index++){
                arrayClient[index] = arrayClient[index+1];
            }
            --cantReal;
            return true; 
        }
        return false; 
    }
    
    public int clientSearch(String cedula){
        //Método para buscar cliente según la cédula que llega como parametro,
        //se recorre el arreglo y se compara con el atributo cedula de cada elemento
        //retorna la posición del arreglo donde se encuentra el cliente
        //si no encuentra nada retorna -1
        int index = -1; 
        for(int i=0; i < cantReal; i++){
            if(cedula.equals(arrayClient[i].getCedula())){
                index = i;
                break;
            }
        }
        return index; 
    }

    public Client clientList(int index, double valor){
        //Este método recibe entero(index) con el que accede a las posiciones
        //del arreglo, para poder tomar el atributo saldo de cada elemento y 
        //compararlo con el valor que llega como parametro.
        //Retornará el cliente de esa posición(index) si cumple con la condición,
        //en caso contrario, retornará null.
        if(arrayClient[index].getSaldo() >= valor){
            return arrayClient[index];
        }
        return null; 
    }

    public boolean makeDeposit(String cedula, double valor){
        //Este método setea el atributo saldo sumandole el valor del parametro.
        //Se apoya del método auxiliar clientSearch() para buscar la posición del cliente.
        int position = clientSearch(cedula); //Esta variable guarda la posición del cliente cuya cédula coincide con la cedula del parametro
        //Este condicional válida que la posición sea diferente de -1, para evitar que si el método 
        //clientSearch() no encuentra nada, este no intente acceder al arreglo.
        if(position != -1){
            Client cliente = arrayClient[position];
            cliente.setSaldo(cliente.getSaldo() + valor);
            return true; 
        }
        return false; 
    }
    
    public boolean retiro(String cedula, double valor) {
	    int position = clientSearch(cedula);
	    
	    if(position != -1){
            Client cliente = arrayClient[position];
            cliente.setSaldo(cliente.getSaldo() - valor);
            return true; 
        }
        return false; 
    }
	    
	
    
    
    public double sumatoriaSaldosHombres() {
    double sumatoria = 0;
    for (int i = 0; i < arrayClient.length; i++) {
        if (arrayClient[i].getSexo() == 'M' ) {
            sumatoria += arrayClient[i].getSaldo();
         }
     }
    return sumatoria;
 }
    
 public double sumatoriaSaldosMujeres() {
     double sumatoria = 0;
     for (int i = 0; i < arrayClient.length; i++) {
         if (arrayClient[i].getSexo() == 'F' ) {
             sumatoria += arrayClient[i].getSaldo();
         }
     }
     return sumatoria;
 }
     
 public double consultarSaldo(String cedula, double saldo) {
    for (int i = 0; i < arrayClient.length; i++) {
         if (arrayClient[i].getCedula() == (cedula)) {
            saldo = arrayClient.length;
                 
            }
    }
    return saldo;
}    					
    
    public Client showElement(int index){
        return arrayClient[index]; 
    }
}
