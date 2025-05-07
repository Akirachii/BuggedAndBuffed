# 🌌 Java Space Fleet Challenge

## 🚀 Overview
Welcome, Captain! Your mission (should you choose to accept it) is to command your **Mothership** and manage an intergalactic **fleet** of ships. These ships can go on expeditions, generate revenue, or get destroyed in epic cosmic battles. You’ll build this as a Java application, using **Object-Oriented Programming**, **custom exceptions**, and a **Dockerized database** for storage.


## 🧠 Concepts & Features

### ✅ Core Concepts:
- A **Mothership** (your main controller, wallet, and hangar)
- A **Fleet** of various ships
- **Ship types**: Fighter, Miner, Trader, Explorer
- **International Space Currency (IC)** to buy/sell/earn
- **Expeditions** for earning and losing money (random events)
- **Custom exceptions** (e.g. low balance, ship not found, damaged ship)



## ⚙️ Project Structure

src/  
├── Main.java # Menu + interaction controller  
├── Mothership.java # Core class with fleet management  
├── ships/  
│ ├── AbstractShip.java # Base class for all ships  
│ ├── FighterShip.java  
│ ├── MinerShip.java  
│ ├── TraderShip.java  
│ ├── ExplorerShip.java  
├── enums/  
│ ├── ShipType.java # Enum for ship types  
├── exceptions/  
│ ├── InsufficientCreditsException.java  
│ ├── ShipNotFoundException.java  
│ ├── DamagedShipException.java  
├── database/  
│ ├── DBManager.java # Handles connection and queries  
│ ├── docker-compose.yml # PostgreSQL container setup  


## 📋 Checklist

### Mothership:
- [ ] Create mothership with name, crew size, cargo capacity, IC credits
- [ ] Buy ships (check for enough IC)
- [ ] Sell ships (refund part of IC)
- [ ] View fleet
- [ ] Go on expeditions (earn or lose IC)
- [ ] Save/load data to/from DB

### Ship Types:
- [ ] Fighter — good in battles, high cost
- [ ] Miner — earns from asteroid mining
- [ ] Trader — earns from space market
- [ ] Explorer — high risk, high reward expeditions

### Exceptions:
- [ ] `InsufficientCreditsException`
- [ ] `ShipNotFoundException`
- [ ] `DamagedShipException`


## 📦 Database Tables

### mothership
| id (UUID) | name | crew_size | cargo_capacity | credits |
|-----------|------|-----------|----------------|---------|

### ships
| id (UUID) | name | type | health | mothership_id (FK) |

### expeditions *(optional but spicy)*
| id | ship_id | outcome | credit_change | timestamp |



## 🎮 Game Flow

1. App launches → prompt user to name their mothership.
2. Main menu appears:
   - Buy ship
   - Sell ship
   - View fleet
   - Check credits
   - Go on expedition
   - Save & Exit
3. Player actions update their fleet, IC balance, and DB.


