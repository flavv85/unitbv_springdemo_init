INSERT INTO member(member_id, member_name, member_nickname)
VALUES (UUID(), 'John Ranger', 'JohnnyR');
INSERT INTO member(member_id, member_name, member_nickname)
VALUES (UUID(), 'Eddy Norman', 'Norm');
INSERT INTO member(member_id, member_name, member_nickname)
VALUES (UUID(), 'Selena Andrews', 'Saw');

INSERT INTO coach(coach_id, name)
VALUES (UUID(), 'Coach1');
INSERT INTO coach(coach_id, name)
VALUES (UUID(), 'Coach2');

INSERT INTO fitness_class(fitness_class_id, coach_id, start_time, end_time)
VALUES ('051916c4-291c-4125-9ae7-d045eeece9ea', SELECT coach_id from coach where name = 'Coach1', '2024-06-25 13:00:00', '2024-06-25 15:00:00');

INSERT INTO fitness_class(fitness_class_id, coach_id, start_time, end_time)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269', SELECT coach_id from coach where name = 'Coach2', '2024-06-25 13:00:00', '2024-06-25 15:00:00');

INSERT INTO fitness_class(fitness_class_id, coach_id, start_time, end_time)
VALUES (UUID(), SELECT coach_id from coach where name = 'Coach1', '2024-06-26 15:00:00', '2024-06-26 17:00:00');

INSERT INTO fitness_class(fitness_class_id, coach_id, start_time, end_time)
VALUES (UUID(), SELECT coach_id from coach where name = 'Coach2', '2024-06-26 15:00:00', '2024-06-26 16:00:00');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('051916c4-291c-4125-9ae7-d045eeece9ea' , SELECT member_id from member where member_nickname = 'JohnnyR');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269', SELECT member_id from member where member_nickname = 'Norm');

INSERT INTO fitness_classes_members(fitness_class_id, member_id)
VALUES ('b7b57d69-d9d0-43bf-a30e-39f682853269', SELECT member_id from member where member_nickname = 'Saw');
