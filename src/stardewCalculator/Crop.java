package stardewCalculator;

public enum Crop {

	BLUE_JAZZ(1,"Blue Jazz", 30, 50, 7, 0, Season.SPRING, 1.0),
	CAULIFLOWER(2,"Cauliflower", 80, 175, 12, 0, Season.SPRING, 1.0), GARLIC(3, "Garlic", 40, 60, 4, 0, Season.SPRING, 1.0),
	GREEN_BEAN(4, "Green Bean", 60, 40, 10, 3, Season.SPRING, 1.0), KALE(5, "Kale", 70, 110, 6, 0, Season.SPRING, 1.0),
	PARSNIP(6, "Parsnip", 20, 35, 4, 0, Season.SPRING, 1.0), POTATO(7, "Potato", 50, 80, 6, 0, Season.SPRING, 1.2),
	RHUBARB(8, "Rhubarb", 100, 220, 13, 0, Season.SPRING, 1.0),
	STRAWBERRY(9, "Strawberry", 100, 120, 8, 4, Season.SPRING, 1.0), TULIP(10, "Tulip", 20, 30, 6, 0, Season.SPRING, 1.0),

	BLUEBERRY(11, "Blueberry", 80, 80, 13, 4, Season.SUMMER, 3.0), CORN(12, "Corn", 150, 50, 14, 4, Season.SUMMER, 1.0),
	HOPS(13, "Hops", 60, 25, 11, 1, Season.SUMMER, 1.0), HOT_PEPPER(14, "Hot Pepper", 40, 40, 5, 3, Season.SUMMER, 1.0),
	MELON(15, "Melon", 80, 250, 12, 0, Season.SUMMER, 1.0), POPPY(16, "Poppy", 100, 140, 7, 0, Season.SUMMER, 1.0),
	RADISH(17, "Radish", 40, 90, 6, 0, Season.SUMMER, 1.0), RED_CABBAGE(18, "Red Cabbage", 100, 260, 9, 0, Season.SUMMER, 1.0),
	SUMMER_SPANGLE(19, "Summer Spangle", 50, 90, 8, 0, Season.SUMMER, 1.0),
	STARFRUIT(20, "Starfruit", 400, 800, 13, 0, Season.SUMMER, 1.0), TOMATO(21, "Tomato", 50, 60, 11, 4, Season.SUMMER, 1.1),
	WHEAT(22, "Wheat", 10, 25, 4, 0, Season.SUMMER, 1.0),

	AMARANTH(23, "Amaranth", 70, 150, 7, 0, Season.FALL, 1.0), ARTICHOKE(24, "Artichoke", 30, 160, 8, 0, Season.FALL, 1.0),
	BEET(25, "Beet", 20, 100, 6, 0, Season.FALL, 1.0), BOK_CHOY(26, "Bok Choy", 50, 80, 4, 0, Season.FALL, 1.0),
	CRANBERRY(27, "Cranberry", 240, 130, 7, 5, Season.FALL, 2.1), EGGPLANT(28, "Eggplant", 20, 60, 5, 5, Season.FALL, 1.0),
	FAIRY_ROSE(29, "Fairy Rose", 200, 290, 12, 0, Season.FALL, 1.0), GRAPE(30, "Grape", 60, 80, 10, 3, Season.FALL, 1.0),
	PUMPKIN(31, "Pumpkin", 100, 320, 13, 0, Season.FALL, 1.0), RARE_SEED(32, "Rare Seed", 1000, 3000, 24, 0, Season.FALL, 1.0),
	SUNFLOWER(33, "Sunflower", 200, 80, 8, 8, Season.FALL, 1.0), YAM(34, "Yam", 60, 160, 10, 0, Season.FALL, 1.0),
	
	CARROT(35, "Carrot", 0, 35, 3, 0, Season.SPRING, 1.0),
    SUMMER_SQUASH(36, "Summer Squash", 0, 45, 6, 3, Season.SUMMER, 1.0),
    BROCCOLI(37, "Broccoli", 0, 70, 8, 4, Season.FALL, 1.0),
    POWDERMELON(38, "Powdermelon", 0, 60, 7, 0, Season.WINTER, 1.0);

	private final String cropName;
	private final int seedPrice;
	private final int sellPrice;
	private final int daysToGrow;
	private final int daysToRegrow;
	private final Season growthSeason;
	private final double cropYield;
	private final int cropID;

	Crop(int cropID, String cropName, int seedPrice, int sellPrice, int daysToGrow, int daysToRegrow,
			Season growthSeason, double cropYield) {
		this.cropID = cropID;
		this.cropName = cropName;
		this.seedPrice = seedPrice;
		this.sellPrice = sellPrice;
		this.daysToGrow = daysToGrow;
		this.daysToRegrow = daysToRegrow;
		this.growthSeason = growthSeason;
		this.cropYield = cropYield;
	}

	public boolean ifRegrow(Crop crop) {
		if (crop.getDaysToRegrow() < 1) {
			return false;
		} else {
			return true;
		}
	}

	public String getCropName() {
		return cropName;
	}

	public int getSeedPrice() {
		return seedPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public int getDaysToGrow() {
		return daysToGrow;
	}

	public int getDaysToRegrow() {
		return daysToRegrow;
	}

	public Season getGrowthSeason() {
		return growthSeason;
	}

	public double getCropYield() {
		return cropYield;
	}

	public double cropProfit(int dayOfSeason) {
		int daysLeft = 29 - dayOfSeason;
		if (daysToGrow > daysLeft) {
			return seedPrice * -1;
		} else {
			int maxHarvests = 1;
			if (daysToRegrow > 0) {
				maxHarvests = (daysLeft - daysToGrow) / daysToRegrow;
			}
			double goldPerDay = ((maxHarvests * sellPrice * cropYield) - seedPrice) / daysLeft;
			return goldPerDay;
		}
	}

	public String toString(int dayOfSeason) {
		return getCropName() + ": " + String.format("%.1f", cropProfit(dayOfSeason));
	}
	
	public String toString() {
		return getCropName();
	}

	public int getCropID() {
		return cropID;
	}
}
