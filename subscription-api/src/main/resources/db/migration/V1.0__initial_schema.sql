CREATE TABLE subscription
(
    id        VARCHAR(255)	NOT NULL,
	date_time TIMESTAMP 	NOT NULL,
    name    VARCHAR(255)	NOT NULL,
    email   VARCHAR(255)	NOT NULL,
    user_type VARCHAR(255)  NOT NULL,
    company  VARCHAR(255)   NOT NULL,
    application_type  VARCHAR(255)   NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO subscription (date_time, name, email, user_type, id, company, application_type)
VALUES ('2023-04-15T12:00', 'Small Store', 'small.store@gmail.com', 'Marketing', 'a04228f1-368b-4692-a97a-2573c7ac735f', 'Small Store Marketing', 'WebApplication'),
('2023-04-15T12:00', 'Dev Store', 'dev.store@gmail.com', 'Developer', 'a05228f1-368b-4692-a97a-2573c7ac735f', 'Dev Store Developer', 'Services');