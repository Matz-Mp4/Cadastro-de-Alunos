package Model.Essentials;
/**
 * Armazena um texto. Inverte texto e limpa espaços extras
 * 
 * @author Julio Arakaki 
 * @version 1.0 2019/02/29
 */
public class Texto {
    // Atributo da classe ou varáveis de instancia
    private String txt;

    /** 
     * Construtor: armazena o texto e limpa os espaços excedentes
     * 
     * @param txt String com o texto que será armazenado
     */
    Texto(String txt){
        setTxt(txt);
        limpaBrancos();
    }

    // setters e getters
    private void setTxt(String t){
        this.txt = t;
    }

    public String getTxt(){
        return this.txt;
    }

    /**
     * Retorna um texto invertido
     * @return txtInvertido String contendo o texto invertido
     */
    public String getTextoInvertido(){
        String txtInvertido = "";
        if(!(getTxt() == null || getTxt().equals("") )){
            for (int i=getTxt().length()-1; i >= 0; i--){
                txtInvertido = txtInvertido + getTxt().charAt(i);
            }
        } else return null;
        return txtInvertido;
    }

    /**
     * Retorna quantidade de palavras do nome
     * @return qtd numero de palavras
     */
    public int getQtdePalavras(){
        return (getTxt().split(" ").length);
    }

    /**
     * Retira espacos excedentes de uma string
     * @return s string sem espacos excedentes
     */
    private void limpaBrancos(){
        // Elimina espacos do inicio e fim da string
        setTxt(getTxt().trim());

        // Elimina espacos excedentes do meio da string
        String s = "";
        for (int i=0; i < getTxt().length(); i++){
            s = s + getTxt().charAt(i);
            if(getTxt().charAt(i) == ' '){ // Achou primeiro espaco
                while(getTxt().charAt(i+1) == ' '){ // pula os excedentes
                    i++;
                }
            }
        }
        setTxt(s);
    }
    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return(getTxt());
    }
}
