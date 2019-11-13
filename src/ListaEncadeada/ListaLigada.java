
package ListaEncadeada;


public class ListaLigada {
    
  private Nodo  primeira;
  private Nodo ultima;
  private int totalDeElementos;
    
  public void adiciona(Object elemento) {
    if (this.totalDeElementos == 0) {
      this.adicionaNoComeco(elemento);
    } else {
      Nodo nova = new Nodo(elemento);
      this.ultima.setProxima(nova);
      this.ultima = nova;
      this.totalDeElementos++;
    }
  }
  
  private boolean posicaoOcupada(int posicao){
  return posicao >= 0 && posicao < this.totalDeElementos;
}

private Nodo pegaCelula(int posicao) {
  if(!this.posicaoOcupada(posicao)){
    throw new IllegalArgumentException("Posição não existe");
  }

  Nodo atual = primeira;
  for (int i = 0; i < posicao; i++) {
    atual = atual.getProxima();
  }
  return atual;
}
  public void adiciona(int posicao, Object elemento) {
  if(posicao == 0){ // No começo.
    this.adicionaNoComeco(elemento);
  } else if(posicao == this.totalDeElementos){ // No fim.
    this.adiciona(elemento);
  } else {
    Nodo anterior = this.pegaCelula(posicao - 1);
    Nodo nova = new Nodo(anterior.getProxima(), elemento);
    anterior.setProxima(nova);
    this.totalDeElementos++;
    }
  }
  
  public Object pega(int posicao) {
  return this.pegaCelula(posicao).getElemento();
}
  public void remove(int posicao) {
  if (!this.posicaoOcupada(posicao)) {
    throw new IllegalArgumentException("Posição não existe");
  }

  if (posicao == 0) {
    this.removeDoComeco();
  } else if (posicao == this.totalDeElementos - 1) {
    this.removeDoFim();
  } else {
    Nodo anterior = this.pegaCelula(posicao - 1);
    Nodo atual = anterior.getProxima();
    Nodo proxima = atual.getProxima();
    
    anterior.setProxima(proxima);
    proxima.setAnterior(anterior);
    
    this.totalDeElementos--;
  }
}
  public int tamanho() {
    return this.totalDeElementos;
  }
  
  public boolean contem(Object elemento) {
  Nodo atual = this.primeira;

  while (atual != null) {
    if (atual.getElemento().equals(elemento)) {
      return true;
    }
    atual = atual.getProxima();
  }
  return false;
}
  public void adicionaNoComeco(Object elemento) {
    Nodo nova = new Nodo(this.primeira, elemento);
    this.primeira = nova;
    
    if(this.totalDeElementos == 0){
      // caso especial da lista vazia
      this.ultima = this.primeira;
    }
    this.totalDeElementos++;
  }
 public void removeDoComeco() {
  if (!this.posicaoOcupada(0)) {
    throw new IllegalArgumentException("Posição não existe");
  }

  this.primeira = this.primeira.getProxima();
  this.totalDeElementos--;
  
  if (this.totalDeElementos == 0) {
    this.ultima = null;
  }
}
  public void removeDoFim() {
  if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
    throw new IllegalArgumentException("Posição não existe");
  }
  if (this.totalDeElementos == 1) {
    this.removeDoComeco();
  } else {
    Nodo penultima = this.ultima.getAnterior();
    penultima.setProxima(null);
    this.ultima = penultima;
    this.totalDeElementos--;
  }
}
  
}
