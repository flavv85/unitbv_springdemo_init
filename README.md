# unitbv_springdemo_init
Spring Boot app with H2 dDB and CRUD API

Gym fitness club

About the project

The gym will have many coaches. Each coach will have its own fitness class. More coaches can have the same fitness class. Members (users) will be able to attend multiple classes.

The structure of the app:

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
o	If more than 6 members should suggest creating a new class  
-	Boolean isReady
o	Minimum of 3 members to be true
![image](https://github.com/flavv85/unitbv_springdemo_init/assets/60285022/2469a9c8-3c07-4e7c-84af-5f6191ab8969)
