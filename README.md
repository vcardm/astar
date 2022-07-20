# ASTAR

Program that implements the A* algorithm to find a path from any two given nodes.

Steps: 
1. Create a fully-observable environment where there are both pathable and blocked nodes (15 x 15)
2. Get input from the user and an agent must find a good path from their starting node to the goal node
3. The agent must use the A* algorithm to determine its path - Used the Manhattan method for calculating the heuristic
4. Output the envrionment with blocked nodes and path from the start to goal node 

Details: Language: Java version: 17.0.1 IDE: VSCode Imports: No extra imports are needed - Able to run as-is

Sample output:


![astar_output00](https://user-images.githubusercontent.com/87623211/180060852-a465f8e2-9789-4ed8-858a-b9a5751d62e2.png)

![astar_output01](https://user-images.githubusercontent.com/87623211/180060856-8e2863aa-5d06-4814-85fc-aba4d38bf1c1.png)



a. Tests whether the users start and goal node are pathable by ensuring it is not less than 0 for x and y - Continuously ask for users input 
b. Outputs environment with block nodes and the path at the bottem
