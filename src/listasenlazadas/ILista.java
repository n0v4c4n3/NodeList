package listasenlazadas;
/**
 *
 * @author RC
 */
public interface ILista {
    //POS: Constructor, crea una lista vacía
     void Lista();
    //POS: Retorna true si la lista no tiene nodos
    boolean esVacia();
    //POS: Inserta un nodo al principio de la lista
    void agregarInicio(int n);
    //POS: Inserta un nodo al final de la lista
    void agregarFinal(int n);
    //POS: Borra el primer nodo
    void borrarInicio();
    //POS: Borra el último nodo
    void borrarFin();
    //POS: Muestra los datos de la lista
    void mostrar();
    //POS: Elimina todos los nodos de la lista
    void vaciar();
}