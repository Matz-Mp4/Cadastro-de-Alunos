import java.awt.*;
import javax.swing.*;

import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.*;

public class CadastroJanela extends JFrame {

  private PainelInserir pnlInserir;
  private PainelMensagem pnlMensagem;
  private PainelArquivo pnlArquivo;
  private PainelRemover pnlRemover;
  private JPanel pnlEntrada;
  private PainelListar pnlListar;
  private JScrollPane scrollListar;

  public CadastroJanela(IArmazenagem cad) {

    inicializar(cad);
  }

  private void inicializar(IArmazenagem cad) {
    setTitle("Cadastro");
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(30, 20));
    add(getPainelMensagem(), BorderLayout.PAGE_END);
    add(getPainelInserir(cad), BorderLayout.CENTER);
    add(getPainelEntrada(cad), BorderLayout.LINE_START);
    // add(getPainelListar(cad), BorderLayout.CENTER);

    GuiUtils.setBorda(pnlInserir, "INSERIR");
    GuiUtils.setBorda(pnlRemover, "REMOVER");
    GuiUtils.setBorda(pnlArquivo, "ARQUIVO");
    GuiUtils.setBorda(pnlListar, "Lista de Alunos");
    getContentPane().setBackground(GuiUtils.COR_FUNDO);
    setVisible(true);
    pack();
    // setSize(700, 600);
  }

  public JPanel getPainelRemover(IArmazenagem cad) {
    if (pnlRemover == null) {
      pnlRemover = new PainelRemover(cad, pnlMensagem);
    }

    return pnlRemover;
  }

  public JPanel getPainelInserir(IArmazenagem cad) {
    if (pnlInserir == null) {
      pnlInserir = new PainelInserir(cad, pnlMensagem);
    }

    return pnlInserir;
  }

  public JPanel getPainelArquivo(IArmazenagem cad) {
    if (pnlArquivo == null) {
      pnlArquivo = new PainelArquivo(cad, pnlMensagem);
    }

    return pnlArquivo;
  }

  public JPanel getPainelEntrada(IArmazenagem cad) {
    if (pnlEntrada == null) {
      pnlEntrada = new JPanel();
      pnlEntrada.setLayout(new BoxLayout(pnlEntrada, BoxLayout.PAGE_AXIS));
      pnlEntrada.add(getPainelRemover(cad));
      pnlEntrada.add(getPainelArquivo(cad));
      pnlEntrada.add(getPainelListar(cad));
    }
    return pnlEntrada;
  }

  public PainelListar getPainelListar(IArmazenagem cad) {

    if (pnlListar == null) {
      pnlListar = new PainelListar(cad, pnlMensagem);
      // scrollListar= new JScrollPane(pnlListar,
      // JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      // JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      // scrollListar.setBorder(BorderFactory.createEmptyBorder());
      // scrollListar.getVerticalScrollBar().setUnitIncrement(6);
    }
    return pnlListar;
  }

  public JPanel getPainelMensagem() {
    if (pnlMensagem == null) {
      pnlMensagem = new PainelMensagem();
    }

    return pnlMensagem;
  }
}
