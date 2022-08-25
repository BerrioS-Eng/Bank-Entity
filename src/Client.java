public class Client {
    private String cedula, nombre; 
    private char sexo; 
    private double Saldo; 

    public Client(String cedula, String nombre, char sexo, double saldo){
        this.cedula = cedula; 
        this.nombre = nombre; 
        this.sexo = sexo; 
        this.Saldo = saldo; 
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
}
