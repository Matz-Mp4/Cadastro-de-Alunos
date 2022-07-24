package Model.Armazenagem.ListaLigada;

public class No{

    private Object item;
    private No proximo;
    private No antecessor;
    
    public No(Object item){
        inicializar(item);
    }

    private void inicializar(Object item){
        setItem(item);
        setProximo(null);
        setAntecessor(null);
    }
    //setter
    public void setItem(Object item){
        this.item = item;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    public void setAntecessor(No antecessor){
        this.antecessor = antecessor;
    }

    //Getters
    public Object getItem(){
        return item;
    }

    public No getProximo(){
        return proximo;
    }

    public No getAntecessor(){
        return antecessor;
    }
}
