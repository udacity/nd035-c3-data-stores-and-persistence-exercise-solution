INSERT INTO person (age, favorite_composer, name) VALUES (32, 'Erik Satie', 'Terry');

INSERT INTO outfit (person_id, gloves, hat, legs, shoes, top) VALUES (last_insert_id(), 'red', 'blue', 'brown', 'puce', 'taupe');