# parcial-juego-criaturas
Simulador de batallas POO con clases abstractas y polimorfism


Parcial - Juego de Batalla de Criaturas
Proyecto para el parcial de Programación Orientada a Objetos en Java con Maven. El juego simula una batalla por turnos entre diferentes criaturas usando los principios de POO.

Integrantes:

Emmanuel Francisco Ortega Alban

Germán Darío Bolaños Gaviria

----------------------------------------------------------------------------------

Qué hice yo (Emmanuel Ortega):

1-Cree la clase Criatura.java como clase abstracta. No se puede crear una criatura directa, sino que sirve de molde para los demas. Ahi declare los atributos protegidos (nombre, salud y fuerza) para que las subclases los puedan usar y los encapsule con sus getters y setters validando que la salud no baje de cero. Tambien defini los metodos abstractos atacar y defender, que obligan a cada criatura a programar su propio comportamiento.

Cree la clase Dragon.java que hereda de Criatura con extends y llama a su constructor usando super. Le agregue el atributo privado de escamas.

Aplique polimorfismo con el @Override en Dragon.java:

En atacar le cambie la formula para que pegue el doble de daño por llamarada.

En defender le puse logica para que sus escamas le bajen 5 puntos al daño que recibe antes de quitarle vida.

2. Implementé la clase Main.java con el método simularBatalla(Criatura c1, Criatura c2):
- Apliqué polimorfismo dinámico: el método recibe referencias genéricas de tipo Criatura y no necesita saber si está peleando un Dragón, Guerrero o Mago. Solo llama a c1.atacar(c2) y Java se encarga de ejecutar la lógica propia de cada criatura en tiempo de ejecución.
- Creé la lógica del combate por turnos con un ciclo while que revisa estaViva() hasta que una criatura cae derrotada y anuncia al ganador.
- Instancié las criaturas usando polimorfismo (Criatura c = new Dragon(...)) y ejecuté los combates de prueba en la consola.

----------------------------------------------------------------------------