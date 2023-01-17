# RedSorcery

A Minecraft Spigot plugin that adds rituals to interact with the world aswell as players and their tools.

# Permissions
## Commands
## Rituals
These permissions allow the use of rituals
|Ritual|Node|Description|
|----|:----:|------|
| Halt Rain | redsorcery.rituals.haltrain | |
| Kill Server | redsorcery.rituals.killserver | |
| Kill Server Head | redsorcery.rituals.killserver.head | This permission needs to be given to any player/group that when their head is sacrified to the kill server ritual it is allowed to function |

# Rituals
All Rituals are activated by growing a sapling on the moss block.\
All rituals must be built with the top being north

X = Moss Block\
Y = Sapling\
' ' = Any Block (indicated by white concrete in pictures)

## Halt Rain
A ritual that stops the rain or a storm in the current world.
![Halt Rain Layout](assets/halt_rain.png)

A = AIR Blocks\
C = Stone Brick Blocks\
R = Redstone Wire

From north to south\
First Layer\
{ ' ', 'C', 'C', 'C', ' ' },\
{ 'C', 'C', ' ', 'C', 'C' },\
{ 'C', ' ', 'X', ' ', 'C' },\
{ 'C', 'C', ' ', 'C', 'C' },\
{ ' ', 'C', 'C', 'C', ' ' }\
Second Layer (1 block above last)\
{ ' ', 'R', 'R', 'R', ' ' },\
{ 'R', 'R', 'A', 'R', 'R' },\
{ 'R', 'A', 'Y', 'A', 'R' },\
{ 'R', 'R', 'A', 'R', 'R' },\
{ ' ', 'R', 'R', 'R', ' ' }
## Kill Server
This ritual will stop the server running, to activate it the player head of a player with the correct permissions (listed below) is required to be thrown into the area.
![Kill Server Layout level 0](assets/kill_server_level0.png)
![Kill Server Layout level 1](assets/kill_server_level1.png)

A = AIR Blocks\
C = Netherite Blocks\
B = Ancient Debris Blocks\
R = Diamond Blocks

From north to south\
First Layer\
{ ' ', 'C', 'C', 'C', 'C', 'C', ' ', },\
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', },\
{ 'C', ' ', 'R', 'R', 'R', ' ', 'C', },\
{ 'C', ' ', ' ', 'X', ' ', ' ', 'C', },\
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', },\
{ 'C', ' ', ' ', 'R', ' ', ' ', 'C', },\
{ ' ', 'C', 'C', 'C', 'C', 'C', ' ', }\
Second Layer\
{ ' ', 'R', 'R', 'R', 'R', 'R', ' ' },\
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' },\
{ 'R', ' ', 'A', 'A', 'A', ' ', 'R' },\
{ 'R', ' ', 'B', 'Y', 'B', ' ', 'R' },\
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' },\
{ 'R', ' ', 'B', 'A', 'B', ' ', 'R' },\
{ ' ', 'R', 'R', 'R', 'R', 'R', ' ' }