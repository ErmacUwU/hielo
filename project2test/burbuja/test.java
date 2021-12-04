package burbuja;

public class test {
    public static void main(String[] args) {
        ListaGenerica num = new ListaGenerica();

        num.insertarAlInicio(6);
        num.insertarAlInicio(9);
        num.insertarAlInicio(7);
        num.insertarAlInicio(10);
        num.insertarAlInicio(5);
        num.insertarAlInicio(1);
        num.insertarAlInicio(3);
        num.insertarAlInicio(2);
        num.insertarAlInicio(8);
        num.insertarAlInicio(4);

        
        num.burbuja();

    }
    
}


