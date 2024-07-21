# Seleinum Testing Project

**This project is a template for setting up a Selenium WebDriver project using Java and Maven. It includes the necessary dependencies and a basic structure to get you started with writing and running automated tests. The behaviour driver development is supported by Cucumber**
### Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK is installed on your machine.
- **Maven**: Make sure Maven is installed and configured.
- **IDE**: (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:

```
git clone https://github.com/hala-samir/AutomatedTestingSuite
```
2. Install dependencies:

```
mvn clean install
```
3. Run tests:
```
mvn test
```
### Project Structure
```
Selenium-maven-project
├── src
│   ├── main
│   │   └── java
|   |       └── pages
│   └── test
│       ├── java
│       │   └── runner
|       |   └── stepDefinition
|       |   └── utilities
│       └── resources
|           └──features 
|           └──testSuites
|           └──testData
├── pom.xml
├── .gitignore
└── README.md
```

### Running Tests

1. Run all tests:
- Go to the project path 
```
mvn test
```

2. Generate TestNG Reports: 
After running the tests, the Reports will be generated in the `target\surefire-reports` directory.

### Cross Browser Testing

These test cases are supported to be run on different browsers (Chrome, Firefox, Edge and Safari).
``` 
mvn test -Dbrowser="browsserName"
```

## Test Case Design

This project includes automated test cases for the following functionalities of a web application: registration, login, add to cart, send a contact message, and logout. Each test case is designed to verify the core functionalities and ensure the application behaves as expected.

### 1. Registration

**Objective**: Verify that a new user can successfully register on the web application.

**Steps**:
1. Navigate to the registration page.
2. Fill in the required fields (e.g. email, password).
3. Submit the registration form.
4. Verify that the user is redirected to a confirmation page or receives a success message.

**Expected Result**: The user should be successfully registered and receive a confirmation message.

### 2. Login

**Objective**: Verify that a registered user can log in to the web application.

**Steps**:
1. Navigate to the login page.
2. Enter valid credentials (username and password).
3. Submit the login form.
4. Verify that the user is redirected to the dashboard or home page.

**Expected Result**: The user should be successfully logged in and redirected to the dashboard or home page.

### 3. Add to Cart

**Objective**: Verify that a user can add items to the shopping cart.

**Steps**:
1. Navigate to the product listing page.
2. Select a product and navigate to the product detail page.
3. Click the "Add to Cart" button.
4. Verify that the product is added to the cart and the cart count is updated.

**Expected Result**: The selected product should be added to the cart, and the cart count should reflect the addition.

### 4. Send a Contact Message

**Objective**: Verify that a user can send a contact message through the contact form.

**Steps**:
1. Navigate to the contact page.
2. Fill in the required fields (e.g., name, email, message).
3. Submit the contact form.
4. Verify that the user receives a confirmation message indicating the message was sent successfully.

**Expected Result**: The user should receive a confirmation message indicating that the contact message was sent successfully.

### 5. Logout

**Objective**: Verify that a logged-in user can log out of the web application.

**Steps**:
1. Ensure the user is logged in.
2. Click the "Logout" button or link.
3. Verify that the user is redirected to the login page or home page and that the session is terminated.

**Expected Result**: The user should be successfully logged out and the signup button is displayed.