package burbuja;

public class NodoLista {
    private Object data;
    private NodoLista enlace;

    public NodoLista(Object data) {
        this.data = data;
        this.enlace = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodoLista getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoLista enlace) {
        this.enlace = enlace;
    }
}
