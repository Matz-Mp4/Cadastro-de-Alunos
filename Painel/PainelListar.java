package Painel;

import java.awt.*;
import javax.swing.*;

import GuiEssentials.Botao;
import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.Eventos.ListarEventos;

public class PainelListar extends JPanel {

  private Botao jbtnListar;

  public PainelListar(IArmazenagem cad, PainelMensagem mens) {
    inicializar();
    new ListarEventos(this, cad);

  }

  private void inicializar() {
    setBackground(GuiUtils.COR_FUNDO);
    setForeground(GuiUtils.COR_LETRA);
    setLayout(new FlowLayout());
    jbtnListar = new Botao("Listar", Botao.BOTAO_PROFUNDO, GuiUtils.COR_BOTAO);
    GuiUtils.criarGap(this, 20, 20);
    add(jbtnListar);

  }

  public Botao getjbtnListar() {
    return jbtnListar;
  }

}
