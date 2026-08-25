🧩 Bubble Zilla
A colorful Android puzzle game built with Kotlin and Jetpack Compose, published on Google Play, and monetized with Google AdMob.







Understand the project in 30 seconds
Bubble Zilla is a native Android puzzle game designed for short, engaging brain-training sessions. The application uses Kotlin and Jetpack Compose for its interface and game screens, while Google AdMob provides in-app monetization.

The repository contains both the Android source code and a dedicated brain/ knowledge base covering product requirements, architecture, setup, monetization, releases, and future development.

Project detail	Value
Product	Bubble Zilla puzzle game
Platform	Android
Language	Kotlin
UI toolkit	Jetpack Compose
Monetization	Google AdMob
Package ID	com.Startupzilla.bubblezilla
Distribution	Google Play
Project status	Published
Technical documentation	brain/
Highlights
Native Android puzzle-game experience

Modern declarative interface with Jetpack Compose

Clear separation between UI, game state, and puzzle logic

Google AdMob integration for monetization

Debug and signed release build support

Production distribution through Google Play

Structured documentation for developers and AI coding assistants

How the application works
flowchart TD
    A["Player input"] --> B["Jetpack Compose UI"]
    B --> C["Puzzle and game logic"]
    C --> D["Game state"]
    D --> B
    B --> E["Google AdMob"]
The player interacts with a puzzle through the Compose interface.

User actions are passed to the game-logic layer.

The logic validates the action and updates the current game state.

Compose observes the state change and redraws only the affected UI.

AdMob remains isolated from the puzzle rules and handles supported ad placements.

Detailed flows and design decisions are documented in brain/architecture.md and brain/prd.md.

Technology stack
Area	Technology	Responsibility
Application	Native Android	Runs the game on supported Android devices
Programming language	Kotlin	Application and puzzle logic
User interface	Jetpack Compose	Screens, components, state-driven rendering, and theming
Build system	Gradle	Dependencies, build variants, testing, and release bundles
Monetization	Google AdMob	In-app advertisements
Distribution	Google Play Console	Testing and production releases
Documentation	Markdown	Product, architecture, setup, and operational knowledge
Exact SDK versions and dependencies belong in brain/trd.md, which should remain the authoritative technical reference.

Repository structure
Bubble-Zilla-Puzzle-Game/
├── app/                     # Main Android application module
│   └── src/
│       ├── main/            # Kotlin source code and Android resources
│       ├── test/            # Local unit tests
│       └── androidTest/     # Instrumented Android tests
├── brain/                   # Project knowledge base and technical documentation
│   ├── README.md            # Documentation index
│   ├── brain.md             # Main technical blueprint
│   ├── prd.md               # Product requirements and user flows
│   ├── trd.md               # Technical requirements and versions
│   ├── architecture.md      # Architecture and data flow
│   ├── monetization.md      # AdMob strategy and implementation notes
│   ├── roadmap.md           # Completed, planned, and future work
│   ├── api.md               # Integration and API reference
│   ├── setup.md             # Local setup, signing, and test configuration
│   └── changelog.md         # Release history
├── gradle/                  # Gradle wrapper configuration
├── build.gradle.kts         # Root build configuration
├── settings.gradle.kts      # Project and module configuration
├── gradle.properties        # Gradle project properties
├── .gitignore               # Files excluded from version control
└── README.md                # Project overview
The tree describes the intended top-level organization. Keep it synchronized with the repository whenever files or modules are renamed.

Documentation index
The brain/ directory is the single source of truth for project documentation.

Document	What it explains
brain.md	Main technical blueprint, stack, repository structure, and AdMob overview
prd.md	Product requirements, user stories, features, UX flows, and product direction
trd.md	SDK versions, dependencies, signing requirements, and build configuration
architecture.md	Components, state flow, boundaries, and architecture decisions
monetization.md	AdMob setup, placement strategy, optimization, and future revenue options
roadmap.md	Completed work, upcoming tasks, and long-term plans
api.md	AdMob and Jetpack Compose integration patterns
setup.md	Prerequisites, cloning, building, signing, and test ad configuration
changelog.md	Version-by-version release history
These Markdown files are intended for both human contributors and AI coding assistants. Update the relevant document whenever a product rule, dependency, architecture decision, or release process changes.

Getting started
Prerequisites
Git

Android Studio

Android SDK versions defined in brain/trd.md

A compatible JDK defined by the project configuration

An Android emulator or physical Android device

Clone the repository
git clone https://github.com/bipulkumar62/Bubble-Zilla-Puzzle-Game.git
cd Bubble-Zilla-Puzzle-Game
Open and run
Open the repository in Android Studio.

Allow Gradle to synchronize the project.

Configure local development values by following brain/setup.md.

Select an emulator or connected Android device.

Run the app configuration.

For command-line builds on Windows PowerShell:

.\gradlew.bat assembleDebug
For macOS or Linux:

./gradlew assembleDebug
Testing
Run local unit tests before opening a pull request:

.\gradlew.bat test
Run instrumented tests with an emulator or Android device connected:

.\gradlew.bat connectedAndroidTest
Test puzzle rules independently from Compose UI wherever possible. Important state transitions, win or failure conditions, level progression, and reward logic should have deterministic tests.

AdMob development rules
Use Google's test ad units during development and automated testing.

Never click production ads to test them.

Keep ad loading and failures separate from puzzle logic.

A failed or unavailable ad must not crash the game or block normal gameplay.

Document every production ad placement in brain/monetization.md.

Follow Google Play and AdMob policies before publishing each release.

Security and repository hygiene
Never commit any of the following:

Signing keystores such as *.jks or *.keystore

Signing passwords or key.properties

Private API credentials or service-account files

Machine-specific local.properties

Local environment files containing secrets

Before every push, check the staged files:

git status
git diff --cached
If a secret was committed, removing the file from the next commit is not sufficient. Revoke or rotate the exposed credential and remove it from Git history.

Release build
Before creating a production bundle:

Update the version code and version name.

Update brain/changelog.md.

Run unit and instrumented tests.

Verify AdMob behavior with approved test configuration.

Review signing and release steps in brain/setup.md.

Build the Android App Bundle.

.\gradlew.bat bundleRelease
The generated bundle is normally available under:

app/build/outputs/bundle/release/
Do not commit the generated bundle or private signing material.

Roadmap
The live roadmap is maintained in brain/roadmap.md. Keep the README focused on the current product; use the roadmap for planned features and long-term ideas.

Contributing
Fork the repository.

Create a focused branch:

git checkout -b feature/short-feature-name
Make one logically grouped change.

Add or update tests and documentation.

Run the relevant test suite.

Open a pull request describing the problem, solution, and verification performed.

Avoid combining unrelated refactors, features, and formatting changes in one pull request.

Google Play
Bubble Zilla is published on Google Play: https://play.google.com/store/apps/details?id=com.Startupzilla.bubblezilla&hl=en-US



License
No open-source license has been declared in this README. Until a LICENSE file is added, the source code remains protected by default and reuse rights are not granted automatically.

