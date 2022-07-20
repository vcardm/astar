# ASTAR

Program that implements the A* algorithm to find a path from any two given nodes.

Steps: 
1. Create a fully-observable environment where there are both pathable and blocked nodes (15 x 15)
2. Get input from the user and an agent must find a good path from their starting node to the goal node
3. The agent must use the A* algorithm to determine its path - Used the Manhattan method for calculating the heuristic
4. Output the envrionment with blocked nodes and path from the start to goal node 

Details: Language: Java version: 17.0.1 IDE: VSCode Imports: No extra imports are needed - Able to run as-is

Sample output:

![astar_output](https://user-images.githubusercontent.com/87623211/180042475-0b144348-6df2-400f-b251-e67e5d1dc540.png)

a. Tests whether the users start and goal node are pathable by ensuring it is not less than 0 for x and y - OCntinues to ask for users input
b. Outputs environment with block nodes and the path at the bottem
