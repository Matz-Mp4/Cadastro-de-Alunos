package Model.Armazenagem.Array;

import Model.Armazenagem.IArmazenagem;
import Model.Essentials.Aluno;

/* Autor: Mateus Assalti Santana
   Versão: 31/03/2022
*/
public class CadastroArray implements IArmazenagem{

  Aluno alunosVet[];
  // Quantindade de alunos cadastrados
  private int qtdCad;
  private int tamVet;
  // Construtor

  public void esvaziar(){
    qtdCad = 0;
  }

  public int getTamVetor(){
    return tamVet;
  }
  public CadastroArray(int qtd) {
    alunosVet = new Aluno[qtd];
    tamVet = qtd;
    inicializarCad();
  }

  public void setAlunosVet(Aluno aVet[]) {
    alunosVet = aVet;
  }

  public Aluno[] getAlunosVet() {
    return alunosVet;
  }
/* 
  public void setQtdCad(int quant) {
    qtdCad = quant;
  }
*/
  public int getQtdCad() {
    return qtdCad;
  }

  public boolean removerCad(String raAluno) {

    boolean veri = true;
    int posicao = 0;

    
    if (estaVazio() != true && posicao != -1) {
      posicao = buscarPosicaoCad(raAluno);

      for (int i = posicao; i < getQtdCad() - 1; i++) {
        alunosVet[i] = alunosVet[i + 1];
      }

      //setQtdCad(getQtdCad() - 1);
      qtdCad--;
    } else {
      veri = false;
    }

    return veri;
  }

  public void inicializarCad() {
    qtdCad = 0;
    /*for (int i = 0; i < alunosVet.length; i++) {
      alunosVet[i] = null;
    }*/
  }

  public int buscarPosicaoCad(String raAluno) {

    int posicao = 0;

    while (alunosVet[posicao].getRA().equals(raAluno) == false && posicao < getQtdCad()) {
      posicao++;
    }

    if (alunosVet[posicao].getRA().equals(raAluno) == true) {
      return posicao;
    }
    return -1;
  }

  public boolean inserirCad(Aluno a) {

    boolean veri = true;

    if (getQtdCad() < alunosVet.length) {
      int posicao = getQtdCad();

      alunosVet[posicao] = new Aluno(a.getRA(),
          a.getCurso(),
          a.getNota(),
          a.getNome().getNomePessoa(),
          a.getIdade());

      // qtdCad += 1;
      qtdCad++;
      //setQtdCad(getQtdCad() + 1);

    } else {
      veri = false;
    }

    return veri;
  }

  public boolean estaVazio() {

    boolean veri = false;
    if (getQtdCad() == 0) {
      veri = true;
    }

    return veri;
  }

  public boolean estaCheio(){

    boolean veri = false;

    if(qtdCad == alunosVet.length){
      veri = true;
    }

    return veri;
  }

}
