


//Clase Empleado
/**
 * <h2> Una clase para atribuir los metodos de empleado
 * @version 1.0, 04/03/2022
 * @author Jorge Ruiz Navarro
 * @since 04-03-2022
*/
public class Empleado {
   
    private static double pagoPorHoraExtra; //atributo de clase
    private String nif;
    private String nombre;
    private double sueldoBase;
    private int horasExtras;
    private double tipoIRPF;
    private char casado;  //S ó N
    private int numeroHijos;
   
    //Constructor por defecto
    public Empleado() {
    }

    //Constructor con un parámetro
    /** 
     * @param nif como cadena de empleado
     */
    public Empleado(String nif) {
        this.nif = nif;
    }

    //Métodos get/set
    /**
     * @return el empleado que este casado
     */
    public char getCasado() {
        return casado;
    }
/**
 * @param casado variable casado instanciada
 */
    public void setCasado(char casado) {
        this.casado = casado;
    }

      /**
     * @return las horas extras que haya realizado el empleado
     */
    public int getHorasExtras() {
        return horasExtras;
    }
    
/**
 * @param horasExtras como varaible de las horas del empleado
 */
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
  /**
     * @return el nif del empleado
     */
    public String getNif() {
        return nif;
    }
/**
 * @param nif para reconocer al empleado 
 */
    public void setNif(String nif) {
        this.nif = nif;
    }
  /**
     * @return el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
    
/**
 * @param nombre como varible necesaria en la clase empleado
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  /**
     * @return el numero de hijos que tenga el empleado
     */
    public int getNumeroHijos() {
        return numeroHijos;
    }

    /**
     * @param numeroHijos para establecer el numero de hijos de un empleado
     */
    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }
  /**
     * @return el sueldo base que tenga el empleado
     */
    public double getSueldoBase() {
        return sueldoBase;
    }
/**
 * @param sueldoBase para establecer la variable del sueldo del trabajador
 */
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
  /**
     * @return el tipo de IRPF que se le vaya a realizar al empleado
     */
    public double getTipoIRPF() {
        return tipoIRPF;
    }
/**
 * @param tipoIRPF para establecer el IRPF que se le va aplicar al trabajador
 */
    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    //métodos get/set para el atributo static
      /**
     * @return pago que se la hace a la hora extra que haga
     */
    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }
/**
 * @param pagoPorHoraExtra establece el pago que se le hara al trabajador por las horas extras
 */
    public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
    }
   
   
    //calcular el importe de las horas extra
    /**
     * @return el importe de las horas extras (con la multiplicacion de las horas extras por el pago de las mismas)
     */
    public double calcularImporteHorasExtras(){
        return horasExtras * pagoPorHoraExtra;
    }
   
    //calcular el sueldo bruto
      /**
     * @return el sueldo bruto (sumando el sueldo base con el calculo del importe de las horas extras)
     */
    public double calcularSueldoBruto(){
        return sueldoBase + calcularImporteHorasExtras();
    }
   
    //calcular el importe de las retencion por IRPF
    /**
     * @param tipo establece el tipo de IRPF que se va a aplicar 
     * @return  la rentencion de IRPF (con la multiplicacion del sueldo bruto por la variable tipo, esto se divide entre 100)
     */
    public double calcularRetencionIrpf(){
        double tipo = tipoIRPF;
        if(casado == 's' || casado == 'S') {
            tipo = tipo - 2; //2 puntos menos si está casado
        }
        tipo = tipo - numeroHijos; //un punto menos por cada hijo                                                 
        if(tipo<0){
            tipo = 0;
        }
        return calcularSueldoBruto() * tipo / 100;
    }
   
    //calcular el importe liquido a cobrar
      /**
     * @return el sueldo (multiplicando el sueldo bruto restandole la retencion del IRPF)
     */
    public double calcularSueldo(){
        return calcularSueldoBruto() - calcularRetencionIrpf();
    }

    //mostrar los datos de un trabajador
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNif: ");
        sb.append(nif);
        sb.append("\nSueldo Base: ");
        sb.append(sueldoBase);
        sb.append("\nHoras Extras: ");
        sb.append(horasExtras);
        sb.append("\ntipo IRPF: ");
        sb.append(tipoIRPF);
        sb.append("\nCasado: ");
        sb.append(casado);
        sb.append("\nNúmero de Hijos: ");
        sb.append(numeroHijos);
        return  sb.toString();
    }
}//Fin de la Clase Empleado