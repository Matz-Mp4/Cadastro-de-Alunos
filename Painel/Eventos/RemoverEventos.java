package Painel.Eventos;

import java.awt.event.*;
import java.awt.*;

import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.PainelMensagem;
import Painel.PainelRemover;

public class RemoverEventos {

  private PainelRemover guiRemover;

  public RemoverEventos(PainelRemover guiRemover, IArmazenagem cad, PainelMensagem mens) {
    this.guiRemover = guiRemover;
    setEventos(cad, mens);
  }

  private void setEventos(IArmazenagem cad, PainelMensagem mens) {
    guiRemover.getBotaoRemover().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          if (cad.estaVazio() == false) {
            String temp = guiRemover.getEntrada();
            if (cad.removerCad(temp) == true) {
              GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Aluno Removido", GuiUtils.COR_CERTO, Color.white);
            } else {
              GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Aluno nao foi encontrado", Color.red, Color.white);
            }
          } else {
            GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Cadastro Vazio", GuiUtils.COR_LETRA, Color.white);
          }
        } catch (Exception ae) {
          GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Dados Invalidos", Color.red, Color.white);
        }
      }

    });
  }
}
