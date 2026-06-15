<h1 align="center">📱 PhoneContact-BinarySearch</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Algorithm-Binary%20Search-blue?style=for-the-badge" alt="Algorithm" />
  <img src="https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge" alt="Contributions Welcome" />
</p>

<p align="center">
  A smart, console-based Phone Contact Manager built in Java that leverages the power of <strong>Binary Search</strong> for blazing-fast <code>O(log n)</code> name lookups. Perfect for learning and DAA (Design and Analysis of Algorithms) Lab demonstrations! 🚀
</p>

## ✨ Features

- ⚡ **`O(log n)` Lookups**: Implements Binary Search for highly efficient contact retrieval, ensuring fast searches even with large contact lists.
- 🎓 **Educational Mode**: Displays each step of the search process (`low`, `mid`, and `high` indices) to help visualize how Binary Search works in real-time.
- 🗂️ **Sorted Insertion**: Automatically maintains contacts in strict alphabetical order upon entry.
- ✅ **Data Validation**: Includes robust phone number validation to ensure accurate data entry.
- 🛡️ **Duplicate Prevention**: Intelligently prevents duplicate names/numbers to keep your contact list clean.

## 🛠️ Technologies Used

- **Language:** Java
- **Core Algorithm:** Binary Search
- **Paradigm:** Console-based Application / Object-Oriented Programming

## 🚀 Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) 8 or higher installed on your machine.

### Installation & Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Subhash757/PhoneContact-BinarySearch.git
   ```

2. **Navigate to the directory:**
   ```bash
   cd PhoneContact-BinarySearch
   ```

3. **Compile the Java file:**
   ```bash
   javac PhoneContactBinarySearch_1.java
   ```

4. **Run the application:**
   ```bash
   java PhoneContactBinarySearch_1
   ```

## 💡 How It Works (The Algorithm)

When you search for a contact, the system doesn't check every single name. Instead, it uses the **Divide and Conquer** technique:
1. Finds the `mid` point of the sorted contact list.
2. Compares the target name with the `mid` element.
3. If they match, the contact is found!
4. If the target is alphabetically before the `mid` element, it discards the right half and searches the left.
5. If after, it discards the left half and searches the right.

*The application prints these specific steps (`low`, `mid`, `high`) in the console so you can see the algorithm in action!*

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/Subhash757/PhoneContact-BinarySearch/issues).

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

Distributed under the MIT License. See `LICENSE` for more information.

---
<p align="center">
  If you found this helpful or learned something new, don't forget to give it a ⭐ on GitHub!
</p>
