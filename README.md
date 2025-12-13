# Turn-Based Combat System

A Java-based turn-based combat game featuring an epic battle between a player-controlled Wizard and an AI-controlled Dragon. This project demonstrates object-oriented programming principles, including inheritance, interfaces, and the Memento pattern for undo functionality.

## 🎮 Game Overview

In this text-based combat game, players control a Wizard in battle against a formidable Dragon. The game features strategic turn-based combat with various actions, including attacks, healing spells, and the unique ability to undo previous actions using time magic.

## ✨ Features

- **Turn-Based Combat**: Strategic gameplay with player and AI turns
- **Player-Controlled Wizard**: Make tactical decisions each turn
- **AI-Controlled Dragon**: Intelligent enemy with varied attack patterns
- **Multiple Combat Actions**:
  - Simple Attack: Deal base damage to the enemy
  - Heal Spell: Recover health points
  - Undo Spell: Revert the game to a previous state
  - Retreat: Exit the battle
- **Dynamic AI Behavior**: Dragon performs different attacks based on random chance:
  - Basic attack (75% chance)
  - Scorching fire attack - 3x damage (20% chance)
  - Life-stealing bite - 3x damage + heal 20 HP (5% chance)
- **Game State Management**: Implements the Memento pattern for undo functionality
- **Health Tracking**: Real-time health monitoring for both combatants

## 🏗️ Architecture

### Class Structure

#### Core Classes

**`CombatEntity` (Abstract Class)**
- Base class for all combat participants
- Manages health, name, and base power attributes
- Provides methods for:
  - Taking damage
  - Recovering health
  - Checking defeat conditions
- Requires subclasses to implement the `attack()` method

**`Wizard` (Player Character)**
- Extends: `CombatEntity`
- Implements: `PlayerControlled` interface
- Stats:
  - Health: 100 HP
  - Base Power: 15
- Abilities:
  - Attack enemies
  - Heal (20 HP)
  - Undo previous action
  - Retreat from battle

**`Dragon` (Enemy Character)**
- Extends: `CombatEntity`
- Implements: `AIControlled` interface
- Stats:
  - Health: 150 HP
  - Base Power: 20
- Special Attacks:
  - Normal attack (1x base power)
  - Scorching fire (3x base power)
  - Life-stealing bite (3x base power + heal 20 HP)

#### Interfaces

**`PlayerControlled`**
- Defines the contract for player-controlled entities
- Method: `chooseAction(Scanner input, CombatEntity target)`

**`AIControlled`**
- Defines the contract for AI-controlled entities
- Method: `takeTurn(CombatEntity target)`

#### Game Management Classes

**`GameDriver`**
- Main entry point for the application
- Manages the game loop
- Handles turn sequence and game state

**`GameState`**
- Represents a snapshot of the game at a specific moment
- Stores combat entities and their health values
- Enables the undo functionality (Memento pattern)

**`GameStack`**
- Manages the history of game states
- Implements stack operations (push, pop, peek)
- Uses `ArrayList<GameState>` for storage

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java compiler (`javac`)
- Java Runtime Environment (JRE)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/radiah23/Turn-Based-Combat-System-.git
cd Turn-Based-Combat-System-
```

2. Compile all Java files:
```bash
javac *.java
```

### Running the Game

Execute the compiled program:
```bash
java GameDriver
```

## 🎯 How to Play

1. **Start the Game**: Run the `GameDriver` class
2. **View Status**: Each turn displays current health for both the Wizard and Dragon
3. **Choose Your Action**: Select from the available options:
   - `0` - Retreat from battle
   - `1` - Perform a simple attack
   - `2` - Cast a healing spell (restore 20 HP)
   - `3` - Cast an undo spell (revert to previous state)
4. **Dragon's Turn**: The dragon automatically attacks with one of its abilities
5. **Win Condition**: Reduce the Dragon's health to 0 or below
6. **Lose Condition**: Wizard's health reaches 0 or below
7. **Retreat**: Choose to retreat and end the battle early

### Example Gameplay

```
The Game Starts!!
WizardHealth Power100Max Health100Base Power15
DragonHealth Power150Max Health150Base Power20

0. Retreat 1. Simple Attack 2. Heal (Spell) 3. Undo (Spell)
1

Dragontakes a hit for15damage fromWizard
WinWizardtakes a hit for20damage fromDragon
Victory
...
```

## 📊 Game Mechanics

### Combat System
- Damage is dealt based on each entity's `basePower` attribute
- Special attacks can multiply damage by 3x
- Health cannot exceed the maximum health value
- Combat continues until one combatant's health reaches zero

### Undo Mechanism
- The game maintains a stack of previous game states
- Players can revert to the previous turn using the undo action
- Each undo restores all combat entities to their previous health values
- Implements the Memento design pattern

### AI Behavior
The Dragon uses a random number generator (1-20) to determine its action:
- **1-15**: Normal attack (75% chance)
- **16-19**: Scorching fire attack (20% chance)
- **20**: Life-stealing bite (5% chance)

The probabilities are calculated from the ranges: 15 numbers out of 20 for normal attack (75%), 4 numbers for scorching fire (20%), and 1 number for life-stealing bite (5%).

## 🗂️ File Structure

```
Turn-Based-Combat-System-/
├── CombatEntity.java       # Abstract base class for all combat entities
├── PlayerControlled.java   # Interface for player-controlled entities
├── AIControlled.java       # Interface for AI-controlled entities
├── Wizard.java            # Player character implementation
├── Dragon.java            # Enemy character implementation
├── GameState.java         # Memento class for game state snapshots
├── GameStack.java         # Stack data structure for state history
├── GameDriver.java        # Main game loop and entry point
└── README.md             # This file
```

## 🎓 Design Patterns

### Memento Pattern
The game implements the **Memento Pattern** through:
- **Originator**: `CombatEntity` objects whose state needs to be saved
- **Memento**: `GameState` class that stores entity states
- **Caretaker**: `GameStack` class that manages the history of states

This pattern allows the undo functionality without violating encapsulation principles.

### Strategy Pattern
The use of `PlayerControlled` and `AIControlled` interfaces demonstrates a form of the **Strategy Pattern**, allowing different combat behaviors for different entity types.

## 🔮 Future Enhancements

Potential improvements for the project:

- [ ] Add more character classes (Rogue, Warrior, etc.)
- [ ] Implement multiple enemy types
- [ ] Add an equipment/inventory system
- [ ] Include status effects (poison, burn, freeze)
- [ ] Create a leveling/experience system
- [ ] Add save/load game functionality
- [ ] Implement a graphical user interface (GUI)
- [ ] Add sound effects and music
- [ ] Create multiplayer support
- [ ] Implement difficulty levels
- [ ] Add more diverse spells and abilities
- [ ] Include critical hit mechanics
- [ ] Add dodge/block mechanics

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

**radiah23**

## 🙏 Acknowledgments

This project was created as a demonstration of:
- Object-oriented programming principles
- Turn-based game mechanics
- Design pattern implementation in Java
- State management and undo functionality
