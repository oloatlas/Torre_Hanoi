
package algoritimos;


public class Lista{
private Caixinha inicio;

   public Lista(){
     this.inicio =  null;
   }

    public void inserir(int elemento){
     Caixinha nova = new Caixinha();
     nova.setElemento(elemento);
     nova.setProximo(null);
     
     if(inicio==null){inicio=nova;}
     else{Caixinha aux;
     aux= inicio;
     while(aux.getProximo()!= null){
       aux = aux.getProximo();
     }
     aux.setProximo(nova);
     }
    }
    
    public int retirar(){
     
     Caixinha aux = inicio;
     int elemento = aux.getElemento();
     inicio = aux.getProximo();
     return elemento;
    }
    
    public void listar(){
    if(inicio==null){System.out.println("lista vazia");}
    else{Caixinha aux = inicio;
     while(aux.getProximo()!= null){System.out.println("Elemento visto" +aux.getElemento());
       aux=aux.getProximo();
      }
     }
    }
    
    public boolean isEmpty(){
     return(this.inicio==null);
    }
}
