# SSDD.PO

## Práctica Obligatoria - Sistemas Distribuidos

### Grado en Ingeniería Informática - URJC - 2016

# Nomeolvides

La empresa *Nomeolvides* ofrece como servicio una API REST para listas de cosas. A través de dicha API un desarrollador puede ofrecer una aplicación cliente que permita hacer listas de la compra, listas de regalos, listas de propósito para el nuevo año, etc, sin preocuparse de escribir la parte del servidor, porque puede usar la API de *Nomeolvides*, y esta empresa se encarga de almacenar las listas de los usuarios en su base de datos.

Las listas que ofrece *Nomeolvides* como API REST llevan el nombre del usuario que creó la lista, un nombre y una lista de ítems. Cada item tiene un nombre y una cantidad. El siguiente sería un ejemplo de lista en formato JSON:

```
{
	"user": "pablo",
	"name": "lista de cosas a pedir a los reyes",
	"items": [
		{"name": "cajas de lego", "quantity": 3},
		{"name": "castillo de playmobil", "quantity": 1},
		{"name": "Monster truck", "quantity": 1}
	]
}
```

Para que los desarrolladores que usan su API no tengan que preocuparse de latencias, servidores que no responden, etc, *Nomeolvides* proporciona su API con balanceo de carga, de forma que se minimicen las latencias y se eviten posibles errores ante caídas de los servidores. Para ello, han dispuesto un balanceador de carga, y detrás de él tres servidores web que son los que realmente implementan la API. Para que las listas estén accesibles desde cualquier sitio y los usuarios las puedan llevar siempre consigo, las listas se guardan en una base de datos mysql.

La API REST debe soportar las siguientes operaciones:

- Obtener todas las listas de un usuario
- Obtener todas las listas de un usuario dado con el mismo nombre
- Dar de alta una lista nueva
- Modificar una lista ya existente
- Borrar una lista dado su id

### Se pide:

- Implementar una API REST para las operaciones descritas. La API debe cumplir con las buenas prácticas que se han visto en clase, debe ser limpia, identificar correctamente los recursos y utilizar JSON para las peticiones y las respuestas.
- Implementar la aplicación REST con Spring Boot.
- Montar una topología en Azure adecuada a los siguientes requisitos:
	- La aplicación *Nomeolvides* consistirá en tres máquinas virtuales balanceadeas
	- La aplicación utilizará una base de datos Mysql en una máquina virtual separada

### Defensa de la práctica
La práctica deberá ser defendida por los alumnos en el día estipulado por el profesor. Dicha fecha **se comunicará a través del Campus Virtual**. El día de la defensa los alumnos deben presentarse con la topología montada en la cuenta de alguno de los miembros del grupo.

En principio con que toda la infraestructura esté montada en la cuenta de uno de los miembros es suficiente. No obstante, dado que los errores se producen, se recomienda que algún otro miembro la tenga también montada en su cuenta. **Si la aplicación por el motivo que sea no es funcional no se podrá dar la práctica por aprobada**. Aseguraros de que todo funciona correctamente.

Cualquier **duda** sobre la práctica será formulada a través del **foro** que se habilitará al efecto en el Campus Virtual.
