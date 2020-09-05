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
´´´
Suma(2, 3) = 2 + 3
´´´
O no:
´´´
- (2, 3) -> 2 + 3
´´´

Se dice que una funcion es de Orden Superior si cumple una de las siguientes condiciones:
- Ser parte de los parametros de otras funciones: 'g°f(x) = y' o 'g[f(x)] = y'
- Ser el retorno de otras funciones: 'g(x) = f'

Tratamos a las funciones como "ciudadanos de primera clase" cuando cumplen las dos condiciones para ser de Orden Superior.
Esta caracterización les permite ser almacenadas en 'variables' y ser utilizadas como tal: 'var a = f'

Y, en casos particulares, pueden referenciar a elementos que no son parte de sus parametros ni estan definidos dentro de si mismas:
´´´
bono = 100
// ... 
(salarioActual) -> salarioActual + bono
´´´
A estas últimas se les conoce como clausuras o cerraduras.
