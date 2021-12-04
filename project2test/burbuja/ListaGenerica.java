package burbuja;


public class ListaGenerica {

    private NodoLista primero;
    private NodoLista ultimo;

    public ListaGenerica() {
        this.primero = null;
        this.ultimo = null;
    }


    public ListaGenerica insertarAlInicio(Object obj) {
        NodoLista nodo = new NodoLista(obj);
        nodo.setEnlace(this.primero);
        this.primero = nodo;
        return this;
    }

    public void insertarEntre(Object anterior, Object obj) {
        NodoLista nuevo = new NodoLista(obj);
        NodoLista nodo = buscarNodoAnterior(anterior);

        nuevo.setEnlace(nodo.getEnlace());
        nodo.setEnlace(nuevo);
    }

    private NodoLista buscarNodoAnterior(Object anterior){
        NodoLista target = this.primero;

            while ( target.getEnlace() != null ){
                if(anterior.equals(target.getEnlace().getData())){
                    return target;
                }
                target = target.getEnlace();
        }
        return null;
    }
    public Object eliminar (Object entrada){
        NodoLista actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;

        while ((actual != null) && (!encontrado)){
            encontrado = (actual.getData() == entrada);
            if (!encontrado){
                anterior = actual;
                actual = actual.getEnlace();
            }
        }
        if(actual != null){
            if (actual == primero){
                this.primero = actual.getEnlace();
            }
            else{
                anterior.setEnlace(actual.getEnlace());
            }
        }
        return actual.getData();
    }

    public boolean esVacia() {
        return (this.primero == null & this.ultimo==null);
    }

    public void imprimirLista(){
        NodoLista copiaLista = primero;
        while(copiaLista != null){
            System.out.println(copiaLista.getData());
            copiaLista = copiaLista.getEnlace();
        }
    }

    private NodoLista buscarNodoSiguiente(Object buscar){
        NodoLista target = this.primero;

            while ( target.getEnlace() != null ){
                if(buscar.equals(target)){
                    return target.getEnlace();
                }
                target = target.getEnlace();
        }
        return null;
    }

    public void burbuja(){
        NodoLista i=this.primero, j, siguiente;

        imprimir();

        while(i.getEnlace() != null){
            j=this.primero;
            while(j.getEnlace() != null){
                siguiente = buscarNodoSiguiente(j);
                int aux1 = (int)j.getData();
                int aux2 = (int)siguiente.getData();
                if (aux1>aux2){
                    Object aux = siguiente.getData();
                    siguiente.setData(j.getData());
                    j.setData(aux);
                }
                j = j.getEnlace();
            }
            i = i.getEnlace();
        }
        System.out.println("\n");
        imprimir();
    }

    public void imprimir(){
        NodoLista k=this.primero;
        while(k != null){
            System.out.print(k.getData()+" - ");
            k = k.getEnlace();
        }
    }

}
