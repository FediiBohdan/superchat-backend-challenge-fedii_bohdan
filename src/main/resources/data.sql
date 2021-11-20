-------- CONTACT TABLE --------
DROP TABLE IF EXISTS contact CASCADE;

CREATE TABLE contact (id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(250) NOT NULL,
                      email VARCHAR(250) NOT NULL,
                      login VARCHAR(250) NOT NULL,
                      password VARCHAR(250) NOT NULL,
                      creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                      update_date TIMESTAMP,
                      is_deleted BOOLEAN DEFAULT FALSE NOT NULL);

INSERT INTO contact (name, email, login, password) VALUES
('Derek Jackson', 'derek@mail.us', 'derek_super', 'derek_pass'),
('Mary Austin', 'mary@mail.uk', 'mary_super', 'mary_pass'),
('Alfredo Pacino', 'alfredo@mail.it', 'alfredo_super', 'alfredo_pass');

-------- MESSAGE TABLE --------
DROP TABLE IF EXISTS message;

CREATE TABLE message (id BIGSERIAL PRIMARY KEY,
                      sender_id BIGINT NOT NULL,
                      receiver_id BIGINT NOT NULL,
                      content VARCHAR(1000) NOT NULL,
                      creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                      update_date TIMESTAMP,
                      is_deleted BOOLEAN DEFAULT FALSE NOT NULL,
                      FOREIGN KEY (sender_id) REFERENCES contact (id),
                      FOREIGN KEY (receiver_id) REFERENCES contact (id));

INSERT INTO message (sender_id, receiver_id, content) VALUES
(1, 2, 'Hello, Marry! How are you?'),
(2, 1, 'Hi, Derek! I am ok!'),
(2, 3, 'Good morning, Alfredo! When will you finish the task?');