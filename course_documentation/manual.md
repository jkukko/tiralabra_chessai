# Manual

## Performance Test
You can test performance of algorithms by using PerformanceTest class. You can run perfomance test two different way. First, by using jar and second manually running the code with ide. 

### Jar
* Select latest release, [Releases](https://github.com/jkukko/tiralabra_chessai/releases)
* Download chess.jar
* Extract file
* Run `java -jar chess.jar` in folder where extracted file is

### Manually
* Clone github [repository](https://github.com/jkukko/tiralabra_chessai)
* Open project in ide (for example NetBeans)
* Run performanceTest Class

## Test AIBot with xBoard
You can test playing against AIBot. 
* Clone github [repository](https://github.com/jkukko/tiralabra_chessai)
* run code `./gradlew clean build`
* install xboard chess program
* run code `xboard`
* add "tira-chess" -fcp "java -jar /YOURLOCATION/tiralabra_chessai/build/libs/chess-all.jar" to engine list (tab bar Engine). Remember change YOURLOCATION to your local location where tiralabra_chessai is located
* Select "tira-chess" for 1st engine (Engine - Load New 1st Engine)
* Under mode select Machine White (in code hard coded that AI is white)
