MERGE INTO candy AS target
USING (SELECT 1 AS id, 'Gummy Badgers' AS name, 3.50 AS price) AS source
ON target.id = source.id
WHEN MATCHED THEN
    UPDATE SET target.name = source.name, target.price = source.price
WHEN NOT MATCHED THEN
    INSERT (id, name, price) VALUES (source.id, source.name, source.price);

MERGE INTO candy AS target
USING (SELECT 2 AS id, 'Chocolate CreepyDepartmentStoreMannequin' AS name, 18.50 AS price) AS source
ON target.id = source.id
WHEN MATCHED THEN
    UPDATE SET target.name = source.name, target.price = source.price
WHEN NOT MATCHED THEN
    INSERT (id, name, price) VALUES (source.id, source.name, source.price);

MERGE INTO candy AS target
USING (SELECT 3 AS id, 'Lemon Icosahedrons' AS name, 6.20 AS price) AS source
ON target.id = source.id
WHEN MATCHED THEN
    UPDATE SET target.name = source.name, target.price = source.price
WHEN NOT MATCHED THEN
    INSERT (id, name, price) VALUES (source.id, source.name, source.price);

MERGE INTO candy AS target
USING (SELECT 4 AS id, 'Halm' AS name, 2.99 AS price) AS source
ON target.id = source.id
WHEN MATCHED THEN
    UPDATE SET target.name = source.name, target.price = source.price
WHEN NOT MATCHED THEN
    INSERT (id, name, price) VALUES (source.id, source.name, source.price);
