# CSE 220 Practice Assignment: Vehicle Hierarchy

## What this assignment practices

- Abstract classes and abstract methods
- Inheritance and constructor chaining
- Polymorphism through abstract references
- Enums with metadata
- Input validation
- Encapsulation with `private final` fields
- Method overriding
- Reusing inherited behavior

## Scenario

You are building a small transportation application. The program must represent land vehicles and water vehicles using a shared abstract hierarchy.

Your job is to create the required classes and enums so that the provided `Main.java` and instructor tests work correctly.

---

## Required project layout

```text
Java_Practice_Assignment/
├── README.md
└── Assignment/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        │       ├── Main.java
        │       └── Vehicles/
        │           ├── Vehicle.java
        │           ├── Enums/
        │           │   └── VehicleCategory.java
        │           ├── Land/
        │           │   ├── LandVehicle.java
        │           │   ├── Car.java
        │           │   ├── Bicycle.java
        │           │   └── Enums/
        │           │       └── LandVehicleType.java
        │           └── Water/
        │               ├── WaterVehicle.java
        │               ├── Boat.java
        │               ├── Sailboat.java
        │               └── Enums/
        │                   └── WaterVehicleType.java
        └── test/
            └── java/
                ├── instructor/
                │   ├── AbstractContractTest.java
                │   ├── InheritanceTest.java
                │   ├── ValidationTest.java
                │   ├── PolymorphismTest.java
                │   └── MainDriverTest.java
                └── student/
                    └── StudentTest.java
```

## Rules

Do **not** modify the files inside:

```text
Assignment/src/test/java/instructor/
```

You may create your own tests in:

```text
Assignment/src/test/java/student/
```

`Main.java` is already provided. Your goal is to make the missing classes work with it.

---

# Part 1 — Abstract hierarchy

## `Vehicle`

Package:

```java
Vehicles
```

Create a `public abstract class Vehicle`.

It must declare these public abstract methods:

```java
public abstract int getWheelOrPropellerCount();
public abstract VehicleCategory getVehicleCategory();
public abstract double travelTime(double distance);
```

### Guidance

- `travelTime(distance)` should return the number of **hours** needed to travel the supplied distance.
- Remember the basic relationship:

```text
time = distance / speed
```

- The base class is a good place for shared validation helpers, but that is optional.

---

# Part 2 — Land vehicles

## `LandVehicle`

Package:

```java
Vehicles.Land
```

It must extend `Vehicle`.

Create a `public abstract class LandVehicle`.

It must declare:

```java
public abstract LandVehicleType getType();
public abstract double getSpeed();
```

It must implement this method as `public final`:

```java
getVehicleCategory()
```

and always return:

```java
VehicleCategory.LAND
```

## `Car`

Package:

```java
Vehicles.Land
```

Constructor:

```java
public Car(double speed)
```

Requirements:

- exactly 4 wheels
- type is `LandVehicleType.CAR`
- speed is the constructor value
- `travelTime(distance)` uses the car's speed

## `Bicycle`

Package:

```java
Vehicles.Land
```

Constructor:

```java
public Bicycle(double speed)
```

Requirements:

- exactly 2 wheels
- type is `LandVehicleType.BICYCLE`
- speed is the constructor value
- `travelTime(distance)` uses the bicycle's speed

---

# Part 3 — Water vehicles

## `WaterVehicle`

Package:

```java
Vehicles.Water
```

It must extend `Vehicle`.

Create a `public abstract class WaterVehicle`.

It must declare:

```java
public abstract WaterVehicleType getType();
public abstract double getSpeed();
```

It must implement `getVehicleCategory()` as `public final` and always return:

```java
VehicleCategory.WATER
```

## `Boat`

Package:

```java
Vehicles.Water
```

Constructor:

```java
public Boat(double speed, int propellers)
```

Requirements:

- type is `WaterVehicleType.BOAT`
- store the number of propellers
- `travelTime(distance)` uses the boat's speed

## `Sailboat`

Package:

```java
Vehicles.Water
```

Constructor:

```java
public Sailboat(double speed)
```

Requirements:

- it must extend `Boat`
- pass `0` propellers to the parent constructor
- type must be `WaterVehicleType.SAILBOAT`
- reuse inherited speed and travel-time behavior

---

# Part 4 — Validation

All speeds must be:

- greater than `0`
- finite
- not `NaN`

Invalid speed values must throw:

```java
IllegalArgumentException
```

`Boat` propellers must be `0` or greater.

`travelTime(distance)` must reject distances that are:

- `0`
- negative
- `NaN`
- positive or negative infinity

with `IllegalArgumentException`.

### Guidance

A helper such as this may reduce repeated code:

```java
protected static double requirePositiveFinite(double value, String name)
```

You do **not** have to use that exact helper.

---

# Part 5 — Enums

Each enum constant must store:

```java
private final String name;
private final String description;
```

Each enum must provide:

```java
public String getName()
public String getDescription()
public String toString()
```

`toString()` must return the display name.

## `VehicleCategory`

Package:

```java
Vehicles.Enums
```

| Constant | Display name | Description |
|---|---|---|
| `LAND` | `Land` | `A vehicle designed primarily for travel on land.` |
| `WATER` | `Water` | `A vehicle designed primarily for travel on water.` |

## `LandVehicleType`

Package:

```java
Vehicles.Land.Enums
```

| Constant | Display name | Description |
|---|---|---|
| `CAR` | `Car` | `A four-wheeled motor vehicle.` |
| `BICYCLE` | `Bicycle` | `A two-wheeled human-powered vehicle.` |

## `WaterVehicleType`

Package:

```java
Vehicles.Water.Enums
```

| Constant | Display name | Description |
|---|---|---|
| `BOAT` | `Boat` | `A powered water vehicle.` |
| `SAILBOAT` | `Sailboat` | `A boat primarily propelled by sails.` |

---

# Part 6 — Encapsulation

Any instance fields that store constructor data must be:

```java
private final
```

Do not expose mutable public fields.

---

# Part 7 — Main program

`Main.java` is already provided.

It creates:

- one `Car`
- one `Bicycle`
- one `Boat`
- one `Sailboat`

and stores them through abstract references.

This is intentional: the assignment is testing **polymorphism**.

Do not put your formulas or main logic into `Main.java`.

---

# Suggested order

1. Create the three enums.
2. Create `Vehicle`.
3. Create `LandVehicle` and `WaterVehicle`.
4. Implement `Car` and `Bicycle`.
5. Implement `Boat`.
6. Implement `Sailboat` using inheritance.
7. Run the tests.
8. Fix one failing category at a time.

---

# Helpful thinking prompts

Before coding each class, ask yourself:

- What is the direct parent class?
- Which methods are already inherited?
- Which abstract methods do I still have to implement?
- Which values belong in fields?
- Can I reuse a parent implementation instead of rewriting it?
- Should this method be overridden?
- Is validation happening before the value is stored?

---

# Running the assignment

From the `Assignment` folder:

```bash
mvn test
```

To run the demonstration program:

```bash
mvn compile exec:java
```

Your goal is to make all instructor tests pass.

## Challenge rule

Try not to open the instructor tests immediately. Start from the README. If you get stuck, use a failing test name as a hint before reading the whole test.
