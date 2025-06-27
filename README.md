# xv-spawn

Plugin na komende `/spawn` z odliczaniem gdy gracz otrzyma damage autoamtycznie teleportacja zostaje anulowana.

## 🛠️Informacje

Wersja: 1.18.2
Silnik: spigot

## 🚀 Komendy

| Komenda             | Opis                                 | Permisja          |
|---------------------|--------------------------------------|----------------------------|
| `spawn`       | Teleportuje na spawn.       | `xv-spawn.spawn`                |
| `setspawn`         | Ustawia lokalizację spawnu   | `xv-spawn.setspawn`                |

## ⚙️ Plik konfiguracyjny `config.yml`

```yml
location:
  ==: org.bukkit.Location
  world: world
  x: -67.40438965486605
  y: 77.0
  z: 82.05542265944898
  pitch: 57.149906
  yaw: 79.948616
actions:
  title: false
  actionbar: true
teleportTime: 6 # jednostki podajemy w sekundach
title:
  info:
    title: '&6&lSpawn'
    subtitle: '&7zostaniesz przeteleportowany za &6%teleportTime%'
  success:
    title: '&6&lSpawn'
    subtitle: '&aPomyslnie przeteleportowano'
  danger:
    title: '&6&lSpawn'
    subtitle: '&cAnulowano teleportacje'
actionBar:
  info:
    content: '&7Teleportacja rozpocznie sie za &6%teleportTime%'
  success:
    content: '&aPomyslnie przeteleportowano'
  danger:
    content: '&cAnulowano teleportacje'
```

## 🧩 Instalacja pluginu



 1. Pobierz plugin z repozytorium

 2. Pobrany plugin prześlij do folderu `plugins` na twoim serverze

 3. Zrestartuj bądź uruchom server
