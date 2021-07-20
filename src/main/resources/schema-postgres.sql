DROP TABLE IF EXISTS baskets;
CREATE TABLE baskets(
    id serial PRIMARY KEY,
    name VARCHAR(250),
    description VARCHAR(500),
    image_path VARCHAR(500),
    available integer
 );