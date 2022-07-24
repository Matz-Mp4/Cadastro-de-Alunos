package Painel;

import java.awt.*;
import javax.swing.*;
import GuiEssentials.*;
import Model.Armazenagem.IArmazenagem;
import Painel.Eventos.InserirEventos;

public class PainelInserir extends JPanel {

  private JPanel form;

  private JPanel painelBotoes;
  private Botao jbtnLimpar;
  private Botao jbtnConcluir;

  private CampoTexto campoNome;
  private CampoTexto campoIdade;
  private CampoTexto campoCurso;
  private CampoTexto campoRA;
  private CampoTexto campoNota;

  public PainelInserir(IArmazenagem cad, PainelMensagem mens) {
    inicializar();
    new InserirEventos(this, cad, mens);
  }

  /**
   * Defini os eventos do botao de limpar e de concluir
   */
  private void inicializar() {
    setLayout(new BorderLayout());
    add(getForm(), BorderLayout.CENTER);
    add(getPainelBotoes(), BorderLayout.PAGE_END);
    setVisible(true);
    setBackground(GuiUtils.COR_FUNDO);
  }

  public JPanel getPainelBotoes() {

    if (painelBotoes == null) {
      painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      painelBotoes.setBackground(GuiUtils.COR_FUNDO);
      jbtnLimpar = new Botao("LIMPAR", Botao.BOTAO_PROFUNDO, GuiUtils.COR_BOTAO);
      jbtnConcluir = new Botao("INSERIR", Botao.BOTAO_PROFUNDO, Color.red);
      painelBotoes.add(jbtnConcluir);
      GuiUtils.criarGap(painelBotoes, 20, 20);
      painelBotoes.add(jbtnLimpar);
    }
    return painelBotoes;
  }

  public JPanel getForm() {
    if (form == null) {
      form = new JPanel();
      form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
      form.setBackground(GuiUtils.COR_FUNDO);

      campoNome = new CampoTexto(
          "Nome",
          GuiUtils.COR_FUNDO,
          GuiUtils.COR_LETRA,
          CampoTexto.CAMPO_TEXTO_FUNDO);
      campoIdade = new CampoTexto(
          "Idade",
          GuiUtils.COR_FUNDO,
          GuiUtils.COR_LETRA,
          CampoTexto.CAMPO_TEXTO_FUNDO);
      campoRA = new CampoTexto(
          "RA",
          GuiUtils.COR_FUNDO,
          GuiUtils.COR_LETRA,
          CampoTexto.CAMPO_TEXTO_FUNDO);
      campoNota = new CampoTexto(
          "Nota",
          GuiUtils.COR_FUNDO,
          GuiUtils.COR_LETRA,
          CampoTexto.CAMPO_TEXTO_FUNDO);
      campoCurso = new CampoTexto(
          "Curso",
          GuiUtils.COR_FUNDO,
          GuiUtils.COR_LETRA,
          CampoTexto.CAMPO_TEXTO_FUNDO);

      GuiUtils.criarGap(form, 19, 10);
      form.add(campoNome);
      form.add(campoIdade);
      form.add(campoCurso);
      form.add(campoRA);
      form.add(campoNota);
      GuiUtils.criarGap(form, 19, 10);
    }

    return form;
  }

  public CampoTexto getCampoNome() {
    return campoNome;
  }

  public CampoTexto getCampoIdade() {
    return campoIdade;
  }

  public CampoTexto getCampoNota() {
    return campoNota;
  }

  public CampoTexto getCampoRA() {
    return campoRA;
  }

  public CampoTexto getCampoCurso() {
    return campoCurso;
  }

  public Botao getBotaoLimpar() {
    return jbtnLimpar;
  }

  public Botao getBotaoConcluir() {
    return jbtnConcluir;
  }

}
