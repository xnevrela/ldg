#LDG job application project

## Definition
- Cílovou webovou aplikací by měl být jednoduchý kontaktní formulář viz wireframe (WF) níže
- FE komponenty by měly obsáhnout jeden selectbox, jehož data (možnosti) se dotahují skrze BE z DB vrstvy
- Input fieldy by měly obsahovat základní validace 
  - Policy number – alfanumerické znaky
  - Name + Surname – pouze písmena
  -Request field by měl omezovat délku (dle Vaší úvahy, nemusí být 5.000 jako je ve WF)
- Submit formu má skrze BE uložit do DB
- Aplikace půjde kompletně sestavit jedním příkazem s využitím libovolného nástroje pro sestavování aplikací (např. gradle, maven, … ).

## Run Java
```
mvn clean install
java -jar target/ldg-application-<version>.jar
```

## Run Docker
```
docker build -t ldg-application .
docker run --rm --name ldg-application -p 8080:8080 ldg-application
```
