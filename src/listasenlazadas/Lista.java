package listasenlazadas;
public class Lista implements ILista {
    private NodoLista inicio; 
    private NodoLista fin;

    //Constructor
    public void Lista(){
        this.inicio=null;
        this.fin=null;
    }

    //Inicio
  


    /*****Métodos Básicos*****/

    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
      }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(int n){
        NodoLista nuevo= new NodoLista(n);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(int n){
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia())
            this.agregarInicio(n);
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig() != null)
                aux=aux.getSig();
            NodoLista nuevo= new NodoLista(n);
            aux.setSig(nuevo);
            this.fin=nuevo;
        }
    }

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }
    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin(){
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();
            else{
                NodoLista aux = this.inicio;
                while (aux.getSig().getSig() != null)
                    aux=aux.getSig();
                this.fin=aux;
                this.fin.setSig(null);
            }
        }
    }

 //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio!=null)
            borrarInicio();
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar(){
        if (this.esVacia())
            System.out.println("Lista es vacía");
        else  {
            NodoLista aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getDato());
                aux=aux.getSig();
            }
        }
    }


/*****Otros Métodos (iterativos)*****/

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(int n){
        //lista vacía o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || this.inicio.getDato()>=n){
            this.agregarInicio(n);
            return;
        }
        //último elemento es menor o igual => agrego al final
        if (this.fin.getDato()<=n){
            this.agregarFinal(n);
            return;
        }
        NodoLista aux=this.inicio;
        while (aux.getSig()!=null && aux.getSig().getDato() < n)
            aux=aux.getSig();
        NodoLista nuevo=new NodoLista(n);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(int n){
        if (this.esVacia())
            return;
        if (this.inicio.getDato()==n)
            this.borrarInicio();
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig()!=null && aux.getSig().getDato() != n)
                aux=aux.getSig();
            //lo encontré o llegué al final de la lista
            if (aux.getSig()!=null){
                NodoLista borrar=aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
            }
        }
    }
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos(){
        int cont=0;
        if (!this.esVacia()){
            NodoLista aux=this.inicio;
            while (aux!=null){
                 aux=aux.getSig();
                 cont ++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLista obtenerElemento(int n){
        NodoLista aux=this.inicio;
        while (aux!=null && aux.getDato()!=n)
            aux=aux.getSig();
        //encontré dato o llegué al final
        return aux;
    }

    
    /*****  Métodos RECURSIVOS  *****/

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista l){
        if(l!=null){
            System.out.println(l.getDato());
            mostrarREC(l.getSig());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista l){
        if (l!=null){   
            mostrarInversoREC(l.getSig());
            System.out.println(l.getDato());
        }
    }

    
    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoLista l, int n){
        if (l != null){
            if (l.getDato()==n)
                return true;
            else
                return existeDatoREC(l.getSig(),n);
        }
        else
             return false;
    }


}