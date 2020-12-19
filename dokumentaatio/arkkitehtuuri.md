<h1> Rakenne </h1>

Ohjelman rakenne noudattaa kolmitasoisa kerrosarkkitehtuuria. Koodin käyttöliittymä löytyy pakkauksesta kulutussovellus.ui, sovelluslogiikka pakkauksesta kulutussovellus.domain, ja datan tallennuksesta vastaa pakkaus kulutussovellus.dao

<h1> Käyttöliittymä </h1>

Käyttöliittymä sisältää 7 näkymää:

* Aloitusnäyttö

* Kirjautuminen

* Käyttäjän luominen

* Käyttäjän etusivu

* Kulujen kirjaaminen

* Kulujen tarkastelu

* Kulujen muokkaaminen (Toistaiseksi vain kulujen poisto-ominaisuus)


Näkymät on luoto Scene-olioina, joista yksi kerrallaan on näkyvissä, eli sijoitettuna sovelluksen stageen.

Käyttöliittymä pyrkii olemaan täysin eriytettynä  sovelluslogiikasta. Se kommunikoi sovelluslogiikan kanssa daoService-olion kautta sopivin parametrein.


<h2> Päätoiminnallisuudet </h2>
Seuraavaksi kuvataan sovelluksen toimintalogiikkaa muutaman päätoiminnallisuuden osalta.
Näitä ovat kulun lisääminen, poistaminen ja listaus sekä käyttäjän luominen ja kirjautuminen.
Toimintalogiikka on kuvattu sekvenssikaavioina.

<h3> Käyttäjän luominen </h3>
Käyttäjä kirjoittaa käyttäjän luomisnäkymässä tekstikenttiin nimensä, haluamansa käyttäjätunnuksen ja salasanan.
Kun painetaan painiketta createUserButton, etenee sovelluksen kontrolli seuraavasti:
 
![Image of Kayttajanlisays](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kayttajanlisays.png)


<h3> Käyttäjän kirjautuminen </h3>
Käyttäjä kirjoittaa nimikenttään käyttäjätunnuksensa ja salasanansa, jotka ovat voimassa. Klikattaessa loginButton-painiketta, etenee sovelluksen kontrolli seuraavasti:
![Image of Kirjautuminen](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kirjautuminen.png)


<h3> Kulun lisääminen </h3>
Uuden kulun luovan sendButton- painikkeen klikkaamisen jälkeen sovelluksen kontrolli etenee seuraavasti:
![Image of Kulunlisays](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kulunlisays.png)

<h3> Kulun poistaminen </h3>
Kulun poistavan removeExpenseButton- painikkeen klikkaamisen jälkeen sovelluksen kontrolli etenee seuraavasti:
![Image of Kulunpoisto](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kulunpoisto.png)

<h3> Kulun listaaminen </h3>
Kulut listaavan showButton- painikkeen klikkaamisen jälkeen sovelluksen kontrolli etenee seuraavasti:
![Image of Kulujenlistaus](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kulujenlistaus.png)
