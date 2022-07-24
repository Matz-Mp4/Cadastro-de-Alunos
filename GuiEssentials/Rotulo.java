package GuiEssentials;
import javax.swing.JLabel;
import java.awt.*;


public class Rotulo extends JLabel{
    
    public Rotulo(String nome, String fonte) {

        super(nome);
        setFont(new Font(fonte, Font.BOLD, 15));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setCor(GuiUtils.COR_FUNDO, Color.white);

    }

    public  void setCor(Color corFundo, Color corLetra){

        setBackground(corFundo);
        setForeground(corLetra);
    }    
}
