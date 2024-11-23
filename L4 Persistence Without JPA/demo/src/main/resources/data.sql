-- Begin a transaction
BEGIN;

INSERT INTO person (age, favorite_composer, name) VALUES (32, 'Erik Satie', 'Terry');

INSERT INTO outfit (person_id, gloves, hat, legs, shoes, top)
SELECT id, 'red', 'blue', 'brown', 'puce', 'taupe' FROM person
WHERE name = 'Terry' AND age = 32 AND favorite_composer = 'Erik Satie';

-- Commit the transaction
COMMIT;
