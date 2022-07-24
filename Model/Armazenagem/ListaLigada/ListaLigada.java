package Model.Armazenagem.ListaLigada;

import Model.Essentials.Aluno;

public class ListaLigada {
  private No inicio;
  private No fim;
  private No meio;
  private int qtd;
  private char letra;
  private int sinalMeio;

  public ListaLigada(String nome) {
    inicializar(nome);
  }

  public void esvaziar() {
    No apont, aux;
    if (qtd != 0) {
      apont = inicio;

      do {
        aux = apont.getProximo();
        apont = null;
        apont = aux;
      } while (apont != null);
      meio = null;
      qtd = 0;
    }
  }

  /*
   * @param uma variavel do tipo String, uma variavel do tipo String
   * 
   * @return uma variavel do tipo String
   * 
   * @fuction determina qual das variavel é "maior"
   * em ordem alfabetica
   **/
  private String qualMaior(String nome1, String nome2) {
    String maior = null;
    boolean veri = false;
    int i = 0, fim;

    if (nome1.equals(nome2) != true) {
      // Matias Maties
      // Mat Matias
      // Maaaa Mat
      fim = nome1.length();
      if (nome1.length() > nome2.length()) {
        fim = nome2.length();
      }
      while (i < fim && veri == false) {
        if (nome1.charAt(i) > nome2.charAt(i)) {
          veri = true;
          maior = nome1;
        } else if (nome2.charAt(i) > nome1.charAt(i)) {
          veri = true;
          maior = nome2;
        }
        i++;
      }

      if (veri == false) {
        if (nome1.length() < nome2.length()) {
          maior = nome2;
        } else {
          maior = nome1;
        }
      }
    }
    return maior;
  }

  /*
   * @parm uma variavel do tipo String
   * 
   * @return uma variavel do tipo No
   * 
   * @function buscar 1 primeira posicao que é menor
   * que o valor comparado -> insere na direita
   **/
  private No buscarPosInsMenor(String nome) {
    No aux;
    Aluno auxAluno;
    String nomeAux, maior;
    No posicao = null;
    boolean achou = false;

    if (meio.getAntecessor() != null) {
      aux = meio.getAntecessor();
      do {
        auxAluno = (Aluno) aux.getItem();
        nomeAux = auxAluno.getNome().getNomePessoa();

        maior = qualMaior(nome, nomeAux);

        if (maior == nome) {
          achou = true;
          posicao = aux;
          // Tem duplicata
        } else if (maior == null) {
          achou = true;
          // uma forma de informar que é uma duplicata
          posicao = meio;
        }

        aux = aux.getAntecessor();
      } while (aux != null && achou == false);

      // se achou for false entao insere no começo
      if (achou == false) {
        posicao = null;
      }
    }
    return posicao;
  }

  /*
   * @parm uma variavel do tipo String
   * 
   * @return uma variavel do tipo No
   * 
   * @function buscar 1 primeira posicao que é "maior"
   * que o valor comparado -> insere na esquerde
   **/

  private No buscarPosInsMaior(String nome) {
    No aux;
    Aluno auxAluno;
    String nomeAux, maior = null;
    No posicao = null;
    boolean achou = false;

    if (meio.getProximo() != null) {
      aux = meio.getProximo();
      do {
        auxAluno = (Aluno) aux.getItem();
        nomeAux = auxAluno.getNome().getNomePessoa();

        maior = qualMaior(nome, nomeAux);
        if (maior == nomeAux) {
          achou = true;
          posicao = aux;
          // Tem duplicata
        } else if (maior == null) {
          achou = true;
          // Uma forma de saber se tem duplicata
          posicao = meio;
        }

        aux = aux.getProximo();
      } while (aux != null && achou == false);

      // se achou for false, insere no fim da lista
      if (achou == false) {
        posicao = null;
      }
    }
    return posicao;
  }

  private String eMaiorQueMeio(String nome) {
    String maior;

    Aluno meioAluno = (Aluno) meio.getItem();
    String nomeMeio = meioAluno.getNome().getNomePessoa();

    maior = qualMaior(nome, nomeMeio);

    return maior;
  }

  /*
   * @param uma variavel do tipo String
   * 
   * @return uma variavel do tipo No
   * 
   * @function buscar o No que tem o valor do parametro
   **/
  public No buscarPos(String nome) {
    No posicao = null;
    No aux;
    Aluno auxAluno = (Aluno) meio.getItem();
    String nomeAux = auxAluno.getNome().getNomePessoa();
    boolean achou = false;
    // nome é maior que o meio

    if (nome.equals(nomeAux)) {
      posicao = meio;
    } else if (eMaiorQueMeio(nome) == nome) {
      aux = meio.getProximo();
      do {
        auxAluno = (Aluno) aux.getItem();
        nomeAux = auxAluno.getNome().getNomePessoa();

        if (nomeAux.equals(nome)) {
          achou = true;
          posicao = aux;
        }
        aux = aux.getProximo();
      } while (aux != null && achou == false);

      // nome é menor que o meio
    } else if (eMaiorQueMeio(nome) != null) {

      aux = meio.getAntecessor();
      do {
        auxAluno = (Aluno) aux.getItem();
        nomeAux = auxAluno.getNome().getNomePessoa();

        if (nomeAux.equals(nome) == true) {
          achou = true;
          posicao = aux;
        }
        aux = aux.getAntecessor();
      } while (aux != null && achou == false);
    }
    return posicao;
  }

  void inserirInicio(Object item) {

    No novo = new No(item);
    No prim = inicio;
    novo.setAntecessor(null);
    inicio = novo;

    if (qtd == 0) {
      novo.setProximo(null);
      fim = novo;
      meio = novo;
      sinalMeio = 0;
    } else {
      prim.setAntecessor(novo);
      novo.setProximo(prim);
      sinalMeio--;
    }
    qtd++;
    atualizarMeio();

  }

  void removerInicio() {
    No prim = inicio, prox;
    if (qtd != 0) {

      qtd--;
      inicio = prim.getProximo();
      if (prim.getProximo() == null) {
        fim = null;
        meio = null;
        sinalMeio = 0;
      } else {
        prox = prim.getProximo();
        prox.setAntecessor(null);
        sinalMeio++;
        atualizarMeio();
      }
      prim = null;
    }
  }

  void removerUltimo() {
    No ultimo = fim, ant;
    if (qtd != 0) {
      qtd--;
      fim = ultimo.getAntecessor();
      // Se tem apenas um elemento
      if (inicio.getProximo() == null) {
        inicio = null;
        meio = null;
        sinalMeio = 0;
      } else {
        ant = ultimo.getAntecessor();
        ant.setProximo(null);
        sinalMeio--;
        atualizarMeio();
      }
      ultimo = null;
    }

  }

  void inserirFim(Object item) {

    No novo = new No(item);
    No ultimo = fim;
    novo.setProximo(null);
    fim = novo;

    if (qtd == 0) {
      qtd++;
      novo.setAntecessor(null);
      inicio = novo;
      meio = novo;
      sinalMeio = 0;
    } else {
      qtd++;
      ultimo.setProximo(novo);
      novo.setAntecessor(ultimo);
      sinalMeio++;
      atualizarMeio();
    }

  }

  /*
   * @param umva variavel do tipo Object
   * 
   * @retun nenhum
   * 
   * @function insere um elemento na lista em ordem alfabetica
   **/

  public boolean inserir(Object item) {
    No posicao, ant, prox;
    String nomeItem, nomeMeio, maior;
    boolean veri = false;
    Aluno itemAluno;

    if (qtd == 0) {
      inserirInicio(item);
      veri = true;

    } else {

      itemAluno = (Aluno) item;
      nomeItem = itemAluno.getNome().getNomePessoa();
      nomeMeio = getNomeNo(meio);
      maior = qualMaior(nomeItem, nomeMeio);
      if (maior == nomeMeio) {
        posicao = buscarPosInsMenor(nomeItem);
        if (posicao == null) {
          inserirInicio(item);
          veri = true;
          // senao, insere no meio
        } else if (posicao != meio) {
          No novo = new No(item);

          prox = posicao.getProximo();
          novo.setProximo(prox);
          novo.setAntecessor(posicao);
          posicao.setProximo(novo);
          prox.setAntecessor(novo);

          qtd++;
          sinalMeio--;
          atualizarMeio();
          veri = true;
        }

      } else if (maior == nomeItem) {
        posicao = buscarPosInsMaior(nomeItem);
        if (posicao == null) {
          inserirFim(item);
          veri = true;
          // senao, insere no meio
        } else if (posicao != meio) {
          No novo = new No(item);
          ant = posicao.getAntecessor();
          novo.setProximo(posicao);
          novo.setAntecessor(ant);
          ant.setProximo(novo);
          posicao.setAntecessor(novo);
          qtd++;
          sinalMeio++;

          atualizarMeio();
          veri = true;
        }
      }
    }
    return veri;
  }

  private String getNomeNo(No a) {
    String nome = null;
    Aluno aux;
    if (a != null) {
      aux = (Aluno) a.getItem();
      nome = aux.getNome().getNomePessoa();
    }
    return nome;
  }

  /*
   * @param uma variavel do tipo String
   * 
   * @return uma variavel do tipo boolean
   * 
   * @function remove um elemento da lista
   **/

  boolean remover(String nome) {

    No posicao = buscarPos(nome);
    No ant, prox;
    String maior, nomeMeio;
    boolean veri = false;

    if (posicao != null) {
      if (posicao == inicio) {
        removerInicio();

      } else if (posicao == fim) {
        removerUltimo();
      } else {

        if (posicao == meio) {
          sinalMeio--;
          meio = meio.getAntecessor();
        }
        nomeMeio = getNomeNo(meio);
        maior = qualMaior(nomeMeio, nome);
        if (maior == nome) {
          sinalMeio--;
        } else if (maior == nomeMeio) {
          sinalMeio++;
        }
        ant = posicao.getAntecessor();
        prox = posicao.getProximo();
        ant.setProximo(prox);
        prox.setAntecessor(ant);
        qtd--;
        atualizarMeio();
      }
      veri = true;
    }
    return veri;
  }

  // setter
  private void inicializar(String nome) {
    inicio = null;
    meio = null;
    fim = null;
    qtd = 0;
    sinalMeio = 0;
    letra = Character.toUpperCase(nome.charAt(0));
  }

  /*
   * @param nenhum
   * 
   * @retun nenhum
   * 
   * @function Mecanismo para atualizar o endereco do meio
   */
  private void atualizarMeio() {

    if (qtd % 2 != 0 && sinalMeio < 0) {
      meio = meio.getAntecessor();
      sinalMeio = 0;
    } else if (qtd % 2 != 0 && sinalMeio > 0) {
      meio = meio.getProximo();
      sinalMeio = 0;
    }
  }

  public void mostrar() {

    No posicao;
    if (qtd == 0) {
      System.out.println("Lista vazia");
    } else {
      posicao = inicio;

      System.out.println("meio: " + getNomeNo(meio));
      do {
        System.out.print(getNomeNo(posicao) + "->");
        posicao = posicao.getProximo();
      } while (posicao != null);
    }
  }

  // getter
  public No getInicio() {
    return inicio;
  }

  public No getFim() {
    return fim;
  }

  public No getMeio() {
    return meio;
  }

  public int getqtd() {
    return qtd;
  }

  public char getLetra() {
    return letra;
  }

}
