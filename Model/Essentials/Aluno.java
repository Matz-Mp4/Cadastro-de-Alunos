package Model.Essentials;
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno extends Pessoa{
    private String ra;
    private String curso;
    private float nota;
    
    public Aluno(String raAluno, String cursoAluno, float notaAluno, String nome, int idade){
        super(nome, idade);
        setRA(raAluno);
        setCurso(cursoAluno);
        setNota(notaAluno);
    }
    
    //Setters
    public void setRA(String raAluno){
        ra = raAluno;
    }
    
    public void setNota(float notaAluno){
        nota = notaAluno;
    }
    
    public void setCurso(String cursoAluno){
        curso = cursoAluno;
    }
    
    //Getters
    
    public String getRA(){
        return ra;
    }
    
    public String getCurso(){
        return curso;
    }
    
    public float getNota(){
        return nota;
    }
    
    public String toString(){
         return  "\tNome: " + getNome().getNomePessoa() + 
                 "\n\tIdade: " + getIdade() + 
                 "\n\tRa: " + getRA() + 
                 "\n\tCurso:" + getCurso() + 
                 "\n\tNota: " + getNota();
    }
}
