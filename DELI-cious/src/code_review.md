### ✅ **What’s Working Well**

1. **Project Structure**: Your project uses packages and class organization consistent with OOP principles from Workbook 4. Each class seems to handle a specific responsibility—good encapsulation!

2. **Use of Inheritance**: You correctly use inheritance with `extends`, following the workbook guidance on reducing code duplication and promoting reusability (Workbook 5).

3. **String and Loop Logic**: Your use of `StringBuilder`, `split()`, and loop structures to manipulate text is in line with Workbook 2 examples and shows good grasp of Java string handling.

---

### ⚠️ **Areas for Improvement**

1. **Class Responsibility and Cohesion**

    * Some classes are handling both UI and business logic, such as prompting the user and manipulating domain data in the same class. This tightly couples your input/output logic with your domain logic, which makes it harder to maintain or test. Consider moving input logic to a separate `Main` or `UI` class.

2. **Constructor Overuse**

    * Several constructors are overloaded, which is okay, but some logic inside constructors could be delegated to helper methods. Keep constructors simple and focused on object creation only.

3. **Method Naming**

    * Stick with action-based method names (`calculateTotal`, `displayResults`, etc.). Avoid vague names like `doStuff()` or `process()` unless the context makes it very clear.

4. **Magic Numbers and Strings**

    * Avoid hardcoded values. Use constants (e.g., `private static final int MAX_RETRIES = 3;`). This makes your code easier to maintain and understand.

---

### 🛠️ Suggestions

* **Refactor for Testability**: If you isolate your business logic into its own class and avoid `Scanner` usage inside that logic, it becomes much easier to write unit tests using JUnit (Workbook 4, Module 3).

* **Leverage IntelliJ**: Use **Alt+Enter** to apply quick fixes and **Ctrl+Alt+L** to auto-format your code for readability. Use **Shift+Shift** to search classes and **Ctrl+Shift+F10** to quickly run your application.

* **Code Comments**: While your code has some comments, aim for concise, meaningful ones that explain *why* something is done—not *what* is done (the code already shows that).