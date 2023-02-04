# RedSorcery

A Minecraft Spigot plugin that adds rituals to interact with the world aswell as players and their tools.

# Permissions
## Commands
## Rituals
These permissions allow the use of rituals
|Ritual|Node|Description|
|----|:----:|------|
| Modify Weather | redsorcery.rituals.modweather | |
| Kill Server | redsorcery.rituals.killserver | |
| Kill Server Head | redsorcery.rituals.killserver.head | This permission needs to be given to any player/group that when their head is sacrified to the kill server ritual it is allowed to function |
| Ritual of Enchantment | redsorcery.rituals.enchant | |

# Rituals
All Rituals are activated by growing a sapling on the moss block.\
All rituals must be built with the top being north

X = Moss Block\
Y = Sapling\
' ' = Any Block (indicated by white concrete in pictures)

## Modify Weather
A ritual that stops the rain or a storm in the current world.
![Modify Weather Layout](assets/halt_rain.png)

If a water bucket is dropped into the area, it will start the rain instead of stopping.

<details><summary>Text Based Instructions</summary>
<pre>
A = AIR Blocks
C = Stone Brick Blocks
R = Redstone Wire<br>

From north to south
First Layer
{ ' ', 'C', 'C', 'C', ' ' }
{ 'C', 'C', ' ', 'C', 'C' }
{ 'C', ' ', 'X', ' ', 'C' }
{ 'C', 'C', ' ', 'C', 'C' }
{ ' ', 'C', 'C', 'C', ' ' }
Second Layer (1 block above last)
{ ' ', 'R', 'R', 'R', ' ' }
{ 'R', 'R', 'A', 'R', 'R' }
{ 'R', 'A', 'Y', 'A', 'R' }
{ 'R', 'R', 'A', 'R', 'R' }
{ ' ', 'R', 'R', 'R', ' ' }
</pre>
</details>

## Ritual of Enchantment
A ritual that allows enchanting multiple items at once using books without consuming the books.
The beacon needs to have an active effect.
Consumes the amethyst clusters every operation.
<details><summary>Building Images</summary>

![Ritual of Enchantment Layout level 0](assets/enchantment_level0.png)
![Ritual of Enchantment Layout level 1](assets/enchantment_level1.png)
![Ritual of Enchantment Layout level 2](assets/enchantment_level2.png)
![Ritual of Enchantment Layout level 3](assets/enchantment_level3.png)
![Ritual of Enchantment Layout level 4](assets/enchantment_level4.png)
![Ritual of Enchantment Layout level 5](assets/enchantment_level5.png)
![Ritual of Enchantment Layout level 5 amethyst](assets/enchantment_level5_amethyst.png)
![Ritual of Enchantment Layout level 6](assets/enchantment_level6.png)
![Ritual of Enchantment Layout level 7](assets/enchantment_level7.png)
![Ritual of Enchantment Layout level 8](assets/enchantment_level8.png)
</details>
<details><summary>Text Based Instructions</summary>

<pre>
'S' = STONE_BRICKS
'P' = QUARTZ_PILLAR
'T' = ENCHANTING_TABLE
'D' = DEEPSLATE_TILES
'A' = POLISHED_BLACKSTONE_BRICK_STAIRS
'Q' = QUARTZ_STAIRS
'B' = BEACON
'C' = AMETHYST_CLUSTER
'E' = CHISELED_QUARTZ_BLOCK
'N' = NETHERITE_BLOCK
<br>

From north to south
First Layer
{ ' ', ' ', ' ', 'S', 'S', 'S', 'S', 'S', ' ', ' ', ' ' }
{ ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', 'S', ' ', ' ' }
{ ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'S', ' ' }
{ 'S', ' ', ' ', 'D', 'D', 'D', 'D', 'D', ' ', ' ', 'S' }
{ 'S', ' ', ' ', 'D', 'A', 'A', 'A', 'D', ' ', ' ', 'S' }
{ 'S', ' ', ' ', 'D', 'A', 'X', 'A', 'D', ' ', ' ', 'S' }
{ 'S', ' ', ' ', 'D', 'A', 'A', 'A', 'D', ' ', ' ', 'S' }
{ 'S', ' ', ' ', 'D', 'D', 'D', 'D', 'D', ' ', ' ', 'S' }
{ ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'S', ' ' }
{ ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', 'S', ' ', ' ' }
{ ' ', ' ', ' ', 'S', 'S', 'S', 'S', 'S', ' ', ' ', ' ' }
Second Layer
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', 'T', ' ', ' ', ' ', ' ', ' ', 'T', ' ', ' ' }
{ 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', 'Y', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' }
{ ' ', ' ', 'T', ' ', ' ', ' ', ' ', ' ', 'T', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
Third Layer
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
Fourth Layer
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'P', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', 'P' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'P', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', 'P' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
Fifth Layer
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ 'Q', 'E', 'Q', ' ', ' ', ' ', ' ', ' ', 'Q', 'E', 'Q' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ 'Q', 'E', 'Q', ' ', ' ', ' ', ' ', ' ', 'Q', 'E', 'Q' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
Sixth Layer
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' }
{ ' ', 'Q', 'E', 'C', ' ', ' ', ' ', 'C', 'E', 'Q', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', 'Q', 'E', 'C', ' ', ' ', ' ', 'C', 'E', 'Q', ' ' }
{ ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
Seventh Layer
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', 'Q', 'N', ' ', ' ', ' ', 'N', 'Q', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', 'Q', 'N', ' ', ' ', ' ', 'N', 'Q', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
Eigth Layer
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', 'Q', 'Q', 'Q', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', 'Q', 'Q', 'Q', 'Q', 'Q', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
Ninth Layer
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', 'B', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
</pre>
</details>

## Kill Server
This ritual will stop the server running, to activate it, the player head of a player with the correct permissions (listed above) is required to be thrown into the area.
<details><summary>Building Images</summary>

![Kill Server Layout level 0](assets/kill_server_level0.png)
![Kill Server Layout level 1](assets/kill_server_level1.png)
</details>

<details><summary>Text Based Instructions</summary>
<pre>
A = AIR Blocks
C = Netherite Blocks
B = Ancient Debris Blocks
R = Diamond Blocks<br>

From north to south
First Layer
{ ' ', 'C', 'C', 'C', 'C', 'C', ' ', }
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', }
{ 'C', ' ', 'R', 'R', 'R', ' ', 'C', }
{ 'C', ' ', ' ', 'X', ' ', ' ', 'C', }
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', }
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', }
{ ' ', 'C', 'C', 'C', 'C', 'C', ' ', }
Second Layer
{ ' ', 'R', 'R', 'R', 'R', 'R', ' ' }
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' }
{ 'R', ' ', 'A', 'A', 'A', ' ', 'R' }
{ 'R', ' ', 'B', 'Y', 'B', ' ', 'R' }
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' }
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' }
{ ' ', 'R', 'R', 'R', 'R', 'R', ' ' }
</pre>
</details>