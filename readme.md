# Autocomplete

This project was completed in **Fall 2022** for the **COS226 Algorithms and Data Structures** course. More information can be found here:

https://www.cs.princeton.edu/courses/archive/spring25/cos226/assignments/autocomplete/specification.php

This project implements an **autocomplete system** that suggests query strings based on a given prefix. Each query string is associated with a non-negative weight, and results are displayed in **descending order of weight**.

## Features
* **Efficient Search**: Finds matching queries using **binary search**.
* **Sorting by Weight**: Returns results in decreasing order of frequency or importance.
* **Performance Optimization**: Designed for **fast autocomplete suggestions** with minimal delay.


## How to Run the Code

### 1. Compile the Program
Visualize Autocomplete for any of the following files: cities.txt, actors.txt, artist.txt, etc.
```bash
java-algs4 AutocompleteGUI.java cities.txt 7 
```

