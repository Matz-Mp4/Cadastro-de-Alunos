package Painel.Eventos;

import java.awt.event.*;

import Model.Armazenagem.IArmazenagem;
import Painel.PainelListar;
import Painel.JanelaTabela;

public class ListarEventos {

  public ListarEventos(PainelListar pnlLista, IArmazenagem cad) {
    setEventos(pnlLista, cad);
  }

  private void setEventos(PainelListar pnlLista, IArmazenagem cad) {

    pnlLista.getjbtnListar().addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (cad.estaVazio() == false) {
          new JanelaTabela(cad);

        }
      }

    });
  }

}
