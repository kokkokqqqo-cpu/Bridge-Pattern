# Assignment 3 | Bridge Pattern

**Student:** Azhikhat Nurai   
**Group:** SE2523  
**Topic:** Option A (Drawing: Shape & Renderer)  
**Repository URL:** https://github.com/kokkokqqqo-cpu/Bridge-Pattern/tree/main  
**Base Commit Hash:** `5573295ea564a309e2357c50b86bb09e193ef554`  

---

## Role Mapping Table

| Role | Class Name | Source Path |
| :--- | :--- | :--- |
| **Abstraction** | `Shape` | `src/Shape.java` |
| **Refined Abstraction A1** | `Circle` | `src/Circle.java` |
| **Refined Abstraction A2** | `Square` | `src/Square.java` |
| **Implementor** | `Renderer` | `src/Renderer.java` |
| **Concrete Implementor I1** | `VectorRenderer` | `src/VectorRenderer.java` |
| **Concrete Implementor I2** | `RasterRenderer` | `src/RasterRenderer.java` |
| **Concrete Implementor I3** | `AsciiRenderer` | `src/AsciiRenderer.java` |
| **Client** | `Main` | `src/Main.java` |

---

## Key Method Locations

- **Bridge Field (`renderer`):** `src/Shape.java` (`protected Renderer renderer;`)
- **`execute()` Operation:** Defined in `src/Shape.java`, implemented in `src/Circle.java` and `src/Square.java`.
- **`setImplementation(...)` Method:** Defined in `src/Shape.java`.
- **T5 Runtime Switch Check:** Located in `src/Main.java` inside `runDemo()`.

---

## Build and Run Commands

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

---

## Expected Outcomes (T1-T7)

- **T1:** `Circle + VectorRenderer` -> `"Vector render of Circle [ID=1] with radius 2.0"`
- **T2:** `Circle + RasterRenderer` -> `"Raster render of Circle [ID=1] with radius 2.0"`
- **T3:** `Square + VectorRenderer` -> `"Vector render of Square [ID=2] with side 3.0"`
- **T4:** `Square + RasterRenderer` -> `"Raster render of Square [ID=2] with side 3.0"`
- **T5:** Runtime Switch on `Circle` from `VectorRenderer` to `RasterRenderer` (`sameObject=true`, `stateUnchanged=true`).
- **T6:** `Circle + AsciiRenderer` -> `"ASCII render of Circle [ID=1] with radius 2.0"`
- **T7:** `Square + AsciiRenderer` -> `"ASCII render of Square [ID=2] with side 3.0"`
