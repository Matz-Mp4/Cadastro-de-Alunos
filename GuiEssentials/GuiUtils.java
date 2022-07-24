package GuiEssentials;

import javax.swing.*;
import javax.swing.border.*;

import Model.Essentials.CadastroValidacao;
import Painel.PainelMensagem;

import java.awt.*;

/**
 * Classe para definir constantes e
 * pre difinições para as demais janelas
 */
public class GuiUtils {

  public static final String AVISO_INCIAL = "  Aviso: nenhum erro ate o momento  ";
  public static final String NOME_FONTE = "Fantasque Sans Mono";

  public static final Color COR_LETRA = new Color(248, 148, 6);
  public static final Color COR_CERTO = new Color(1, 50, 32);

  public static final Color COR_FUNDO = new Color(8, 14, 44);
  public static final Color COR_BOTAO = new Color(207, 0, 15);

  public static void criarGap(JPanel painel, int height, int width) {

    painel.add(Box.createRigidArea(new Dimension(height, width)));
  }

  public static void setRotuloAviso(PainelMensagem mensagem) {
    mensagem.getRotuloMens().setText(AVISO_INCIAL);
    mensagem.getRotuloMens().setForeground(Color.white);
    mensagem.setBackground(COR_LETRA);
    mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
  }

  public static void setRotuloMensagem(PainelMensagem rtlMens, String mens, Color fundo, Color letra) {

    rtlMens.getRotuloMens().setText(mens);
    rtlMens.getRotuloMens().setForeground(letra);
    rtlMens.setBackground(fundo);
    rtlMens.getRotuloMens().setAlignmentX(Component.CENTER_ALIGNMENT);

  }

  public static String getNomeFonte() {

    return NOME_FONTE;
  }

  public static void setBorda(JPanel jpnl, String nome) {

    Border linhaCor = BorderFactory.createLineBorder(GuiUtils.COR_LETRA);
    TitledBorder titulo = new TitledBorder(linhaCor, nome);
    titulo.setTitleFont(new Font(GuiUtils.NOME_FONTE, Font.BOLD | Font.ITALIC, 15));
    titulo.setTitleColor(GuiUtils.COR_LETRA);
    titulo.setTitleJustification(TitledBorder.CENTER);
    jpnl.setBorder(titulo);

  }

  public static int entrarQuantCad() {
    String temp;
    int quant = 0;
    do {
      temp = JOptionPane.showInputDialog("Forneca a quantidade valida de alunos: ");

      // Apenas adiciona se a string tiver numero para evitar erro de execessao
      if (CadastroValidacao.verificarApenasNumero(temp)) {
        quant = Integer.parseInt(temp);
      }
    } while (quant <= 0);

    return quant;
  }
}
