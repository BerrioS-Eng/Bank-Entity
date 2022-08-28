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

    public void deleteClient(String cedula){
        //Luego de tener la posición del cliente a eliminar con ayuda del método
        //clientSearch(), se procede a eliminar el cliente sobrescribiendo ese cliente
        //con el cliente de la posición contigua.
        int index = clientSearch(cedula);
        if(index != -1){
            for(;index < cantReal-1; index++){
                arrayClient[index] = arrayClient[index+1];
            }
        }
        --cantReal;
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

    public Client showElements(int index){
        return arrayClient[index]; 
    }
}
