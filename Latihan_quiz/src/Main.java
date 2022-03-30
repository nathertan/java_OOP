import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	int flag = 0;
	ArrayList<Route>routeData = new ArrayList<>();
	
	public Main() {
		int input_menu = 0;

		do {
			System.out.println("BlueJack Station");
			System.out.println("=================");
			System.out.println("1. Insert route");
			System.out.println("2. View routes");
			System.out.println("3. Update route");
			System.out.println("4. Exit");
			System.out.print(">>");
			
			input_menu = scan.nextInt();
			scan.nextLine();
			
			switch (input_menu) {
			case 1:
				addRoute();
				break;
			case 2:
				viewRoute();
				break;
			case 3:
				updateRoute();
				break;
			case 4:
				return;
			}
		}while(input_menu < 1 || input_menu != 4);
		
		
	}

	public String generateID() {
		return ("BJ" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10));
	}
	
	void addRoute() {
		// TODO Auto-generated method stub
		System.out.print("Input route destination [Jakarta | Bogor | Depok | Tanggerang | Bekasi] (case sensitive): " + "");
		String destination = scan.nextLine();
		scan.nextLine();
		System.out.print("Input route distance [1...1000]:" + "");
		Integer distance = scan.nextInt();
		scan.nextLine();
		String genID = generateID();
		int routePrice = ((distance/2 * 1000) + 10000);
		Route temp = new Route(destination, distance, genID, routePrice);
		routeData.add(temp);
		System.out.println("Successfully added new route!\nPress Enter to continue...");
		scan.nextLine();
		flag++;
		
	}
		
	void  viewRoute() {
		if(routeData.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			return;
		}
		System.out.println("=====================================================");
		System.out.println("|  ID   |  To              | Distance |   Price     |");
		System.out.println("=====================================================");

		for (int i = 0; i < flag; i++) {
			System.out.print("| " + routeData.get(i).getRouteID() + " | ");
			System.out.printf("%-10s       ", routeData.get(i).getRouteName());
			System.out.printf("| %-7d  |", routeData.get(i).getRouteDistance());
			System.out.printf(" Rp. %-8d|", routeData.get(i).getRoutePrice());
			System.out.println();
		}
		System.out.println("=====================================================");
		System.out.println("Press Enter to continue...");
		scan.nextLine();
		return;
	}
		
	void updateRoute() {
		int tmp = 0;
		int idx = 0;
		if(routeData.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			return;
		}
		System.out.println("=====================================================");
		System.out.println("|  ID   |  To              | Distance |   Price     |");
		System.out.println("=====================================================");

		for (int i = 0; i < flag; i++) {
			System.out.print("| " + routeData.get(i).getRouteID() + " | ");
			System.out.printf("%-10s       ", routeData.get(i).getRouteName());
			System.out.printf("| %-7d  |", routeData.get(i).getRouteDistance());
			System.out.printf(" Rp. %-8d|", routeData.get(i).getRoutePrice());
			System.out.println();
		}
		System.out.println("=====================================================");
		
		System.out.print("Input Route ID to update: ");
		String idInput = scan.nextLine();
		for (int i = 0; i < flag; i++) {
			if (idInput.compareTo(routeData.get(i).getRouteID()) == 0) {
				idx = i;
				break;
			}
			tmp++;
			if (tmp == flag) {
				System.out.println("Route ID is invalid!");
				System.out.println("Press Enter to continue...");
				scan.nextLine();
				return;
			}
		}
		
		System.out.print("Input route destination [Jakarta | Bogor | Depok | Tanggerang | Bekasi] (case sensitive): " + "");
		String destination = scan.nextLine();
		scan.nextLine();
		routeData.get(idx).setRouteName(destination);
		System.out.print("Input route distance [1...1000]:" + "");
		Integer distance = scan.nextInt();
		scan.nextLine();
		routeData.get(idx).setRouteDistance(distance);
		int routePrice = ((distance/2 * 1000) + 10000);
		routeData.get(idx).setRoutePrice(routePrice);
		System.out.println("Successfully updated Route " + idInput + "!");
		System.out.println("Press Enter to continue...");
		scan.nextLine();
		return;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
