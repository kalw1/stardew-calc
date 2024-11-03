package stardewCalculator;

import java.util.Scanner;

public class ProfitCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Stardew Valley Crop Profit");
		System.out.print("What is the current season: \n1. Spring\n2. Summer\n3. Fall\nEnter Selection: ");
		int seasonInt = scanner.nextInt();
		System.out.print("Enter current day of season: ");
		int dayOfSeason = scanner.nextInt();
		Season currentSeason;
		switch (seasonInt) {
		case 1:
			currentSeason = Season.SPRING;
			break;
		case 2:
			currentSeason = Season.SUMMER;
			break;
		case 3:
			currentSeason = Season.FALL;
			break;
		default:
			currentSeason = Season.WINTER;
		}
		System.out.println("\nCrop Name: Gold Per Day (during growth)");
		for (Crop crop : Crop.values()) {
			if (crop.getGrowthSeason() == currentSeason) {
				System.out.println(crop.toString(dayOfSeason));
			}
		}
		scanner.close();
	}
}
