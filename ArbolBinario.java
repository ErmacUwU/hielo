package arbolbinario;

import java.util.ArrayList;

public class ArbolBinario { 
    protected Nodo raiz; 

    public ArbolBinario() { 
        raiz = null; 
    } 

    public ArbolBinario(Nodo raiz) { 
        this.raiz = raiz; 
    } 

    public Nodo raizArbol() { 
        return raiz; 
    } 

    boolean esVacio() { 
        return raiz == null; 
    } 

    public static Nodo nuevoArbol(Nodo ramaIzdo, Object valor, Nodo ramaDcho) { 
        return new Nodo(ramaIzdo, valor, ramaDcho);
    }

    ArrayList<Integer> ArbolOrdenado = new ArrayList<Integer>();

    public void agregar (Object nuevo){
        Nodo nodo = new Nodo(nuevo);
        if(esVacio()){
            this.raiz = nodo;
            return;
        }
        Nodo aux = this.raiz;
        Nodo padre;
        while(true){
            padre = aux;
            int valor1 =(int)nuevo, valor2 =(int)aux.valorNodo();
            if(valor1<valor2){
                aux = aux.subarbolIzdo();
                if(aux == null){
                    padre.ramaIzdo(nodo);
                    return;
                }
            }
            else{
                aux = aux.subarbolDecho();
                if(aux == null){
                    padre.ramaDcho(nodo);
                    return;
                }
            }
            if(valor1==valor2){
                System.out.println("Ese valor ya esta en el arbol");
                return;
            }
        }


    }

    public void inOrden(){
        ArbolOrdenado.clear();
        this.inOrden(this.raiz);
    }
    public void inOrden(Nodo nodo){
        if (nodo == null){
            return;
        }
       
        inOrden(nodo.subarbolIzdo());
        int aux = (int)nodo.valorNodo();
        ArbolOrdenado.add(aux);
        inOrden(nodo.subarbolDecho());
    }

    public void postOrden(){
        ArbolOrdenado.clear();
        this.postOrden(this.raiz);
    }

    public void postOrden(Nodo nodo){
        if (nodo == null){
            return;
        }
        postOrden(nodo.subarbolIzdo());
        postOrden(nodo.subarbolDecho());
        int aux = (int)nodo.valorNodo();
        ArbolOrdenado.add(aux);
    }

    public void preOrden(){
        ArbolOrdenado.clear();
        this.preOrden(this.raiz);
    }

    public void preOrden(Nodo nodo){
        if (nodo == null){
            return;
        }
        int aux = (int)nodo.valorNodo();
        ArbolOrdenado.add(aux);
        inOrden(nodo.subarbolIzdo());
        inOrden(nodo.subarbolDecho());
    }

    public void testimprimir(){
        System.out.println(ArbolOrdenado);
    }

    public boolean buscar(Object buscado){
        return this.buscar(this.raiz, buscado);
    }

    public boolean buscar(Nodo guia, Object buscado){
        if(guia.subarbolIzdo()!=null && buscar(guia.subarbolIzdo(), buscado)){
            return true;
        }

        if(guia.valorNodo().equals(buscado)){
            return true;
        }

        if(guia.subarbolDecho()!=null && buscar(guia.subarbolDecho(), buscado)){
            return true;
        }

        return false;
    }

} 
