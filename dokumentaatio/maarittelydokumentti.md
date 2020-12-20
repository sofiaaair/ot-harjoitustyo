<h1> Kulunseurantasovelluksen vaatimusmäärittely </h1>

<h2> Sovelluksen tarkoitus </h2>

Käyttäjä voi lisätä sovellukseen kuluttamansa rahasumman eli _expensen_ ja seurata, mihin eri asioihin rahaa kuluu.

Käyttäjä voi seurata rahanmenoaan ja tehdä havaintoja omista kulutustottumuksistaan.


<h2> Käyttäjät </h2>

Sovellukseen voi luoda tunnuksen ja kirjautua sisään.
Käyttäjällä on nimi, käyttäjänimi ja salasana.
Sovelluksella on toistaiseksi yksi käyttäjärooli, _normaali käyttäjä_.

<h2> Käyttöliittymäluonnos </h2>

Perusversio koostuu seitsemästä eri näkymästä:

![Image of kayttoliittyma](file:///home/airassof/ot-harjoitustyo/dokumentaatio/kuvat/lopullinenkayttoliittyma.png)

<h2> Perusversion tarjoama toiminnallisuus </h2>

<h3> Ennen kirjautumista </h3>

* Käyttäjä voi luoda järjestelmään käyttäjätunnuksen.

   * Käyttäjätunnuksen täytyy olla uniikki.

* Käyttäjä voi kirjautua järjestelmään

  * kirjautuminen tapahtuu kirjautumisnäkymässä syöttämällä olemassaoleva käyttäjätunnus ja salasana niille osoitetuihin kenttiin.
  * jos käyttäjätunnus ei ole olemassa, järjestelmä ilmoittaa asiasta

<h3> Kirjautumisen jälkeen </h3>

* Käyttäjä voi lisätä kuluja järjestelmään

* Käyttäjä voi tarkastella lisäämiään kuluja
  * Kukin kulu näkyy vain sen lisänneelle käyttäjälle

* Käyttäjä voi poistaa kuluja

* Käyttäjä voi kirjautua ulos järjestelmästä

<h3> Jatkokehitysideoita </h3>

Perusversion jälkeen voisi ohjelmaa laajentaa seuraavasti:

* Lisättyjen kulujen editointi
* Kuluihin voisi lisätä ajankohdan, jolloin kulu on syntynyt
* Kuluja voisi ajankohdan lisäämisen jälkeen tarkastella kuukausittaisen, viikottaisen ja päivittäisen kulutuksen näkökulmasta
* Järjestelmään voisi lisätä kulujen lisäksi myös tulot 
* Järjestelmään voisi kulujen lisäksi lisätä myös säästösuunnitelmia



