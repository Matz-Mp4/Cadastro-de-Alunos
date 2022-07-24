package GuiEssentials;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;



public class CampoTexto extends JTextField{

    public static final int CAMPO_TEXTO_FUNDO = 1;
    public static final int CAMPO_TEXTO_RASO = 2;


    public CampoTexto(String nome, Color corFundo, Color corLetra, int modelo){
        //super(nome);
        setBackground(corFundo);
        setForeground(corLetra);
        setCampoTexto(modelo, nome, corLetra);
    }
   
    private void setCampoTexto(int modelo, String nome, Color corTitulo){

        if(CAMPO_TEXTO_FUNDO == modelo){

            setCampoTextoProfundo(nome, corTitulo);
        }else{
            setCampoTextoRaso(nome, corTitulo);
        }
    }

    void setCampoTextoProfundo(String nome, Color corTitulo){

        Border nivelAbaixo = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        TitledBorder titulo;
        titulo = BorderFactory.createTitledBorder(nivelAbaixo,nome);

        titulo.setTitleJustification(TitledBorder.ABOVE_TOP);
        titulo.setTitleColor(corTitulo);
        //setBackground(corBackground);
        //setForeground(corLetra);
    
        setBorder(titulo);
    }
    
    void setCampoTextoRaso(String nome, Color corTitulo){

        Border linhaCor = BorderFactory.createLineBorder(corTitulo);

        TitledBorder titulo = BorderFactory.createTitledBorder(linhaCor, nome);

        //setBackground(corBackground);
        //setForeground(corLetra);

        setBorder(titulo);
    }

}
