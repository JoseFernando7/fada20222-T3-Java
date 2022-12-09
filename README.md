# Taller 3 
 ## Arboles rojinegroes

## Recursos

http://www.rmboot.com/RedBlack.html

## Cambios

Se ha agregado una referencia al padre en las pruebas, puede hacer este cambio para tener el nodo padre

```java
@Getter
@Setter
private ArbolRojinegro father;
```

## Sobre la entrega

1- Las anotaciones de ```@Getter``` y ```@Setter``` no funcionaron correctamente (o no supimos utilizarlos) por lo que se usó los getters y setters por defecto de java.

2- Las funciones de rotaciones (izquierda y derecha) funcionan correctamente cambiando la estructura de los árboles. Pero por alguna situación que no logramos arreglar la función de búsqueda bfs no la toma correctamente por lo que las funciones fallan los tests.