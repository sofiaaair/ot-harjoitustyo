<h1> Arkkitehtuurikuvaus </h1>

<h2> Ohjelman rakenne </h2>

Ohjelman rakenne noudattaa kolmitasoisa kerrosarkkitehtuuria. Koodin käyttöliittymä löytyy pakkauksesta kulutussovellus.ui, sovelluslogiikka pakkauksesta kulutussovellus.domain, ja datan tallennuksesta vastaa pakkaus kulutussovellus.dao.
Pakkaustakenne näyttää tältä:

![Image of pakkausrakenne](https://github.com/sofiaaair/ot-harjoitustyo/tree/master/dokumentaatio/kuvat/rakenne.png)

Käyttöliittymä on toteutettu JavaFX:llä, pysyväistallennus löytyy pakkauksesta kulutussovellus.dao.

<h2> Käyttöliittymä </h2>

Käyttöliittymä sisältää 7 näkymää:

* Aloitusnäyttö

* Kirjautuminen

* Käyttäjän luominen

* Käyttäjän etusivu

* Kulujen kirjaaminen

* Kulujen tarkastelu

* Kulujen muokkaaminen (Toistaiseksi vain kulujen poisto-ominaisuus)


Näkymät ovat järjestetty omiksi luokikseen. Kukin luokka luo omanlaisensa Scene-olion, joista yksi kerrallaan on näkyvissä, eli sijoitettuna sovelluksen stageen.

Käyttöliittymä pyrkii olemaan täysin eriytettynä  sovelluslogiikasta. Se kommunikoi sovelluslogiikan kanssa daoService-olion kautta sopivin parametrein.


<h2> Sovelluslogiikka </h2>

Luokat Expense ja User luovat sovelluksen loogisen datamallin, ne kuvaavat käyttäjiä ja käyttäjän järjestelmään syöttämiä kuluja:

![Image of datamalli](https://github.com/sofiaaair/ot-harjoitustyo/tree/master/dokumentaatio/kuvat/datamalli.jpg)

Toiminnallisista kokonaisuuksista vastaa DaoService, joka tarjoaa kaikille käyttäjäliittymän toiminnoille oman metodinsa, joita ovat esimerkiksi:

* void createExpense(String amount, String type, String id)

* void deleteExpense(int id)

* String listExpense(String type, int id)

* double totalSumOfExpenses(int id)

* List listAllExpenses(int id)

* createTablesDao()

* void createUser(String name, String username, String password)

* User readUser(Integer key)

* int loginUser(String username, String password)

* void deleteUser(int id) 

DaoService pääsee käsiksi kuluihin ja käyttäjiin pakkauksessa kulutussovellus.dao Dao-rajapinnan toteuttavien ExpenseDao ja UserDao luokkien kautta.

DaoServicen ja muiden ohjelman osien suhdetta kuvaava luokka/pakkauskaavio näyttää seuraavalta:

![Image of luokkapakkauskaavio](https://github.com/sofiaaair/ot-harjoitustyo/tree/master/dokumentaatio/kuvat/luokkapakkauskaavio.png)


<h2> Tietojen pysyväistallennus </h2>

Pakkauksen kulutussovellus.dao luokat ExpenseDao ja UserDao huolehtivat tiedon tallentamisesta SQL-tietokantaan.

Luokat noudattvat Data Access Object suunnittelumallia.

<h2> Tietokanta </h2>

Sovellus tallettaa käyttäjän ja kulujen tiedot SQL-tietokantaan.
Tietokannassa on kaksi taulua, User ja Expense.
Sovellus tallettaa käyttäjän tauluun seuraavalla komennolla:

> INSERT INTO USER (id, name, username, password) VALUES (1, "Matti", "Matteo", "12345")

Samalla tavalla sovellus lisää myös kulun tauluun:

> INSERT INTO Expense(amount, type, user_id) VALUES (500, "housing", 1)

Tietokannassa nämä lisätyt tiedot näkyvät seuraavalla tavalla:

> 1|Matti|Matteo|12345

> 1|500.0|housing|1
 

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


<h2> Ohjelman rakenteeseen jääneet heikkoudet </h2>

<h3> Tietokanta </h3>

Tämänhetkinen toteutus tallentaa datan tiettyyn tietokantaan, jolloin sovelluksen datan talletustavan vaihto aiheuttaa suuria muutoksia sovelluslogiikan toteutukseen. Sovelluksesta saisi helpommin muokattavan, jos nykyistä  DAO- mallia laajentaisi ja toteuttaisi ExpenseDao ja UserDao luokkien toteutukset erillisten Dao -rajapintojen taakse.

<h3> Testaus </h3>

Testeissä käytetään tämänhetkisessä toteutuksessa tiedostoon tallentavia DAO- olioita, jonka vuoksi testit pyyhkivät jo tietokantaan luodut tiedostot.

<h3> Käyttöliittymä </h3>

Käyttäjän salasanan ja käyttäjätunnuksen pituus ja muoto ovat vapaita, tähän olisi hyvä asettaa jotain rajoituksia
