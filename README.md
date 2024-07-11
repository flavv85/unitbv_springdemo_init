# unitbv_springdemo_init
Spring Boot app with H2 dDB and CRUD API

JAVA 17 with maven
pom dependecies:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- h2
- flyway-core
- lombok
- spring-boot-starter-test

Gym fitness club

About the project

Functionality: The gym will have many coaches. Each coach will have its own fitness class and can have multiple fitness class. Members (users) will be able to attend multiple classes.

The base structure of the app (will be upgraded as we go along with the project):

Entities:
1.	COACH
-	String Id
-	String name
-	List<FitnessClass> fitnessClasses -> @OneToMany (mappedBy)

2.	MEMBER
-	String id
-	String name
-	String nickname


3.	FITNESSCLASS
-	String id
-	LocalDateTime startTime
-	LocalDateTime endTime
o	Should not be less than 1h and no longer than 3 h
-	Coach coach -> @ManyToOne @JoinColumn
-	Set<Members> members -> @ManyToMany @JoinTable (name, joinColumns, inverseJoinColumns
o	If more than 8 members should suggest creating a new class  
-	Boolean isReady
o	Minimum of 3 members to be true

----------------------------------
**FitnessClass**
- add the list of members attending fitness class and display only their nickname (when consulting fitness classes)
- add a name for the fitness class, make sure is's persisted in the db (needs to be added as column in the table) and also returned to the client     
  when consulting the database
- add custom date formatters (AAAA-LL-ZZ:HH:mm:ss) / AAAA-LL-ZZ:HH:mm / AA-LL-ZZ:HH:mm)
- validation 1: if classes are less than 60 minutes, display 1h. Round to 1+ if minutes above or equal 30
- general purpose method to append hour/s to fitness class duration (1hour /2 hours)
- validation 2: classes need to have min 3 max 8 members. When consulting one / all fitness classes we need to display custom messages for both cases
- validation 3: if validation 3 is false add and return a transient property of type boolean (isReady) true / false
- move all validation into a separate validation class

**Coach**
- add a new reviews called reviews (think of relation type)
- the Review entity purpose is to keep track of the marks (reviews) gave by the members attending the fitness classes
- add custom message to user for existing coaches that don't have any reviews yet when consulting them.
- return in the dto all fitness class of the coach when consulting one or all coaches
- validation: when deleting a coach throw a custom error and do not delete the entity(coach) if has classes attending (fitness classes)

**Review (new Entity) **
- create java object
- should have: id, coach_id, member_id, mark (1-10)
- create script to add it as entity into the db
- create dto's for populating data to and from client
- create service method with implementation and repository for getting all coaches above average mark 8
- create service method with implementation and repository for getting all coaches custom entered mark (eg.6,5 and above)
  
**Member**
- create service method with implementation and repository for getting all members
- create service method with implementation and repository for getting all members from a fitness class
- create service method with implementation and repository for updating nickname
- create service method with implementation and repository for deleting member
- add a new ENUM(MemberStatus) property status (ACTIVE, INACTIVE). Should be null if user has no review given, or ACTIVE otherwise. 
- create service method with implementation and repository for deleting all members from a fitness class. if there are members that gave a mark(review - MemberStatus = ACTIVE) do not delete them from the date base and set the MemberStatus to INACTIVE

----------------------------------

ACCEPTANCE CRITERIA

- Trebuie sa va creati un branch nou, pornind din main,
care se va numi “project/{team_name}”. Structura proiectului Maven nu trebuie modificata.
- Trebuie sa alegeti metodele de http potrivite pentru toate actiunile. Implementarea
metodelor va fi impartita intre voi astfel incat fiecare sa aiba un aport aproximativ egal in proiect.
- Daca una dintre regulile de validare pica, se va arunca o exceptie custom si se va intoarce
un mesaj de eroare clientului. Mesajul de eroare trebuie sa fie mapat pe response code 400 (BAD
REQUEST) si sa contina mesajul potrivit de eroare.
- Validarile vor trebui facute si pentru metoda POST, si pentru metoda PUT, insa gasiti o
varianta astfel inca sa evitati duplicarea codului.
- Daca un obiect nu exista in baza de date, se va arunca o exceptie si veti raspunde cu un
mesaj de eroare corespunzator si statusul 404 NOT FOUND. Verificarea aceasta trebuie facuta
pentru fiecare actiune (get, post, put, delete).
-Toate callurile de REST se vor testa cu Postman. Nu uitati sa adaugati calea completa (request mapping, path variable, query params unde e cazul)
si body-ul.
-Trebuie sa va folositi de Spring Stereotypes: RestController, Service, Repository si de
principiul de Dependency Injection (Autowired).
-Se va folosi baza de date in-memory H2. La pornirea aplicatiei, tabelele necesare vor fi
deja create. Trebuie sa aveti toate clasele din domeniu si campurile aferente mapate in JPA.
Verificati scripturile de sql pentru numele tabelelor/coloanelor (restaurant-
infrastructure\src\main\resources\db\migration\V1). Alegeti un data type potrivit pentru
campurile voastre.
- Atentie la relatiile dintre entitati. Identificati tipul de relatie dintre obiectele voastre (cu
bold in sectiunea Business Needs). Va veti folosi aici de principiul OOP numit compozitie pentru
a evidentia relatia lor in Java, dar si de adnotarile de JPA pentru a evidentia relatia lor in baza de
date.
- Pentru fiecare clasa de domeniu trebuie sa existe o clasa DTO corespunzatoare (sau mai multe daca dorim sa intoarcem utilizatorului alte informatii, decat cele care sunt de asemenea necesare pentru a salva in baza de date) si un serviciu de mapare din/la domeniu.
- Trebuie sa creati 2 exceptii custom care sa contina un mesaj de eroare:
BusinessException si UnknownObjectException. Exceptiile trebuie prinse in RestErrorController, unde ii veti extrage mesajul. 
BusinessException o veti arunca atunci cand o regula de validare este incalcata. In handler, veti returna un raspuns clientului care sa contina mesajul din
exceptie si statusul HttpStatus BAD_REQUEST. UnknownObjectException o veti arunca atunci
cand nu gasiti un obiect in baza de date, desi am primit un id pentru el de la client. In handler,
veti returna un raspuns clientului care sa contina mesajul din exceptie si statusul HttpStatus
NOT_FOUND.

HINTS:
Va incurajez sa cautati pe internet cand nu stiti cum sa rezolvati ceva (ex. How can I
validate an email address Java, how do I validate a country Java). In viata reala cautam foarte
multe pe internet si copiem mult cod de acolo, nu reinventam mereu roata si ne gandim noi la
alogritmi complicati. 😊 Puteti folosi orice librarie externa care va face viata mai usoara, cu
conditia sa va adaugati dependinta in pom.xml, folosindu-va de Maven.


