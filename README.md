# xvd-spawn

Plugin na komende `/spawn` z odliczaniem gdy gracz otrzyma damage autoamtycznie teleportacja zostaje anulowana.

## 🚀 Komendy

| Komenda             | Opis                                 | Permisja          |
|---------------------|--------------------------------------|----------------------------|
| `spawn`       | Teleportuje na spawn.       | `xvd-spawn.spawn`                |
| `setspawn`         | Ustawia lokalizację spawnu   | `xvd-spawn.setspawn`                |
| `xvd-spawn reload`     | przeładowuje plik konfiguracyjny| `xvd-spawn.reload`            |

## ⚙️ Plik konfiguracyjny `config.yml`

```yml
location:
  ==: org.bukkit.Location
  world: world
  x: -103.44915619893438
  y: 70.0
  z: 111.90265031467231
  pitch: 67.500114
  yaw: 31.20007
actions:
  title: true
  actionbar: false
teleportTime: 6 # jednostki podajemy w sekundach
title:
  title: '&6&lSpawn'
  subtitle: '&7zostaniesz przeteleportowany za &6%teleportTime%'
actionBar:
  content: '&7Teleportacja rozpocznie sie za &6%teleportTime%'
```

## 🧩 Instalacja pluginu



 1. Pobierz plugin z repozytorium

 2. Pobrany plugin prześlij do folderu `plugins` na twoim serverze

 3. Zrestartuj bądź uruchom server
