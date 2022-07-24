package Painel;

import javax.swing.*;
import java.awt.*;

import GuiEssentials.Botao;
import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.Eventos.ArquivoEventos;

public class PainelArquivo extends JPanel {
  private Botao jbtnLer;
  private Botao jbtnGravar;

  public PainelArquivo(IArmazenagem cad, PainelMensagem mens) {
    inicializar();
    new ArquivoEventos(cad, this, mens);
  }

  private void inicializar() {
    setBackground(GuiUtils.COR_FUNDO);
    setForeground(GuiUtils.COR_LETRA);
    setLayout(new FlowLayout());
    jbtnGravar = new Botao("GRAVAR", Botao.BOTAO_PROFUNDO, GuiUtils.COR_BOTAO);
    jbtnLer = new Botao("LER", Botao.BOTAO_PROFUNDO, GuiUtils.COR_BOTAO);
    add(jbtnLer);
    GuiUtils.criarGap(this, 20, 20);
    add(jbtnGravar);

  }

  public Botao getJbtnLer() {
    return jbtnLer;
  }

  public Botao getJbtnGravar() {
    return jbtnGravar;
  }

}
