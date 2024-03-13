# TP8 de Programmation Orienté Objet

Ce dépôt correspond au TP8 de POO disponible [ici](https://www.fil.univ-lille1.fr/~routier/enseignement/licence/poo/tdtp/sujet-wator.pdf "TP8").
Le TP consistait à créer un environnement maritime où se développe prédateurs et proies.

---
##  Membres du binôme

* Nollet Antoine
* Moi-même

---
## Contenu de ce dépôt

* **dist** (distribution des `.jar` executables)
* **lib** (librairie contenant de quoi effectuer les test et de créer les executables)
* **src** (contient les différents codes `.java`)
* **test** (contient les programmes de `test`)
* **media** (contient les `sons` et `images`)
* **makefile** (fichier facilitant l'utilisation du projet)
* [**readme.md**](readme.md "menu des readme") (le menu des readme)
* [**[fr]readme.md**]([fr]readme.md "readme en français") (le fichier que voici, en français)
* [**[en]readme.md**]([en]readme.md "readme en anglais") (le fichier que voici, en anglais)
* [**[es]readme.md**]([es]readme.md "readme en espagnol") (le fichier que voici, en espagnol)

---
## Explications

Si vous lisez ceci, vous avez été admis à accéder à mes projets POO.
Utilisez l'option clone de ce dossier POO et créer un dossier local, si cela n'est pas déjà fait.

Veuillez ouvrir une console depuis ce dossier local, la commande **git pull** est conseillé à chaque fois que vous retournerez consulter ce projet.

Depuis la racine de ce TP dans un shell, vous pouvez executer ces différentes commandes :

* **make** : effectue l'`executable` du projet
* **make comp** : compile les différentes `classes`
* **make compTest** : compile les `classes de test`
* **make doc** : crée la `documentation`
* **make test** : effectue les différents `tests`
* **make oneTest args="package.classTest"** : effectue un `test` (remplacer "package" et "classTest" par les noms correspondant à ce que vous voulez tester)
* **make extract** : extrait les classes depuis les fichiers `.jar`
* **make exe** : crée les `executables`
* **make wator args="w h pt ps tgp spg ssp s dp display squSz"** : effectue l'`executable` du projet
* **make clean** : supprime tous les fichiers `.class`, le dossier `docs` et les fichiers extraits avec `make extract`

## 'make wator' : Message d'utilisation

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

Le "Jeu de la Vie" a été implémenté dans ce projet.
Pour un explicatif de ce qu'est le "Jeu de la Vie", cliquer [ici](https://fr.wikipedia.org/wiki/Jeu_de_la_vie "LifeGame")

Les commandes précédents fonctionnent également pour le LifeGame, il n'y a que la commande **make lifegame args="w h pd s dp display squSz"** qui a été rajouté. Elle permet de lancer l'executable lié au LifeGame

## 'make lifegame' : Message d'utilisation

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

Une simulation de feu de forêt a été implémenté dans ce projet.

Les commandes précédents fonctionnent également pour le BurnForest, il n'y a que la commande **make burnforest args="w h pt s dp display squSz"** qui a été rajouté. Elle permet de lancer l'executable lié au BurnForest

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

Si vous avez des questions sur ce projet, n'hésitez pas à me contacter à l'adresse : **antoine.nollet.etu@univ-lille.fr**

Merci pour votre lecture !
---
<br />
<br />
<br />
<div style="text-align:center"><img src="media/pictures/logo.png"alt="Université de Lille"/></div>
