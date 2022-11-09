package listaenlazadasimple;

import javax.swing.JOptionPane;

/**
 *
 * @author EMERSON
 */
public class Lista {

    private Nodo inicio;

    public Lista() {
        this.inicio = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar() {
        Vehiculo v = new Vehiculo();
        v.setMarca(JOptionPane.showInputDialog(null, "Ingrese la marca del vehículo"));
        v.setModelo(Integer.parseInt(JOptionPane.showInputDialog("Digite el modelo del vehículo")));

        Nodo nuevo = new Nodo();
        nuevo.setDato(v);

        if (vacia()) {
            inicio = nuevo;
        } else if (v.getModelo() < inicio.getDato().getModelo()) {
            Nodo aux;
            aux = nuevo;
            aux.setSiguiente(inicio);
            inicio = aux;
        } else if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevo);
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null
                    && aux.getSiguiente().getDato().getModelo() < v.getModelo()) {
                aux = aux.getSiguiente();
            }
            Nodo temporal;
            temporal = nuevo;
            temporal.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temporal);
        }

    }

    public void modificar() {
        if (!vacia()) {
            Nodo aux = inicio;
            boolean encontrado = false;
            int buscarNodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la marca del vehiculo a modificar"));
            while (aux != null && encontrado != true) {
                if (aux.getDato().getModelo() == buscarNodo) {
                    JOptionPane.showMessageDialog(null, "El vehiculo buscado: " + aux.getDato().getModelo() + ", si existe");
                    aux.getDato().setMarca((JOptionPane.showInputDialog(null, "Ingrese la nueva marca del vehiculo")));
                    aux.getDato().setModelo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo modelo")));
                    JOptionPane.showMessageDialog(null, "Se han modificado los datos del vehiculo");
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vehiculo no ha sido registrado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }
    }

    public void eliminarNodo() {
        if (!vacia()) {
            int buscarNodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehiculo a borrar"));
            if (inicio.getDato().getModelo() == buscarNodo) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "Elemento extraído");
            } else {
                Nodo anterior;
                Nodo aux;

                anterior = inicio;
                aux = inicio.getSiguiente();

                while ((aux != inicio) && (aux.getDato().getModelo() != buscarNodo)) {
                    anterior = anterior.getSiguiente();
                    aux = aux.getSiguiente();
                }
                if (aux != inicio) {
                    anterior.setSiguiente(aux.getSiguiente());
                    JOptionPane.showMessageDialog(null, "Elemento extraído");
                }

            }
        }
    }

    public void existe() {
        if (!vacia()) {
            Nodo aux = inicio;
            boolean encontrado = false;
            int buscarNodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehiculo a buscar"));
            while (aux != null && encontrado != true) {
                if (aux.getDato().getModelo() == buscarNodo) {
                    JOptionPane.showMessageDialog(null, "El vehiculo buscado: " + aux.getDato().getModelo() + ", si existe");
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vehiculo no ha sido registrado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }

    }

    public void extraer() {
        if (!vacia()) {
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "Elemento extraído");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer, lista vacía");
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            Nodo aux = inicio;
            while (aux != null) {
                s += aux.getDato().getMarca() + " / " + aux.getDato().getModelo() + " -> ";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Los vehiculos actuales son: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }
    }
}
