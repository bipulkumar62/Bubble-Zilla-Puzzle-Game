<div align="center">

<h1>🧩</h1>

<p><strong>A colorful Android puzzle game built to challenge logic, focus, and problem-solving.</strong></p>

<p>
  <img src="https://img.shields.io/badge/Android-Native-3DDC84?logo=android&logoColor=white" alt="Android">
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/Jetpack-Compose-4285F4?logo=jetpackcompose&logoColor=white" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Google-AdMob-EA4335?logo=googleadmob&logoColor=white" alt="Google AdMob">
</p>

<p>
  <a href="https://play.google.com/store/apps/details?id=com.Startupzilla.bubblezilla"><strong>▶ View on Google Play</strong></a>
  ·
  <a href="./brain/README.md"><strong>📚 Read the Documentation</strong></a>
</p>

</div>

---

## 🎮 What is Bubble Zilla?

**Bubble Zilla** is a native Android puzzle game created for short and engaging brain-challenge sessions. Players interact with puzzles through a clean mobile interface while the game logic validates each action and updates the current game state.

The project is built with **Kotlin** and **Jetpack Compose**, uses **Google AdMob** for monetization, and is published on the **Google Play Store**.

## ⚡ Project at a glance

| | Details |
| --- | --- |
| **App name** | Bubble Zilla |
| **Category** | Puzzle game |
| **Platform** | Android |
| **Language** | Kotlin |
| **UI framework** | Jetpack Compose |
| **Monetization** | Google AdMob |
| **Package name** | `com.Startupzilla.bubblezilla` |
| **Status** | Published on Google Play |

## ✨ Highlights

- Interactive puzzle-based gameplay
- Clean and responsive Android interface
- State-driven UI powered by Jetpack Compose
- Puzzle logic kept separate from UI code
- Google AdMob integration
- Debug and signed release builds
- Complete technical documentation inside `brain/`
- Production release available on Google Play

## 🔄 How it works

```text
Player Action
     ↓
Jetpack Compose UI
     ↓
Puzzle Logic
     ↓
Game State Updated
     ↓
UI Automatically Refreshes
```

1. The player performs an action inside the puzzle screen.
2. The UI sends that action to the puzzle logic.
3. The logic validates the move and updates the game state.
4. Jetpack Compose observes the new state and refreshes the interface.
5. AdMob handles supported ad placements independently of the game rules.

## 🛠 Tech stack

| Technology | Purpose |
| --- | --- |
| **Kotlin** | Application and puzzle logic |
| **Jetpack Compose** | Screens, components, themes, and state-based UI |
| **Gradle** | Dependencies, builds, tests, and release bundles |
| **Google AdMob** | In-app advertisement monetization |
| **Google Play Console** | Testing and production distribution |
| **Markdown** | Product and technical documentation |

Exact SDK versions and dependencies are documented in [`brain/trd.md`](./brain/trd.md).

## 📁 Repository structure

```text
Bubble-Zilla-Puzzle-Game/
├── app/                       # Main Android application
│   └── src/
│       ├── main/              # Kotlin source code and resources
│       ├── test/              # Unit tests
│       └── androidTest/       # Android instrumented tests
├── brain/                     # Complete project documentation
│   ├── README.md              # Documentation index
│   ├── brain.md               # Main technical blueprint
│   ├── prd.md                 # Product requirements
│   ├── trd.md                 # Technical requirements
│   ├── architecture.md        # Architecture and data flow
│   ├── monetization.md        # AdMob strategy
│   ├── roadmap.md             # Development roadmap
│   ├── api.md                 # Integration reference
│   ├── setup.md               # Setup and build guide
│   └── changelog.md           # Release history
├── gradle/                    # Gradle wrapper files
├── build.gradle.kts           # Root build configuration
├── settings.gradle.kts        # Project configuration
├── gradle.properties          # Gradle properties
├── .gitignore                 # Ignored files
└── README.md                  # Project overview
```

## 🧠 Project documentation

The `brain/` folder is the **single source of truth** for product and technical decisions. It is written for both developers and AI coding assistants.

| Document | Purpose |
| --- | --- |
| [`brain.md`](./brain/brain.md) | Project blueprint, stack, structure, and AdMob overview |
| [`prd.md`](./brain/prd.md) | Features, user stories, UX flows, and product requirements |
| [`trd.md`](./brain/trd.md) | SDK versions, dependencies, signing, and build configuration |
| [`architecture.md`](./brain/architecture.md) | Components, game-state flow, and design decisions |
| [`monetization.md`](./brain/monetization.md) | AdMob setup, placements, and monetization strategy |
| [`roadmap.md`](./brain/roadmap.md) | Completed work, upcoming tasks, and future plans |
| [`api.md`](./brain/api.md) | Jetpack Compose and AdMob integration patterns |
| [`setup.md`](./brain/setup.md) | Installation, local setup, testing, and release signing |
| [`changelog.md`](./brain/changelog.md) | Version-by-version release history |

## 🚀 Run locally

### Requirements

- Git
- Android Studio
- Android SDK and JDK versions listed in `brain/trd.md`
- Android emulator or physical device

### Installation

```bash
git clone https://github.com/bipulkumar62/Bubble-Zilla-Puzzle-Game.git
cd Bubble-Zilla-Puzzle-Game
```

Open the project in Android Studio, allow Gradle to finish syncing, select a device, and run the `app` configuration.

### Build from PowerShell

```powershell
.\gradlew.bat assembleDebug
```

### Run unit tests

```powershell
.\gradlew.bat test
```

### Create a release bundle

```powershell
.\gradlew.bat bundleRelease
```

The release bundle is generated inside:

```text
app/build/outputs/bundle/release/
```

Read [`brain/setup.md`](./brain/setup.md) before creating a signed production build.

## 📢 AdMob rules

- Always use Google test ads during development.
- Never click production ads for testing.
- An unavailable ad must never crash or block the game.
- Keep advertisement code separate from puzzle logic.
- Document every production placement in `brain/monetization.md`.

## 🔐 Security

Never commit:

- `*.jks` or `*.keystore`
- `key.properties`
- Signing passwords
- Private API credentials
- Service-account files
- `local.properties`

Check files before every commit:

```bash
git status
git diff --cached
```

## 🤝 Contributing

1. Fork the repository.
2. Create a branch: `git checkout -b feature/feature-name`
3. Make one focused change.
4. Add or update tests and documentation.
5. Open a pull request explaining what changed and how it was tested.

## 🗺 Roadmap

Completed features, upcoming improvements, and long-term plans are maintained in [`brain/roadmap.md`](./brain/roadmap.md).

## 📄 License

No open-source license has been declared yet. Until a `LICENSE` file is added, reuse and redistribution rights are not granted automatically.

## 👨‍💻 Developer

Developed and maintained by **Bipul Kumar**.

- GitHub: [@bipulkumar62](https://github.com/bipulkumar62)
- Repository: [Bubble-Zilla-Puzzle-Game](https://github.com/bipulkumar62/Bubble-Zilla-Puzzle-Game)
- Google Play: [Download Bubble Zilla](https://play.google.com/store/apps/details?id=com.Startupzilla.bubblezilla)

---

<div align="center">
  <strong>If Bubble Zilla helped you, consider giving the repository a ⭐.</strong>
</div>
