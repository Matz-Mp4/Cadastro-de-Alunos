package Painel;

import java.awt.*;
import javax.swing.*;

import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Model.Essentials.Aluno;

public class JanelaTabela extends JFrame {

  private final String[] COL_CABECALHO = {
    "Nome",
    "Idade",
    "RA",
    "Curso",
    "Nota",
  };
  private JTextField[][] tabela;
  JPanel pnlTabela;
  JScrollPane scrollTabela;

  public JanelaTabela(IArmazenagem cad) {
    inicializar(cad);
  }

  private void inicializar(IArmazenagem cad) {
    add(getScrollTabela(cad));
    setBackground(GuiUtils.COR_FUNDO);
    setBackground(GuiUtils.COR_FUNDO);
    setTabela(cad);
    setVisible(true);
    // setSize(400, 500);
    // setResizable(false);
    pack();
  }

  public JPanel getPainelTabela(IArmazenagem cad) {
    if (pnlTabela == null) {
      pnlTabela = new JPanel();
      pnlTabela.setLayout(new GridLayout(cad.getTamVetor() + 2, 5, 1, 1));
      // pnlTabela.setLayout(new GridLayout(5, 5, 1, 1));

      pnlTabela.setBackground(GuiUtils.COR_FUNDO);
      pnlTabela.setForeground(GuiUtils.COR_FUNDO);
      pnlTabela.setBorder(BorderFactory.createEmptyBorder());

    }

    return pnlTabela;
  }

  public JScrollPane getScrollTabela(IArmazenagem cad) {
    if (scrollTabela == null) {

      scrollTabela = new JScrollPane(getPainelTabela(cad),
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

      scrollTabela.setBorder(BorderFactory.createEmptyBorder());
      scrollTabela.getVerticalScrollBar().setUnitIncrement(6);
    }
    return scrollTabela;
  }

  public void atualizarTabela(IArmazenagem cad) {

    String[] aux = new String[5];
    Aluno[] tempAluno = cad.getAlunosVet();
    for (int i = 0; i < cad.getQtdCad(); i++) {
      aux[0] = tempAluno[i].getNome().getNomePessoa();
      aux[1] = String.valueOf(tempAluno[i].getIdade());
      aux[2] = tempAluno[i].getRA();
      aux[3] = tempAluno[i].getCurso();
      aux[4] = String.valueOf(tempAluno[i].getNota());

      for (int j = 0; j < 5; j++) {
        setTabelaQuadrado(i + 1, j, aux[j]);

      }
    }

    /*
     * for(int i = cad.getQtdCad()+1; i < cad.getTamVetor(); i++){
     * for(int j = 0; j < 5; j++){
     * setTabelaQuadrado(i, j, " ");
     * }
     * }
     */
  }

  private void setTabela(IArmazenagem cad) {
    // quant de quadrados + cabeçalho
    tabela = new JTextField[cad.getTamVetor() + 1][5];
    // Adicionado uma uma linha como rodapeU
    for (int i = 0; i < COL_CABECALHO.length; i++) {
      tabela[0][i] = new JTextField(COL_CABECALHO[i]);
      tabela[0][i].setBackground(GuiUtils.COR_LETRA);
      tabela[0][i].setForeground(GuiUtils.COR_FUNDO);
      tabela[0][i].setFont(new Font(GuiUtils.NOME_FONTE, Font.BOLD | Font.ITALIC, 14));
      tabela[0][i].setEditable(false);
      pnlTabela.add(tabela[0][i]);
    }

    atualizarTabela(cad);
    /*
     * 
     * for(int i = 1; i < cad.getTamVetor(); i ++){
     * for(int j = 0; j < 5; j++){
     * setTabelaQuadrado(i, j, " ");
     * add(tabela[i][j]);
     * }
     * }
     */
  }

  private void setTabelaQuadrado(int indice1, int indice2, String texto) {

    if (tabela[indice1][indice2] == null) {
      tabela[indice1][indice2] = new JTextField();
      tabela[indice1][indice2].setText(texto);
      tabela[indice1][indice2].setBorder(BorderFactory.createEmptyBorder());
      tabela[indice1][indice2].setBackground(GuiUtils.COR_FUNDO);
      tabela[indice1][indice2].setForeground(GuiUtils.COR_LETRA);
      tabela[indice1][indice2].setFont(new Font(GuiUtils.NOME_FONTE, Font.BOLD, 14));
      tabela[indice1][indice2].setEditable(false);
    } else {
      tabela[indice1][indice2].setText(texto);
    }
    pnlTabela.add(tabela[indice1][indice2]);

    System.out.println(texto);
  }
}
