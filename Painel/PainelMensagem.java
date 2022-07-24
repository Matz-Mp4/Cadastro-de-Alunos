package Painel;

import java.awt.*;
import javax.swing.*;

import GuiEssentials.GuiUtils;
import GuiEssentials.Rotulo;

public class PainelMensagem extends JPanel {

  private Rotulo mensagem;

  public PainelMensagem() {
    setLayout(new FlowLayout());
    inicializar();
  }

  public void inicializar() {
    String fonte = GuiUtils.NOME_FONTE;
    String aviso = GuiUtils.AVISO_INCIAL;
    mensagem = new Rotulo(aviso, fonte);
    setBackground(GuiUtils.COR_LETRA);
    add(mensagem);
  }

  public void setMensagem(String mens, Color corFundo, Color corLetra) {
    mensagem.setBackground(corFundo);
    mensagem.setForeground(corLetra);
    mensagem.setText(mens);
  }

  public Rotulo getRotuloMens() {
    return mensagem;
  }

}
