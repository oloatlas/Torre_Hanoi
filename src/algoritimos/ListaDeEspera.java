
package algoritimos;


public class ListaDeEspera {
    
    public static void main (String args[]){
     Lista lista = new Lista();
     lista.inserir(25);
     lista.inserir(24);
     lista.inserir(25);
     lista.inserir(26);
     
     while(!lista.isEmpty()){
        int e = lista.retirar();
        System.out.println("returei o elemento e" + e);
     }
     
    }
}
