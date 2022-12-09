package rojinegros;

/*import lombok.Getter;
import lombok.Setter;*/

import java.util.LinkedList;
import java.util.Queue;

public class ArbolRojinegro {
    /*
     * @Getter No me funcionó :'v (o no lo sé usar)
     *
     * @Setter private ArbolRojinegro izq;
     *
     * @Getter
     *
     * @Setter private ArbolRojinegro der;
     *
     * @Getter
     *
     * @Setter private int valor;
     *
     * @Getter
     *
     * @Setter private boolean black; //Si es negro True, en otro caso rojo
     */

    private ArbolRojinegro izq;
    private ArbolRojinegro der;
    private ArbolRojinegro father;
    private int valor;
    private boolean black; // Si es negro True, en otro caso rojo

    public ArbolRojinegro(ArbolRojinegro izq, ArbolRojinegro der,
int valor, boolean black) { // <-- (Me estoy enfermando de ver esta línea así)
        this.izq = izq;
        this.der = der;
        this.valor = valor;
        this.black = black;
    }

    public ArbolRojinegro() {
        this.izq = null;
        this.der = null;
        this.black = true;
    }

    /**************** Getters y Setters ****************/
    public ArbolRojinegro getIzq() {
        return izq;
    }

    public void setIzq(ArbolRojinegro izq) {
        this.izq = izq;
    }

    public ArbolRojinegro getDer() {
        return der;
    }

    public void setDer(ArbolRojinegro der) {
        this.der = der;
    }

    public ArbolRojinegro getFather() {
        return father;
    }

    public void setFather(ArbolRojinegro father) {
        this.father = father;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    /**************** Getters y Setters ****************/

    /*
     * Metodos a implementar
     */

    public void insertar(int x) throws Exception {
        if (x >= this.valor) {
            if (this.der == null) {
                this.der = new ArbolRojinegro(null, null, x, false);
                this.der.setFather(this);
            } else {
                this.der.insertar(x);
            }
        } else {
            if (this.izq == null) {
                this.izq = new ArbolRojinegro(null, null, x, false);
                this.izq.setFather(this);
            } else {
                this.izq.insertar(x);
            }
        }
    }

    public int maximo() throws Exception {
        if (this.getDer() != null) {
            return this.getDer().maximo();
        } else {
            return this.getValor();
        }
    }

    public int minimo() throws Exception {
        if (this.getIzq() != null) {
            return this.getIzq().minimo();
        } else {
            return this.getValor();
        }
    }

    public ArbolRojinegro search(int x) throws Exception {
        if (this.valor == x) {
            return this;
        } else {
            if (x >= this.valor) {
                if (this.getDer() != null) {
                    return this.getDer().search(x);
                } else {
                    return null;
                }
            } else {
                if (this.getIzq() != null) {
                    return this.getIzq().search(x);
                } else {
                    return null;
                }
            }
        }
    }

    public void rotacionIzquierda(int x) throws Exception {
        ArbolRojinegro nodo = this.search(x);

        if (nodo != null) {
            ArbolRojinegro nodoDer = nodo.getDer();

            nodo.setDer(nodoDer.getIzq());

            if (nodoDer.getIzq() != null) {
                nodoDer.getIzq().setFather(nodo);
            }

            nodoDer.setIzq(nodo);
            nodo.setFather(nodoDer);
        } else {
            throw new Exception();
        }
    }

    public void rotacionDerecha(int x) throws Exception {
        ArbolRojinegro nodo = this.search(x);

        if (nodo != null) {
            ArbolRojinegro nodoIzq = nodo.getIzq();

            nodo.setIzq(nodoIzq.getDer());

            if (nodoIzq.getDer() != null) {
                nodoIzq.getDer().setFather(nodo);
            }

            nodoIzq.setDer(nodo);
            nodo.setFather(nodoIzq);
        } else {
            throw new Exception();
        }
    }

    /*
     * Area de pruebas, no modificar.
     */
    // Verificaciones
    /*
     * Busqueda por amplitud para verificar arbol.
     */
    public String bfs() {
        String salida = "";
        String separador = "";
        Queue<ArbolRojinegro> cola = new LinkedList<>();
        cola.add(this);
        while (cola.size() > 0) {
            ArbolRojinegro nodo = cola.poll();
            salida += separador + String.valueOf(nodo.getValor());
            separador = " ";
            if (nodo.getIzq() != null) {
                cola.add(nodo.getIzq());
            }
            if (nodo.getDer() != null) {
                cola.add(nodo.getDer());
            }
        }
        return salida;
    }

    /*
     * Recorrido inorder. Verifica propiedad de orden.
     */
    public String inorden() {
        String recorrido = "";
        String separador = "";
        if (this.getIzq() != null) {
            recorrido += this.getIzq().inorden();
            separador = " ";
        }
        recorrido += separador + String.valueOf(this.getValor());
        if (this.getDer() != null) {
            recorrido += " " + this.getDer().inorden();
        }
        return recorrido;
    }

}