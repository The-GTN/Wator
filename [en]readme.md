# Practical Work n°8 of Oriented Object's Programmation

This upload corresponds with the PW8 of OOP available [here](https://www.fil.univ-lille1.fr/~routier/enseignement/licence/poo/tdtp/sujet-wator.pdf "PW8").
This PW consisted of creating an environment where predators and preys are developping themself.

---
##  Squad's Members

* Nollet Antoine
* Self My

---
## Content of this work

* **dist** (distribution of executables `.jar`)
* **lib** (library containing what we need to do the tests and to create the executables)
* **src** (contains the differents codes `.java`)
* **test** (contains `test` programs)
* **media** (contains the `sounds` and `pictures`)
* **makefile** (file making easier this work's using)
* [**readme.md**](readme.md "readme menu") (the readme's menu)
* [**[fr]readme.md**]([fr]readme.md "readme in french") (the file you are reading, in french)
* [**[en]readme.md**]([en]readme.md "readme in english") (the file you are reading, in english)
* [**[es]readme.md**]([es]readme.md "readme in spanish") (the file you are reading, in spanish)

---
## Explanations

If you're reading that, you've been granted to access to my OOP projects.
Use the clone option of this OPP folder and create a local folder, if it's not already done.

Open a shell from this local folder, the **git pull** command is recommended for each times you come back to this work.

From the root of this work folder, in a shell, you could use this differents commands :

* **make** : create the `documentation`, run the `tests` and run the `executables`
* **make comp** : build the differents `classes`
* **make compTest** : build the `testing classes`
* **make doc** : create the `documentation`
* **make test** : make the differents `tests`
* **make oneTest args="package.classTest"** : make one `test` (replace "package" and "classTest" with the name corresponding to what you want to test)
* **make extract** : extract the classes from the `.jar` files
* **make exe** : create the `executables`
* **make wator args="w h pt ps tgp spg ssp s dp display squSz"** : run the `executable` of this project
* **make clean** : delete all the `.class` files, the `docs` folder and the extracted files created with `make extract`

## 'make wator' : message of use

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

The "Life Game" has been implemented in this project.
For more explanations about this game, click [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life "LifeGame")

The previous commands work also for the LifeGame, there just one command added : **make lifegame args="w h pd s dp display squSz"** . It executes the executable linked at the LifeGame

## 'make lifegame' : message of use

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

A simulation of forest fire has been implemented in this project.

The previous commands work also for the BurnForest, there just one command added : **make burnforest args="w h pt s dp display squSz"** . It executes the executable linked at the BurnForest

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

If you have questions about this project, don't hesitate to contact me from this email : **antoine.nollet.etu@univ-lille.fr**

Thanks for your reading !
---
<br />
<br />
<br />
<div style="text-align:center"><img src="media/pictures/logo.png"alt="Université de Lille"/></div>
