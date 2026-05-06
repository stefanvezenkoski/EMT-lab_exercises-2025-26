CREATE VIEW accommodation_view AS
SELECT a.id, a.name, a.category, a.num_rooms,
       CONCAT(h.name, ' ', h.surname) AS host_full_name,
       c.name AS country_name
FROM accommodation a
         JOIN host h ON a.host_id = h.id
         JOIN country c ON h.country_id = c.id;

CREATE MATERIALIZED VIEW accommodation_stats AS
SELECT category,
       COUNT(*) AS total_accommodations,
       SUM(num_rooms) AS total_rooms,
       AVG(num_rooms) AS avg_rooms
FROM accommodation
GROUP BY category;
