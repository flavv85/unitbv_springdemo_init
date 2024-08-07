INSERT INTO member(member_id, member_name, member_nickname,member_status)
VALUES ('151916c4-291c-4125-9ae7-d045eeece9ee', 'John Ranger', 'JohnnyR','ACTIVE');
INSERT INTO member(member_id, member_name, member_nickname,member_status)
VALUES (UUID(), 'Eddy Norman', 'Norm','ACTIVE');
INSERT INTO member(member_id, member_name, member_nickname)
VALUES (UUID(), 'Selena Andrews', 'Saw');

INSERT INTO coach(coach_id, name)
VALUES ('991916c4-291c-4125-9ae7-d045eeece9ea', 'Coach1');
INSERT INTO coach(coach_id, name)
VALUES (UUID(), 'Coach2');

INSERT INTO fitness_class(fitness_class_id, fitness_class_name, coach_id, start_time, end_time)
VALUES ('051916c4-291c-4125-9ae7-d045eeece9ea','Fitness_Class1' , SELECT coach_id from coach where name = 'Coach1', '2024-06-25 13:00:00', '2024-06-25 15:00:00');

INSERT INTO fitness_class(fitness_class_id,fitness_class_name , coach_id, start_time, end_time)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269','Fitness_Class2' , SELECT coach_id from coach where name = 'Coach2', '2024-06-25 13:00:00', '2024-06-25 15:00:00');

--INSERT INTO fitness_class(fitness_class_id,fitness_class_name , coach_id, start_time, end_time)
--VALUES (UUID(),'Fitness_Class3' , SELECT coach_id from coach where name = 'Coach1', '2024-06-26 15:00:00', '2024-06-26 17:00:00');
--
--INSERT INTO fitness_class(fitness_class_id,fitness_class_name , coach_id, start_time, end_time)
--VALUES (UUID(),'Fitness_Class4', SELECT coach_id from coach where name = 'Coach2', '2024-06-26 15:00:00', '2024-06-26 16:00:00');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('051916c4-291c-4125-9ae7-d045eeece9ea' , SELECT member_id from member where member_nickname = 'JohnnyR');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269', SELECT member_id from member where member_nickname = 'Norm');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269', SELECT member_id from member where member_nickname = 'Saw');

INSERT INTO review(review_id,coach_id,member_id,mark)
VALUES (UUID(),SELECT coach_id from coach where name='Coach1',SELECT member_id from member where member_name='John Ranger',8);

INSERT INTO review(review_id,coach_id,member_id,mark)
VALUES (UUID(),SELECT coach_id from coach where name='Coach1',SELECT member_id from member where member_name='Eddy Norman',7);


