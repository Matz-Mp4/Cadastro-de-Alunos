package Model.Armazenagem;

import Model.Essentials.Aluno;

public interface IArmazenagem {
    
  public void esvaziar();

  public int getTamVetor();
  
  public void setAlunosVet(Aluno aVet[]);
  
  public Aluno[] getAlunosVet();

  public int getQtdCad();

  public boolean removerCad(String raAluno);

  public void inicializarCad(); 

  public int buscarPosicaoCad(String raAluno);

  public boolean inserirCad(Aluno a);

  public boolean estaVazio();

  public boolean estaCheio();
}

