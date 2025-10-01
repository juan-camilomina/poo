public class operacionesmatematicas {
       
    //atributos 
    private int n1;
     private int n2;
     //construtor de a clase: permite inicializar la clase I 
    

    /*
     * firma del metodo construtor 
     * visibilidad: publico 
     * nombre: operaciones matematicas 
     * cuantos parametros:2 
     * de que tipo son los parametros:
     *       parametro 1 tipo entero 
     *       parametro 2 tipo entero 
     */
    public operacionesmatematicas(int n1, int n2){
    this.n1=n1;
    this.n2=n2; 
    }




     //metodos 
     public int sumar (){
        return n1 + n2; 



    


     }

        public int restar (){  
            return n1 - n2; 
 



        }
                 public int multiplicar (){ 
                return n1 * n2; 
            }

                        public int dividir (){ 
                           double resultado;
                            if (n2 ==0){
                                resultado =0.0; 
                            }else{
                                resultado = (double)n1/n2; 
                            
                            }
                            return (int)resultado;

                            }

                            }
                            

                        
    
    
