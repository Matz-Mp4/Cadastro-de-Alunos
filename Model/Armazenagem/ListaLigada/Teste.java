package Model.Armazenagem.ListaLigada;

import Model.Essentials.Aluno;

public class Teste {
  public static void main(String[] args) {
    Aluno aluno1 = new Aluno("ra00", "CC", 10, "Mateus", 20);
    Aluno aluno2 = new Aluno("ra00", "CC", 10, "Mateus", 20);
    Aluno aluno3 = new Aluno("ra00", "CC", 10, "Mateus", 20);

    CadastroMultiLista cad = new CadastroMultiLista();
    cad.inserirCad(aluno1);
    cad.inserirCad(aluno2);
    cad.inserirCad(aluno3);
    cad.removerCad("Mateus");
    cad.removerCad("Mateus");
    // cad.mostrarCad();

    Aluno[] a = cad.getAlunosVet();

    for (int i = 0; i < cad.getQtd(); i++) {
      System.out.println(a[i].toString());
    }
  }
}
