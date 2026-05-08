# StackDrop

A Fabric mod for **Minecraft Java 26.1.2** that makes every block you mine and every mob you kill drop a full stack (64) of items instead of the usual amount.

- Works in any game mode, any difficulty, cheats on or off.
- Server-side only — no client installation required on vanilla clients connecting to a modded server.

## Requirements

| Component | Version |
|---|---|
| Minecraft Java Edition | 26.1.2 |
| Fabric Loader | ≥ 0.19.2 |
| Fabric API | 0.148.0+26.1.2 |
| Java | 25+ |

## Building

```bash
./gradlew build
```

The compiled JAR will be in `build/libs/`. Drop it (and Fabric API) into your `mods/` folder.

## How it works

A single Mixin on `LootTable#getRandomItems` intercepts the list of `ItemStack`s produced by any loot table roll — before the items are spawned in the world — and sets each stack's count to its maximum (`getMaxStackSize()`). Because both block drops and mob drops go through loot tables, one mixin covers everything.
