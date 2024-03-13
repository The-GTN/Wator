# TP8 de Programación Orientada Objeto

Este depósito corresponde al TP8 de POO disponible [aquí](https://www.fil.univ-lille1.fr/~routier/enseignement/licence/poo/tdtp/sujet-wator.pdf "TP8").
El Trabajo Práctico consiste en crear un ambiente dondé predadores y presas estàn desarrollando aquí.

---
##  Membros del pareja

* Nollet Antonio
* Mismo Mí

---
## Contenido de este depósito

* **dist** (distribución de los `.jar` ejecutables)
* **lib** (librario contente lo que efectuar los test y de crear los ejecutables)
* **src** (contente los diferentes codigos `.java`)
* **test** (contente los programas de `test`)
* **media** (contente los `sonidos` y los `imagenes`)
* **makefile** (fichiero simplificando la utilización del proyecto)
* [**readme.md**](readme.md "menú de los readme") (el menú de los readme)
* [**[fr]readme.md**]([fr]readme.md "readme en francés") (el fichiero que esta leeyendo, en francés)
* [**[en]readme.md**]([en]readme.md "readme en inglès") (el fichiero que esta leeyendo, en inglès)
* [**[es]readme.md**]([es]readme.md "readme en español") (el fichiero que esta leeyendo, en español)

---
## Explicación

Si està leyendo este fichero, fue admitido a mís proyectos de POO.
Utiliza la opción clone de este carpeta POO y crear una carpeta local, si no ya hacido.

Usted abre una consolà desde la carpeta local, el commando **git pull** està recomendada siempre que usted consulta este proyecto.

Desde la raíz de este trabajo en una consolà, puede executar estes differentes commandos :

* **make** : efectua el `ejecutable` del proyecto
* **make comp** : compila los diferentes `class`
* **make compTest** : compila los `class de test`
* **make doc** : crea la `documentación`
* **make test** : efectua los diferentes `test`
* **make oneTest args="package.classTest"** : efectua un `test` (reemplazar "package" y "classTest" con los nombres correspondiente a lo que quiere)
* **make extract** : extracta los class desde los fichieros `.jar`
* **make exe** : crea los `ejecutables`
* **make wator args="w h pt ps tgp spg ssp s dp display squSz"** : efectua el `ejecutable` del proyecto
* **make clean** : supprime todos los fichieros `.class`, la carpeta `docs` et los fichieros extractados con `make extract`

## 'make wator' : mensaje de uso

    run with java wator.Wator w h pt ps tgp spg ssp s dp [display [squSz]]
    where:
    w       = width of environment (chose value<100)
    h       = height of environment (chose value<100)
    pt      = percentage of tuna at beginning
    ps      = percentage of shark at beginning
    tgp     = tuna gestation period
    sgp     = shark gestation period
    ssp     = shark starvation period
    s       = number of steps of process (number of 'fishes' that act)
    dp      = display period (nb of steps between 2 displays)
    display = (optional) graphical display (text if no arg)
    squSz   = (optional) square size if no arg
    try:
    java wator.watorMain 20 20 20 20 1 3 2 40000 250 g 20
    or
    java wator.watorMain 25 25 30 10 2 5 3 125000 250 g 20

---

## Contenu additionel : LifeGame

El "Juego de la vida" ha estado implementado en este proyecto.
Por màs de explicaciónes acerca de este juego, clic [aquí](https://es.wikipedia.org/wiki/Juego_de_la_vida "LifeGame").

Los precedentes commandos functionan también con el Juego de la vida, hay un adicional commando : **make lifegame args="w h pd s dp display squSz"** . Efectua el ejecutable del Juego de la vida.

## 'make lifegame' : mensaje de uso

    run with java life.LifeGame w h pd s dp [display [squSz]]
    where:
    w       = width of environment (chose value<100)
    h       = height of environment (chose value<100)
    pd      = percentage of death at beginning
    s       = number of steps of process
    dp      = display period (nb of steps between 2 displays)
    display = (optional) graphical display (text if no arg)
    squSz   = (optional) square size if no arg
    try:
    java life.LifeGame 20 20 40 200 1 g 10
    or
    java life.LifeGame 25 25 50 200 1 g 20

---

## Contenu additionel : BurnForest

una simulacion de incendio forestal ha estado implementado en este proyecto.

Los precedentes commandos functionan también con el "BurnForest", hay un adicional commando : **make burnforest args="w h pt s dp display squSz"** . Efectua el ejecutable de la simulacion de incendio forestal.

## 'make burnforest' : Message d'utilisation

    run with java forest.BurnForest w h pt s dp [display [squSz]]
    where:
    w       = width of environment (chose value<100)
    h       = height of environment (chose value<100)
    pt      = percentage of trees at beginning
    s       = number of steps of process
    dp      = display period (nb of steps between 2 displays)
    display = (optional) graphical display (text if no arg)
    squSz   = (optional) square size if no arg
    try:
    java forest.BurnForest 30 30 60 100 1 g 10
    or
    java forest.BurnForest 25 25 70 150 1 g 20

---

Si tiene preguntas sobre este trabajo, no duda a contactar me vía mí dirección electrónica : **antoine.nollet.etu@univ-lille.fr**

Graciás para su lectura !
---
<br />
<br />
<br />
<div style="text-align:center"><img src="media/pictures/logo.png"alt="Université de Lille"/></div>
