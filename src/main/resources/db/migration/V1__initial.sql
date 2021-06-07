CREATE TABLE roulette (
    id BIGINT AUTO_INCREMENT,
    state VARCHAR,
    customer INT,
    bet_amount DOUBLE,
    bet_number_or_color VARCHAR,
    winning_number_or_color VARCHAR,
    earned_money DOUBLE,
    PRIMARY KEY(id)
);
