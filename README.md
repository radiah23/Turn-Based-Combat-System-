# Turn-Based Combat System

Object Oriented Programming course Project

## Overview

This project is a Java-based turn-based combat system developed as part of an Object Oriented Programming (OOP) course. The system demonstrates key OOP concepts, including encapsulation, inheritance, and polymorphism, through the design of player and enemy classes, combat interactions, and game logic.

## Features

- **Turn-Based Mechanics**: Players and enemies alternate actions in battle.
- **Object-Oriented Design**: Clear class structure for combatants, items, abilities, and combat logic.
- **Undo Feature**: Rewind the game's current state using a stack-based approach.
- **Console Interface**: Interact with the system via a Java console application.

## Key Classes and Functions

Here are the major parts of the repository:

### 1. `CombatEntity` (Abstract Class)

- **Purpose**: Represents a combat entity (e.g., Player, Enemy).
- **Functions**:
  - `hasLost()`: Check if the entity has no health left.
  - `takeHit(int damage, String source)`: Applies damage to the entity.
  - `recover(int amount, String source)`: Heals the entity up to its maximum health.
  - `getMaxHealth()`: Returns the entity's max health.
  - `getBasePower()`: Returns the entity's base attack power.
  - `setHealth(int health)`: Sets the entity's current health.
  - `getHealth()`: Returns the entity's current health.
  - `attack(CombatEntity target)` (Abstract): Defines an attack action on another combat entity.

### 2. `Wizard` (Class)

- **Inheritance**: Extends `CombatEntity`. Implements `PlayerControlled`.
- **Functions**:
  - `chooseAction(Scanner input, CombatEntity target)`: Prompts the player for an action (e.g., attack, retreat, undo, or heal).
  - `attack(CombatEntity target)`: Attacks the target entity.

### 3. `Dragon` (Class)

- **Inheritance**: Extends `CombatEntity`. Implements `AIControlled`.
- **Functions**:
  - `attack(CombatEntity target)`: Attacks the target entity.
  - `takeTurn(CombatEntity target)`: Defines the Dragon's AI behavior for its turn.

### 4. `GameState` (Class)

- **Purpose**: Stores the current state of combat entities.
- **Functions**:
  - `getCE(int index)`, `getCEHealth(int index)`: Retrieve the state of combat entities.
  - `getSize()`, `sizeHealth()`: Return the size of combatant lists.

### 5. `GameStack` (Class)

- **Purpose**: Maintains and provides "undo" functionality using a stack.
- **Functions**:
  - `push(GameState t)`: Adds a game state to the stack.
  - `pop()`: Removes and returns the top game state from the stack.
  - `peek()`: Returns the current game state without removing it.

### 6. `PlayerControlled` (Interface)

- **Functions**:
  - `chooseAction(Scanner input, CombatEntity target)`: Prompts the player for actions.

### 7. `AIControlled` (Interface)

- **Functions**:
  - `takeTurn(CombatEntity target)`: Executes the next turn for AI players.

### 8. `GameDriver` (Class)

- **Purpose**: Main entry point for the game.
- **Functions**:
  - `main(String[] args)`: Initializes the game and drives the main execution loop.
  - Implements turn-based logic, handling both player and AI decisions.
  - Offers options such as attacking, retreating, healing, or undoing turns.

### Example Gameplay Flow:
- The game initializes with two entities: `Wizard` and `Dragon`.
- `Wizard` (Player) can choose actions such as attacking, healing, or undoing.
- `Dragon` (AI) automatically executes its turn based on its AI logic.

### Highlight: GameState and Undo Feature
- Every turn, the current state of both combatants is saved to the `GameStack`.
- Players can "undo" turns, restoring the entities to a previous game state.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.

### Building and Running

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/radiah23/Turn-Based-Combat-System-.git
   cd Turn-Based-Combat-System-
   ```
2. **Compile the Project**:
   ```bash
   javac *.java
   ```
3. **Run the Main Class**:
   ```bash
   java GameDriver
   ```

## Object-Oriented Concepts in Action

- **Encapsulation**: Critical data (e.g., health, power) is controlled by accessor and mutator methods.
- **Inheritance & Polymorphism**: Combatant behaviors are defined in the `CombatEntity` superclass, with specific implementations for `Wizard` and `Dragon`.
- **Abstraction**: Interfaces (`PlayerControlled`, `AIControlled`) enable polymorphic behavior for player and AI-driven entities.

## Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests.

---

**Project by [radiah23](https://github.com/radiah23)**