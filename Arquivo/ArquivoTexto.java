package Arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.BufferedReader;

import Model.Armazenagem.IArmazenagem;
import Model.Essentials.Aluno;

public class ArquivoTexto implements InterArquivo {
  // Nome da pasta onde vai ser salvo
  private final String LOCAL = "Save/";
  // Caracter que separa os dados
  private final char SEPARADOR = '|';

  public boolean gravar(IArmazenagem cad, String nome) {
    boolean veri = true;
    String nomeArq = LOCAL + nome;
    File arq = new File(nomeArq);
    Aluno[] temp;
    // Escreve no arquivo
    PrintWriter pw = null;
    FileOutputStream fos = null;

    try {
      fos = new FileOutputStream(arq);
      pw = new PrintWriter(fos);
    } catch (Exception ae) {
      veri = false;
    }
    try {
      if (veri == true) {
        temp = cad.getAlunosVet();
        String nomeP, curso, idade, ra, nota;
        for (int i = 0; i < cad.getQtdCad(); i++) {
          nomeP = temp[i].getNome().getNomePessoa();
          idade = String.valueOf(temp[i].getIdade());
          curso = temp[i].getCurso();
          ra = temp[i].getRA();
          nota = String.valueOf(temp[i].getNota());

          pw.print(ra);
          pw.print(SEPARADOR);
          pw.print(curso);
          pw.print(SEPARADOR);
          pw.print(nota);
          pw.print(SEPARADOR);
          pw.print(nomeP);
          pw.print(SEPARADOR);
          pw.print(idade);
          pw.println(SEPARADOR);
        }
      }
    } catch (Exception e) {
      veri = false;
    } finally {
      try {
        pw.close();
      } catch (Exception o) {
        veri = false;
      }
      try {
        fos.close();
      } catch (Exception i) {
        veri = false;
      }
    }
    return veri;
  }

  public boolean ler(File arq, IArmazenagem cad) {
    boolean veri = true;
    BufferedReader br = null;
    FileReader fr = null;

    try {
      fr = new FileReader(arq);
      br = new BufferedReader(fr);
    } catch (Exception e) {
      veri = false;
    }

    try {
      if (arq.exists() == true) {
        String line = br.readLine();
        String nomeP = "";
        String ra = "";
        String curso = "";
        int idade = 0;
        float nota = 0;
        cad.esvaziar();
        while (line != null) {
          String separadores = "\n" + SEPARADOR;
          // Verificar os campos de dados
          StringTokenizer st = new StringTokenizer(line, separadores);

          if (st.hasMoreTokens()) {
            ra = st.nextToken();
          }
          if (st.hasMoreTokens()) {
            curso = st.nextToken();
          }

          if (st.hasMoreTokens()) {
            String notaS = st.nextToken();
            nota = Float.parseFloat(notaS);
          }
          if (st.hasMoreTokens()) {
            nomeP = st.nextToken();
          }
          if (st.hasMoreTokens()) {
            String idadeS = st.nextToken();
            idade = Integer.parseInt(idadeS);
          }
          Aluno temp = new Aluno(ra, curso, nota, nomeP, idade);
          cad.inserirCad(temp);

          line = br.readLine();
        }
      } else {
        veri = false;
      }
    } catch (Exception e) {
      System.out.print(e.getMessage());
      veri = false;
    } finally {
      try {
        br.close();
        fr.close();
      } catch (Exception e) {
        veri = false;
      }
    }
    return veri;
  }
}
