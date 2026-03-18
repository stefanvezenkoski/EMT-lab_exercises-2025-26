INSERT INTO country (name, continent) VALUES
                                          ('Macedonia',      'Europe'),
                                          ('Germany',        'Europe'),
                                          ('Japan',          'Asia'),
                                          ('France',         'Europe'),
                                          ('United States',  'North America');

INSERT INTO host (created_at, name, surname, country_id) VALUES
                                                             (NOW(), 'Marko',  'Markovski', 1),
                                                             (NOW(), 'Hans',   'Mueller',   2),
                                                             (NOW(), 'Yuki',   'Tanaka',    3),
                                                             (NOW(), 'Claire', 'Dubois',    4);

INSERT INTO accommodation (created_at, name, category, condition, num_rooms, host_id, rented) VALUES
                                                                                                  (NOW(), 'Ohrid Lake View',     'APARTMENT', 'GOOD', 2, 1, false),
                                                                                                  (NOW(), 'Skopje City Room',    'ROOM',      'GOOD', 1, 1, false),
                                                                                                  (NOW(), 'Berlin Central Flat', 'FLAT',      'GOOD', 3, 2, false),
                                                                                                  (NOW(), 'Munich Guesthouse',   'HOUSE',     'BAD',  4, 2, false),
                                                                                                  (NOW(), 'Kyoto Traditional',   'HOUSE',     'GOOD', 5, 3, true),
                                                                                                  (NOW(), 'Tokyo Hotel Stay',    'HOTEL',     'GOOD', 1, 3, false),
                                                                                                  (NOW(), 'Paris Motel',         'MOTEL',     'BAD',  2, 4, false),
                                                                                                  (NOW(), 'Lyon Apartment',      'APARTMENT', 'GOOD', 3, 4, false);