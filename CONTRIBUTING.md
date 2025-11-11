# Contributing to RollbaseUtils

Thank you for considering contributing to RollbaseUtils! This document outlines the process for contributing to this project.

## Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/your-username/RollbaseUtils.git
   cd RollbaseUtils
   ```
3. **Create a branch** for your changes:
   ```bash
   git checkout -b feature/your-feature-name
   ```

## Development Environment

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git

### Building the Project

```bash
# Build all modules
cd rollbase-shared-annotations && mvn clean install && cd ..
cd rollbase-shared && mvn clean install && cd ..
cd rollbase-merge && mvn clean install && cd ..

# Run tests (after JUnit 5 migration is complete)
mvn test
```

### Code Style

- Use 4 spaces for indentation (not tabs)
- Follow standard Java naming conventions
- Add JavaDoc comments to public classes and methods
- Keep methods focused and under 50 lines when possible
- Use meaningful variable and method names

## Submitting Changes

1. **Commit your changes** with clear, descriptive messages:
   ```bash
   git commit -m "Add feature: Brief description of your change"
   ```

2. **Push to your fork**:
   ```bash
   git push origin feature/your-feature-name
   ```

3. **Create a Pull Request** from your fork to the main repository

### Pull Request Guidelines

- Provide a clear description of the problem and solution
- Reference any related issues
- Ensure all tests pass
- Update documentation if necessary
- Keep pull requests focused on a single feature or fix

## Reporting Issues

When reporting issues, please include:

- A clear, descriptive title
- Steps to reproduce the problem
- Expected behavior
- Actual behavior
- Your environment (OS, Java version, etc.)
- Any relevant logs or screenshots

## Code of Conduct

### Our Standards

- Be respectful and inclusive
- Welcome diverse perspectives
- Accept constructive criticism gracefully
- Focus on what's best for the community
- Show empathy towards others

### Unacceptable Behavior

- Harassment, discrimination, or offensive comments
- Personal attacks or insults
- Publishing others' private information
- Other conduct which could reasonably be considered inappropriate

## Questions?

If you have questions about contributing, feel free to:

- Open an issue with your question
- Contact the maintainers

Thank you for contributing to RollbaseUtils!
