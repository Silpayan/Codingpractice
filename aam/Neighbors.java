package aam;

import java.util.ArrayList;

import java.util.List;

public class Neighbors {

	public static void main(String[] s) {
		
		int states[] = {0,1,0,1,0,1,1,0};
		
		int days = 0; 
		//System.out.println("provide Input :");
		
		//int count= keyboard.nextInt();
		
		//If the nieghbors on the both the sides of a cell either active or inactive the cell 
		//becomes inactive on the  next day, 010 to 000 and 101 to 101, 000 to 000 111 to 111
		//otherwise the cell become active 100 to 110 and 001 to 011
		//The two cells on each end have a single adjacent cell
		//so assume that the unoccupied space on the opposite side is an inactive cell,
		//Even after updating the cells state, consider its previous state when updating the state of other cells
		
		//0 Day 1,0,0,0,1,0,1 would become
		//1 Day 0,1,0
		
		//if both side same it becomes inactive 
		//else activate 
		//position -1 and n is always 0
		
		int i = 0, j = 0, houseNum = 1,prevStofPrevHouse =0, prevStofCurrentHouse =  states[0];
		
		System.out.print("Initial Day Status of Hosues are : " );
		for(i=0;i<states.length-1; i++)
			System.out.print(states[i]+", ");
		System.out.print(states[i]+"\n");

		
		for(i=0;i<days; i++) {
			prevStofPrevHouse = states[0];
			states[0] = 0^states[1];
			
			for(houseNum = 1 ;houseNum < states.length-1; houseNum++) {
				//do XOR
				System.out.print(houseNum+", ");
				prevStofCurrentHouse =states[houseNum];
				states[houseNum] = prevStofPrevHouse^states[houseNum+1];
				prevStofPrevHouse=prevStofCurrentHouse;
			}
			
			
			states[houseNum] = prevStofPrevHouse^0;
			
			System.out.print(houseNum+", "+states[houseNum]+"\n");
			
			System.out.print("After Day "+ (i+1) +" Status of Hosues are : " );
			for(j=0;j<states.length-1; j++)
				System.out.print(states[j]+", ");
			System.out.print(states[j]+"\n");
		}
		
		List<Integer> lastStates = new ArrayList();
		for(j=0;j<states.length; j++) {
			System.out.print(states[j]+", ");
			lastStates.add(states[j]);
		}
		
		System.out.println(lastStates);
	}
	
}
