<h1> Testausdokumentti </h1>

Ohjelmaa on testattu sekä JUnitilla yksikkö ja integraatiotstein sekä järjestelmätason testein.

<h2> Yksikkö- ja integraatiotestaus </h2>

<h3> Sovelluslogiikka </h3>

Automatisoitujen testien ytimen muodostaa sovelluslogiikkaa, eli pakkauksesta kulutussovellus.domain sijaitsevia luokkia testaavat integraatiotestit, jotka löytyvät pakkauksesta kulutussovellus.domaintests.
Testit ovat nimeltään DaoServiceTest, ExpenseTest ja UserTest.

<h3> DAO-luokat </h3>

DAO- luokkia testaavat testit ExpenseDaoTest, TablesDaoTest, ja UserDaoTest.

<h3> Testauskattavuus </h3>

Sovelluksen rivikattavuus on 92% ja haarautumakattavuus 95%

![Image of testauskattavuus](https://github.com/sofiaaair/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testauskattavuus.png)

Testaamatta jäi Main- luokka, jossa sijaitsee ainoastaan ohjelman käynnistämiseen liittyvä komento,
sekä tablesDao-luokan tietokannan luova komento, sekä ExpenseDao:n removeAll()- metodin mahdollinen virhetilanne. 

<h3> Järjestelmätestaus </h3>

Järjestelmätestaus on suoritettu manuaalisesti.


