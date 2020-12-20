<h1> Käyttöohje </h1>

Lataa tiedosto kulutussovellus.jar

<h2> Ohjelman käynnistäminen </h2>

> java -jar kulutussovellus.jar

<h2> Alkunäkymä </h2>

Sovellus käynnistyy alkunäkymään:

![Image of alkunakyma](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeTervetuloaNakyma.png)

Kirjautumisnäkymään pääsee painamalla nappia _Sign in_ ja uuden käyttäjän pääsee luomaan painamalla _Sign up_ -nappia.

<h2> Käyttäjän luominen </h2>

Painettiin siis nappia _Sign up_ ja päästiin näkymään, jossa voi luoda uuden käyttäjän.

![Image of kayttajanluonti](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKayttajanLuonti.png)

Haluttu käyttäjänimi kirjoitetaan _Username:_ -tekstiä seuraavaan tyhjään tekstikenttään.
Haluttu salasana ja nimi taas puolestaan _Password:_ ja _Your name:_ tekstiä seuraaviin tekstikenttiin.
_Create user_ luo käyttäjän. 
_Return_ - nappia painamalla päästään takaisin alkunäkymään.


<h2> Kirjautuminen </h2>

Aloitusnäytössä painettiin nappia _Sign in_ ja päästiin kirjautumisnäkymään.

![Image of Kirjautumisnakyma](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKirjautuminen.png)

Nyt kirjoitetaan luotu käyttäjänimi _Username:_- tekstiä seuraavaan tekstikenttään ja salasana _Password:_- tekstiä seuraavaan tekstikenttään.

_Login_- nappulasta pääsee kirjautumaan sisään.

_Return_ palauttaa näkymän takaisin aloitusnäkymään.


<h2> Käyttäjänäkymä </h2>

Kirjautumisnäytöstä _Login_ -nappia painamalla päästiin käyttäjän näkymään.
Käyttäjänäkymä kertoo käyttäjän yksilöllisen id:n.

![Image of kayttajanakyma](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKayttajaNakyma.png)

_Add expenses_ -nappia painamalla päästään näkymään, jossa voi lisätä kuluja ohjelmaan.
_View your expenses_ johdattaa näkymään, jossa voi tarkastella lisättyjä kuluja.
_Log out_ kirjaa käyttäjän ulos ja palaa aloitusnäkymään.

<h2> Kulun lisääminen </h2>

![Image of kulunluonto](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKulunLuonti.png)

Haluttu kulutettu rahasumma lisätään _Amount:_ -tekstiä seuraavaan tekstikenttään. Kulun tyypin saa valittua _Type of expense:_ -tekstiä seuraavasta valintalaatikosta.
Mahdollisia kulun tyyppejä ovat _housing_, _leisure activities_, _shopping_, _traveling_, _food_, ja _other_.
Painamalla _Enter_ painiketta kulu lisätään ohjelmaan.
_Entered expenses_-nappia painamalla pääsee tarkastelemaan syötettyjä kuluja.
_Return_ palauttaa takaisin käyttäjänäymään.


<h2> Kulujen tarkastelu </h2>

![Image of kuluntarkastelu](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKulunTarkastelu.png)

_Show all expenses_- nappia painamalla saa näkyviin ympyrädiagrammin kaikista käyttäjän syöttämistä kuluista.

Yksittäisten kulun tyyppien yhteenvedon saa tulostetuksi valitsemalla valintalaatikosta halutun kulun tyypin ja painamalla _Show expenses by type_ -nappia. Yhteenveto tulostuu ympyrädiagrammin viereen.

_TOTAL_ tulostaa näkyviin kaikkien kulujen yhteissumman.

_Edit expenses_ -nappia painamalla pääsee kulujen muokkausnäkymään, jossa voi poistaa halutut kulut ohjelman muistista.

_Return_ palauttaa takaisin käyttäjänäkymään.


<h2> Kulun poistaminen </h2>

![Image of kulunpoisto](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeKulunPoisto.png)

Kulun muokkausnäkymässä näkyy kaikki lisätyt kulut listana. Listasta voi valita halutun kulun klikkaamalla sitä,
jolloin se muuttuu siniseksi. Tämän jälkeen _Remove expense_ -nappia painamalla kulu poistuu ohjelman muistista.
_Return_ palauttaa käyttäjän takaisin kulujen tarkastelunäkymään.


<h2> Uloskirjaus </h2>

![Image of uloskirjaus](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohjeUlosKirjaus.png)

Ulos kirjautuminen tapahtuu palaamalla käyttäjän näkymään ja klikkaamalla _Log out_ -painiketta yläreunasta.
Ohjelma ohjaa näkymän takaisin alkunäkymään.
