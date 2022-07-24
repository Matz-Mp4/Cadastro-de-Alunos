package Painel.Eventos;

import java.awt.*;
import java.awt.event.*;
import Model.Armazenagem.IArmazenagem;
import Model.Essentials.Aluno;
import Model.Essentials.CadastroValidacao;
import Painel.PainelInserir;
import Painel.PainelMensagem;
import GuiEssentials.GuiUtils;

public class InserirEventos {

  private PainelInserir guiInserir;

  public InserirEventos(PainelInserir guiInserir, IArmazenagem cad, PainelMensagem mens) {
    this.guiInserir = guiInserir;
    setEventos(cad, mens);
  }

  private void setEventos(IArmazenagem cad, PainelMensagem mens) {

    guiInserir.getBotaoLimpar().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        guiInserir.getCampoNome().setText("");
        guiInserir.getCampoIdade().setText("");
        guiInserir.getCampoRA().setText("");
        guiInserir.getCampoNota().setText("");
        guiInserir.getCampoCurso().setText("");
      }
    });

    guiInserir.getBotaoConcluir().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inserirDados(cad, mens);
      }

    });
  }

  private void inserirDados(IArmazenagem cad, PainelMensagem mens) {

    try {
      if (cad.estaCheio() == false) {
        int idade = Integer.parseInt(guiInserir.getCampoIdade().getText());
        float nota = Float.parseFloat(guiInserir.getCampoNota().getText());
        String RA = guiInserir.getCampoRA().getText();
        String curso = guiInserir.getCampoCurso().getText();
        String nome = guiInserir.getCampoNome().getText();

        Aluno auxiliar = new Aluno(RA, curso, nota, nome, idade);

        if (CadastroValidacao.checkarDados(auxiliar) == false) {
          GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Dados Invalidos", Color.green, Color.white);
          GuiUtils.setRotuloAviso(mens);
        } else {
          if (cad.inserirCad(auxiliar) == true) {

            GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: ALUNO CADASTRADO", GuiUtils.COR_CERTO, Color.white);
          } else {
            GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: ALUNO JA EXISTE", GuiUtils.COR_LETRA, Color.white);
          }
        }

      } else {

        GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Cadastro Cheio", GuiUtils.COR_LETRA, Color.white);
      }
    } catch (Exception e) {
      GuiUtils.setRotuloMensagem(mens, "Ultimo Aviso: Dados Invalidos", Color.red, Color.white);

    }
  }
}
