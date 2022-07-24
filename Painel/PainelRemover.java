package Painel;

import java.awt.*;
import javax.swing.*;

import GuiEssentials.Botao;
import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.Eventos.RemoverEventos;
import GuiEssentials.CampoTexto;

public class PainelRemover extends JPanel {

  private CampoTexto campoRA;
  private Botao jbtnRemover;

  public PainelRemover(IArmazenagem cad, PainelMensagem mens) {
    inicializar();
    new RemoverEventos(this, cad, mens);

  }

  private void inicializar() {

    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    jbtnRemover = new Botao("REMOVER", Botao.BOTAO_PROFUNDO, GuiUtils.COR_BOTAO);

    campoRA = new CampoTexto(
        "Forneca o nome",
        GuiUtils.COR_FUNDO,
        GuiUtils.COR_LETRA,
        CampoTexto.CAMPO_TEXTO_FUNDO);
    add(campoRA, BorderLayout.CENTER);
    GuiUtils.criarGap(this, 10, 10);
    jbtnRemover.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(jbtnRemover);
    setBackground(GuiUtils.COR_FUNDO);
  }

  public Botao getBotaoRemover() {
    return jbtnRemover;
  }

  public String getEntrada() {
    return campoRA.getText();
  }
}
