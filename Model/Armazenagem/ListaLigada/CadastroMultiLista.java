package Model.Armazenagem.ListaLigada;

import Model.Armazenagem.IArmazenagem;
import Model.Essentials.Aluno;

public class CadastroMultiLista implements IArmazenagem {
  private ListaLigada[] cad;
  private int qtd;
  private final int FANTASMA = -1;
  private final String[] ALFABETO = { "A", "B", "C", "D", "E", "F",
      "G", "H", "I", "J", "K", "L",
      "M", "N", "O", "P", "Q", "R",
      "S", "T", "U", "V", "W", "X",
      "Y", "Z" };

  public CadastroMultiLista() {
    inicializarCad();
  }

  /*
   * @param nenhum
   * 
   * @return nunhum
   * 
   * @function esvaziar o a lista
   **/
  public void esvaziar() {
    for (int i = 0; i < qtd; i++) {
      cad[i].esvaziar();
    }
    qtd = 0;
  }

  public int getTamVetor() {
    return qtd;
  }

  public int getQtdCad() {
    return qtd;
  }

  public boolean estaCheio() {
    return false;
  }

  /*
   * @param nenhum
   * 
   * @return nenhum
   * 
   * @function uma inicializa os atributos
   **/
  public void inicializarCad() {
    qtd = 0;
    cad = new ListaLigada[26];

    for (int i = 0; i < 26; i++) {
      cad[i] = new ListaLigada(ALFABETO[i]);
    }
  }

  public int buscarPosicaoCad(String nome) {
    boolean veri = false;
    int i = 0, posicao = FANTASMA;
    char buscar = Character.toUpperCase(nome.charAt(0));

    while (i < 27 && veri == false) {
      if (cad[i].getLetra() == buscar) {
        posicao = i;
        veri = true;
      }
      i++;
    }
    return posicao;
  }

  public boolean inserirCad(Aluno a) {
    boolean veri = true;
    int pos;
    String nomeAluno = a.getNome().getNomePessoa();
    pos = buscarPosicaoCad(nomeAluno);

    if (pos != FANTASMA) {
      veri = cad[pos].inserir(a);
      if (veri == true) {
        qtd++;
      }
    }
    return veri;
  }

  public boolean removerCad(String nome) {
    boolean veri = false;
    int posicao;

    if (qtd != 0) {
      posicao = buscarPosicaoCad(nome);
      if (posicao != FANTASMA) {
        veri = cad[posicao].remover(nome);
      }
      if (veri == true) {
        qtd--;
      }
    }
    return veri;
  }

  public int getQtd() {
    return qtd;
  }

  public boolean estaVazio() {
    boolean veri = false;

    if (qtd == 0) {
      veri = true;
    }
    return veri;
  }

  public void mostrarCad() {

    if (qtd == 0) {
      System.out.println("\nLista vazia");
    } else {
      for (int i = 0; i < 26; i++) {
        System.out.print(cad[i].getLetra() + ": ");
        cad[i].mostrar();
        System.out.print("\n");
      }
    }
  }

  public Aluno[] getAlunosVet() {
    Aluno[] vetAluno = new Aluno[qtd];
    No apont;
    Aluno aux;
    int j = 0;

    for (int i = 0; i < 26; i++) {
      apont = cad[i].getInicio();
      do {
        if (apont != null) {
          aux = (Aluno) apont.getItem();
          vetAluno[j] = new Aluno(aux.getRA(),
              aux.getCurso(),
              aux.getNota(),
              aux.getNome().getNomePessoa(),
              aux.getIdade());
          j++;
          apont = apont.getProximo();
        }
      } while (apont != null);
    }
    return vetAluno;
  }

  @Override
  public void setAlunosVet(Aluno[] aVet) {
    // TODO Auto-generated method stub

  }
}
