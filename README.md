<h1>Ohjelmistotekniikan harjoitustyö</h1>


<h3> Kulutussovellus</h3>

Sovelluksen avulla voi seurata omaa rahankäyttöä ja rahankäytön osa-alueita.


<h3> Dokumentaatio</h3>

[Määrittelydokumentti](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testusdokumentti](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Tuntikirjanpito](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

<h3> Release </h3>

[Release](https://github.com/sofiaaair/ot-harjoitustyo/releases/tag/viikko7)

<h3> Komentorivikomennot </h3>

Ohjelman käynnistäminen

Ohjelman voi ajaa Netbeansissa.
Terminaalissa ohjelman voi käynnistää komennolla, 

> mvn compile exec:java -Dexec.mainClass=kulutussovellus.Main

varmista, että olet kansiossa Kulutussovellus

<h3> Testaus </h3>

Testit voi ajaa komennolla 

> mvn test

Koodikattavuuden saa komennolla 

> mvn jacoco:report

Kattavuusraportin saa halutessaan avattua selaimella tiedosto target/site/jacoco/index.html

<h3> Suoritettavan jarin generointi </h3>

Seuraava komento generoi hakemistoon _target_ suoritettavan jar-tiedoston _Kulutussovellus-1.0-SNAPSHOT.jar_

<h3> JavaDoc </h3>

JavaDoc generoidaan seuraavalla komennolla

> mvn javadoc:javadoc

JavaDocin saa näkyviin avaamalla selaimella tiedosto _target/site/apidocs/index.html_


<h3> Checkstyle </h3>

Tiedostoon checkstyle.xml määritetyt tarkastukset suoritetaan komennolla

>mvn jxr:jxr checkstyle:checkstyle

Ja selaimella voi avata tiedoston target/site/checkstyle.html tarkasteltavaksi
