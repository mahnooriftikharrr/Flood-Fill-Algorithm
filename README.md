<!-- 🎨 Animated Header -->

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=26&duration=3000&pause=800&color=00BFFF&center=true&vCenter=true&width=850&lines=🎨+Flood+Fill+Algorithm;Image+Traversal+Using+Queues+in+Java;Custom+Iterator+for+Pixel+Processing+💻" alt="Typing Animation" />
</p>

---

# 🌊 Flood Fill Algorithm – Image Traversal Using Queues in Java

**Flood Fill** (also known as *Bucket Fill*) is an image-processing algorithm that colors all connected pixels of similar color starting from a given seed point the same concept used in tools like the *Paint Bucket* in Photoshop or MS Paint.

This project implements a **Breadth-First Search (BFS)** approach to perform flood-fill operations using a **custom iterator** built with **Queues** in Java.
The algorithm explores neighboring pixels dynamically without scanning the entire image, efficiently filling bounded regions and generating smooth animations of the fill process.

---

## 🎯 Project Goals

* 🧮 Implement a **custom iterator** (`BFSIterator`) to traverse image pixels.
* 🧱 Use a **Queue-based structure** to handle breadth-first traversal.
* 🧠 Create a **robust flood-fill algorithm** using color similarity thresholds.
* 🎨 Experiment with **visual fill effects** and **animated GIF generation**.

---

## ⚙️ How It Works

### 1. 🧩 ImageWalker + BFSIterator

The `ImageWalker` class provides the traversal engine for the image.
It uses a **private inner class**, `BFSIterator`, to explore connected pixels.

* Each time `next()` is called, the iterator:

  1. Retrieves the current pixel location.
  2. Adds its valid neighbors (`right`, `down`, `left`, `up`) to the queue.
  3. Checks that:

     * The pixel is within bounds.
     * It hasn’t been visited.
     * Its color difference is below the threshold.

```java
while (iterator.hasNext()) {
    Point p = iterator.next();
    imageCopy.setRGB(p.x, p.y, fillColor.getRGB());
}
```

---

### 2. 🎨 FloodFill.fill()

This function performs the flood-fill operation:

```java
public static BufferedImage fill(BufferedImage img, Color fillColor,
                                 Point start, double thresh)
```

* Creates a **copy of the original image** using `Utilities.copyImage`.
* Initializes an `ImageWalker` from the start point.
* Iterates through reachable pixels and sets their color.
* Returns a **new image** (preserving the original).

```java
BufferedImage filled = FloodFill.fill(img, Color.blue, new Point(0,0), 0.2);
```

---

### 3. 🧮 Grid Fill

To enhance visual interest, a **gridFill()** variation colors pixels differently based on their position:

```java
public static BufferedImage gridFill(BufferedImage img, Color bgColor, Color gridColor,
                                     Point start, double thresh, int spacing)
```

* Every *nth* pixel (defined by `spacing`) is filled with `gridColor`.
* All others use `bgColor`.
  This produces **creative patterns** and **pixel-grid visuals** for debugging or artistic effect.

---

## 🧠 Data Structures Used

| Data Structure          | Purpose                                          |
| ----------------------- | ------------------------------------------------ |
| 🧱 **Queue**            | Manages pixel exploration order (BFS traversal). |
| 📋 **2D Boolean Array** | Tracks visited pixels to avoid duplication.      |
| 🧩 **BufferedImage**    | Stores pixel data for input/output operations.   |
| 🧮 **Point (java.awt)** | Represents (x, y) coordinates of pixels.         |

---

## 🧪 Example Output

```java
java.awt.Point[x=0,y=3]
java.awt.Point[x=1,y=3]
java.awt.Point[x=0,y=2]
java.awt.Point[x=2,y=3]
java.awt.Point[x=1,y=2]
java.awt.Point[x=0,y=1]
...
```

Resulting Image:

<p align="center">
  <img src="https://media.giphy.com/media/l3vR85PnGsBwu1PFK/giphy.gif" width="350" alt="Flood Fill Animation Example"/>
</p>

---

## 🧩 Key Concepts Demonstrated

✅ **Breadth-First Search (BFS)** traversal
✅ **Iterator Design Pattern** (custom implementation)
✅ **Queue-based frontier expansion**
✅ **Color difference calculation** with thresholds
✅ **Memory management with 2D visited arrays**
✅ **Non-destructive image manipulation**

---

## 🧠 Learning Outcomes

Through this project, I learned to:

* Implement **iterators that manage internal state and data traversal**.
* Design **modular image-processing algorithms**.
* Handle **complex logic flow** using **Queues** and conditionals.
* Optimize performance through **on-demand pixel expansion** instead of pre-processing.
* Understand how **graph traversal maps directly to image problems**.

---

## 💼 Technical Skills Highlighted

| Category               | Tools / Skills                                                 |
| ---------------------- | -------------------------------------------------------------- |
| 💻 **Languages**       | Java                                                           |
| 🧠 **Core Concepts**   | BFS, Iterators, Queues, 2D Arrays, Image Processing            |
| 🧩 **APIs**            | java.awt, java.util.Queue, BufferedImage                       |
| 🎨 **Tools**           | IntelliJ IDEA, GraphicsMagick                                  |
| ⚙️ **Problem Solving** | Graph traversal, custom iterator design, color threshold logic |

---

## 👩🏻‍💻 Author

**Mahnoor Iftikhar**
📍 *Pacific Lutheran University* – Computer Science & Economics, Data Science Minor

📫 [LinkedIn](https://www.linkedin.com/in/mahnooriftikharrr)
📧 [mahnooriftikharr@gmail.com](mailto:mahnooriftikharr@gmail.com)

