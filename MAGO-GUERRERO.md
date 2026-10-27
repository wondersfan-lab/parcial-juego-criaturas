# Mago y Guerrero

Esta es mi parte del parcial de Programación II (juego de batallas entre criaturas). Me tocó hacer las clases Mago y Guerrero, que heredan de la clase abstracta Criatura.

## Mago
El Mago ataca a distancia con hechizos. Tiene un atributo propio llamado `hechizos`. Cuando ataca usa su fuerza como daño, y cuando se defiende el escudo de maná le baja 2 puntos al daño que recibe.

## Guerrero
El Guerrero pelea cuerpo a cuerpo con un arma (atributo `arma`). También usa su fuerza para atacar, y al defenderse la armadura le quita 3 puntos al daño.

## Lo que apliqué
- **Herencia:** las dos clases usan `extends Criatura`, así reutilizo nombre, salud, fuerza y el método estaViva().
- **Polimorfismo:** sobrescribí con `@Override` los métodos atacar() y defender() en cada una, cada criatura ataca distinto.
- **Clases abstractas:** atacar() y defender() venían abstractos en Criatura y acá los implementé.
- **Encapsulamiento:** los atributos propios los dejé private con su getter.

## Git
Trabajé en la rama `feature/implementacion-mago-guerrero` e hice un commit por cada clase. Verifiqué con `mvn clean compile` y dio BUILD SUCCESS.