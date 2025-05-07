-- 1. Types of ships
CREATE TABLE ship_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,          -- e.g. "Fighter", "Miner", "Explorer", "Trader"
    description TEXT
);

-- 2. Your mother ship – the central command unit
CREATE TABLE mother_ship (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    credits DECIMAL(15, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. All other ships in your fleet
CREATE TABLE ship (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    ship_type_id INT,
    owner_id INT,                        -- FK to mother_ship
    hp INT DEFAULT 100,
    fuel INT DEFAULT 100,
    status VARCHAR(50) DEFAULT 'active',  -- or 'destroyed', 'in expedition', etc.
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ship_type_id) REFERENCES ship_type(id),
    FOREIGN KEY (owner_id) REFERENCES mother_ship(id)
);

-- 4. Expeditions you send ships to
CREATE TABLE expedition (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    difficulty_level INT,
    reward DECIMAL(15, 2),
    risk_percent INT,                    -- % chance of something bad happening
    duration_minutes INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 5. Transaction log to track buying/selling ships and expedition results
CREATE TABLE transaction_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mother_ship_id INT,
    ship_id INT,
    expedition_id INT,
    type ENUM('BUY', 'SELL', 'REWARD', 'LOSS') NOT NULL,
    amount DECIMAL(15, 2),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (mother_ship_id) REFERENCES mother_ship(id),
    FOREIGN KEY (ship_id) REFERENCES ship(id),
    FOREIGN KEY (expedition_id) REFERENCES expedition(id)
);
INSERT INTO ship_type (name, description) VALUES
('Fighter', 'Combat ship with strong attack power.'),
('Miner', 'Collects resources from asteroid fields.'),
('Explorer', 'Scans new areas of space.'),
('Trader', 'Generates profit from interstellar trade.');
