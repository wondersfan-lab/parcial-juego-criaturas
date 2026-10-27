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

3. Implementación del sistema de armas (Composición en POO):
- Creé la clase Arma.java con atributos encapsulados para el nombre y el daño adicional.
- Modifiqué la clase base Criatura.java agregándole una lista de armas (List<Arma> armas) y los métodos equiparArma() y calcularDañoExtraArmas(). De esta forma cualquier criatura tiene la capacidad de usar cero, una o múltiples armas sin modificar su jerarquía de herencia.
- Actualicé Dragon.java para que su método atacar() sume el daño de las armas que tenga equipadas antes de aplicar el daño crítico.

4. Integración final y simulación completa del sistema en Main.java:
- Diseñé el flujo final del método main() integrando el sistema de composición de armas con las tres subclases (Dragon, Guerrero y Mago).
- Demostré en la simulación los distintos casos de uso: criaturas con cero, una y múltiples armas equipadas sumando su daño adicional.
- Verifiqué la compatibilidad de toda la arquitectura junto con la ejecución exitosa de la suite completa de pruebas unitarias (mvn clean test).

----------------------------------------------------------------------------

Qué hice yo (Germán Bolaños):

1- Implementé la clase Mago.java, que hereda de Criatura con extends y llama a su constructor con super. Le agregué el atributo privado hechizos.

Apliqué polimorfismo con @Override en Mago.java:
- En atacar lanza un hechizo y usa su fuerza (más el daño de las armas equipadas) para hacer daño al objetivo.
- En defender su escudo de maná le baja 2 puntos al daño antes de quitarle vida.

2- Implementé la clase Guerrero.java, que también hereda de Criatura con extends y super. Le puse el atributo privado arma.

Apliqué polimorfismo con @Override en Guerrero.java:
- En atacar pelea cuerpo a cuerpo con su arma usando su fuerza (más las armas equipadas).
- En defender su armadura le baja 3 puntos al daño recibido.

3- Agregué el sistema de armas a mis criaturas: aproveché la lista de armas y el método calcularDañoExtraArmas() de Criatura para que el Mago (por ejemplo con una varita mágica) y el Guerrero sumen daño extra cuando tienen un arma equipada. Esto es composición, porque la criatura "tiene" armas.

4- Hice las pruebas unitarias del proyecto con JUnit 5, en la carpeta src/test. Creé MagoTest, GuerreroTest, DragonTest y ArmaTest, probando la creación de los objetos, el cálculo de daño al defender, que la salud no baje de cero, el método estaViva() y que las armas aumenten el daño. Corrí mvn test y pasaron las 18 pruebas sin fallos.

----------------------------------------------------------------------------