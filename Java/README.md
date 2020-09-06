## 1. First-Class Functions

Las funciones son:
- Relaciones
- Entre un conjunto de elementos dados (que llamamos 'parámetros', dominio, conjunto de las abscisas, las 'equis', whatever...)
- Y un conjunto de elementos esperados (que llamamos 'retorno', codominio, imagen, conjunto de las ordenadas, las 'yes', whatever again...).
	
De forma general, podemos representarlas así:
- 'f(x) = y' o 'nombreFunción(parametros) = retorno'
- '(x) -> y' o '(parámetros) aplicadaFunciónSinNombre retorno'
	
Esta relación cumple una condición muy importante:
- A cada conjunto de elementos dados le corresponde uno y solo un conjunto de elementos esperados.
- Es decir: Dado ciertos parámetros, siempre se debe obtener el mismo retorno.
	
Las funciones pueden estar nombradas:
```
Suma(2, 3) = 2 + 3
```
O no:
```
(2, 3) -> 2 + 3
```

Se dice que una función es de Orden Superior si cumple una de las siguientes condiciones:
- Ser parte de los parámetros de otras funciones: 'g°f(x) = y' o 'g[f(x)] = y'
- Ser el retorno de otras funciones: 'g(x) = f'

Tratamos a las funciones como "ciudadanos de primera clase" cuando cumplen las dos condiciones para ser de Orden Superior.
Esta caracterización les permite ser almacenadas en 'variables' y ser utilizadas como tal: 'var a = f'

Y, en casos particulares, pueden referenciar a elementos que no son parte de sus parametros ni estan definidos dentro de si mismas:
```
bono = 100
// ... 
(salarioActual) -> salarioActual + bono
```
A estas últimas se les conoce como clausuras o cerraduras.

## 2. Pure Functions
Una función pura es aquella que cumple que:
- Para los mismo argumentos, retorna siempre el mismo valor.
- Al evaluarse no tiene o genera efectos secundarios (side-effects).

Una función genera side effects cuando modifica el estado de una variable que esta fuera del alcance de dicha función.
En programación, debemos reducir y/o evitar conceptos que generan o facilitan la generación de side effects:
- La nulidad
- Las excepciones
- La modificación de valores

Los side effects no son malos, se requieren para operaciones particulares, en donde requerimos interactuar con sistemas externos. Pero deben evitarse en la medida de lo posible.

Algunas herramientas vistas que tenemos para reducir los side effects son:
- Filter: Dado una colección, valida que se cumpla una condición o función. Retorna una lista de elementos que cumplen con la condición o una lista vacía.
- Foreach: Dada una colección, aplique una transformación o función. No me interesa obtener un retorno.
- Map: Dada una colección, aplique una transformación o función y retorne la nueva colección con los cambios aplicados.


