package GuiEssentials;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Botao extends JButton {

  public static final int BOTAO_PROFUNDO = 1;
  public static final int BOTAO_RASO = 2;

  public Botao(String nome, int modelo, Color cor) {
    super(nome);
    setBotao(modelo, cor);
  }

  public int getBotaoProfundo() {

    return BOTAO_PROFUNDO;
  }

  public int getBotaoRaso() {

    return BOTAO_RASO;
  }

  void setBotao(int modelo, Color cor) {

    if (BOTAO_PROFUNDO == modelo) {

      setBotaoProfundo(cor);
    } else {
      setBotaoRaso(cor);
    }
  }

  void setBotaoProfundo(Color cor) {

    Border estiloBotao;
    Border nivelAcima = BorderFactory.createRaisedBevelBorder();
    Border nivelAbaixo = BorderFactory.createLoweredBevelBorder();

    setBackground(cor);
    setForeground(Color.white);

    estiloBotao = BorderFactory.createCompoundBorder(nivelAcima, nivelAbaixo);
    setBorder(estiloBotao);

  }

  void setBotaoRaso(Color cor) {

    Border nivelAcima = BorderFactory.createRaisedBevelBorder();

    setBackground(cor);
    setForeground(Color.white);

    setBorder(nivelAcima);
  }

  public Botao getBota() {

    return this;
  }
}
