EXEC = wator
TEST = java -jar lib/test-1.7.jar

all: $(EXEC)

doc:
	cd src;javadoc wator -d ../docs;
	cd src;javadoc grid -d ../docs;
	cd src;javadoc life -d ../docs;
	cd src;javadoc forest -d ../docs;
	cd src;javadoc color_splash -d ../docs;
	cd src;javadoc thieves -d ../docs;

classes:
	rm -rf classes;mkdir classes

comp: classes
	cd src;javac */*.java */*/*.java -d ../classes;

compTest: comp
	javac -classpath lib/test-1.7.jar test/*/*.java;

test: compTest
	$(TEST) wator.TestShark
	$(TEST) wator.TestTuna
	$(TEST) wator.TestSea
	$(TEST) life.TestCell
	$(TEST) life.TestWorld
	$(TEST) forest.TestCell
	$(TEST) forest.TestForest

oneTest: compTest
	$(TEST) ${args}

wator:
	java -jar dist/Wator.jar ${args}

lifegame:
	java -jar dist/LifeGame.jar ${args}

burnforest:
	java -jar dist/BurnForest.jar ${args}

colorsplash:
	java -jar dist/ColorSplash.jar ${args}

thieves:
	java -jar dist/Thieves.jar ${args}

exe: comp
	cd classes;jar cvfm ../dist/Wator.jar ../lib/manifest/manifest-Wator wator grid
	cd classes;jar cvfm ../dist/LifeGame.jar ../lib/manifest/manifest-LifeGame life grid
	cd classes;jar cvfm ../dist/BurnForest.jar ../lib/manifest/manifest-BurnForest forest grid
	cd classes;jar cvfm ../dist/ColorSplash.jar ../lib/manifest/manifest-ColorSplash color_splash grid
	cd classes;jar cvfm ../dist/Thieves.jar ../lib/manifest/manifest-Thieves thieves grid

extract:
	cd dist;jar xvf Wator.jar
	cd dist;jar xvf LifeGame.jar
	cd dist;jar xvf BurnForest.jar
	cd dist;jar xvf ColorSplash.jar
	cd dist;jar xvf Thieves.jar


clean:
	rm -rf classes docs test/*.class test/*/*.class dist/META-INF dist/wator dist/grid dist/life dist/forest dist/color_splash dist/thieves

.PHONY: clean extract exe oneTest test compTest comp classes doc all wator lifegame burnforest color_splash thieves
