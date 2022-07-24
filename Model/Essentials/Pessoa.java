package Model.Essentials;
/**
 * Representa uma pessoa.
 * 
 * @author Julio Arakaki
 * @version 0.1 24/03/2022
 */
public class Pessoa {
    // Atributos
    NomePessoa nomeP;
    int idadeP;
    
    // Construtor
    Pessoa (String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }
    // setters e getters
    public void setNome(String nome){
        nomeP = new NomePessoa(nome);
    }
    
    public NomePessoa getNome(){
        return nomeP;
    }
    
    public void setIdade(int idade){
        idadeP = idade;
    }
    
    public int getIdade(){
        return idadeP;
    }

    public String getNomeInvertido(){
        return getNome().getNomeInvertido();
    }
    public String getNomeBiblio(){
        return getNome().getNomeBiblio();
    }
    
    public String toString(){
        return "Nome: " + getNome().getNomePessoa() + "\nIdade: " + getIdade();
    }
    
}
