package listaenlazadasimple;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author EMERSON
 */
public class Menu {

    int op = 0;
    Lista lista = new Lista();

    public void mostrarMenu() {
        while (op != 7) {
            try{
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n"
                    + "1. Agregar nodo\n"
                    + "2. Extrae nodo\n"
                    + "3. Eliminar nodo especifico\n"
                    + "4. Modificar Nodo\n"
                    + "5. Existencia del Nodo\n"
                    + "6. Mostrar nodo\n"
                    + "7. Salir\n", "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            }catch(HeadlessException | NumberFormatException e){
                e.getMessage();
            }
            switch (op) {
                case 1:
                    lista.agregar();
                    break;
                case 2:
                    lista.extraer();
                    break;
                case 3:
                    lista.eliminarNodo();
                    break;
                case 4:
                    lista.modificar();
                    break;
                case 5:
                    lista.existe();
                    break;
                case 6:
                    lista.mostrar();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error, opción invalida");
            }

        }
    }
}
