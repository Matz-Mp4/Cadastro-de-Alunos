package Model.Essentials;

public class CadastroValidacao {

  public CadastroValidacao(){
  }


  /**
   * Valida os dados digitados do usuario
   * @param aluno
   * @return
   */
  public static boolean checkarDados(Aluno aluno){

      boolean veri = true;
      
      String nome = aluno.getNome().getNomePessoa();
      String idade = String.valueOf(aluno.getIdade());
      String curso = aluno.getCurso();
      String nota = String.valueOf(aluno.getNota());
      
      if(verificarApenasNumero(idade) == false  || verificarNota(nota) == false || verificarApenasLetras(curso) == false || verificarApenasLetras(nome) == false){

        veri = false;
      }
      return veri; 
  }

  /**
   * Verifica se cada letra de uma String é uma letra 
   * @param palavra
   * @return
   */
  public static boolean verificarApenasLetras(String palavra){
  
    boolean veri = true;
    int i = 0;

    while(i < palavra.length() && veri == true){

      if(verificarDigitoNumero(palavra.charAt(i)) == true){
        veri = false;
      }
      i++;
    }
    return veri;
  }
  
  public static boolean verificarApenasNumero(String numero){

    int i = 0;
    boolean veri = false;

    if(numero != null){

      while(i < numero.length() && verificarDigitoNumero(numero.charAt(i)) == true){
        i++;
      }

      if(i == numero.length()){
        veri = true; 
      }
    }
    return veri;
  }
  
  /**
   *  Verifica o digito de uma um numero 
   * @param caracter parametro para verificar se é um numero inteiro 
   * @return
   */
  public static boolean verificarDigitoNumero(char caracter){
    
    boolean veri = false;
    String digitos = "0123456789";
    int i = 0;
    
    while(veri == false && i < digitos.length()){

      if(caracter == digitos.charAt(i)){
        veri = true;
      }
      i++;
    }

    return veri;

  }
  /**
   *  Verifica se o ra possui uma parte igual a ra e a outra parte
   *  verifica se possui apenas numeros
   * @param ra
   * @return
   */
    
  public static boolean verificarRA(String ra){

    boolean veri = false;
    
    if(ra != null){
      String letra = "";
      String numero = "";
    
      for(int i = 0; i < ra.length(); i++){
        if(i < 2){
          letra += ra.charAt(i);
        }else{
          numero += ra.charAt(i); 
        }
      }

      if(letra.equals("ra") == true && verificarApenasNumero(numero) == true){
        veri = true;
      }
    }
    return veri;
  }

  /**
   * Verifica se a nota esta na escala entra 0 a 10 é nao é uma String
   * @param nota
   * @return
   */
  public static boolean verificarNota(String nota){

    boolean veri = false;
    
    if(verificarApenasLetras(nota) == false){
      float aux = Float.parseFloat(nota);
      if(aux >= 0){
        veri = true;
      }
    }
    return veri;
  }
}
